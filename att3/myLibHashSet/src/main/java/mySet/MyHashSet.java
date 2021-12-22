package mySet;


import mySet.hashMap.MyHashMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MyHashSet<T> {

    private MyHashMap<T, Object> myHashMap;

    public MyHashSet() {
        myHashMap = new MyHashMap<>();
    }

    public MyHashSet(int initialCapacity, float loadFactor) {
        myHashMap = new MyHashMap<T, Object>(initialCapacity, loadFactor);
    }

    public void put(T value) {
        myHashMap.put(value, null);
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
