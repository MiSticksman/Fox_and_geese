package mySet.set;

import mySet.entry.MyEntry;
import mySet.entry.MyEntryMulti;
import mySet.hashMap.MyHashMap;

import java.util.Iterator;

public class MyHashMultiSet<T> extends MyHashSet<T> {
    public MyHashMultiSet() {
        myHashMap = new MyHashMap<T, Object>();
    }

    public MyHashMultiSet(int initialCapacity, float loadFactor) {
        myHashMap = new MyHashMap<T, Object>(initialCapacity, loadFactor);
    }

    @Override
    public boolean add(T value) {
        if (myHashMap.contains(value)) {
            myHashMap.put(value, (Integer) myHashMap.get(value) + 1);
        } else {
            myHashMap.put(value, 1);
        }
        return true;
    }

    @Override
    public void remove(T value) {
        if ((Integer) myHashMap.get(value) == 1) {
            myHashMap.remove(value);
        } else {
            myHashMap.put(value, (Integer) myHashMap.get(value) - 1);
        }
    }

    public Iterable<MyEntryMulti<T>> getIteratorByValueAndCount() {
        class MyHashIterable implements Iterable<MyEntryMulti<T>> {
            @Override
            public Iterator<MyEntryMulti<T>> iterator() {
                class MyHashMultiSetIterator implements Iterator<MyEntryMulti<T>> {
                    Iterator<MyEntry<T, Object>> iterator = myHashMap.iterator();

                    @Override
                    public boolean hasNext() {
                        return iterator.hasNext();
                    }

                    @Override
                    public MyEntryMulti<T> next() {
                        MyEntry<T, Object> myEntry = iterator.next();
                        return new MyEntryMulti(myEntry.getKey(), (Integer) myEntry.getValue());
                    }
                }
                ;
                return new MyHashMultiSetIterator();
            }
        }
        return new MyHashIterable();
    }
}
