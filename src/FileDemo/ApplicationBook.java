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
        int choice = 0;
        List<Book> _lsBook = new ArrayList<>();
        do {
            System.out.println("==== Chuong trinh quan ly sach ====");
            System.out.println("==== 1.Them sach ====");
            System.out.println("==== 1. Hien thisach ====");
            System.out.println("==== 3. Tim sach ====");
            System.out.println("==== 4. Thoat ====");
            System.out.println("==== Ket ThucChuong trinh quan ly sach ====");

            System.out.println("nhap lua chon: ");
            choice = s.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Them sach: ");
                    Book b = new Book();
                    System.out.println("nhap id cua sach: ");
                    int id = s.nextInt();
                    b.setId(id);

                    System.out.println("nhap ten cua sach: ");
                    s.nextLine();
                    String name = s.nextLine();
                    b.setName(name);


                    System.out.println("nhap author cua sach: ");
                    String author = s.nextLine();
                    b.setAuthor(author);



                    FileInputStream fis = null;
                    ObjectInputStream ois = null;
                    try{
                        fis = new FileInputStream("book1.dat");
                        ois = new ObjectInputStream(fis);
                        _lsBook = (List<Book>)ois.readObject();
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
                    _lsBook.add(b);
                    //ghi lai du lieu vao file
                    FileOutputStream fos = null;
                    ObjectOutputStream oos = null;
                    try{
                        fos = new FileOutputStream("book1.dat");
                        oos = new ObjectOutputStream(fos);
                        oos.writeObject(_lsBook);
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
                    fis = null;
                    ois = null;
                    try{
                        fis = new FileInputStream("book1.dat");
                        ois = new ObjectInputStream(fis);
                        _lsBook = (List<Book>)ois.readObject();
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
                    for (Book k: _lsBook){
                        System.out.printf("Sach: %d %s %s %n",k.getId(),k.getAuthor(),k.getName());
                    }
                    break;

                case 3:
                    fis = null;
                    ois = null;
                    try{
                        fis = new FileInputStream("book1.dat");
                        ois = new ObjectInputStream(fis);
                        _lsBook = (List<Book>)ois.readObject();
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
                    System.out.println("nhap vao ten sach: ");
                    s.nextLine();
                    String search = s.nextLine();
                    for (Book _b: _lsBook){
                        if(_b.getName().contains(search)){
                            System.out.printf("Sach: %d %s %s %n",_b.getId(),_b.getAuthor(),_b.getName());
                        }
                    }
                    break;
            }
        }while (choice != 4);
    }
}
