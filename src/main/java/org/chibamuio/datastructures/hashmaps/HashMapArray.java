package org.chibamuio.datastructures.hashmaps;

public class HashMapArray<T> {
    private Entry[] arrayHash;
    private int size;
    public HashMapArray() {

        this.size = size;
        arrayHash = new Entry[size];
        for(int i = 0; i < size; i++){
            arrayHash[i] = new Entry();
        }
    }

    public int getHash(int key){
        return key % size;
    }

    public void put(int key, Object value){
        int hashIndex = getHash(key);
        //Entry current
    }
}
