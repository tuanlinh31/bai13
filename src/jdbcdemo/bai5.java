package jdbcdemo;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class bai5 {
    public static void insertSV(Connection con, int id, String name, float salary_rate, float insurance){
        String sql = "insert into Employee(id, name, salary_rate, insurance) values(?, ?, ?, ?)";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setFloat(3, salary_rate);
            ps.setFloat(4, insurance);
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
    public static void dsNV(Connection con) {
        ArrayList<Employee> _sv2 = new ArrayList<>();
        String sql = "select * from Employee";
        Statement st = null;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                int id1 = rs.getInt("ID");
                String name1 = rs.getString("name");
                float salary_rate = rs.getFloat("salary_rate");
                float insurance = rs.getFloat("insurance");

                Employee nv1 = new Employee();
                nv1.setId(id1);
                nv1.setName(name1);
                nv1.setSalary_rate(salary_rate);
                nv1.setInsurance(insurance);
                _sv2.add(nv1);

//                System.out.printf("SV: %d %s %s %s %n",id1,name1,email1,tel1);
            }

            //duyet array list de hien thi
            for(Employee sv2:_sv2){
                System.out.printf("SV: %d %s %s %s %n",sv2.getId(),sv2.getName(),sv2.getSalary_rate(),sv2.getInsurance());
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
        Scanner s = new Scanner(System.in);
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
        while (true) {
            System.out.println("nhap vao id nv: ");
            int id = s.nextInt();
            System.out.println("nhap vao name nv: ");
            s.nextLine();
            String name = s.nextLine();
            System.out.println("nhap vao salary rate: ");
            float salary_rate = s.nextFloat();
            System.out.println("nhap vao insurance: ");
            float insurance = s.nextFloat();

            insertSV(con, id, name, salary_rate, insurance);

            System.out.println("co muon tiep tuc nhap khong? ");
            s.nextLine();
            String str = s.nextLine();
            if(str.equalsIgnoreCase("NO")){
                break;
            }
            else {
                continue;
            }
        }
        dsNV(con);
        try {
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
