package jdbcdemo;

public class Employee {
    int id;
    String name;
    float salary_rate;
    float insurance;

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

    public float getSalary_rate() {
        return salary_rate;
    }

    public void setSalary_rate(float salary_rate) {
        this.salary_rate = salary_rate;
    }

    public float getInsurance() {
        return insurance;
    }

    public void setInsurance(float insurance) {
        this.insurance = insurance;
    }


}
