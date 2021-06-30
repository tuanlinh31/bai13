package BaithiADF2;

import Baithi.Hotel;

import java.util.*;

public class Customer {
    String name;
    String email;
    String phone;

    ArrayList<Customer> cus = new ArrayList();
    HashMap<Integer,Customer> cus_hm = new HashMap<Integer,Customer>();

    // dung hash map
    public void addCustomerHM(String name, String email, String phone){
        Customer cus_ = new Customer();
        int count = 0;
        int sum = count++;
        cus_.name = name;
        cus_.email = email;
        cus_.phone = phone;
        cus_hm.put(sum,cus_);
    }
    public void  displayHM(){
        for(int key: cus_hm.keySet()){
            System.out.println(cus_hm.get(key).getName());
            System.out.println(cus_hm.get(key).getPhone());
            System.out.println(cus_hm.get(key).getEmail());
        }
    }

    public void findCustomerHM(String name){
        boolean b = false;
        for(int i = 0; i< cus_hm.size();i++){
            Customer p = cus_hm.get(i);
            if(p.name.equals(name)){
                b = true;
                System.out.println("Name: " +p.name);
                System.out.println("Email: " +p.email);
                System.out.println("Phone number: " +p.phone);
            }else{

            }

        }
        if(!b){
            System.out.println("Khong co nguoi ten: " +name);
        }
    }
//dung arraylist
    public  void addCustomer(String name, String email, String phone){
        Customer cu = new Customer();
        cu.name = name;
        cu.email = email;
        cu.phone = phone;
        cus.add(cu);
    }

    public void findCustomer(String name){
        boolean b = false;
        for(int i = 0; i< cus.size();i++){
            Customer p = cus.get(i);
            if(p.name.equals(name)){
                b = true;
                System.out.println("Name: " +p.name);
                System.out.println("Email: " +p.email);
                System.out.println("Phone number: " +p.phone);
            }else{

            }

        }
        if(!b){
            System.out.println("Khong co nguoi ten: " +name);
        }
    }
    public void display(){
        for(int i = 0; i<cus.size();i++){
            Customer p = cus.get(i);
            System.out.println("Name: " +p.name);
            System.out.println("Email: " +p.email);
            System.out.println("Phone number: " +p.phone);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Customer() {
    }
}
