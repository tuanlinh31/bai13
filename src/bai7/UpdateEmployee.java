package bai7;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PublicKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateEmployee {

    public UpdateEmployee() {
        jdbcconnection_7 jdbcconnection = jdbcconnection_7.getInstance();
        Connection con = jdbcconnection.getConnection();
        JFrame j = new JFrame("Sua");

        JLabel l = new JLabel("id");
        l.setBounds(10, 10, 100, 30);
        j.add(l);

        JLabel l2 = new JLabel("name");
        l2.setBounds(10, 50, 100, 30);
        j.add(l2);

        JTextField t = new JTextField();
        t.setBounds(120, 10, 100, 30);
        j.add(t);

        JTextField t2 = new JTextField();
        t2.setBounds(120, 50, 100, 30);
        j.add(t2);


        j.setSize(400, 500);
        j.setLayout(null);
        j.setVisible(true);

        JButton b = new JButton("update");//creating instance of JButton
        b.setBounds(130, 200, 100, 40);//x axis, y axis, width, height
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent be) {
                int id = Integer.parseInt(t.getText());
                String name = t2.getText();
                Connection con = null;

                try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    String url = "jdbc:sqlserver://localhost:1433;databaseName=QLSinhVien";
                    String username = "sa";
                    String password = "Kieuhoi@1";
                    con = DriverManager.getConnection(url, username, password);
                    String sql = "update sinhvien set name = ? where id = ?";
                    PreparedStatement ps = null;
                    ps = con.prepareStatement(sql);
                    ps.setString(1, name);
                    ps.setInt(2, id);
                    ps.execute();

                    JOptionPane.showMessageDialog(j, "sua thanh cong");
                } catch (SQLException throwables) {
                    JOptionPane.showMessageDialog(j, "khong sua duoc");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                jdbcconnection.closeConnection();


            }
        });

        j.add(b);
    }
}
