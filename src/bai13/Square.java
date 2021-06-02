package bai13;

public class Square implements Shape{
    public String name;
    public double width;
    public Square(){

    }
    public Square(float witdh) {
        this.width = witdh;
    }
    public Square(String name, double witdh){
        this.width = witdh;
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWidth() {
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
