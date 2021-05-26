package com.mark;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.CookieHandler;
import java.sql.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;

public class LoadData {

    private final Logger logger = LoggerFactory.getLogger(LoadData.class);
    private Connection[] conn = new Connection[2];
    private PreparedStatement[] stmts = null;

    private static final int LINE_NUM = 1000000;
    private static final int CONN_NUM = 2;
    private static final int TABLE_NUM = 16;
    private static final String TABLE_PREFIX = "order";

    public static void main(String[] args) throws SQLException {
        Long start = System.currentTimeMillis();

        LoadData loadData = new LoadData();


        loadData.getConnection();
        loadData.clear();
        loadData.insertOrder();
        loadData.close();

        Long timespan = System.currentTimeMillis() -  start;
        System.out.println("exectue SQL taken time " + timespan.toString() + "ms");
    }

    private void clear() throws SQLException {
        for (int i=0; i<CONN_NUM; i++) {
            Statement stmt = getConnection(i).createStatement();
            logger.info("truncate table order database {}", stmt.getConnection().getCatalog());
            for (int j=0; j<TABLE_NUM; j++) {
                String alterFormat = "truncate table `order%d`";
                stmt.execute(String.format(alterFormat, j));
            }
        }
    }

    /**
     * 1、使用单行执行语句1小时也才十几万条记录，直接停止执行
     * 2、使用prepareStatment执行executeBatch插入
     *   插入前必须关闭自动提交，同时每次使用addbatch操作才能成功
     *   16W条记录 耗时591s，相当于10分钟
     *   100W条记录 耗时4989981ms 4989s，相当于83分钟
     * 3、打开alter table order disable keys 多次测试结果
     *  2068ms 2025ms 2104ms 2112ms 基本与没有关闭索引结果相同
     * 4、load data infile mysql服务本地执行加载 8.32s
     *
     * @throws SQLException
     */
    private void insertOrder() throws SQLException {
        long start = System.currentTimeMillis();
        AtomicInteger atomicOrder = new AtomicInteger();
        AtomicInteger atomicUser = new AtomicInteger();
        atomicOrder.set(11100);
        atomicUser.set(1000);

        //关闭索引
        for (Connection localConn: conn) {
            Statement smt = localConn.createStatement();
            for (int i=0; i<TABLE_NUM; i++) {
                String sqlFormat = "ALTER TABLE `%s%d` disable keys";
                smt.execute(String.format(sqlFormat, TABLE_PREFIX, i));
            }
        }

        Connection localConn = null;
        PreparedStatement stmt = null;

        //预编译
        String insertSqlFormat = "INSERT INTO `%s%d`(order_id, product_id, shop_id, uid, nums, sale_price, origin_price, address, phone, username, province, city, area) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            for (int i = 0; i < LINE_NUM; i++) {
                //生成对应conn和sql
                int seq = atomicOrder.get() % TABLE_NUM;
                localConn = getConnection(seq);
                stmt = getStmt(insertSqlFormat, seq);
                localConn.setAutoCommit(false);

                stmt.setInt(1, atomicOrder.getAndIncrement());
                stmt.setInt(2, 1);
                stmt.setInt(3, 1200);
                stmt.setInt(4, atomicUser.getAndIncrement());
                stmt.setInt(5, 1);
                stmt.setDouble(6, 2900.00);
                stmt.setDouble(7, 3900.00);
                stmt.setString(8, "湖北省武汉市武昌区彭刘杨路");
                stmt.setString(9, "13045671218");
                stmt.setString(10, "zhansan");
                stmt.setString(11, "湖北");
                stmt.setString(12, "武汉市");
                stmt.setString(13, "武昌区");

                //这个很重要，告知stmt要添加参数到batch命令里面，否则执行不生效
                stmt.addBatch();

                if ((i + 1) % 100000 == 0) {
                    int[] counts = stmt.executeBatch();
                    localConn.commit();
                    logger.info("db {} insert completed {} loop {} times, taken {}.ms", stmt.getConnection().getCatalog(), counts.length, i, System.currentTimeMillis() - start);
                    stmt.clearBatch();
                }
            }

            // 打开索引
            for (Connection tmpConn: conn) {
                Statement smt = tmpConn.createStatement();
                tmpConn.setAutoCommit(true);
                for (int i=0; i<TABLE_NUM; i++) {
                    String sqlFormat = "ALTER TABLE `%s%d` enable keys";
                    smt.execute(String.format(sqlFormat, TABLE_PREFIX, i));
                }
            }

        } catch (SQLException e) {
            //出现异常回滚事务
            localConn.rollback();
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            logger.info("order insert completed {} in {}.ms", LINE_NUM, System.currentTimeMillis() - start);
        }
    }

    private Connection getConnection(int seq) {
        getConnection();
        return conn[seq % conn.length];
    }

    private void getConnection() {
        if (conn[conn.length - 1] != null) {
            return;
        }
        Connection localConn = connect("orderdb0");
        conn[0] = localConn;
        localConn = connect("orderdb1");
        conn[1] = localConn;
    }

    private PreparedStatement getStmt(String sql, int seq) throws SQLException {
        if (stmts == null) {
            stmts = new PreparedStatement[CONN_NUM * TABLE_NUM];
            for (int i=0; i<CONN_NUM; i++) {
                assert stmts != null;
                for (int j=0; j<TABLE_NUM; j++) {
                    stmts[i*TABLE_NUM + j] = conn[i].prepareStatement(String.format(sql, TABLE_PREFIX, j));
                }
            }
        }
        return stmts[(seq % CONN_NUM) * TABLE_NUM + seq % TABLE_NUM];
    }

    private Connection connect(String database) {
        String urlFormat = "jdbc:mysql://192.168.3.13:3306/%s?characterEncoding=utf8&useSSL=false&serverTimezone=UTC";
        String url = String.format(urlFormat, database);
        String user = "mark";
        String password = "123456";
        Connection localConn = null;
        // 1.加载驱动程序
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // 2.获得数据库链接
            localConn = DriverManager.getConnection(url, user, password);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (localConn == null) {
                logger.info("connection failed");
                System.exit(1);
            }
        }
        return localConn;
    }

    private void close() throws SQLException {
        for (Connection localConn : conn) {
            if (localConn != null && !localConn.isClosed()) {
                localConn.close();
            }
        }
    }
}
