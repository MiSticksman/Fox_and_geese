package mySet.hashMap;

/**
 * @author lzy
 * @date 2018/1/18
 */
public class MyHashMap<K, V>  {

    /**
     * Коэффициент загрузки по умолчанию
     */
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    /**
     * Начальная длина по умолчанию
     */
    private static final int DEFAULT_LENGTH = 4;

    private int arrayLength;

    private int size;

    private float loadFactor;
    private Node<K, V>[] tables;

    public MyHashMap(int length, float loadFactor) {
        if (length <= 0) {
            throw new IllegalArgumentException("Начальная ёмкость должна быть больше 0");
        }
        if (loadFactor <= 0) {
            throw new IllegalArgumentException("Коэффициент загрузки должен быть больше 0");
        }
        this.arrayLength = length;
        this.loadFactor = loadFactor;
        tables = new Node[length];
    }

    public MyHashMap() {
        this(DEFAULT_LENGTH, DEFAULT_LOAD_FACTOR);
    }

    public MyHashMap(int length) {
        this(length, DEFAULT_LOAD_FACTOR);
    }

    protected class Node<K, V>  {
        private K key;
        private V value;
        private Node<K, V> next;
        private int hashCode;

        public Node(K key, V value, int hashCode, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.hashCode = hashCode;
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
            return key + "=" + value;
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

    public void put(K key, V value) {
        int hashCode = hash(key);
        int index = indexForArray(hashCode, arrayLength);
        Node<K, V> node = tables[index];
        if (node == null) {
            tables[index] = new Node(key, value, hashCode, null);
            size++;
        } else {
            while(true) {
                K nodeKey = node.getKey();
                if ((key == null && nodeKey == null) || (key != null && key.equals(nodeKey))) {
                    node.setValue(value);
                    break;
                }
                if (node.next == null) {
                    node.next = new Node<>(key, value, hashCode, null);
                    //node = node.next;
                    size++;
                    break;
                }
                node = node.next;
            }
        }

        // Определяем, хотите ли вы развернуть, если вы просто замените значение без добавления элементов, оно не будет выполнено здесь
        if (size > arrayLength * loadFactor) {
            resize();
        }
    }

    public void clear() {
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
        return Math.abs(hashCode) % arrayLength;
    }

    private void resize() {
        int newLength = arrayLength * 2;
        Node<K, V>[] newTables = new Node[newLength];
        for (int i = 0; i < arrayLength; i++) {
            Node<K, V> node = tables[i];
            while(node != null) {
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
                node = node.next;
            }
        }
//        Set<Map.Entry<K, V>> entrySet = entrySet();
//        int newSize = 0;
//        for (Map.Entry entry : entrySet) {
//            Node<K, V> node = (Node<K, V>) entry;
//            node.next = null;
//            int index = indexForArray(node.hashCode, arrayLength);
//            Node<K, V> indexNode = newTables[index];
//            if (indexNode == null) {
//                newTables[index] = node;
//            } else {
//                while (indexNode.next != null) {
//                    indexNode = indexNode.next;
//                }
//                indexNode.next = node;
//            }
//        }
        tables = newTables;
        arrayLength = newLength;
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

    public boolean contains(K key){
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

    public void display() {
        for (int i = 0; i < arrayLength; i++){
            if (tables[i]!=null){
               Node<K, V> node = tables[i];
                while (node != null){
                    System.out.println(node.key  + ":" + node.value);
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

//    public Set<Map.Entry<K, V>> entrySet() {
//        Set<Map.Entry<K, V>> set = new HashSet<>();
//        for (Node<K, V> node : tables) {
//            while (node != null) {
//                set.add((Map.Entry<K, V>) node);
//                node = node.next;
//            }
//        }
//        return set;
//    }
}