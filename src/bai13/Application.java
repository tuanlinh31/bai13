package bai13;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Square sq = new Square();
        Circle c = new Circle();
        Shape area;
        Scanner s = new Scanner(System.in);
        System.out.println("nhap vao ten hinh");
        String name = s.nextLine();
        c.getName(name);
        if(name.equals("hinh tron")){

            System.out.println("nhap vao ban kinh: ");
            double rad = s.nextFloat();

            System.out.println("dien tich hinh tron: " + c.calculateArea(rad));
        }else if(name.equals("hinh vuong")){
            System.out.println("nhap vao canh: ");
            int witdh = s.nextInt();
            System.out.println("dien tich hinh vuong "+ sq.calculateArea(witdh));
        }

        Square sq1 = new Square(3);
        Square sq2 = new Square("hinh vuong",3);

        Circle c1 = new Circle(3);
        Circle c2 = new Circle("hinh tron",3);

    }
}
