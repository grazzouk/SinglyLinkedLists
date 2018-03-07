import java.util.AbstractSequentialList;
import java.util.ListIterator;
import java.util.Collection;
/**
 * A linked list with pointers to the first and last node.
 *
 * @author Gabriel Razzouk
 * @version 30/11/2017
 */
public class SinglyLinkedList<E> extends AbstractSequentialList<E>
{
    private Node<E> first;
    private Node<E> last;
    private int size;
    /**
     * Constructor for a SinglyLinkedList that creates an empty list.
     */
    public SinglyLinkedList()
    {
        first = null;
        last = null;
        size = 0;
    }
    
    /**
     * Constructor for a SinglyLinkedList that creates a list that contains all the objects in a collection given in the argument.
     */
    public SinglyLinkedList(Collection<E> collection)
    {
        for(E element: collection){
             add(element);
        }
    }
    
    /**
     * Adds an object to the Linked List.
     */
    public boolean add(E object){
        Node<E> node = new Node<E>(object, null);
        if (last == null){
            first = node;
        }
        else{
            last.right = node;
        }
        last = node;
        size++;
        return true;       
    }
    
    /**
     * Creates a new iterator over this linked list.
     */
    public ListIterator<E> listIterator(int pos) throws IndexOutOfBoundsException{
        if (pos < 0 || pos > size()) {
            throw new IndexOutOfBoundsException();
        }
        ListIterator<E> li = new SinglyListIterator<E>(pos, this);
        return li;
    }
    
    /**
     * Returns the size of the linked list.
     */
    public int size(){
        return size;
    }
    
    /**
     * Returns the first element of the linked list.
     */
    public Node<E> getFirst(){
        return first;
    }
    
    /**
     * Adds one to the size of the linked list.
     */
        public void incrementSize(){
        size++;
    }
    
    /**
     * Mutator method that sets the value of the last node.
     */
    public void setLast(Node<E> node){
        last = node;
    }
    
    /**
     * Mutator method that sets the value of the first node.
     */
    public void setFirst(Node<E> node){
        first = node;
    }
    
}

