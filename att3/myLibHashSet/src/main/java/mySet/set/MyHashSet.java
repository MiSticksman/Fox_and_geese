package mySet.set;


import mySet.entry.MyEntry;
import mySet.hashMap.MyHashMap;

import java.util.Iterator;

public class MyHashSet<T> implements Iterable<T> {

    protected MyHashMap<T, Object> myHashMap;

    private static final Object PRESENT = new Object();

    public MyHashSet() {
        myHashMap = new MyHashMap<>();
    }

    public MyHashSet(int initialCapacity, float loadFactor) {
        myHashMap = new MyHashMap<T, Object>(initialCapacity, loadFactor);
    }

    public MyHashSet(int initialCapacity) {
        myHashMap = new MyHashMap<>(initialCapacity);
    }

    public boolean add(T value) {
        return myHashMap.put(value, PRESENT) == null;
    }

    public void remove(T value) {
        myHashMap.remove(value);
    }

    public int size() {
        return myHashMap.size();
    }

    public int getLength() {
        return myHashMap.getArrayLength();
    }

    public boolean contains(T value) {
        return myHashMap.contains(value);
    }

    public void clear() {
        myHashMap.clear();
    }

    public boolean isEmpty() {
        return myHashMap.isEmpty();
    }

    public void display() {
        myHashMap.displaySet();
    }

    @Override
    public Iterator<T> iterator() {
        class MyHahSetIterator implements Iterator<T>  {
            Iterator<MyEntry<T, Object>> iterator = myHashMap.iterator();
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public T next() {
                return iterator.next().getKey();
            }
        };
        return new MyHahSetIterator();
    }
}
