class MyHashMap {
    private Node[] array;
    private int size;

    public MyHashMap() {
        array = new Node[16];
        size = 0;
    }

    private class Node {
        private Object key;
        private Object value;
        private Node next;

        public Node(Object key, Object value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public void put(Object key, Object value) {
        int index = getIndex(key);
        Node newNode = new Node(key, value);

        if (array[index] == null) {
            array[index] = newNode;
            size++;
        } else {
            Node current = array[index];
            while (current != null) {
                if (current.key.equals(key)) {
                    current.value = value;
                    return;
                }
                if (current.next == null) {
                    break;
                }
                current = current.next;
            }
            current.next = newNode;
            size++;
        }
    }

    private int getIndex(Object key) {
        return Math.abs(key.hashCode()) % array.length;
    }


    public void remove(Object key) {
        int index = getIndex(key);
        Node current = array[index];
        Node prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    array[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public void clear() {
        array = new Node[16];
        size = 0;
    }

    public int size() {
        return size;
    }


    public Object get(Object key) {
        int index = getIndex(key);
        Node current = array[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }

        return null;
    }
}