import java.io.*;

public class Employee {
    private int id;
    private String name;
    private String surname;
    private int age;
    private String department;
    Employee(int id, String name, String surname, int age, String department) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.department = department;
    }
    public int getId() {
        return this.id;
    }
    public int getAge() {
        return this.age;
    }
    public String getName() {
        return this.name;
    }
    public String getSurname() {
        return this.surname;
    }
    public String getDepartment() {
        return this.department;
    }
    @Override
    public String toString() {
        return "Employee=[" + this.name + " " + this.surname + "]\n";
    }
}
