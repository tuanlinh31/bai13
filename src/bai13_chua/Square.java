package bai13_chua;

public class Square implements Shape{
    private String name;
    private float witdh;
    public Square(){

    }
    public Square(String name){
        this.name = name;
    }

    public Square(String name, float witdh){
        this.name = name;
        this.witdh = witdh;
    }
    @Override
    public String getName() {
        return null;
    }

    @Override
    public float calculateArea() {
        return witdh*witdh;
    }
}
