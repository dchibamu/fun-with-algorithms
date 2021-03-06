package org.chibamuio.datastructures.priorityqueues.impl.impl;

import org.chibamuio.datastructures.priorityqueues.impl.Entry;
import org.chibamuio.datastructures.priorityqueues.impl.PriorityQueue;

import java.util.Comparator;

public abstract class AbstractPriorityQueue<K, V> implements PriorityQueue<K, V> {

    private Comparator<K> comp;

    protected AbstractPriorityQueue(Comparator<K> c) {
        comp = c;
    }

    public AbstractPriorityQueue() {
        this(new DefaultComparator<K>());
    }

    protected int compare(Entry<K, V> a, Entry<K, V> b){
        return comp.compare(a.getKey(), b.getKey());
    }

    protected boolean checkKey(K key) throws IllegalArgumentException {

        try{
            return comp.compare(key,key) == 0;
        }catch(ClassCastException e){
            throw new IllegalArgumentException("Incompatible key");
        }
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    protected static class PQEntry<K, V> implements Entry<K, V> {
        private K k;
        private V v;

        public PQEntry(K key, V value) {
            this.k = key;
            this.v = value;
        }

        @Override
        public K getKey() {
            return k;
        }

        @Override
        public V getValue() {
            return v;
        }

        protected void setKey(K k) {
            this.k = k;
        }

        protected void setValue(V v) {
            this.v = v;
        }
    }
}
