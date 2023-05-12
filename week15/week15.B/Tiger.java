import java.text.DecimalFormat;

public class Tiger extends Animal {
    public Tiger(String name, int age, int weight) {
        super(name, age, weight);
    }
    @Override
    public String feedAnimal() {
        return new DecimalFormat("##.##").format(this.getWeight() / 5);
    }
}
