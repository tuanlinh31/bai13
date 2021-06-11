package Bai2_session1;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("nhap thong tin lop hoc sinh vien: ");

        System.out.println("tong so lop hoc la: ");
        int tongsolop = s.nextInt();
        ArrayList<ClassPT> classpt = new ArrayList<>();
        ArrayList<Student> students_sh = new ArrayList<>();
        for(int k =0;k<tongsolop;k++){

            ClassPT cl = new ClassPT();
            System.out.println("Nhap ma lop: ");
            int id = s.nextInt();
            cl.setId(id);

            System.out.println("Nhap ten lop: ");
            s.nextLine();
            String name = s.nextLine();
            cl.setName(name);

            System.out.println("nhap khoi cua lop: ");
            int age = s.nextInt();
            cl.setAge(age);
            //sinh vien
            ArrayList<Student> students = new ArrayList<>();
            System.out.println("nhap sinh vien cho lop, tong so sinh vien cho lop: ");
            int n = s.nextInt();
            for (int i =0;i<n;i++){
                Student sv = new Student();

                System.out.println("Nhap ma sinh vien: ");
                int idsv = s.nextInt();
                sv.setId(idsv);

                System.out.println("Nhap ten sinh vien: ");
                s.nextLine();
                String namesv = s.nextLine();
                sv.setName(namesv);

                System.out.println("nhap tuoi sinh vien: ");
                int agesv = s.nextInt();
                sv.setAge(agesv);

                students.add(sv);
                students_sh.add(sv);
                System.out.println("**** Ket thuc nhap sinh vien ****");
            }

            cl.setStudents(students);
            classpt.add(cl);
            System.out.println("==== ket thuc nhap lop hoc ====");
        }
        System.out.println("nhap tuoi sinh vien muon hien thi");
        int _tuoi = s.nextInt();
        for(Student sv:students_sh){
            if(sv.getAge() == _tuoi){
                System.out.printf("SV: %d %s %d %n",sv.getId(),sv.getName(),sv.getAge());
            }
        }

        for(ClassPT cl:classpt){
            ArrayList<Student> studentsLop = cl.getStudents();
            for(Student sv:studentsLop){
                if(sv.getAge() == _tuoi){
                    System.out.printf("SV: %d %s %d %n",sv.getId(),sv.getName(),sv.getAge());
                }
            }
        }

        System.out.println("nhap ma lop");
        int _malop = s.nextInt();
        for(ClassPT cl:classpt){
            if(cl.getId() == _malop){
                ArrayList<Student> studentsLop = cl.getStudents();
                for(Student sv:studentsLop){
                    System.out.printf("SV: %d %s %d %n",sv.getId(),sv.getName(),sv.getAge());
                }
                break;
            }
        }

        System.out.println("nhap ma lop");
        int khoilop = s.nextInt();
        for(ClassPT cl:classpt){
            if(cl.getAge() == khoilop){
                ArrayList<Student> studentsLop = cl.getStudents();
                for(Student sv:studentsLop){
                    System.out.printf("SV: %d %s %d %n",sv.getId(),sv.getName(),sv.getAge());
                }
            }
        }
    }

}
