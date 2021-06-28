package bai7;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MainClass {
    JFrame j;

    public MainClass() {
        JFrame j = new JFrame("Demo");
        j.setSize(400, 500);
        j.setLayout(null);
        j.setVisible(true);

        JButton b1 = new JButton("Add new Employee");
        b1.setBounds(100, 50, 150, 50);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new AddEmployee();
            }//end action
        });//end add action

        j.add(b1);

        JButton b2 = new JButton("List Employee");
        b2.setBounds(100, 125, 150, 50);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new ListEmployee();
            }//end action
        });//end add action

        j.add(b2);
        j.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JButton b3 = new JButton("Sua Sinh Vien");
        b3.setBounds(100, 190, 150, 50);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new UpdateEmployee();
            }//end action
        });//end add action

        j.add(b3);

        JButton b4 = new JButton("Xoa Sinh Vien");
        b4.setBounds(100, 255, 150, 50);
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new DeleteEmployee();
            }//end action
        });//end add action

        j.add(b4);
    }


    public static void main(String[] args) {

        new MainClass();
    }

}
