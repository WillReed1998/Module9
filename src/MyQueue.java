import java.util.NoSuchElementException;

public class MyQueue {
    private Object[] array;
    private int front;
    private int rear;

    public MyQueue() {
        array = new Object[10]; // Початковий розмір масиву
        front = 0;
        rear = -1;
    }

    public void add(Object value) {
        if (rear == array.length - 1) {
            resizeArray();
        }
        array[++rear] = value;
    }

    public void clear() {
        front = 0;
        rear = -1;
    }

    public int size() {
        return rear - front + 1;
    }

    public Object peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty.");
        }
        return array[front];
    }

    public Object poll() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty.");
        }
        Object value = array[front++];
        if (front > rear) {
            front = 0;
            rear = -1;
        }
        return value;
    }

    private void resizeArray() {
        int newSize = array.length * 2;
        Object[] newArray = new Object[newSize];
        System.arraycopy(array, front, newArray, 0, size());
        array = newArray;
        rear = size() - 1;
        front = 0;
    }

    private boolean isEmpty() {
        return size() == 0;
    }
}