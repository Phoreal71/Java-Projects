import org.junit.Test;
import static org.junit.Assert.*;
/**
 * This class represents a junit testing class for the Entity class
 * 
 * @author Christopher Tam
 */
public class EntityTester{
  /**
   * Tests the Entity constructor
   */
  @Test
  public void testEntity(){
    Entity e = new Entity("Chris");
    assertEquals("Tests that constructor initializes name field correctly","Chris",e.getName());
    assertEquals("Tests that constructor initializes Health field correctly",Entity.Health.Uninfected,e.getHealthStatus());
    assertEquals("Tests that constructor initializes relations field correctly",null,e.getRelations().getFront());
  }
  
  /**
   * Tests the getName method
   */
  @Test
  public void testGetName(){
    Entity e = new Entity("Chris");
    assertEquals("Tests that getter method returns correct name value","Chris",e.getName());
  }
  
  /**
   * Tests the setName method
   */
  @Test
  public void testSetName(){
    Entity e = new Entity("Chris");
    e.setName("Zack");
    assertEquals("Tests that setter method sets name value correctly","Zack",e.getName());
  }
  
  /**
   * Tests the getHealthStatus method
   */
  @Test
  public void testGetHealthStatus(){
    Entity e = new Entity("Chris");
    assertEquals("Tests that getter method returns correct health value",Entity.Health.Uninfected,e.getHealthStatus());
  }
  
  /**
   * Tests the setHealthStatus method
   */
  @Test
  public void testSetHealthStatus(){
    Entity e = new Entity("Chris");
    e.setHealthStatus(Entity.Health.Infected);
    assertEquals("Tests that setter method sets correct health value",Entity.Health.Infected,e.getHealthStatus());
  }
  
  /**
   * Tests the getRelations method
   */
  @Test
  public void testGetRelations(){
    Entity e = new Entity("Chris");
    Entity a = new Entity("Zack");
    e.getRelations().addToFront(a);
    assertEquals("Tests that getter method returns correct relations list",a,e.getRelations().getFront().getElement());
  }
  
  /**
   * Tests the equals method
   */
  @Test
  public void testEquals(){
    Entity a = new Entity("Chris");
    Entity b = new Entity("Zack");
    Entity c = new Entity("Chris");
    assertTrue("Tests that equals method returns true correctly", a.equals(c));
    assertFalse("Tests that equals method returns false correctly", a.equals(b));  
  }
  
  /**
   * Tests the toString method
   */
  @Test
  public void testToString(){
    Entity a = new Entity("Chris");
    assertEquals("Tests that toString method returns correct string","Chris,Uninfected",a.toString());
  }
  
  /**
   * Tests the compareTo method
   */
  @Test
  public void testCompareTo(){
    Entity a = new Entity("Adam");
    Entity b = new Entity("Beck");
    Entity c = new Entity("Chris");
    Entity d = new Entity("Beck");
    assertTrue("Tests that method returns 0 correctly", b.compareTo(d) == 0);
    assertTrue("Tests that method returns 1 correctly", b.compareTo(a) == 1);
    assertTrue("Tests that method returns -1 correctly",b.compareTo(c) == -1);
  }
}
    