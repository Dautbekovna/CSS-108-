import java.util.*;
class Solution{
    public static void main(String[] args) {
        ArrayList<Character> openBr = new ArrayList<>(Arrays.asList('{', '[', '('));
        ArrayList<Character> closeBr = new ArrayList<>(Arrays.asList('}', ']', ')'));

        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            boolean res = true;
            String val = input.next();
            if (val.length() == 0) {
                res = true;
                continue;
            }
            Stack open = new Stack();
            Stack close = new Stack();
            for (int i = 0; i < val.length(); i++) {
                char ch = val.charAt(i);
                if (openBr.contains(ch)) {
                    open.push(openBr.indexOf(ch));
                } else {
                    close.push(closeBr.indexOf(ch));
                    if (open.isEmpty() || close.pop() != open.pop()) {
                        res = false;
                        break;
                    }
                }
            }
            System.out.println(open.isEmpty() ? res : false);
        }
    }
}