import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = input.next();
        System.out.print("Enter your age: ");
        int age = input.nextInt();
        System.out.print("Enter your favourite sport: ");
        String sport = input.next();
        System.out.print("Enter your hobby: ");
        String hobby = input.next();
        SportAndHobbyImpl p = new SportAndHobbyImpl(name, age, sport, hobby);

        System.out.println(p.getName());
        System.out.println(p.getAge());
        System.out.println(p.howMuchItCostToPlayThisSport());
        System.out.println(p.whatIsMyHobby());
        System.out.println(p.getMyFavoriteSport());
    }
}
