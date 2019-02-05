package org.chibamuio.datastructures.priorityqueues.impl.impl;

import org.chibamuio.datastructures.priorityqueues.impl.Entry;

public class UnsortedPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {


    private int size;

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
        return null;
    }

    @Override
    public Entry<K, V> getMin() {
        return null;
    }

    @Override
    public Entry<K, V> removeMin() {
        return null;
    }

    @Override
    public Entry<K, V> kthSmallest() {
        return null;
    }

    @Override
    public void HeapSort() {

    }
}
