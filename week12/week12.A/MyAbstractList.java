import java.util.Iterator;
import java.util.NoSuchElementException;

abstract class MyAbstractList<E> {

    Node<E> head;
    Node<E> tail;
    int size = 0;

    public MyAbstractList(E[] objects) {
        for (int i = 0; i < objects.length; i++)
            addLast(objects[i]);
    }

    /**
     * Return true if this list doesn't contain any elements
     */
    public abstract boolean isEmpty();

    /**
     * Return the number of elements in this list
     */
    public abstract int size();

    /**
     * Clear the list
     */
    public abstract void clear();

    /**
     * Print the list
     */
    public abstract void print();

    /**
     * Return the element from this list at the specified index
     */
    public abstract E get(int index);

    /**
     * Return the first element from this list
     */
    public abstract E getFirst();

    /**
     * Return the last element from this list
     */
    public abstract E getLast();

    /**
     * Add a new element at the beginning of this list
     */
    public abstract void addFirst(E e);

    /**
     * Add a new element at the end of this list
     */
    public abstract void addLast(E e);

    /**
     * Add a new element at the specified index in this list
     */
    public abstract void add(int index, E e);

    /**
     * Remove the element from the beginning in this list.
     * Return the element that was removed from the list.
     */
    public abstract E removeFirst();

    /**
     * Remove the element from the end in this list.
     * Return the element that was removed from the list.
     */
    public abstract E removeLast();

    /**
     * Remove the element at the specified position in this list.
     * Return the element that was removed from the list.
     */
    public abstract E remove(int index);

    /**
     * Return true if this list contains the element
     */
    public abstract boolean contains(E e);

    /**
     * Return the index of the first matching element in this list.
     * Return -1 if no match.
     */
    public abstract int indexOf(E e);

    /**
     * Return the index of the last matching element
     * in this list. Return -1 if no match.
     */
    public abstract int lastIndexOf(E e);

    /**
     * Replace the element at the specified position
     * in this list with the specified element.
     */
    public abstract E set(int index, E e);

    /**
     * Override iterator() defined in Iterable
     * @return
     */
    public Iterator<E> iterator(){
        return new LLIterator();
    }

    private class LLIterator implements Iterator<E> {
        boolean canRemove = false;
        int previousLoc = -1;
        private Node<E> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (hasNext()) {
                E data = current.data;
                current = current.next;
                previousLoc++;
                canRemove = true;
                return data;
            }
            throw new NoSuchElementException("There are no next element");
        }

        @Override
        public void remove() {
            if (!canRemove) {
                throw new IllegalStateException("You can't delete element before first next() method call");
            }

            MyAbstractList.this.remove(previousLoc);
            canRemove = false;
        }
    }
}


class Node<E> {
    E data;
    Node<E> next;

    public Node(E data) {
        this.data = data;
    }
}

class MyLL<E> extends MyAbstractList<E> {

    public MyLL(E[] objects) {
        super(objects);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public void print() {
        if (size > 0) {
            String result = "[";
            Node<E> current = head;
            for (int i = 0; i < size - 1; i++) {
                result += current.data + ", ";
                current = current.next;
            }
            result += current.data + "]";
            System.out.println(result);
        } else {
            System.out.println("");
        }
    }

    @Override
    public E get(int index) {
        if (index == 0) return getFirst();
        else if (index == size - 1) return getLast();
        else {
            Node<E> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.data;
        }
    }

    @Override
    public E getFirst() {
        if (size == 0) return null;
        else return head.data;
    }

    @Override
    public E getLast() {
        if (size == 0) return null;
        else return tail.data;
    }

    @Override
    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e);
        newNode.next = head;
        head = newNode;
        size++;

        if (tail == null) tail = head;
    }

    @Override
    public void addLast(E e) {
        Node<E> newNode = new Node<>(e);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }
        size++;
    }

    @Override
    public void add(int index, E e) {
        if (index == 0) addFirst(e);
        else if (index >= size) addLast(e);
        else {
            Node<E> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            Node<E> temp = current.next;
            current.next = new Node<>(e);
            current.next.next = temp.next;
        }
    }

    @Override
    public E removeFirst() {
        if (size == 0) return null;
        else {
            Node<E> temp = head;
            head = head.next;
            size--;
            if (head == null) tail = null;
            return temp.data;
        }
    }

    @Override
    public E removeLast() {
        if (size == 0) return null;
        else if(size == 1) {
            Node<E> temp = head;
            head = tail = null;
            size = 0;
            return temp.data;
        }
        else {
            Node<E> current = head;
            for (int i = 0; i < size - 2; i++) {
                current = current.next;
            }
            Node<E> temp = tail;
            tail = current;
            tail.next = null;
            size--;
            return temp.data;
        }
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) return null;
        else if (index == 0) return removeFirst();
        else if (index == size - 1) return removeLast();
        else {
            Node<E> prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            Node<E> current = prev.next;
            prev.next = current.next;
            size--;
            return current.data;
        }
    }

    @Override
    public boolean contains(E e) {
        Node<E> current = head;
        Node<E> newNode = new Node<>(e);
        boolean contains = false;
        for (int i = 0; i < size; i++) {
            if (current.data == newNode.data) {
                contains = true;
                break;
            }
            current = current.next;
        }
        return contains;
    }

    @Override
    public int indexOf(E e) {
        Node<E> current = head;
        Node<E> newNode = new Node<>(e);
        int contains = -1;
        for (int i = 0; i < size; i++) {
            if (current.data == newNode.data) {
                contains = i;
                break;
            }
            current = current.next;
        }
        return contains;
    }

    @Override
    public int lastIndexOf(E e) {
        Node<E> current = head;
        Node<E> newNode = new Node<>(e);
        int contains = -1;
        for (int i = 0; i < size; i++) {
            if (current.data == newNode.data) {
                contains = i;
            }
            current = current.next;
        }
        return contains;
    }


    @Override
    public E set(int index, E e) {
        if (index == 0) {
            addFirst(e);
            return head.data;
        } else if (index == size - 1) {
            addLast(e);
            return head.data;
        } else {
            add(index, e);
            Node<E> newNode = new Node<>(e);
            return newNode.data;
        }
    }
}