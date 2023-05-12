import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws InputMismatchException {
        Scanner input = new Scanner(System.in);
        try {
            System.out.print("Enter two integers: ");
            int x = input.nextInt();
            int y = input.nextInt();
            Calculator calc1 = new Calculator(x, y);
            System.out.println(calc1.Add());
            System.out.println(calc1.Subtract());
            System.out.println(calc1.Multiplication());
            System.out.println(calc1.Division());
        } catch (InputMismatchException ex) {
            throw new InputMismatchException("you should enter only integers");
        }
    }
}
