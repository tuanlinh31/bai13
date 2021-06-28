package bai7;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbcconnection_7 {
    Connection con = null;
    private static jdbcconnection_7 jdbcConnection = null;
    private jdbcconnection_7() {

    }

    public static jdbcconnection_7 getInstance() {
        if(jdbcConnection == null) {
            jdbcConnection = new jdbcconnection_7();
        }
        return jdbcConnection;
    }

    public Connection getConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=QLSinhVien";
            String username = "sa";
            String password = "Kieuhoi@1";
            con = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return con;
    }

    public void closeConnection() {
        try {
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
