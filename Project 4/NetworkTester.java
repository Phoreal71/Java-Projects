import org.junit.Test;
import static org.junit.Assert.*;
/**
 * This class represents a junit testing class for the Network class
 *
 * @author Christopher Tam
 */
public class NetworkTester{
  /**
   * Tests the Network constructor
   */
  @Test
  public void testNetwork(){
    Network a = new Network();
    assertEquals("Tests that constructor initializes network field correctly",null,a.getNetwork().getFront());
  }
  
  /**
   * Tests the getNetwork method
   */
  @Test
  public void testGetNetwork(){
    Network a = new Network();
    Entity b = new Entity("Chris");
    a.getNetwork().addToFront(b);
    assertEquals("Tests that getter method returns correct network field correctly",b,a.getNetwork().getFront().getElement());
  }
  
  /**
   * Tests the iterator method
   */
  @Test
  public void testIterator(){
    Network a = new Network();
    Entity b = new Entity("Zack");
    a.getNetwork().addToFront(b);
    NetworkIterator<Entity> netIter = new NetworkIterator<Entity>(a.getNetwork().getFront());
    assertEquals("Tests that getter method initializes a network iterator correctly",b,netIter.next());
  }
  
  /**
   * Tests the addRelation method
   */
  @Test
  public void testAddRelation(){
    Network a = new Network();
    Entity b = new Entity("Chris");
    Entity c = new Entity("Zack");
    a.addRelation(b,c);
    assertEquals("Tests that method adds entities to network correctly",c,a.getNetwork().getFront().getElement());
    assertEquals("Tests that method adds entities to network correctly",b,a.getNetwork().getFront().getNext().getElement());
    assertEquals("Tests that method adds entity to other entity's relations correctly",b,c.getRelations().getFront().getElement());
    assertEquals("Tests that method adds entity to other entity's relations correctly",c,b.getRelations().getFront().getElement());
  }
  
  /**
   * Tests the removeRelation method
   */
  @Test
  public void testRemoveRelation(){
    Network a = new Network();
    Entity b = new Entity("Chris");
    Entity d = new Entity("Long");
    Entity c = new Entity("Zack");
    Entity e = new Entity("Yuet");
    b.getRelations().addToFront(e);
    b.getRelations().addToFront(c);
    c.getRelations().addToFront(d);
    c.getRelations().addToFront(b);
    a.removeRelation(b,c);
    assertEquals("Tests that method removes entity from relation correctly",e,b.getRelations().getFront().getElement());
    assertEquals("Tests that method removes entity from relation correctly",d,c.getRelations().getFront().getElement());
  }
  
  /**
   * Tests the addRelations method
   */
  @Test
  public void testaddRelations(){
    try{
      Network a = new Network();
      String s[] = new String[2];
      s[0] = "How";
      s[1] = "Are";
      a.addRelations(s);
      Entity b = new Entity("How");
      Entity c = new Entity("Are");
      assertTrue("Tests that method adds relation to network correctly",b.equals(a.getNetwork().getFront().getElement()));
      assertTrue("Tests that method adds relation to network correctly",c.equals(a.getNetwork().getFront().getNext().getElement()));
    }
    catch(NotAnEvenStringException e){
      System.out.println("String input has an odd number of strings!");
    }
  }
}
