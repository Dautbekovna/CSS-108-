import java.util.ArrayList;
public class Main {
    public static boolean isPalindrome(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<>();
        while (head != null) {
            arr.add(head.val);
            head = head.next;
        }

        int i = 0;
        int j = arr.size() - 1;
        while (i < j) {
            if (arr.get(i) != arr.get(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 2, 1};
        int[] arr2 = new int[]{1, 2};
        ListNode l1_head = new ListNode(arr1[0]);
        ListNode l2_head = new ListNode(arr2[0]);
        ListNode temp = l1_head;
        for (int i = 1; i < arr1.length; i++) {
            temp.next = new ListNode(arr1[i]);
            temp = temp.next;
        }
        temp = l2_head;
        for (int i = 1; i < arr2.length; i++) {
            temp.next = new ListNode(arr2[i]);
            temp = temp.next;
        }
        System.out.println(toStringList(l1_head) + " == " + isPalindrome(l1_head));
        System.out.println(toStringList(l2_head) + " == " + isPalindrome(l2_head));
    }
    public static String toStringList(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null){
            sb.append("->");
            sb.append(head.val);
            head = head.next;
        }
        return sb.toString();
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}