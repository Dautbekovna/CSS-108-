import java.util.PriorityQueue;
import java.util.Queue;

public class Heap<T> {
    Queue<T> pq0 = new PriorityQueue<>();
    public void insert(T value) {
        pq0.add(value);
    }
    public T getMin() {
        return pq0.peek();
    }
    public T extractMin() {
        T min = pq0.peek();
        pq0.remove();
        return min;
    }
    public boolean isEmpty() {
        return pq0.isEmpty();
    }
    public int size() {
        return pq0.size();
    }
    public T[] toArray() {
        T[] arr = (T[]) pq0.toArray();
        return arr;
    }
    public void decreaseKey(int index, T newValue) {
        pq0.add(newValue);
        // условие и результат не совпадают, поэтому я оставила так
    }
}
