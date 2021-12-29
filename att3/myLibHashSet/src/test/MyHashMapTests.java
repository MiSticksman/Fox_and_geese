import mySet.hashMap.MyHashMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyHashMapTests {

    @Test
    void testMapPut() {
        MyHashMap<String, String> myHashMap = new MyHashMap<>();
        myHashMap.put("book1", "author1");
        myHashMap.put("book2", "author2");
        myHashMap.put("book1", "author3");
        Assertions.assertEquals(myHashMap.get("book1"), "author3");
    }

    @Test
    void testMapPutNull() {
        MyHashMap<String, String> myHashMap = new MyHashMap<>();
        myHashMap.put(null, "author1");
        myHashMap.put(null, "author2");
        Assertions.assertEquals(myHashMap.get(null), "author2");
    }

    @Test
    void testMapRemove() {
        MyHashMap<String, String> myHashMap = new MyHashMap<>();
        myHashMap.put("book1", "author1");
        myHashMap.put("book2", "author2");
        myHashMap.put("book3", "author3");
        myHashMap.remove("book3");
        Assertions.assertNull(myHashMap.get("book3"));
    }

    @Test
    void testMapClear() {
        MyHashMap<String, String> myHashMap = new MyHashMap<>();
        myHashMap.put("book1", "author1");
        myHashMap.put("book2", "author2");
        myHashMap.put("book3", "author3");
        myHashMap.clear();
        Assertions.assertTrue(myHashMap.isEmpty());
    }

    @Test
    void testMapSize() {
        MyHashMap<String, String> myHashMap = new MyHashMap<>();
        myHashMap.put("book1", "author1");
        myHashMap.put("book2", "author2");
        myHashMap.put("book3", "author3");
        myHashMap.put("book3", "author4");
        myHashMap.put("book5", "author5");
        myHashMap.put("book6", "author6");
        Assertions.assertEquals(myHashMap.size(), 5);
    }

    @Test
    void testMapGet() {
        MyHashMap<String, String> myHashMap = new MyHashMap<>();
        myHashMap.put("book1", "author1");
        myHashMap.put(null, "author2");
        myHashMap.put(null, "author3");
        myHashMap.put("book5", "author5");
        Assertions.assertEquals(myHashMap.get(null), "author3");
        Assertions.assertEquals(myHashMap.get("book5"), "author5");
    }

    @Test
    void testMapResize() {
        MyHashMap<String, String> myHashMap = new MyHashMap<>(4, 0.5F);
        myHashMap.put("book1", "author1");
        myHashMap.put(null, "author2");
        myHashMap.put(null, "author3");
        myHashMap.put("book5", "author5");
        myHashMap.put("book10", "author5");
        Assertions.assertEquals(myHashMap.size(), 4);
        Assertions.assertEquals(myHashMap.getArrayLength(), 8);
    }

}
