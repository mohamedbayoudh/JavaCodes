package edu.kit.informatik.sortierteListe;
/**
 * 
 * @author Bayoudh Mohamed
 * @matNr 2082466
 * contains the interfaces of the class LinkedSortedAppendList
 * 
 */
public interface SortedAppendList<T extends Comparable<T>> {
    /**
     * @param element
     * 
     * it adds a sorted element in the list
     */
    void addSorted(T element);
    /**
     * @return an Iterator which make the manipulation of the list easier
     */
    SortedIterator<T> iterator();
}

