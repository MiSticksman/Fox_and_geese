import mySet.set.MyHashSet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyHashSetTests {

    @Test
    void testSetContains() {
        MyHashSet<String> myHashSet = new MyHashSet<>();
        myHashSet.add("bmw");
        myHashSet.add("audi");
        myHashSet.add("toyota");
        myHashSet.add("skoda");
        myHashSet.add("toyota");
        Assertions.assertTrue(myHashSet.contains("bmw"));
    }

    @Test
    void testSetClear() {
        MyHashSet<String> myHashSet = new MyHashSet<>();
        myHashSet.add("bmw");
        myHashSet.add("audi");
        myHashSet.add("toyota");
        myHashSet.add("skoda");
        myHashSet.add("toyota");
        myHashSet.clear();
        Assertions.assertTrue(myHashSet.isEmpty());
    }


    @Test
    void testSetRemove() {
        MyHashSet<String> myHashSet = new MyHashSet<>();
        myHashSet.add("bmw");
        myHashSet.add("audi");
        myHashSet.add("toyota");
        myHashSet.add("skoda");
        myHashSet.remove("audi");
        Assertions.assertFalse(myHashSet.contains("audi"));
    }

    @Test
    void testSetResize() {
        MyHashSet<String> myHashSet = new MyHashSet<>(4, 0.5F);
        myHashSet.add("bmw");
        myHashSet.add("audi");
        myHashSet.add("toyota");
        myHashSet.add("bmw");
        myHashSet.add("skoda");
        Assertions.assertEquals(myHashSet.size(), 4);
        Assertions.assertEquals(myHashSet.getLength(), 8);
    }

}
