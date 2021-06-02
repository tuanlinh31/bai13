package Bai12;

import Bai12.entity.FGperson;
import Bai12.entity.VNperson;
import jdk.jshell.Snippet;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        VNperson vp = new VNperson();
        FGperson fp = new FGperson();
        do{
            System.out.println("---------Menu--------");
            System.out.println("------1. nhap thong tin nguoi VN--------");
            System.out.println("------2. nhap thong tin nguoi nuoc ngoai--------");
            System.out.println("------0. Ket thuc nhap--------");
            System.out.println("------End Menu--------");
            System.out.println("Choose? ");
            choice = sc.nextInt();
            if(choice == 0){
                choice =3;
            }
            switch (choice){
                case 1:
                    System.out.println("nhap id: ");
                    int id = sc.nextInt();
                    System.out.println("nhap name: ");
                    sc.nextLine();
                    String name = sc.nextLine();
                    System.out.println("nhap date: ");
                    String date = sc.nextLine();
                    System.out.println("nhap type: ");
                    String type = sc.nextLine();
                    System.out.println("nhap kw: ");
                    int kw = sc.nextInt();
                    System.out.println("nhap phone: ");
                    sc.nextLine();
                    String phone = sc.nextLine();
                    System.out.println("nhap wallet: ");
                    int wallet = sc.nextInt();
                    vp.insertKH(id,name,date,type,kw,phone,wallet,null,null);
                    break;
                case 2:
                    System.out.println("nhap id: ");
                    int id1 = sc.nextInt();
                    System.out.println("nhap name: ");
                    sc.nextLine();
                    String name1 = sc.nextLine();
                    System.out.println("nhap date: ");
                    String date1 = sc.nextLine();
                    System.out.println("nhap type: ");
                    String type1 = sc.nextLine();
                    System.out.println("nhap kw: ");
                    int kw1 = sc.nextInt();
                    System.out.println("nhap phone: ");
                    sc.nextLine();
                    String phone1 = sc.nextLine();
                    System.out.println("nhap wallet: ");
                    int wallet1 = sc.nextInt();
                    System.out.println("nhap nation: ");
                    sc.nextLine();
                    String nation = sc.nextLine();
                    System.out.println("nhap nationid: ");
                    sc.nextLine();
                    String nationid = sc.nextLine();

                    vp.insertKH(id1,name1,date1,type1,kw1,phone1,wallet1,nation,nationid);
                    break;
                case 3:
                    System.out.println("da nhap xong");
                    vp.displayDetails();
                    vp.retrievePhoneNumber();

                    float thanhtien = vp.invoice();
                    float thanhtien2 = fp.invoice();
                    float p = fp.pay(thanhtien2);
                    System.out.println("Doanh thu trung binh tu khach nuoc ngoai" +p);
                    break;
            }
        }while (choice !=4);
    }
}
