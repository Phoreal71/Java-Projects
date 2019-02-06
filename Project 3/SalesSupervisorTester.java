// Packages imported for junit testing
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * This class represents a junit testing class for the SalesSupervisor class
 * 
 * @author Christopher Tam
 */
public class SalesSupervisorTester{
  /**
   * Tests the SalesSupervisor constructor
   */
  @Test
  public void testSalesSupervisor(){
    SalesSupervisor e = new SalesSupervisor("Zack","Thomas","567",50.0,40.0);
    assertEquals("Tests that constructor initializes firstname field correctly", "Zack", e.getFirstName());
    assertEquals("Tests that constructor initializes lastname field correctly", "Thomas", e.getLastName());
    assertEquals("Tests that constructor initializes number field correctly", "567", e.getNumber());
    assertTrue("Tests that constructor initializes hourlyrate field correctly", 50.0 == e.getSalary());
    assertTrue("Tests that constructor initializes hourlyrate field correctly", 40.0 == e.getCommission());
  }
  
  /**
   * Tests the getFirstName method
   */
  @Test
  public void testGetFirstName(){
    SalesSupervisor e = new SalesSupervisor("Zack","Thomas","567",50.0,40.0);
    assertEquals("Tests that getter method returns correct firstname value", "Zack", e.getFirstName());
  }
  
  /**
   * Tests the getLastName method
   */
  @Test
  public void testGetLastName(){
    SalesSupervisor e = new SalesSupervisor("Zack","Thomas","567",50.0,40.0);
    assertEquals("Tests that getter method returns correct lastname value", "Thomas", e.getLastName());
  }
  
  /**
   * Tests the setName method
   */
  @Test
  public void testSetName(){
    SalesSupervisor e = new SalesSupervisor("Zack","Thomas","567",50.0,40.0);
    e.setName("Chris","Puckers");
    assertEquals("Tests that setter method sets firstname value", "Chris", e.getFirstName());
    assertEquals("Tests that setter method sets lastname value", "Puckers", e.getLastName());
  }
  
  /**
   * Tests the getNumber method
   */
  @Test
  public void testGetNumber(){
    SalesSupervisor e = new SalesSupervisor("Zack","Thomas","567",50.0,40.0);
    assertEquals("Tests that getter method returns correct number value", "567", e.getNumber());
  }
  
  /**
   * Tests the getSalary method
   */
  @Test
  public void testGetSalary(){
    SalesSupervisor e = new SalesSupervisor("Zack","Thomas","567",50.0,40.0);
    assertTrue("Tests that getter method returns correct salary value", 50.0 == e.getSalary());
  }
  
  /**
   * Tests the setSalary method
   */
  @Test
  public void testSetSalary(){
    SalesSupervisor e = new SalesSupervisor("Zack","Thomas","567",50.0,40.0);
    e.setSalary(100.0);
    assertTrue("Tests that setter method sets salary value correctly", 100.0 == e.getSalary());
  }
  
  /**
   * Tests the getCommission  method
   */
  @Test
  public void testGetCommission(){
    SalesSupervisor e = new SalesSupervisor("Zack","Thomas","567",50.0,40.0);
    e.setCommission(35.0);
    assertTrue("Tests that getter method returns the correct commission", 35.0 == e.getCommission());
  }
  
  /**
   * Tests the setCommission method
   */
  @Test
  public void testSetCommission(){
    SalesSupervisor e = new SalesSupervisor("Zack","Thomas","567",50.0,40.0);
    e.setCommission(35.0);
    assertTrue("Tests that setter method sets the commission correctly", 35.0 == e.getCommission());
  }
  
  /**
   * Tests the getNumSales method
   */
  @Test
  public void testGetNumSales(){
    SalesSupervisor e = new SalesSupervisor("Zack","Thomas","567",50.0,40.0);
    e.setNumSales(5);
    assertTrue("Tests that getter method returns the correct numsales", 5 == e.getNumSales());
  }
  
  /**
   * Tests the setNumSales method
   */
  @Test
  public void testSetNumSales(){
    SalesSupervisor e = new SalesSupervisor("Zack","Thomas","567",50.0,40.0);
    e.setNumSales(5);
    assertTrue("Tests that setter method sets the correct numsales", 5 == e.getNumSales());
  }
  
  /**
   * Tests the getBonus method
   */
  @Test
  public void testGetBonus(){
    SalesSupervisor e = new SalesSupervisor("Zack","Thomas","567",50.0,40.0);
    e.setBonus(700.0);
    assertTrue("Tests that getter method returns correct bonus value", 700.0 == e.getBonus());
  }
  
  /**
   * Tests the setBonus method
   */
  @Test
  public void testSetBonus(){
    SalesSupervisor e = new SalesSupervisor("Zack","Thomas","567",50.0,40.0);
    e.setBonus(500.0);
    assertTrue("Tests that setter method sets bonus value correctly", 500.0 == e.getBonus());
  }
  
