package edu.kit.informatik.sortierteListe;

/**
 * 
 * @author Bayoudh Mohamed
 * @matNr 2082466 contains the implementation of the interfaces of
 *        SortedAppendList in the class LinkedSortedAppendList
 *        and the implementation of the interface Sorted Iterator in the class SortedIteratorImpl
 *
 */
public class LinkedSortedAppendList<T extends Comparable<T>> implements SortedAppendList<T> {
    private Cell<T> head;

    /**
     * a constructor which return a empty list
     */
    public LinkedSortedAppendList() {
        this.head = null; // leere Liste
    }

    /**
     * @param element
     * 
     * it adds a sorted element in the list
     */
    public void addSorted(T element) {
        //------ Adding when the list is empty : 
        if (this.head == null) {
             this.head = new Cell<T>(element , null);
            }
        //------ Adding when the list is not  empty : 
        else
        {
             T hi = null;
             this.head = new Cell<T>(element, this.head);
             SortedIteratorImpl<T> it = (SortedIteratorImpl<T>) iterator();
             while ((it.hasNext()) && (it.cursor.next != null) 
                       && (it.cursor.content.compareTo(it.cursor.next.content) >= 0 )) {
                 if (it.cursor.content.compareTo(it.cursor.next.content) >= 0 ) {
                     hi = it.cursor.content;
                     it.cursor.content = it.cursor.next.content;
                     it.cursor.next.content = hi;
                     it.next();
                 }
                 else {
                      it.next();
                      
                 }
            }
             
        }
        
    }

    /**
     * @return an Iterator which make the manipulation of the list easier
     */
    public SortedIterator<T> iterator() {
        return new SortedIteratorImpl<T>(this.head);
    }

    public class Cell<T> {
        private T content;
        private Cell<T> next;

        /**
         * a Constructor which fill the object Cell<T> with the content and the next reference of the list
         * 
         * @param p
         *            the content of the Cell<T>ule
         * @param n
         *            the reference of the next element
         */
        public Cell(T p, Cell<T> n) {
            this.content = p;
            this.next = n;
        }
    }

    public class SortedIteratorImpl<T extends Comparable<T>> implements SortedIterator<T> {
        private Cell<T> cursor;
        /**
         * a Constructor which fill the Iterator
         * 
         * @param start
         *             the start of the Iterator
         */
        public SortedIteratorImpl(Cell<T> start ) {
            this.cursor = start;
        }

        /**
         * it returns a boolean result , which describe if the list has a next element or is finish
         * 
         * @return true or false
         */
        public boolean hasNext() {
            return (this.cursor != null);
        }

        /**
         * it returns the content of the Cell<T> and move the Iterator to the next element 
         * 
         * @return the next element of the list 
         */
        public T next() {
            T c =  this.cursor.content;
            this.cursor = this.cursor.next;
            return c;
        }
    }
}
