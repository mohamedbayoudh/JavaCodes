package edu.kit.informatik.sortierteListe;


public interface SortedIterator<T extends Comparable<T>> {
     /**
     * it returns a boolean result , which describe if the list has a next element or is finish
     * 
     * @return true or false
     */
    boolean hasNext();
    /**
     * it returns the content of the Cell and move the Iterator to the next element 
     * 
     * @return the next element of the list
     */
    T next();
}
