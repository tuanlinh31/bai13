package FileDemo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ApplicationBook {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Book b = new Book();
        List<Book> lsBook = new ArrayList<>();
        int choice = 0;
        do{
            System.out.println("==== Menu ====");
            System.out.println("1. them sach");
            System.out.println("2. hien thi danh sach sach");
            System.out.println("3. tim sach theo ten");
            System.out.println("4. thoat");
            System.out.println("==== End Menu ====");

            System.out.println("choose? ");
            choice = s.nextInt();
            switch (choice){
                case 1:
                    System.out.println("nhap vao id sach");
                    int id = s.nextInt();
                    System.out.println("nhap vao ten sach");
                    s.nextLine();
                    String name = s.nextLine();
                    System.out.println("nhap vao ten tac gia");
                    String author = s.nextLine();
                    b.setId(id);
                    b.setName(name);
                    b.setAuthor(author);
                    lsBook.add(b);

                    FileOutputStream fos = null;
                    ObjectOutputStream oos = null;
                    try{
                        fos = new FileOutputStream("book1.dat");
                        oos = new ObjectOutputStream(fos);
                        oos.writeObject(lsBook);
                    }catch (Exception e){
                        e.printStackTrace();
                    }finally {
                        try{
                            fos.close();
                            oos.close();
                        }catch (Exception e){

                        }
                    }
                    break;

                case 2:
                    FileInputStream fis = null;
                    ObjectInputStream ois = null;
                    try{
                        fis = new FileInputStream("book1.dat");
                        ois = new ObjectInputStream(fis);
                        List<Book> _lsBook = (List<Book>)ois.readObject();
                    }catch (Exception e){
                        e.printStackTrace();
                    }finally {
                        try{
                            fis.close();
                            ois.close();
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                    break;
                case 3:
                    break;

            }
        }while (choice!= 4);
    }
}
