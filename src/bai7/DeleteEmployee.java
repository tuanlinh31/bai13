package bai7;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteEmployee {
    public DeleteEmployee(){
        jdbcconnection_7 jdbcconnection = jdbcconnection_7.getInstance();
        Connection con = jdbcconnection.getConnection();
        JFrame j = new JFrame("Xoa");

        JLabel l = new JLabel("id");
        l.setBounds(10, 10, 100, 30);
        j.add(l);

        JTextField t = new JTextField();
        t.setBounds(120, 10, 100, 30);
        j.add(t);


        j.setSize(400, 500);
        j.setLayout(null);
        j.setVisible(true);

        JButton b = new JButton("Delete");//creating instance of JButton
        b.setBounds(130, 200, 100, 40);//x axis, y axis, width, height
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent be) {
                int id = Integer.parseInt(t.getText());
                Connection con = null;

                try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    String url = "jdbc:sqlserver://localhost:1433;databaseName=QLSinhVien";
                    String username = "sa";
                    String password = "Kieuhoi@1";
                    con = DriverManager.getConnection(url, username, password);
                    String sql = "Delete from sinhvien  where id = ?";
                    PreparedStatement ps = null;
                    ps = con.prepareStatement(sql);
                    ps.setInt(1, id);
                    ps.execute();

                    JOptionPane.showMessageDialog(j, "xoa thanh cong");
                } catch (SQLException throwables) {
                    JOptionPane.showMessageDialog(j, "khong the xoa");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                jdbcconnection.closeConnection();


            }
        });

        j.add(b);
    }
}
