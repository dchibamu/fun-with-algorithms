package org.chibamuio.datastructures.hashmaps;

public class Entry {
    private int key;
    private Object value;
    private Entry next;

    public Entry(int key, Object value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }

    public Entry() {
        next = null;
    }

    public int getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }
}
