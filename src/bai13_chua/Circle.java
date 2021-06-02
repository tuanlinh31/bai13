package bai13_chua;

public class Circle implements Shape{
    private String name;
    private float rad;

    public Circle(){

    }
    public Circle(String name){
        this.name = name;
    }

    public Circle(String name, float rad){
        this.name = name;
        this.rad = rad;
    }
    public void setName(String name) {
        this.name = name;
    }

    public float getRad() {
        return rad;
    }

    public void setRad(float rad) {
        this.rad = rad;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public float calculateArea() {
        return (float) (Math.PI *rad *rad);
    }
}
