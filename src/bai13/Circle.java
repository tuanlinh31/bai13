package bai13;

import java.security.PublicKey;

public class Circle implements Shape{
    public String name;
    public float rad;
    public Circle(){

    }
    public Circle(float rad) {
        this.rad = rad;
    }
    public Circle(String name, float rad){
        this.rad = rad;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRad() {
        return rad;
    }

    public void setRad(float rad) {
        this.rad = rad;
    }

    @Override

    public void getName(String shape) {
        System.out.println(shape);
    }

    @Override
    public double calculateArea(double rad) {
        double areaC = (rad * rad * 3.14F);
        return areaC;
    }
}
