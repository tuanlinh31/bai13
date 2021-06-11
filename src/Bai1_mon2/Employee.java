package Bai1_mon2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Employee {
    int id;
    String name;
    float salary_rate;
    float insurance;
    ArrayList<Employee> arr = new ArrayList();
    ArrayList salar = new ArrayList();

    public Employee(int i, String nguyen_van_ti, float v, float v1) {
    }

    public Employee() {

    }


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

    public float getSalary_rate() {
        return salary_rate;
    }

    public void setSalary_rate(float salary_rate) {
        this.salary_rate = salary_rate;
    }

    public float getInsurance() {
        return insurance;
    }

    public void setInsurance(float insurance) {
        this.insurance = insurance;
    }

    public float calculateSalaryOfMonth(int month, int numberofday){
        float sal = 0;

        for (int i = 0;i<arr.size(); i++){
            Employee e = arr.get(i);
            sal = (((float) numberofday)*e.salary_rate*(1800000/22) - e.insurance);
            salar.add(sal);
        }

        return sal;
    }
    public void  display(int month){
        for(int i = 0; i<salar.size();i++){
            Object e = salar.get(i);
            System.out.println("luong thang: "+e);
        }
    }
    public void insertNV(int id, String name, float salary_rate, float insurance){
        Employee e = new Employee();
        e.id = id;
        e.name = name;
        e.salary_rate = salary_rate;
        e.insurance = insurance;
        arr.add(e);
    }
    public static void main(String[] args) {
        Employee e = new Employee();
        Scanner sc = new Scanner(System.in);
        e.insertNV(1,"Nguyen Van Teo",3.6F,500000F);
        e.insertNV(2,"Nguyen Van Ti",5.1F,680000F);
        while (true){
            try{
                sc.nextLine();
                System.out.println("nhap vao thang can tinh luong: ");
                int month = sc.nextInt();
                System.out.println("nhap vao so ngay di lam: ");
                int numberofday = sc.nextInt();
                float luong = e.calculateSalaryOfMonth(month,numberofday);

                e.display(month);
            }catch (InputMismatchException ex){
                System.out.println("loi roi");
            }
        }
    }
}
