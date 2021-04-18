import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.*;

public class HikariPoolTest {

    private HikariDataSource ds;

    public static void main(String[] args) {
        long st = System.currentTimeMillis();
        try {
            HikariPoolTest hikariPoolTest = new HikariPoolTest();
            hikariPoolTest.connect();

            hikariPoolTest.query();
            hikariPoolTest.update(1, "mark");
            hikariPoolTest.delete(1);

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        System.out.println(System.currentTimeMillis() - st);
    }


    private void connect() throws ClassNotFoundException, SQLException {
        HikariConfig conf = new HikariConfig();
        conf.setUsername("root");
        conf.setPassword("root");
        conf.setJdbcUrl("jdbc:mysql://localhost:3306/user");
        ds = new HikariDataSource(conf);
    }

    private ResultSet query() throws SQLException {
        Statement st = ds.getConnection().createStatement();
        ResultSet rs = st.executeQuery("select * from user");
        //4.处理数据库的返回结果(使用ResultSet类)

        rs.close();
        st.close();
        return rs;
    }

    private boolean update(int id, String username) throws SQLException {
        Statement st = ds.getConnection().createStatement();
        String s="update user set user_name=? where id= " + id;
        PreparedStatement pst = ds.getConnection().prepareStatement(s);
        pst.setString(1, username);
        boolean rt = pst.execute();
        pst.close();
        st.close();
        return rt;
    }

    private boolean delete(int id) throws SQLException {
        Statement st = ds.getConnection().createStatement();
        boolean ret = st.execute("delete from user where id=" + id);
        st.close();
        return ret;
    }

    private void close() throws SQLException {
        ds.getConnection().close();
    }
}
