package mySet;

import mySet.hashMap.MyHashMap;


import java.util.HashSet;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {


//       MyHashMap<String, Integer> myHashMap = new MyHashMap<>();
//        myHashMap.put("one", 1);
//        myHashMap.put("two", 2);
//        myHashMap.put("three", 3);
//       // myHashMap.put("one", 5);
//        //myHashMap.put("dsgsg", 7);
//        //myHashMap.put("three", 4);
//        myHashMap.put("four", 4);
//        myHashMap.put(null, 100);
//        myHashMap.put("five", 5);
//        myHashMap.put("six", 6);
//        myHashMap.put("seven", 7);
//        myHashMap.put("eight", 8);
//        myHashMap.put("nine", 9);
//        myHashMap.put("ten", 10);
//        myHashMap.put("eleven", 11);
//        for (MyEntry entry: myHashMap) {
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }



        /*MyHashSet<Integer> myHashSet = new MyHashSet<>();
        myHashSet.put(11);
        myHashSet.put(2);
        myHashSet.put(1);
        myHashSet.put(4);
        myHashSet.put(5);
        myHashSet.put(14);
        myHashSet.put(14);
        myHashSet.put(41);
//        myHashSet.display();
        for (Integer a: myHashSet) {
            System.out.println(a);
        }*/

        MyHashMultiSet<String> myHashMultiSet = new MyHashMultiSet<>();
        myHashMultiSet.put("a");
        myHashMultiSet.put("b");
        myHashMultiSet.put("c");
        myHashMultiSet.put("b");
        myHashMultiSet.put("a");
        myHashMultiSet.put("c");
        myHashMultiSet.put("a");
        myHashMultiSet.put("d");
        myHashMultiSet.put("f");
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


//        HashMap<String, Integer> hashMap = new HashMap<>();
//        hashMap.put("one", 1);
//        hashMap.put("two", 2);
//        hashMap.put("three", 3);
//        hashMap.put("one", 5);
//        hashMap.put("dsgsg", 7);
//        hashMap.put("three", 4);
//        for (Map.Entry<String, Integer> entry: hashMap.entrySet()) {
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }

       /*HashSet<String> hashSet = new HashSet<>();
        hashSet.add("Vadim");
        hashSet.add("Pasha");
        hashSet.add("Denis");
        hashSet.add("Serega");
        System.out.println(hashSet.contains("Vadim"));
        for (String entry: hashSet) {
            System.out.println(entry);
        }*/

    }
}
