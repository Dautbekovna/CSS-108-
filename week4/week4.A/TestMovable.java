import java.util.Scanner;
public class TestMovable {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Write x: ");
        int x = input.nextInt();
        System.out.print("Write y: ");
        int y = input.nextInt();
        System.out.print("Write xSpeed: ");
        int xSpeed = input.nextInt();
        System.out.print("Write ySpeed: ");
        int ySpeed = input.nextInt();
        System.out.print("Write radius: ");
        int radius = input.nextInt();
        MovablePoint m = new MovablePoint(x, y, xSpeed, ySpeed);
        MovableCircle c  = new MovableCircle(x, y, xSpeed, ySpeed, radius);

        System.out.println(m.toString());
        m.moveLeft();
        System.out.println(m.toString());
        System.out.println(c.toString());
        c.moveDown();
        System.out.println(c.toString());
    }
}
