
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
         return new LinkedStack.StackListIterator();
    }

    class StackListIterator implements ListIterator<E> {
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
            previousLoc++;
            return temp.data;
        }
        @Override
        public boolean hasPrevious() {
            return previousLoc > -1;
        }
        @Override
        public E previous() {
            StackNode<E> curr = top;
            for (int i = 0; i < previousLoc; i++) {
                curr = curr.next;
            }
            previousLoc--;
            return curr.data;
        }
        @Override
        public int nextIndex() {
            return previousLoc + 1;
        }
        @Override
        public int previousIndex() {
            return previousLoc;
        }
        @Override
        public void remove() {
            System.err.println("You can access only top element in stack!");
        }
        @Override
        public void set(E e) {
            System.err.println("You can access only top element in stack!");
        }
        @Override
        public void add(E e) {
            System.err.println("You can access only top element in stack!");
        }
    }

}
public class P12C {
    public static void main(String[] args) {
        LinkedStack<Integer> linkedStack = new LinkedStack<>(new Integer[]{1,2,3,4,5,6});
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
        ListIterator<Integer> listIterator =
                linkedStack.listIterator();
        while (listIterator.hasNext()){
            System.out.print(listIterator.nextIndex() + "_" +
                    listIterator.next() + " ");
        }
        System.out.println();

        while (listIterator.hasPrevious()){
            System.out.print(listIterator.previousIndex() + "_" +
                    listIterator.previous() + " ");
        }
        System.out.println();
    }
}
