package org.chibamuio.datastructures.list;

public interface Position<E> {

    /**
     * Returns the element stored at that position
     *
     * @return the stored element
     * @throws IllegalArgumentException if position no longer valid
     */
    E getElement() throws IllegalArgumentException;
}
