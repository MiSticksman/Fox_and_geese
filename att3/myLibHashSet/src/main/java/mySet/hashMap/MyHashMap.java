package mySet.hashMap;

import mySet.MyEntry;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyHashMap<K, V> implements Iterable<MyEntry<K, V>> {

    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private static final int DEFAULT_LENGTH = 4;

    private int arrayLength;

    private int size;

    private final float LOAD_FACTOR;

    private Node<K, V>[] tables;

    public MyHashMap(int length, float loadFactor) {
        if (length <= 0) {
            throw new IllegalArgumentException("Начальная ёмкость должна быть больше 0");
        }
        if (loadFactor <= 0) {
            throw new IllegalArgumentException("Коэффициент загрузки должен быть больше 0");
        }
        this.arrayLength = length;
        this.LOAD_FACTOR = loadFactor;
        tables = new Node[length];
    }

    public MyHashMap() {
        this(DEFAULT_LENGTH, DEFAULT_LOAD_FACTOR);
    }

    public MyHashMap(int length) {
        this(length, DEFAULT_LOAD_FACTOR);
    }

    protected class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return key + " = " + value;
        }
    }

    public V get(K key) {
        int index = indexForArray(hash(key), arrayLength);
        Node<K, V> node = tables[index];
        for (Node<K, V> n = node; n != null; n = n.next) {
            if ((key == null && null == n.getKey()) || (key != null && key.equals(n.getKey()))) {
                return n.value;
            }
        }
        return null;
    }

    public V put(K key, V value) {
        int hashCode = hash(key);
        int index = indexForArray(hashCode, arrayLength);
        Node<K, V> node = tables[index];
        if (node == null) {
            tables[index] = new Node(key, value, null);
            size++;
        } else {
            while (true) {
                K nodeKey = node.getKey();
                if ((key == null && nodeKey == null) || (key != null && key.equals(nodeKey))) {
                    V oldValue = node.getValue();
                    node.setValue(value);
                    return oldValue;
                }
                if (node.next == null) {
                    node.next = new Node<>(key, value, null);
                    size++;
                    break;
                }
                node = node.next;
            }
        }
        if (size > arrayLength * LOAD_FACTOR) {
            resize();
        }
        return null;
    }


    public void clear() {
        arrayLength = DEFAULT_LENGTH;
        tables = new Node[arrayLength];
        size = 0;
    }

    public int size() {
        return size;
    }

    public int hash(K key) {
        return key == null ? 0 : Math.abs(key.hashCode());
    }

    private int indexForArray(int hashCode, int arrayLength) {
        return Math.abs(hashCode) % (arrayLength - 1);
    }

    private Node<K, V>[] resize() {
        int newLength = arrayLength * 2;
        Node<K, V>[] newTables = new Node[newLength];
        for (int i = 0; i < arrayLength; i++) {
            Node<K, V> node = tables[i];
            while (node != null) {
                Node<K, V> temp = node.next;
                node.next = null;
                int hash = hash(node.getKey());
                int index = indexForArray(hash, newLength);
                Node<K, V> node1 = newTables[index];
                if (node1 == null) {
                    newTables[index] = node;
                } else {
                    while (node1.next != null) {
                        node1 = node1.next;
                    }
                    //newTables[index] = node;
                    node1.next = node;
                }
                node = temp;
            }
        }
        tables = newTables;
        arrayLength = newLength;
        return newTables;
    }

    public void remove(K deleteKey) {
        int hash = hash(deleteKey);
        int index = indexForArray(hash, arrayLength);
        if (tables[index] != null) {
            Node<K, V> previous = null;
            Node<K, V> current = tables[index];
            while (current != null) {
                if (current.key.equals(deleteKey)) {
                    if (previous == null) {
                        tables[index] = tables[index].next;
                    } else {
                        previous.next = current.next;
                    }
                    size--;
                }
                previous = current;
                current = current.next;
            }
        }
    }

    public boolean contains(K key) {
        int hash = hash(key);
        int index = indexForArray(hash, arrayLength);
        if (tables[index] != null) {
            Node<K, V> temp = tables[index];
            while (temp != null) {
                if (temp.key.equals(key))
                    return true;
                temp = temp.next;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void display() {
        for (int i = 0; i < arrayLength; i++) {
            if (tables[i] != null) {
                Node<K, V> node = tables[i];
                while (node != null) {
                    System.out.println(node.key + ":" + node.value);
                    node = node.next;
                }
            }
        }
    }

    public void displaySet() {
        for (int i = 0; i < arrayLength; i++) {
            if (tables[i] != null) {
                Node<K, V> node = tables[i];
                while (node != null) {
                    System.out.print(node.key + " ");
                    node = node.next;
                }
            }
        }
    }

    @Override
    public Iterator<MyEntry<K, V>> iterator() {
        class MyHashMapIteratorMyEntry implements Iterator<MyEntry<K, V>> {
            MyEntry<K, V> myEntry = new MyEntry<>(null, null);
            Node<K, V> curr = new Node<>(null, null, null);
            int index = 0;
            boolean check = false;

            @Override
            public boolean hasNext() {
                if (check)
                    return curr != null;
                else if (arrayLength > index) {
                    if (tables[index] == null) {
                        index++;
                        return hasNext();
                    }
                    return tables[index] != null;
                }
                return false;
            }

            @Override
            public MyEntry<K, V> next() {
                if (hasNext()) {
                    if (check) {
                        myEntry.setKey(curr.key);
                        myEntry.setValue(curr.value);
                        curr = curr.next;
                        if (curr == null) {
                            check = false;
                            index++;
                        }
                        return myEntry;
                    } else {
                        myEntry.setKey(tables[index].getKey());
                        myEntry.setValue(tables[index].getValue());
                        curr = tables[index].next;
                        if (curr == null) {
                            index++;
                        } else check = true;
                    }
                    return myEntry;
                }
                throw new NoSuchElementException("sosi");
            }
        }
        return new MyHashMapIteratorMyEntry();
    }
}
