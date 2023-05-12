import java.text.DecimalFormat;
import java.util.Locale;

public class Lion extends Animal {
    public Lion(String name, int age, int weight) {
        super(name, age, weight);
    }
    @Override
    public String feedAnimal() {
        return new DecimalFormat("##.##").format(this.getWeight() / 7);
    }
}
