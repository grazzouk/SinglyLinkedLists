import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * An iterator for singlyLinkedLists that can go forwards, backwards, and add items to the list.
 * 
 * @author Gabriel Razzouk
 * @version 30/11/2017
 */
public class SinglyListIterator<E> implements ListIterator<E> 
{
    private Node<E> previous;
    private Node<E> next;
    private SinglyLinkedList<E> list;
    private int nextIndex;
    /**
     * A constructor for the iterator which takes a list and sets the user set position as the next node.
     * If the given position is too low or too high it defaults to either the lowest or highest index.
     */
    public SinglyListIterator(int pos, SinglyLinkedList<E> l) throws IndexOutOfBoundsException{
        if (pos < 0 || pos > l.size()){
            throw new IndexOutOfBoundsException();
        }
        Node<E> start = l.getFirst();
        next = start;
        previous = null;
        list = l;
        nextIndex  = pos;
        for (int i = 0; i < pos; i++){
            previous = next;
            next = next.right;
        }
    }
    
    /**
     * Adds an element to the list between the previous and next nodes.
     */
    public void add(E e){
        Node<E> node = new Node<E>(e, null);
        if(hasNext()){
            node.right = next;
        }
        else{
            list.setLast(node);
        }
        if (hasPrevious()){
            previous.right = node;
        }
        else {
            list.setFirst(node);
        }
        list.incrementSize();
        previous = node;
        next = node.right;
        nextIndex++;
    }
    
    /**
     * Moves backwards one step through the list.
     */
    public E previous() throws NoSuchElementException{
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            next = list.getFirst();
            previous = null;
            for (int i = 0; i < nextIndex - 1; i++){
                previous = next;
                next = next.right;
            }
            nextIndex--;
            return next.left;
        }
        
    /**
     * Moves forewards one step through the list.
     */
    public E next() throws NoSuchElementException{
        if (!hasNext()){ 
            throw new NoSuchElementException();
        }
        previous = next;
        next = next.right;
        nextIndex++;
        return previous.left;
    }

    /**
     * Returns the index of the previous node.
     */
    public int previousIndex(){
        return nextIndex - 1;
    }
    
    /**
     * Returns the index of the next node.
     */
    public int nextIndex(){
        return nextIndex;
    }
    
    /**
     * Checks if the list has a previous node.
     */
    public boolean hasPrevious(){
        return nextIndex > 0; 
    }
    
    /**
     * Checks if the list has a next node.
     */
    public boolean hasNext(){
        return nextIndex < list.size();
    }
    
    //required but not implemented
    public void set(E e){throw new UnsupportedOperationException();}
    
    //required but not implemented
    public void remove(){throw new UnsupportedOperationException();}
}
