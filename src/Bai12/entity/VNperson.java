package Bai12.entity;

import Bai12.logic.IElectricity;

import java.util.ArrayList;

public class VNperson extends Person implements IElectricity {



    @Override
    public float invoice() {
        int count = 0;
        float thanhtien = 0;
        for(int i = 0;i<arr.size();i++){
            Person p = arr.get(i);
            if(p.nation == null){
                count++;
            }
        }
        if(count <=quota){
            thanhtien = price*count;
        }
        else {
            thanhtien = price*quota+ (kw - quota)*price*1.5F;
        }
        System.out.println("So tien: " +thanhtien);
        return thanhtien;
    }

    @Override
    public float pay(float thanhtien) {
        float p = wallet - thanhtien;
        return p;
    }


    @Override
    public void insertKH(int id, String name, String date, String type, int kw, String phone, int wallet, String nation, String nationalid) {
        boolean trung = false;
        for(int i = 0; i<arr.size();i++){
            Person p = arr.get(i);
            if(p.id == id){
                trung = true;
                break;
            }
        }
        if(!trung){
            Person p = new VNperson();
            p.id = id;
            p.name = name;
            p.date = date;
            p.type = type;
            p.kw = kw;
            p.phone = phone;
            p.wallet = wallet;
        }
    }

    @Override
    public void retrievePhoneNumber() {
        for(int i = 0; i<arr.size();i++){
            Person p = arr.get(i);
            if(p.nation == null){
                System.out.println("so dien thoai: 84" + p.phone);
            }else{
                System.out.println("so dien thoai: 00" +p.phone);
            }
        }
    }
}
