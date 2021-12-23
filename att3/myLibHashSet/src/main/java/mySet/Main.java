package mySet;

import mySet.hashMap.MyHashMap;
import mySet.trial.TryHashSet;

import java.util.HashMap;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {

//        HashSetCustom<String> hashSetCustom = new HashSetCustom<>();
//        hashSetCustom.add("Vadim");
//        hashSetCustom.add("Pasha");
//        hashSetCustom.add("Denis");
//        hashSetCustom.add("Serega");
//        hashSetCustom.add("Max");
//        hashSetCustom.display();
//        System.out.println(hashSetCustom.contains("Vadim"));

//        HashMapCustom<String, Integer> hashMapCustom = new HashMapCustom<>();
//        hashMapCustom.put("one", 1);
//        hashMapCustom.put("two", 2);
//        hashMapCustom.put("three", 3);

       MyHashMap<String, Integer> myHashMap = new MyHashMap<>();
        myHashMap.put("one", 1);
        myHashMap.put("two", 2);
        myHashMap.put("three", 3);
       // myHashMap.put("one", 5);
        //myHashMap.put("dsgsg", 7);
        //myHashMap.put("three", 4);
        myHashMap.put("four", 4);
        myHashMap.put("five", 5);
        myHashMap.put("six", 6);
        myHashMap.put("seven", 7);
        myHashMap.put("eight", 8);
        myHashMap.put("nine", 9);
        myHashMap.put("ten", 10);
        myHashMap.put("eleven", 11);

        myHashMap.display();
//
//        selfHashMap.remove("six");
//        selfHashMap.remove("two");
//        selfHashMap.remove("four");
//        selfHashMap.remove("three");
//        System.out.println();
//        selfHashMap.display();
//        System.out.println();
//        System.out.println(selfHashMap.contains("five"));
//        System.out.println(selfHashMap.contains("six"));

        /*MyHashSet<Integer> myHashSet = new MyHashSet<>();
        myHashSet.put(1);
        myHashSet.put(2);
        myHashSet.put(4);
        myHashSet.put(1);
        myHashSet.display();
        System.out.println();
        myHashSet.remove(2);
        myHashSet.display();
        System.out.println(myHashSet.contains(1));*/
//        myHashSet.put(1);
//        myHashSet.put(1);

        /*TryHashSet<String, Integer> tryHashSet = new TryHashSet<>();
        tryHashSet.put("one", 1);
        tryHashSet.put("two", 2);
        tryHashSet.put("three", 3);
        tryHashSet.put("one", 5);
        tryHashSet.put("dsgsg", 7);
        tryHashSet.put("three", 4);
        tryHashSet.put("four", 52);
        tryHashSet.put("five", 61);
        tryHashSet.put("six", 411);
        tryHashSet.put("seven", 87);*/


        HashMap<String, Integer> hashMap = new HashMap<>();
//        hashMap.put("one", 1);
//        hashMap.put("two", 2);
//        hashMap.put("three", 3);
//        hashMap.put("one", 5);
//        hashMap.put("dsgsg", 7);
//        hashMap.put("three", 4);
//        for (Map.Entry<String, Integer> entry: hashMap.entrySet()) {
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }

       HashSet<String> hashSet = new HashSet<>();
//        hashSet.add("Vadim");
//        hashSet.add("Pasha");
//        hashSet.add("Denis");
//        hashSet.add("Serega");
//        System.out.println(hashSet.contains("Vadim"));
    }
}
