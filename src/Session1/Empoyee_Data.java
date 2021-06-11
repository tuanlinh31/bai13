package Session1;

public class Empoyee_Data {
    private String name;
    private float salary;
    public Empoyee_Data(String name){
        this.name = name;
        this.salary = 5600;
    }
    public String toString(){
        return "[Name = " + this.name + ", Salary = " + this.salary + "]";
    }
}
