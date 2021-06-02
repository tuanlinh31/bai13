import entity.News;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    public static double calculate(int a[]) {
        int s = 0;
        for(int i = 0; i<a.length;i++){
            s +=a[i];
        }

        int avg = s /a.length;


        return avg;
    }



    public static void main(String[] args) {
        int[] ratelist = new int[3];

        int choice = 0;
        Scanner s = new Scanner(System.in);
        News n = new News();


         do{
            System.out.println("-------------Menu--------");
            System.out.println("-------1. Insert News--------");
            System.out.println("-------2. View list News--------");
            System.out.println("-------3. Average rate--------");
            System.out.println("-------4. Exit--------");
            System.out.println("-----------End Menu--------");

            System.out.println("nhap vao lua chon: ");
            choice = s.nextInt();
            switch (choice){
                case 1:
                    s.nextLine();
                    System.out.println("Nhap vao title: ");
                    String title = s.nextLine();
                    System.out.println("Nhap publish date: ");
                    String publishdate = s.nextLine();
                    System.out.println("Nhap vao author");
                    String author = s.nextLine();
                    System.out.println("Nhap vao content: ");
                    String content = s.nextLine();

                    n.insertNews(title,publishdate,author,content);


                    System.out.println("Nhap vao danh gia ");
                    for(int i = 0; i<3; i++){
                        ratelist[i] = s.nextInt();
                    }

                    break;
                case 2:
                    n.display();
                    break;
                case 3:
                    System.out.println(calculate(ratelist));
                    break;
                case 4:
                    System.out.println("Bye Bye");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
         }while (choice!=4);

    }


}
