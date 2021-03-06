package org.chibamuio.datastructures.priorityqueues.impl;

public interface PriorityQueue<K, V> {
    int size();
    boolean isEmpty();
    Entry<K, V> insert(K key, V value) throws IllegalArgumentException;
    Entry<K, V> getMin();
    Entry<K, V> removeMin();
    Entry<K, V> kthSmallest();
    void HeapSort();
}
