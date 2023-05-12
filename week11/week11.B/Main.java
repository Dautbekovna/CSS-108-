import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            String word = input.next();
            countInitialCharacter(word);
            countCharacter(word);
        }
    }
    public static char[] countInitialCharacter(String word) {
        char[] chars = new char[word.length()];
        System.out.print("{");
        for (int i = 0; i < chars.length; i++) {
            chars[i] = word.charAt(i);
            if (i != chars.length - 1) {
                System.out.print("'" + chars[i] + "', ");
            }
        }
        System.out.println("'" + chars[chars.length - 1] + "'}");
        return chars;
    }
    public static HashMap countCharacter(String word) {
        String[] arr = word.split("");
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            String letter = arr[i].toUpperCase();
            if (!map.containsKey(letter)) {
                map.put(letter, 1);
            } else {
                int n = map.get(letter);
                n++;
                map.put(letter, n);
            }
        }
        System.out.print(map);
        return map;
    }
}
