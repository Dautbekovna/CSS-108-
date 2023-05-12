import java.text.DecimalFormat;

public class Bear extends Animal {
    public Bear(String name, int age, int weight) {
        super(name, age, weight);
    }
    @Override
    public String feedAnimal() {
        return new DecimalFormat("##.##").format(this.getWeight() / 10);
    }
}
