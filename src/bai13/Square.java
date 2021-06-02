package bai13;

public class Square implements Shape{
    public String name;
    public float width;
    public Square(){

    }
    public Square(float rad) {
        this.width = rad;
    }
    public Square(String name, float rad){
        this.width = rad;
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    @Override
    public void getName(String shape) {
        System.out.println(shape);
    }

    @Override
    public double calculateArea(double witdh) {
        double areaS;
        areaS = witdh*witdh;
        return areaS;
    }
}
