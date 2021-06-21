package Bai6;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Class {
    private int id;
    String name;
    int khoi;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKhoi() {
        return khoi;
    }

    public void setKhoi(int khoi) {
        this.khoi = khoi;
    }
}
