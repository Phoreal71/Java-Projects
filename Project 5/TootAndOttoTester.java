import org.junit.Test;
import static org.junit.Assert.*;
import javafx.scene.control.Button;
/**
 * This class represents a junit testing class for the TootAndOtto class
 * 
 * @author Christopher Tam
 */
public class TootAndOttoTester{
  /**
   * Tests the setWin method
   */
  @Test
  public void testSetWin(){
    TootAndOtto.setWin(2);
    assertEquals("Tests that setter method sets win value correctly", 2, TootAndOtto.getWin());
  }
  
  /**
   * Tests the getWin method
   */
  @Test
  public void testGetWin(){
    assertEquals("Tests that getter method returns correct win value", 2, TootAndOtto.getWin());
  }
  
  /**
   * Tests the setTurn method
   */
  @Test
  public void testSetTurn(){
    TootAndOtto.setTurn(2);
    assertEquals("Tests that setter method sets turn value correctly", 2, TootAndOtto.getTurn());
  }
  
  /**
   * Tests the getTurn method
   */
  @Test
  public void testGetTurn(){
    assertEquals("Tests that getter method returns correct turn value", 2, TootAndOtto.getTurn());
  }
  
  /**
   * Tests the setArray method
   */
  @Test
  public void testSetArray(){
    Button[][] a = new Button[6][6];
    TootAndOtto.setArray(a);
    assertTrue("Tests that setter method sets array correctly",a.equals(TootAndOtto.getArray()));
  }
  
  /**
   * Tests the getArray method
   */
  @Test
  public void testGetArray(){
    Button[][] a = new Button[6][6];
    TootAndOtto.setArray(a);
    assertTrue("Tests that getter method returns correct array", a.equals(TootAndOtto.getArray()));
  }
    
}