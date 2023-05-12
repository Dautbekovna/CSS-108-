import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter employee ID: ");
        int id = input.nextInt();
        System.out.print("Enter employee name: ");
        String name = input.next();
        System.out.print("Enter employee surname: ");
        String surname = input.next();
        System.out.print("Enter employee age: ");
        int age = input.nextInt();
        System.out.print("Enter employee department: ");
        String department = input.next();

        Employee employee = new Employee(id, name, surname, age, department);

        try (
                ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("src/" + employee.getId() + ".txt"))
        ) {
            outputStream.writeObject("Employee: " + employee.getName() + " " + employee.getSurname() + "\n");
            outputStream.writeObject("Age: " + employee.getAge() + "\n");
            outputStream.writeObject("Department: " + employee.getDepartment() + "\n");
        }

        try (
                ObjectInputStream inputObject = new ObjectInputStream(new FileInputStream("src/" + employee.getId() + ".txt"));
                ) {
            System.out.print(inputObject.readObject());
            System.out.print(inputObject.readObject());
            System.out.println(inputObject.readObject());
        }

        System.out.print(employee.toString());
    }
}
