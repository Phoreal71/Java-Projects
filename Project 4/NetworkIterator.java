import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * This class represents an iterator for the Network class
 * 
 * @author Christopher Tam
 */
public class NetworkIterator<S extends Entity> implements Iterator<S>{
  // nodeptr stores where we are in the list 
  private LLNode<S> nodeptr;
  /**
   * Creates a new NetworkIterator 
   * @param firstNode the first node whose data is returned by the iterator
   */
  public NetworkIterator(LLNode<S> firstNode){
    nodeptr = firstNode;      
  }
  
  /**
  * Returns true if there is still more data in the list
  * @return true if more data
  */
  @Override      
  public boolean hasNext(){
    return nodeptr != null;      
  }
  
  /**
  * Returns the next element stored in the list and increments.
  * @return the next element
  */
  @Override      
  public S next(){ 
    try{
      S element = nodeptr.getElement();        
      nodeptr = nodeptr.getNext();        
      return element;      
    }
    catch(NoSuchElementException e){
      System.out.println("No such element exists my guy!");
      return null;
    }
  }
      
}