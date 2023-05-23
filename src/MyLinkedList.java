    public class MyLinkedList {
        private Node head;
        private Node tail;
        private int size;

        private class Node {
            private Object data;
            private Node prev;
            private Node next;

            public Node(Object data) {
                this.data = data;
            }
        }

        public void add(Object value) {
            Node newNode = new Node(value);
            if (size == 0) {
                head = newNode;
                tail = newNode;
            } else {
                newNode.prev = tail;
                tail.next = newNode;
                tail = newNode;
            }
            size++;
        }

        public void remove(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException();
            }
            if (index == 0) {
                head = head.next;
                if (head != null) {
                    head.prev = null;
                } else {
                    tail = null;
                }
            } else if (index == size - 1) {
                tail = tail.prev;
                tail.next = null;
            } else {
                Node current = head;
                for (int i = 0; i < index; i++) {
                    current = current.next;
                }
                current.prev.next = current.next;
                current.next.prev = current.prev;
            }
            size--;
        }

        public void clear() {
            head = null;
            tail = null;
            size = 0;
        }

        public int size() {
            return size;
        }

        public Object get(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException();
            }
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.data;
        }
    }

