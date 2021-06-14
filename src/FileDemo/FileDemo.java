package FileDemo;

import java.io.*;

public class FileDemo {
    public static void main(String[] args) {
        File f = new File("C:\\java\\Hello.txt");
        System.out.println("Path is: " +f.getPath());
        System.out.println("Path is: " +f.getAbsolutePath());
        System.out.println("Name is: " +f.getName());
        System.out.println("File exists is: " +f.exists());
        System.out.println("File is: " +f.isFile());
        System.out.println("File is: " +f.isDirectory());
        System.out.println("File is: " +f.canExecute());

        File f1 = new File("c:\\java");
        if(f1.isDirectory()){
            File[] lsfile = f1.listFiles();
            for (File _f1:lsfile){
                System.out.println("Absolutepath: " + _f1.getAbsolutePath());
                if(_f1.isDirectory()){
                    System.out.println(" is foleder");
                }else {
                    System.out.println(" is file");
                }
            }
        }
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        try {
             inputStream = new FileInputStream(("c:\\java\\Hello.txt"));
             outputStream = new FileOutputStream("out.txt");
            int ch;
            StringBuffer sb = new StringBuffer();

            while ((ch = inputStream.read()) != -1){
                System.out.println((char) ch);
                sb.append(ch);
                outputStream.write(ch);
            }
        System.out.println();

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(inputStream != null){
                try{
                    inputStream.close();
                    outputStream.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }

        }
        Book b = new Book();
        b.setId(1);
        b.setName("Nguyen Tuan");
        b.setAuthor("Nguyen Tuan");

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            fos = new FileOutputStream("book.dat");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(b);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                fos.close();
                oos.close();
            }catch (Exception e){

            }
        }
        //doc du lieu

    }
}
