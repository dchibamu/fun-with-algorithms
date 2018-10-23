package org.chibamuio.datastructures.priorityqueues.impl.impl;

import java.util.Comparator;

@SuppressWarnings("unchecked")
public class DefaultComparator<K> implements Comparator<K> {
    @Override
    public int compare(K o1, K o2) {
        return ((Comparator<K>)o1).compare(o1, o2);
    }
}
