package jdbcdemo;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class JDBC_sua {

    public static void themSV(Connection con, int id, String name, String tel, String email) {
        String sql = "insert into sinhvien(id, name, email, tel) values(?, ?, ?, ?)";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, email);
            ps.setString(4, tel);
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
    public static void suaSV(Connection con, int id, String name) {
        String sql = "update sinhvien set name = ? where id = ?";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, id);
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
    public static void xoaSV(Connection con,int id) {
        String sql = "delete from sinhvien where id = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            ps.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }
    public static void dsSV(Connection con) {
        ArrayList <SinhVien> _sv2 = new ArrayList<>();
        String sql = "select * from sinhvien";
        Statement st = null;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                int id1 = rs.getInt("ID");
                String name1 = rs.getString("name");
                String email1 = rs.getString("email");
                String tel1 = rs.getString("tel");

                SinhVien sv1 = new SinhVien();
                sv1.setId(id1);
                sv1.setName(name1);
                sv1.setEmail(email1);
                sv1.setTel(tel1);
                _sv2.add(sv1);

//                System.out.printf("SV: %d %s %s %s %n",id1,name1,email1,tel1);
            }

            //duyet array list de hien thi
            for(SinhVien sv2:_sv2){
                System.out.printf("SV: %d %s %s %s %n",sv2.getId(),sv2.getName(),sv2.getEmail(),sv2.getTel());
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                st.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }


    }
    public static void main(String[] args) {
        //tao connection
        Connection con = null;
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

        int choice = 0;
        Scanner s = new Scanner(System.in);

        do {
            System.out.println("------------- Menu --------------");
            System.out.println("1. Them moi sv");
            System.out.println("2. Cap nhat ten sv");
            System.out.println("3. Xoa sinh vien theo id");
            System.out.println("4. Danh sach sv");
            System.out.println("5. tim kiem sv");
            System.out.println("------------- Menu --------------");

            choice = s.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("nhap vao id sv: ");
                    int id = s.nextInt();

                    System.out.println("nhap vao name sv: ");
                    s.nextLine();
                    String name = s.nextLine();

                    System.out.println("nhap vao email sv: ");
                    String email = s.nextLine();

                    System.out.println("nhap vao tel sv: ");
                    String tel = s.nextLine();
                    themSV(con, id, name, email,tel);
                    break;
                case 2:
                    System.out.println("nhap vao id sinh vien");
                    int id1 = s.nextInt();

                    System.out.println("nhap vao ten sv");
                    s.nextLine();
                    String name1 = s.nextLine();
                    suaSV(con,id1,name1);
                    break;
                case 3:
                    System.out.println("nhap vao id sinh vien");
                    int id2 = s.nextInt();
                    xoaSV(con,id2);
                    break;
                case 4:
                    dsSV(con);
                    break;
            }
        } while (choice != 6);
        //end menu

        try {
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}