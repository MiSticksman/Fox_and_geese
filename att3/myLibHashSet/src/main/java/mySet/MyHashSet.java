package mySet;


import mySet.hashMap.MyHashMap;

public class MyHashSet<T> {

    private MyHashMap<T, Object> myHashMap;

    private static final Object PRESENT = new Object();

    public MyHashSet() {
        myHashMap = new MyHashMap<>();
    }

    public MyHashSet(int initialCapacity, float loadFactor) {
        myHashMap = new MyHashMap<T, Object>(initialCapacity, loadFactor);
    }

    public boolean put(T value) {
        return myHashMap.put(value, PRESENT) == null;
    }

    public void remove(T value) {
        myHashMap.remove(value);
    }

    public boolean contains(T value) {
        return myHashMap.contains(value);
    }

    public void display() {
        myHashMap.displaySet();
    }

}
