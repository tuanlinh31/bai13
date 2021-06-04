package Baithi;

import java.util.ArrayList;
import java.util.Scanner;

public class Hotel {
    String name;
    String location;
    String ownername;
    ArrayList <Hotel> arr = new ArrayList();

    public void insertHotel(String name, String location,String ownername){
        Hotel h = new Hotel();
        h.name = name;
        h.location = location;
        h.ownername = ownername;
        arr.add(h);
    }

    public void displayDetails(String ownername){

        boolean b = false;
        for(int i = 0; i< arr.size();i++){
            Hotel p = arr.get(i);
            if(p.ownername.equals(ownername)){
                b = true;
                System.out.println("Name of hotel: " +p.name);
                System.out.println("Location of hotel: " +p.location);
                System.out.println("Owner name of hotel: " +p.ownername);
            }else{

            }

        }
        if(!b){
            System.out.println("Khong co chu so huu nao ten: " +ownername);
        }
    }
    public Hotel() {
    }

    public Hotel(String name, String location, String ownername) {
        this.name = name;
        this.location = location;
        this.ownername = ownername;
    }

    public static void main(String[] args) {
        Hotel h = new Hotel();
        int count = 0;
        h.insertHotel("maivilla","hanoi","linh");
        h.insertHotel("songhong","ho chi minh","long");
        h.insertHotel("baoson","da nang","quynh");
        h.insertHotel("hoabinhresort","da lat","quy");
        h.insertHotel("Somerset","nha trang","khanh");
        h.insertHotel("Daewoo","can tho","thang");
        h.insertHotel("Aria Boutique","hoi an","viet");
        h.insertHotel("Riverside","hoi an","hai anh");
        h.insertHotel("Lasiesta","hoi an","chi");
        h.insertHotel("Allegro","hoi an","huong");

        do{
            count++;
            Scanner sc = new Scanner(System.in);
            System.out.println("nhap vao ten chu so huu khach san: ");
            String own = sc.nextLine();
            h.displayDetails(own);
        }while(count <= 10);

    }
}