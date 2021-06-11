package Bai2_session1;

import java.util.ArrayList;

public class ClassPT {
    private int id;
    private String name;
    private int age;
    private ArrayList<Student> students = new ArrayList<Student>();

    public ClassPT(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public ClassPT() {
    }

    public void insertSV(int id, String name, int age){

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
