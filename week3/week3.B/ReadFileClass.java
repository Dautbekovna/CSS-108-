import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class ReadFileClass {
    public static void main(String[] args) throws FileNotFoundException {
        java.io.File file = new java.io.File("text.txt");
        Scanner scan = new Scanner(file);

        ArrayList<String> arr = new ArrayList<>();
        int n = 0;
        while (scan.hasNext()) {
            String s = scan.nextLine();
            arr.add("[" + n + "]: " + s);
            n++;
        }
        scan.close();
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
    }
}
