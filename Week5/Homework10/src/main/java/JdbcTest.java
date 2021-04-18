import javax.xml.transform.Result;
import java.sql.*;
import java.util.Map;

public class JdbcTest {

    Connection conn;

    public static void main(String[] args)  {
        JdbcTest jdbc = new JdbcTest();
        try {
            jdbc.connect();
            ResultSet resultSet =  jdbc.query();
            while(resultSet.next()){
                System.out.println(resultSet.getString("user_name")+" "
                  +resultSet.getString("user_password"));
                }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                jdbc.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    private void connect() throws ClassNotFoundException, SQLException {
        String URL="jdbc:mysql://127.0.0.1:3306/user?useUnicode=true&amp;characterEncoding=utf-8";
        String USER="root";
        String PASSWORD="root";
        //1.加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //2.获得数据库链接
        conn = DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private ResultSet query() throws SQLException {
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from user");
        //4.处理数据库的返回结果(使用ResultSet类)

        rs.close();
        st.close();
        return rs;
    }

    private boolean update(int id, String username) throws SQLException {
        Statement st = conn.createStatement();
        String s="update user set user_name=? where id= " + id;
        PreparedStatement pst = conn.prepareStatement(s);
        pst.setString(1, username);
        boolean rt = pst.execute();
        pst.close();
        st.close();
        return rt;
    }

    private boolean delete(int id) throws SQLException {
        Statement st = conn.createStatement();
        boolean ret = st.execute("delete from user where id=" + id);
        st.close();
        return ret;
    }

    private void close() throws SQLException {
        conn.close();
    }
}
