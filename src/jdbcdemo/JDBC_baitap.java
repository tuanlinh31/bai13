package jdbcdemo;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class JDBC_baitap {
    public static void main(String[] args) {
        SinhVien sv = new SinhVien();
        Scanner s = new Scanner(System.in);
        ArrayList<SinhVien> _sv = new ArrayList<>();
        int choice = 0;

        Connection con = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:sqlserver://localhost:1433;databaseName=QLSinhVien";
            String user = "sa";
            String password = "Kieuhoi@1";
            con = DriverManager.getConnection(url, user, password);

        do{
            System.out.println("==== Menu ====");
            System.out.println("====1. them sinh vien ====");
            System.out.println("====2. cap nhat ten sinh vien ====");
            System.out.println("====3. xoa sinh vien theo id====");
            System.out.println("====4. danh sach sv ====");
            System.out.println("==== End Menu ====");

            System.out.println("choose? ");
            choice = s.nextInt();


            switch (choice){
                case 1:
                    System.out.println("nhap vao id sinh vien");
                    int id = s.nextInt();
                    System.out.println("nhap vao ten sinh vien");
                    s.nextLine();
                    String name = s.nextLine();
                    System.out.println("nhap vao email sinh vien");
                    String email = s.nextLine();
                    System.out.println("nhap vao tel sinh vien");
                    String tel = s.nextLine();

                    String sql = "insert into sinhvien(id,name,email,tel) values(?,?,?,?)";
                    PreparedStatement pr = con.prepareStatement(sql);
                    pr.setInt(1,id);
                    pr.setString(2,name);
                    pr.setString(3,email);
                    pr.setString(4,tel);
                    pr.execute();
                    break;
                case 2:
                    System.out.println("nhap vao id sinh vien: ");
                    int id1 = s.nextInt();
                    System.out.println("nhap vao email can update");
                    s.nextLine();
                    String email1 = s.nextLine();
                    System.out.println("nhap vao so dien thoai moi: ");
                    String tel1 = s.nextLine();

                    sql = "update sinhvien set email =?, tel =? where id =?";
                    pr = con.prepareStatement(sql);
                    pr.setString(1,email1);
                    pr.setString(2,tel1);
                    pr.setInt(3,id1);
                    pr.execute();
                    break;
                case 3:
                    System.out.println("nhap vao id sinh vien: ");
                    int _id = s.nextInt();
                    sql = "delete from sinhvien where id =?";
                    pr = con.prepareStatement(sql);
                    pr.setInt(1,_id);
                    pr.execute();
                    break;
                case 4:
                    sql = "select * from sinhvien";
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery(sql);
                    while(rs.next()){
                        int id2 = rs.getInt("ID");
                        String name2 = rs.getString("name");
                        String email2 = rs.getString("email");
                        String tel2 = rs.getString("tel");

                        SinhVien sv1 = new SinhVien();
                        sv1.setId(id2);
                        sv1.setName(name2);
                        sv1.setEmail(email2);
                        sv1.setTel(tel2);
                        _sv.add(sv1);

//                System.out.printf("SV: %d %s %s %s %n",id1,name1,email1,tel1);
                    }

                    //duyet array list de hien thi
                    for(SinhVien sv2:_sv){
                        System.out.printf("SV: %d %s %s %s %n",sv2.getId(),sv2.getName(),sv2.getEmail(),sv2.getTel());
                    }
                    break;

            }


        }while (choice !=5);
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
