package BaithiADF2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Customer cus = new Customer();
        Scanner s = new Scanner(System.in);
        int choice  = 0;
        do{
            System.out.println("=== Menu ===");
            System.out.println("=== 1. Add new customer ===");
            System.out.println("=== 2. Find by name ===");
            System.out.println("=== 3. Display all ===");
            System.out.println("=== 4. Exit ===");
            System.out.println("=== End Menu ===");

            System.out.println("nhap vao lua chon: ");
            choice = s.nextInt();

            switch (choice){
                case 1:
                    System.out.println("nhap vao ten: ");
                    s.nextLine();
                    String name = s.nextLine();
                    System.out.println("nhap vao email: ");
                    String email = s.nextLine();
                    System.out.println("nhap vao phone: ");
                    String phone = s.nextLine();
                    cus.addCustomer(name,email,phone);
                    break;
                case 2:
                    System.out.println("nhap vao ten muon tim kiem: ");
                    s.nextLine();
                    String name1 = s.nextLine();
                    cus.findCustomer(name1);
                    break;
                case 3:
                    cus.display();
                    break;

            }
        }while (choice != 4);
    }
}
