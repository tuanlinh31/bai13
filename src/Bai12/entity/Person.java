package Bai12.entity;

import java.util.ArrayList;

public abstract class Person {
    public int id;
    public String name;
    public String date;
    public String type;
    public int kw;
    public String phone;
    public int wallet;
    public String nation;
    public String nationalid;
    public abstract void insertKH(int id, String name, String date, String type, int kw,String phone, int wallet,String nation,String nationalid);
    public abstract void retrievePhoneNumber();
    ArrayList<Person> arr = new ArrayList();

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getNationalid() {
        return nationalid;
    }

    public void setNationalid(String nationalid) {
        this.nationalid = nationalid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getKw() {
        return kw;
    }

    public void setKw(int kw) {
        this.kw = kw;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getWallet() {
        return wallet;
    }

    public void setWallet(int wallet) {
        this.wallet = wallet;
    }

    public void displayDetails(){
        for(int i = 0; i<arr.size();i++){
            Person p = arr.get(i);
            System.out.println("id: " + p.id);
            System.out.println("name: " + p.name);
            System.out.println("date: " + p.date);
            System.out.println("type: " + p.type);
            System.out.println("phone: " + p.phone);
            System.out.println("wallet: " + p.wallet);
            System.out.println("nation: " + p.nation);
            System.out.println("nationID : " + p.nationalid);

        }
    }


}
