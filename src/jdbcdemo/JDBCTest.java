package jdbcdemo;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class JDBCTest {
    public static void main(String[] args) {
        SinhVien sv = new SinhVien();
        Scanner s = new Scanner(System.in);
        ArrayList <SinhVien> _sv = new ArrayList<>();

        System.out.println("nhap id: ");
        int id = s.nextInt();

        System.out.println("nhap name: ");
        s.nextLine();
        String name = s.nextLine();

        System.out.println("nhap email: ");
        String email = s.nextLine();

        System.out.println("nhap tel: ");
        String tel = s.nextLine();

        sv.setId(id);
        sv.setName(name);
        sv.setEmail(email);
        sv.setTel(tel);

        Connection con = null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:sqlserver://localhost:1433;databaseName=QLSinhVien";
            String user = "sa";
            String password = "Kieuhoi@1";
            con = DriverManager.getConnection(url,user,password);
            DatabaseMetaData db = con.getMetaData();
            System.out.println(db.getDriverName());

            //cach 1
//            Statement st = con.createStatement();
//            String sql = "insert into sinhvien(id,name,email,tel) values(" + id + ",'" + name + "','" + email + "','" + tel + "')";
//            st.execute(sql);

            //cach 2 dung prepare statement
            String sql = "insert into sinhvien(id,name,email,tel) values(?,?,?,?)";
            PreparedStatement pr = con.prepareStatement(sql);
            pr.setInt(1,id);
            pr.setString(2,name);
            pr.setString(3,email);
            pr.setString(4,tel);
            pr.execute();

            //update du lieu cua sinh vien id =1; doi email
            sql = "update sinhvien set email =? where id =?";
            pr = con.prepareStatement(sql);
            pr.setString(1,"linh@fpt.edu.vn");
            pr.setInt(2,1);
            pr.execute();

            //delete du lieu
            int _id =1;
            sql = "delete from sinhvien where id =?";
            pr = con.prepareStatement(sql);
            pr.setInt(1,_id);
            pr.execute();

            //select
            sql = "select * from sinhvien";
            Statement st = con.createStatement();
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
                _sv.add(sv1);

//                System.out.printf("SV: %d %s %s %s %n",id1,name1,email1,tel1);
            }

            //duyet array list de hien thi
            for(SinhVien sv2:_sv){
                System.out.printf("SV: %d %s %s %s %n",sv2.getId(),sv2.getName(),sv2.getEmail(),sv2.getTel());
            }


        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }finally {
            try{
                con.close();
            }catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }
    }
}
