package TestException;

import java.rmi.server.ExportException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TestException {
    public static void main(String[] args) {
        int a = 0;
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                a = sc.nextInt();
                break;

            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("loi");
            }
        }


        System.out.println("A = " + a);
        System.out.println("nhap publish date (MM/dd/yyyy): ");
        String publishDate = "";
        while (true) {
            try {
            publishDate = sc.nextLine();
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYYY");
            Date d = sdf.parse(publishDate);
            break;
            } catch (ParseException e) {
                System.out.println("Input MM/dd/yyyy");
            }
        }
        System.out.println("publishDate: "+publishDate);

    }
}
