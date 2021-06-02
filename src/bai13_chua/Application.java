package bai13_chua;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Circle c1 = new Circle();
        System.out.println("nhap vao ten object 1: ");
        String name = s.nextLine();
        c1.setName(name);
        System.out.println("nhap vao radius object 1: ");
        float rad = s.nextFloat();
        c1.setRad(rad);
        String x = c1.getName();
        System.out.println("ten object 1: " +x);
        System.out.println("Area object 1: " +c1.calculateArea());


        System.out.println("nhap vao ten object 1: ");
        s.nextLine();
        name = s.nextLine();
        Circle c2 = new Circle(name);
        System.out.println("nhap vao radius object 1: ");
        rad = s.nextFloat();
        c1.setRad(rad);
        System.out.println("ten object 1: " +c2.getName());
        System.out.println("Area object 1: " +c2.calculateArea());



        System.out.println("nhap vao ten object 1: ");
        s.nextLine();
        name = s.nextLine();
        System.out.println("nhap vao radius object 1: ");
        rad = s.nextFloat();
        Circle c3 = new Circle(name,rad);
        System.out.println("ten object 1: " +c3.getName());
        System.out.println("Area object 1: " +c3.calculateArea());
    }
}
