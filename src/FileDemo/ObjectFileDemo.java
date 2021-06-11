package FileDemo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjectFileDemo {
    public static void main(String[] args) {
        Book b = new Book();
        b.setId(1);
        b.setName("Nguyen Tuan");
        b.setAuthor("Nguyen Tuan");
        Book b2 = new Book();
        b.setId(2);
        b.setName("Nguyen Tuan");
        b.setAuthor("Nguyen Tuan");

        List<Book> lsBook = new ArrayList<>();
        lsBook.add(b);
        lsBook.add(b2);

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            fos = new FileOutputStream("book.dat");
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

        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
            fis = new FileInputStream("book.dat");
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
    }
}
