package week2.A;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter cat name: ");
        Cat cat = new Cat(input.next());
        System.out.print("Enter dog name: ");
        Dog dog = new Dog(input.next());
        System.out.print("Enter second dog name: ");
        Dog dog2 = new Dog(input.next());
        System.out.println(cat.toString());
        System.out.println(dog.toString());
        cat.greets();
        dog.greets();
        dog.greets(dog);
    }
}