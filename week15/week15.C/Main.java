import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Heap<Integer> heap = new Heap<>();
        heap.insert(5);
        heap.insert(1);
        heap.insert(9);
        heap.insert(3);
        heap.insert(7);
        heap.insert(2);
        System.out.println("Minimum value: " + heap.getMin());
        System.out.println("Extracted minimum value: " + heap.extractMin());
        System.out.println("New minimum value: " + heap.getMin());
        heap.decreaseKey(2, 0);
        System.out.println("New minimum value after decrease key: " +
                heap.getMin());

        System.out.println("Elements in heap: " +
                Arrays.toString(heap.toArray()));

        System.out.println("Size of heap: " + heap.size());
        System.out.println("Is heap empty? " + heap.isEmpty());
    }
}