package Bai4;

import java.io.File;

public class Application {
    public static void readFolder(String path){
        File f1 = new File(path);
        if(f1.isDirectory()){
            File[] lsfile = f1.listFiles();
            for (File _f1 : lsfile){
                System.out.print("Absolutepath: " + _f1.getAbsolutePath());
                if(_f1.isDirectory()){
                    readFolder(_f1.getAbsolutePath());
                    System.out.println(" is folder");
                }else {
                    System.out.println(" is file");
                }
            }
        }else {
            System.out.println(f1.getAbsolutePath() + "is file");
        }
    }

    public static void main(String[] args) {
        readFolder("c:\\java");
    }
}
