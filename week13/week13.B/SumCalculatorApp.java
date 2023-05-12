import java.util.Scanner;
public class SumCalculatorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        scanner.close();
        SumCalculator calculator = new SumCalculator(number);
        calculator.calculateSum();
    }
}