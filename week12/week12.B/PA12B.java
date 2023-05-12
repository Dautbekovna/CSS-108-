
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

class StackNode<E> {
    E data;
    StackNode<E> next;

    public StackNode(E data) {
        this.data = data;
    }
}

class LinkedStack<E> {
    private StackNode<E> top;
    private int size;

    public LinkedStack(E[] objects) {
        for (int i = 0; i < objects.length; i++) {
            push(objects[i]);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void push(E e) {
        StackNode<E> newNode = new StackNode<>(e);
        if (size == 0) {
            top = newNode;
        } else {
            StackNode<E> current = top;
            top = newNode;
            top.next = current;
        }
        size++;
    }

    public E pop() throws EmptyStackException {
        if (size == 0) return null;
        else {
            StackNode<E> temp = top;
            top = temp.next;
            size--;
            return temp.data;
        }
    }

    public E peek() throws EmptyStackException {
        if (size == 0) return null;
        else {
            return top.data;
        }
    }

    @Override
    public String toString() {
        String res = "[ ";
        if (size == 0) return "";
        else {
            StackNode<E> current = top;
            for (int i = 0; i < size; i++) {
                res += current.data + " ";
                current = current.next;
            }
            res += "]";
            return res;
        }
    }

    public Iterator<E> iterator() {
        return new StackIterator();
    }

    class StackIterator implements Iterator<E> {

        boolean canRemove = false;
        int previousLoc = -1;
        StackNode<E> current = top;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            StackNode<E> temp = current;
            current = current.next;
            return temp.data;
        }
    }

    public ListIterator<E> listIterator() {
        // Only for C task !!!!!!!!
        return null;
        // return new LinkedStack.StackListIterator();
    }
}

public class PA12B {
    public static void main(String[] args) {
        LinkedStack<Integer> linkedStack = new LinkedStack<>(new Integer[]{1,2,3,4,5,6});
//        System.out.println(linkedStack.toString());
//        System.out.println(linkedStack.pop());
//        System.out.println(linkedStack.toString());
        while(linkedStack.size() > 0) {
            System.out.println(linkedStack.size() + "_linkedStack.peek(): " + linkedStack.peek());
            System.out.println(linkedStack.size() + "_linkedStack.pop(): " + linkedStack.pop());
            System.out.println(linkedStack.size() + "_After pop: " + linkedStack.toString() + "\n");
        }

        for (int i = 0; i < 6; i++) {
            linkedStack.push(i+25);
            System.out.println(i + "_After push" + "(" + (i+25) +  ")" + ": " + linkedStack.toString());
        }

        Iterator<Integer> iterator = linkedStack.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        iterator = linkedStack.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }
}