  /**
   * Tests the getAmountEarned method
   */
  @Test
  public void testGetAmountEarned(){
    SalesSupervisor e = new SalesSupervisor("Zack","Thomas","567",50.0,40.0);
    e.setNumSales(5);
    e.setBonus(10.0);
    assertTrue("Tests that method returns correct amount earned", 260.0 == e.getAmountEarned());
  }
  
  /**
   * Tests the adjustPay method
   */
  @Test 
  public void testAdjustPay(){
    SalesSupervisor a = new SalesSupervisor("Fey","Thomas","667",50.0,40.0);
    SalesSupervisor e = new SalesSupervisor("Zack","Thomas","567",50.0,30.0);
    e.adjustPay(0.1);
    a.adjustPay(-0.1);
    assertTrue("Tests that method adjusts pay correctly", 33.0 == e.getCommission());
    assertTrue("Tests that method adjusts pay correctly", 36.0 == a.getCommission());
  }
  
  /**
   * Tests the toString method overrider 
   */
  @Test
  public void testToString(){
    SalesSupervisor e = new SalesSupervisor("Zack","Thomas","567",50.0,40.0);
    assertEquals("Tests that method returns correct string expression", "567:Thomas,Zack,Sales Supervisor", e.toString());
  }
  
  /**
   * Tests the equals method overrider 
   */
  @Test
  public void testEquals(){
    SalesSupervisor e = new SalesSupervisor("Zack","Thomas","567",50.0,10.0);
    SalesSupervisor a = new SalesSupervisor("Zack","Thomas","567",60.0,20.0);
    SalesSupervisor b = new SalesSupervisor("Fey","Thomas","567",60.0,30.0);
    SalariedEmployee c = new SalariedEmployee("Zack","Thomas","567",60.0);
    assertTrue("Tests that equals method functions correctly", e.equals(a));
    assertFalse("Tests that equals method functions correctly", e.equals(b));
    assertFalse("Tests that equals method functions correctly", e.equals(c));
  }
  
  /**
   * Tests the compareToByName method
   */
  @Test
  public void testCompareToByName(){
    SalesSupervisor e = new SalesSupervisor("basher","thomas1","567",50.0,40.0);
    assertTrue("Tests that method compares names correctly", 0 == e.compareToByName("basher","thomas1"));
    assertTrue("Tests that method compares names correctly", -1 == e.compareToByName("zasher","uganda"));
    assertTrue("Tests that method compares names correctly", 1 == e.compareToByName("zasher","spank"));
    assertTrue("Tests that method compares names correctly", -1 == e.compareToByName("basher","uganda"));
    assertTrue("Tests that method compares names correctly", 1 == e.compareToByName("basher","spank"));
    assertTrue("Tests that method compares names correctly", -1 == e.compareToByName("matlab","thomas1"));
    assertTrue("Tests that method compares names correctly", 1 == e.compareToByName("asher","thomas1"));
  }
  
  /**
   * Tests the compareToByEarnings method
   */
  @Test
  public void testCompareToByEarnings(){
    SalesSupervisor e = new SalesSupervisor("basher","thomas","567",50.0,40.0);
    e.setNumSales(5);
    e.setBonus(10.0);
    assertTrue("Tests that method compares earnings correctly", 0 == e.compareToByEarnings(260.0));
    assertTrue("Tests that method compares earnings correctly", -1 == e.compareToByEarnings(270.0));
    assertTrue("Tests that method compares earnings correctly", 1 == e.compareToByEarnings(250.0));
  }
  
  /**
   * Tests the setSupervisor method
   */
  @Test
  public void testSetSupervisor(){
    SalesSupervisor e = new SalesSupervisor("basher","thomas","567",50.0,40.0);
    SalariedSupervisor a = new SalariedSupervisor("basher","thomas","567",50.0);
    e.setSupervisor(a);
    assertTrue("Tests that the setter method sets a salaried supervisor correctly", a.equals(e.getSupervisor()));
    HourlySupervisor b = new HourlySupervisor("zasher","uganda","667",70.0);
    e.setSupervisor(b);
    assertTrue("Tests that the setter method sets an hourly supervisor correctly", b.equals(e.getSupervisor()));
    SalesSupervisor c = new SalesSupervisor("basher","spank","889",90.0,30.0);
    e.setSupervisor(c);
    assertTrue("Tests that the setter method sets a sales supervisor correctly", c.equals(e.getSupervisor()));
  }
  
  /**
   * Tests the getSupervisor method
   */
  @Test
  public void testGetSupervisor(){
    SalesSupervisor e = new SalesSupervisor("basher","thomas","567",50.0,40.0);
    SalariedSupervisor a = new SalariedSupervisor("basher","thomas","567",50.0);
    e.setSupervisor(a);
    assertTrue("Tests that the getter method returns a supervisor", a.equals(e.getSupervisor()));
  }
}