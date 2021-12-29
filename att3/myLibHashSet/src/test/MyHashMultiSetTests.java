import mySet.set.MyHashMultiSet;
import mySet.set.MyHashSet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyHashMultiSetTests {

    @Test
    void testMultiSetContains() {
        MyHashMultiSet<String> myHashMultiSet = new MyHashMultiSet<>();
        myHashMultiSet.add("bmw");
        myHashMultiSet.add("audi");
        myHashMultiSet.add("toyota");
        myHashMultiSet.add("skoda");
        myHashMultiSet.add("toyota");
        Assertions.assertTrue(myHashMultiSet.contains("toyota"));
    }

    @Test
    void testMultiSetClear() {
        MyHashMultiSet<Integer> myHashMultiSet = new MyHashMultiSet<>();
        myHashMultiSet.add(41);
        myHashMultiSet.add(21);
        myHashMultiSet.add(141);
        myHashMultiSet.add(41);
        myHashMultiSet.add(34);
        myHashMultiSet.clear();
        Assertions.assertTrue(myHashMultiSet.isEmpty());
    }

    @Test
    void testMultiSetRemove() {
        MyHashMultiSet<String> myHashMultiSet = new MyHashMultiSet<>();
        myHashMultiSet.add("bmw");
        myHashMultiSet.add("audi");
        myHashMultiSet.add("toyota");
        myHashMultiSet.add("skoda");
        myHashMultiSet.add("toyota");
        Assertions.assertTrue(myHashMultiSet.contains("audi"));
    }

    @Test
    void testSetRemove() {
        MyHashMultiSet<String> myHashMultiSet = new MyHashMultiSet<>();
        myHashMultiSet.add("bmw");
        myHashMultiSet.add("audi");
        myHashMultiSet.add("toyota");
        myHashMultiSet.add("skoda");
        myHashMultiSet.add("toyota");
        myHashMultiSet.remove("toyota");
        myHashMultiSet.remove("audi");
        Assertions.assertFalse(myHashMultiSet.contains("audi"));
        Assertions.assertTrue(myHashMultiSet.contains("toyota"));
    }
}
