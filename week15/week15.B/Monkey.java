import java.text.DecimalFormat;

public class Monkey extends Animal {
    public Monkey(String name, int age, int weight) {
        super(name, age, weight);
    }
    @Override
    public String feedAnimal() {
        return new DecimalFormat("##.##").format(this.getWeight() / 15);
    }
}
