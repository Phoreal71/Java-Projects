import java.util.NoSuchElementException;
import java.util.Iterator;

/**
 * A class to represent a linked list of nodes.
 */
public class LinkedList<T> implements Iterable<T> {
  /** the first node of the list, or null if the list is empty */
  private LLNode<T> front;
  
  /**
   * Creates an initially empty linked list
   */
  public LinkedList() {
    front = null;
  }
  
  /**
   * Returns the first node.
   */
  protected LLNode<T> getFront() {
    return front;
  }

  /**
   * Changes the first node.
   * @param node  the first node of the new linked list
   */
  protected void setFront(LLNode<T> node) {
    this.front = node;
  }

  /**
   * Add an element to the front of the linked list
   * @param element  the element to add
   */
  public void addToFront(T element) {
    setFront(new LLNode<T>(element, getFront()));
  }
  
  /**
   * Return whether the list is empty
   * @return true if the list is empty
   */
  public boolean isEmpty() {
    return (getFront() == null);
  }
  
  /**
   * Returns the length of the linked list
   * @return the number of nodes in the list
   */
  public int length() {
    int count = 0;                      // counts number of nodes seen
    LLNode<T> nodeptr = getFront();
    while (nodeptr != null) {
      count++;
      nodeptr = nodeptr.getNext();
    }
    return count;
  }
  
  /**
   * Remove and return the element at the front of the list
   * @return the first element of the list
   * @throws NoSuchElementException if there is no such element
   */
  public T removeFromFront() {
    if (isEmpty())
      throw new NoSuchElementException();
    else {
      T save = getFront().getElement();
      setFront(getFront().getNext());
      return save;
    }
  }

  /**
   * Add an element to the very end of the list
   * @param element the element to add to the end of the list
   */
  public void addToEnd(T element) {
    if (isEmpty()) 
      addToFront(element);
    else {
      LLNode<T> nodeptr = getFront();
      // the loop will end with nodeptr looking at the last node in list
      while (nodeptr.getNext() != null)
        nodeptr = nodeptr.getNext();
      nodeptr.setNext(new LLNode<T>(element, null));
    }
  }
  
  /**
   * Print the contents of the list to the console.
   * @param list the list to print
   */
  public static <T> void printList1(LinkedList<T> list) {
    LLNode<T> nodeptr = list.getFront();
    while (nodeptr != null) {
      System.out.print(nodeptr.getElement().toString() + " ");
      nodeptr = nodeptr.getNext();
    }
    System.out.println();
  }
  
  /**
   * Return an iterator for our linked list
   * @return the iterator
   */
  public Iterator<T> iterator() {
    return new LinkedListIterator<T>(getFront());
  }
  
}
