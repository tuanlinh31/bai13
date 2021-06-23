package jdbcdemo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCDao {

    public void insert() {
        JDBCConnection jdbcConnection = JDBCConnection.getInstance();
        Connection con = jdbcConnection.getConnection();
        JFrame j = new JFrame("demo");


        JLabel l = new JLabel("name");
        l.setBounds(10, 10, 100, 30);
        j.add(l);

        JLabel l2 = new JLabel("email");
        l2.setBounds(10, 50, 100, 30);
        j.add(l2);

        JLabel l3 = new JLabel("tel");
        l3.setBounds(10, 90, 100, 30);
        j.add(l3);


        JTextField t2 = new JTextField();
        t2.setBounds(120, 50, 100, 30);
        j.add(t2);

        JTextField t = new JTextField();
        t.setBounds(120, 10, 100, 30);
        j.add(t);

        JTextField t3 = new JTextField();
        t3.setBounds(120, 90, 100, 30);
        j.add(t3);


        j.setSize(400, 500);
        j.setLayout(null);
        j.setVisible(true);

        JButton b = new JButton("click");//creating instance of JButton
        b.setBounds(130, 200, 100, 40);//x axis, y axis, width, height
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent be) {
                String name = t.getText();
                String email = t2.getText();
                String tel = t3.getText();
                Connection con = null;

                try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    String url = "jdbc:sqlserver://localhost:1433;databaseName=QLSinhVien";
                    String username = "sa";
                    String password = "Kieuhoi@1";
                    con = DriverManager.getConnection(url, username, password);
                    String sql = "insert into SinhVien(name, email, tel) values(?, ?, ?)";
                    PreparedStatement ps = null;
                    ps = con.prepareStatement(sql);
                    ps.setString(1, name);
                    ps.setString(2, email);
                    ps.setString(3, tel);
                    ps.execute();

                    JOptionPane.showMessageDialog(j, "them moi thanh cong");
                } catch (SQLException throwables) {
                    JOptionPane.showMessageDialog(j, "them moi that bai");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                jdbcConnection.closeConnection();


            }
        });

        j.add(b);//adding button in JFrame}
//        String sql = "insert into sinhvien(name, email, tel) values(?, ?, ?, ?)";
//        PreparedStatement ps = null;
//        try {
//            ps = con.prepareStatement(sql);
//            ps.setString(1, name);
//            ps.setString(2, email);
//            ps.setString(3, tel);
//            ps.execute();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        jdbcConnection.closeConnection();
//    }
    }
}
