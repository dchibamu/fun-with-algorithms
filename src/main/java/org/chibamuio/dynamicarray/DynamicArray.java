package org.chibamuio.dynamicarray;

import java.util.Arrays;

public class DynamicArray<T> {
    Object []data;
    int size;
    public DynamicArray() {
        this.size = 0;
        this.data = new Object[1];
    }

    public int getSize(){
        return data.length;
    }

    public T get(int index){
        return (T) data[index];
    }

    public void put(Object index){
        ensureCapacity(size + 1);
    }

    public T update(T newValue, int index){
        return null;
    }

    public void delete(int index){

    }

    public void ensureCapacity(int minCapacity){
        int oldCapacity = getSize();
        if(minCapacity > oldCapacity){
            int newCapacity = oldCapacity*2;

            data = Arrays.copyOf(data, newCapacity);
        }
    }
}
