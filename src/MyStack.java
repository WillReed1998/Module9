import java.util.NoSuchElementException;

public class MyStack {
    private Node top;
    private int size;

    private static class Node {
        private Object value;
        private Node next;

        public Node(Object value) {
            this.value = value;
        }
    }

    public void push(Object value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index.");
        }

        if (index == 0) {
            top = top.next;
        } else {
            Node currentNode = top;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.next;
            }
            currentNode.next = currentNode.next.next;
        }

        size--;
    }

    public void clear() {
        top = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty.");
        }
        return top.value;
    }

    public Object pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty.");
        }
        Object value = top.value;
        top = top.next;
        size--;
        return value;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
