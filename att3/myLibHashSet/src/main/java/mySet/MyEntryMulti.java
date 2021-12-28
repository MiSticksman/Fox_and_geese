package mySet;

public class MyEntryMulti<T> {
    private T key;
    private int value;

    public MyEntryMulti(T key, int value) {
        this.key = key;
        this.value = value;
    }

    public T getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
