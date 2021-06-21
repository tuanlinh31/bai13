package Bai6;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    public static void inputClass(Connection con, String name, int khoi){
        String sql = "insert into Class(name, khoi) values(?, ?)";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, khoi);
            ps.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    public static int timtentheolop(Connection con, String name){
        String sql = "select id from Class where name =? ";
        PreparedStatement ps = null;
        int id =0;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                id = rs.getInt("id");
//                System.out.printf("SV: %d %s %s %s %n",id1,name1,email1,tel1);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return id;
    }

    public static void inputSV(Connection con,int class_id, String name, int age){
        String sql = "insert into Student(class_id,name,age) values(?, ?,?)";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, class_id);
            ps.setString(2, name);
            ps.setInt(3,age);
            ps.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int choice = 0;
        ArrayList<SinhVien> _sv = new ArrayList<>();
        ArrayList<Class> _cl = new ArrayList<>();
        Class cl = new Class();

        Connection con = null;
        try {
            java.lang.Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:sqlserver://localhost:1433;databaseName=QLSinhVienBai6";
            String user = "sa";
            String password = "Kieuhoi@1";
            con = DriverManager.getConnection(url, user, password);

            do{
            System.out.println("====Menu====");
            System.out.println("====1. Nhap lop ====");
            System.out.println("====2. Nhap sinh vien====");
            System.out.println("====3. Nhap 1 so tuoi====");
            System.out.println("====4. Nhap ma lop, hien thi danh sach sinh vien====");
            System.out.println("====5. Nhap khoi, hien thi danh sach sinh vien cua lop====");
            System.out.println("====6. Thoat====");
            System.out.println("====End Menu====");

            System.out.println("nhap vao lua chon");
            choice = s.nextInt();
            switch (choice){
                case 1:
                    System.out.println("nhap vao ten class: ");
                    s.nextLine();
                    String name = s.nextLine();
                    System.out.println("nhap vao khoi class: ");
                    int khoi = s.nextInt();

                    inputClass(con,name,khoi);
                    break;
                case 2:

                    System.out.println("nhap vao ten sinh vien: ");
                    s.nextLine();
                    String name1 = s.nextLine();
                    System.out.println("nhap vao tuoi sinh vien: ");
                    int age1 = s.nextInt();
                    System.out.println("nhap vao ten lop: ");
                    s.nextLine();
                    String lop = s.nextLine();
                    int class_id10 = timtentheolop(con,lop);

                    inputSV(con,class_id10,name1,age1);
                    break;
                case 3:
                    System.out.println("nhap vao so tuoi sinh vien: ");
                    int age2 = s.nextInt();
                    String sql = "select * from Student where age =?";
                    PreparedStatement pr = con.prepareStatement(sql);
                    pr.setInt(1,age2);
                    ResultSet rs = pr.executeQuery();
                    while(rs.next()){
                        int class_id3 = rs.getInt("class_id");
                        int id3 = rs.getInt("id");
                        String name3 = rs.getString("name");
                        int age3 = rs.getInt("age");

                        SinhVien sv1 = new SinhVien();
                        sv1.setClass_id(class_id3);
                        sv1.setId(id3);
                        sv1.setName(name3);
                        sv1.setAge(age3);
                        _sv.add(sv1);

//                System.out.printf("SV: %d %s %s %s %n",id1,name1,email1,tel1);
                    }

                    //duyet array list de hien thi
                    for(SinhVien sv2:_sv){
                            System.out.printf("SV: %d %s %s %s %n",sv2.getClass_id(),sv2.getId(),sv2.getName(),sv2.getAge());
                    }
                    break;
                case 4:
                    System.out.println("nhap ma lop: ");
                    int class_id2 = s.nextInt();
                    sql = "select * from Student where class_id = ?";
                    pr = con.prepareStatement(sql);
                    pr.setInt(1,class_id2);

                    ResultSet rs1 = pr.executeQuery();
                    while(rs1.next()){
                        int class_id4 = rs1.getInt("class_id");
                        int id4 = rs1.getInt("id");
                        String name4 = rs1.getString("name");
                        int age4 = rs1.getInt("age");

                        SinhVien sv5 = new SinhVien();
                        sv5.setClass_id(class_id4);
                        sv5.setId(id4);
                        sv5.setName(name4);
                        sv5.setAge(age4);
                        _sv.add(sv5);

//                System.out.printf("SV: %d %s %s %s %n",id1,name1,email1,tel1);
                    }

                    //duyet array list de hien thi
                    for(SinhVien sv6:_sv){
                            System.out.printf("SV: %d %s %s %s %n",sv6.getClass_id(),sv6.getId(),sv6.getName(),sv6.getAge());
                    }
                    break;
                case 5:
                    System.out.println("nhap vao khoi lop hoc: ");
                    int khoi1 = s.nextInt();
                    sql = "select * from Student inner join Class on (Student.class_id = Class.id) where khoi = ?";
                    pr = con.prepareStatement(sql);
                    pr.setInt(1,khoi1);
                    rs = pr.executeQuery();
                    while(rs.next()){
                        int class_id5 = rs.getInt("class_id");
                        int id5 = rs.getInt("id");
                        String name5 = rs.getString("name");
                        int age5 = rs.getInt("age");

                        SinhVien sv3 = new SinhVien();
                        sv3.setClass_id(class_id5);
                        sv3.setId(id5);
                        sv3.setName(name5);
                        sv3.setAge(age5);
                        _sv.add(sv3);

//                System.out.printf("SV: %d %s %s %s %n",id1,name1,email1,tel1);
                    }

                    //duyet array list de hien thi
                    for(SinhVien sv4:_sv){
                        System.out.printf("SV: %d %s %s %s %n",sv4.getClass_id(),sv4.getId(),sv4.getName(),sv4.getAge());
                    }
                    break;
            }
        }while (choice!=6);
        }            catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        catch (SQLException throwables){
            throwables.printStackTrace();
        }
        finally {
            try{
                con.close();
            }catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }
    }
}
