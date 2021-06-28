package bai7;

import javax.swing.*;
import java.sql.*;

public class ListEmployee {
    JFrame j;

    public ListEmployee() {
        Connection con = null;
        j = new JFrame();
        String data[][];
        String column[]={"ID","NAME","EMAIL","TEL"};
        int n = 100;
        data = new String[n][4];
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=QLSinhVien";
            String username = "sa";
            String password = "Kieuhoi@1";
            con = DriverManager.getConnection(url, username, password);
            String sql = "select * from SinhVien";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();


            int index = 0;
            while (rs.next()){
                int id = rs.getInt("ID");
                String name = rs.getString("name");
                String email = rs.getString("EMAIL");
                String tel = rs.getString("TEL");
                String _row[] =  {String.valueOf(id),name,email,tel};
                data[index++] =_row;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        JTable jt=new JTable(data,column);
        jt.setBounds(30,40,200,300);
        JScrollPane sp=new JScrollPane(jt);
        j.add(sp);
        j.setSize(300,400);
        j.setVisible(true);

    }
}
