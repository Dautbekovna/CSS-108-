import java.util.ArrayList;
import java.util.Arrays;

public class GenericMethod {
    public static void main(String[] args) {
        ArrayList<Number> list = new ArrayList<>(Arrays.asList(1, 2L, 3.00, 4.56F));
        System.out.println(sum(list));
    }
    public static Number sum(ArrayList<Number> list) {
        double sum = 0;
        for (Number n : list) {
            sum += n.doubleValue();
        }
        return sum;
    }
}
