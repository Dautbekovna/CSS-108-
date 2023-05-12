import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class SimpleIO {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        ArrayList<String> arr = new ArrayList<>();
        boolean isFile = true;
        do {
            System.out.print("please enter an input file: ");
            String filename = input.next();
            java.io.File file = new java.io.File(filename);
            if (file.exists() && !file.isDirectory()) {
                isFile = false;
                arr.add(filename);
            }
        } while (isFile);
        do {
            System.out.print("please enter an output file: ");
            String filename = input.next();
            isFile = true;
            if (!arr.get(0).equals(filename)) {
                isFile = false;
            }
        } while (isFile);

        java.io.File file = new java.io.File(arr.get(0));
        Scanner scan = new Scanner(file);
        int result = 0;
        while(scan.hasNext()) {
            String s = scan.nextLine().toLowerCase();
            String[] newArr = s.split(" ");
            int count = 0;
            for (String word: newArr) {
                if (word.matches("the")) count++;
            }
            result += count;
        }
        System.out.println(result);
    }
}
