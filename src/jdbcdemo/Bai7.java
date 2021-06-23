package jdbcdemo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Bai7 {
    public static void main(String[] args) {
        JDBCDao jdbc = new JDBCDao();
        jdbc.insert();
    }
}
