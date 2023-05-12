package week2.A;

public class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Animal[name='" + this.name + "']";
    }
}
