package Bai1_mon2;

import Session1.Empoyee_Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Employee_chua {
    private int id;
    private String name;
    private float salary_rate;
    private float insurance;
//    float [] bangluong = new float[12];
//    ArrayList bangluong1 = new ArrayList();
    HashMap<String, Float> bangluong = new HashMap<String, Float>();
    public Employee_chua(int id, String name, float salary_rate, float insurance) {
        this.id = id;
        this.name = name;
        this.salary_rate = salary_rate;
        this.insurance = insurance;
    }

    public float CalculateSalaryOfMonth(int month, int numberofDay){
        float x = numberofDay * salary_rate *(1800000/22) -insurance;
//        bangluong[month - 1] =x;
        bangluong.put(String.valueOf(month),x);
        return x;
    }

    public static void main(String[] args) {
        Employee e1 = new Employee(1,"Nguyen Van Ti",3.6f,500000f);
        Scanner s = new Scanner(System.in);
        for(int i = 0; i<=12;i++){
            System.out.println("Nhap so ngay lafm viec cua thang  "+ i + "cua Ti");
            int num = s.nextInt();
            float luongthang1 = e1.calculateSalaryOfMonth(i,num);
        }



        Employee e2 = new Employee(1,"Nguyen Van TEO",5.1f,500000f);
        for(int i = 0; i<=12;i++){
            System.out.println("Nhap so ngay lafm viec cua thang  "+ i + "cua TEO");
            int num = s.nextInt();
            float luongthang1 = e1.calculateSalaryOfMonth(i,num);
        }

    }
}
