package mySet;

import mySet.entry.MyEntry;
import mySet.entry.MyEntryMulti;
import mySet.hashMap.MyHashMap;
import mySet.set.MyHashMultiSet;
import mySet.set.MyHashSet;

public class Main {

    public static void main(String[] args) {

       MyHashMap<String, Integer> myHashMap = new MyHashMap<>();
        myHashMap.put("one", 1);
        myHashMap.put("two", 2);
        myHashMap.put("three", 3);
        myHashMap.put("four", 4);
        myHashMap.put(null, 100);
        myHashMap.put("five", 5);
        myHashMap.put("six", 6);
        myHashMap.put("seven", 7);
        myHashMap.put("seven", 8);
        myHashMap.put("eight", 8);
        myHashMap.put("eight", 314);
        myHashMap.put("nine", 9);
        myHashMap.put("nine", 4141);
        myHashMap.put("six", 666);
        myHashMap.put("ten", 10);
        myHashMap.put("eleven", 11);
        for (MyEntry entry: myHashMap) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }


        MyHashSet<Integer> myHashSet = new MyHashSet<>();
        myHashSet.add(11);
        myHashSet.add(2);
        myHashSet.add(1);
        myHashSet.add(4);
        myHashSet.add(5);
        myHashSet.add(14);
        myHashSet.add(14);
        myHashSet.add(41);
//        myHashSet.display();
        for (Integer a: myHashSet) {
            System.out.println(a);
        }

        MyHashMultiSet<String> myHashMultiSet = new MyHashMultiSet<>();
        myHashMultiSet.add("a");
        myHashMultiSet.add("b");
        myHashMultiSet.add("c");
        myHashMultiSet.add("b");
        myHashMultiSet.add("a");
        myHashMultiSet.add("c");
        myHashMultiSet.add("a");
        myHashMultiSet.add("d");
        myHashMultiSet.add("f");
        myHashMultiSet.remove("b");
        myHashMultiSet.remove("b");
        myHashMultiSet.remove("a");
        myHashMultiSet.remove("a");
        myHashMultiSet.remove("a");
        for (MyEntryMulti<String> myEntryMulti: myHashMultiSet.getIteratorByValueAndCount()) {
            System.out.println(myEntryMulti.getKey() + " " + myEntryMulti.getValue());
        }
        System.out.println(myHashMultiSet.contains("d"));
        System.out.println(myHashMultiSet.isEmpty());
        myHashMultiSet.clear();
        for (MyEntryMulti<String> myEntryMulti: myHashMultiSet.getIteratorByValueAndCount()) {
            System.out.println(myEntryMulti.getKey() + " " + myEntryMulti.getValue());
        }
        System.out.println(myHashMultiSet.isEmpty());



    }
}
