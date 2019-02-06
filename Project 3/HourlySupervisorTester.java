// Packages imported for junit testing
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * This class represents a junit testing class for the HourlySupervisor class
 * 
 * @author Christopher Tam
 */
public class HourlySupervisorTester{
  /**
   * Tests the HourlySupervisor constructor
   */
  @Test
  public void testHourlySupervisor(){
    HourlySupervisor e = new HourlySupervisor("Zack","Thomas","567",50.0);
    assertEquals("Tests that constructor initializes firstname field correctly", "Zack", e.getFirstName());
    assertEquals("Tests that constructor initializes lastname field correctly", "Thomas", e.getLastName());
    assertEquals("Tests that constructor initializes number field correctly", "567", e.getNumber());
    assertTrue("Tests that constructor initializes hourlyrate field correctly", 50.0 == e.getHourlyRate());
  }
  
  /**
   * Tests the getFirstName method
   */
  @Test
  public void testGetFirstName(){
    HourlySupervisor e = new HourlySupervisor("Zack","Thomas","567",50.0);
    assertEquals("Tests that getter method returns correct firstname value", "Zack", e.getFirstName());
  }
  
  /**
   * Tests the getLastName method
   */
  @Test
  public void testGetLastName(){
    HourlySupervisor e = new HourlySupervisor("Zack","Thomas","567",50.0);
    assertEquals("Tests that getter method returns correct lastname value", "Thomas", e.getLastName());
  }
  
  /**
   * Tests the setName method
   */
  @Test
  public void testSetName(){
    HourlySupervisor e = new HourlySupervisor("Zack","Thomas","567",50.0);
    e.setName("Chris","Puckers");
    assertEquals("Tests that setter method sets firstname value", "Chris", e.getFirstName());
    assertEquals("Tests that setter method sets lastname value", "Puckers", e.getLastName());
  }
  
  /**
   * Tests the getNumber method
   */
  @Test
  public void testGetNumber(){
    HourlySupervisor e = new HourlySupervisor("Zack","Thomas","567",50.0);
    assertEquals("Tests that getter method returns correct number value", "567", e.getNumber());
  }
  
  /**
   * Tests the getHourlyRate method
   */
  @Test
  public void testGetHourlyRate(){
    HourlySupervisor e = new HourlySupervisor("Zack","Thomas","567",50.0);
    assertTrue("Tests that getter method returns correct hourlyrate value", 50.0 == e.getHourlyRate());
  }
  
  /**
   * Tests the setHourlyRate method
   */
  @Test
  public void testSetHourlyRate(){
    HourlySupervisor e = new HourlySupervisor("Zack","Thomas","567",50.0);
    e.setHourlyRate(100.0);
    assertTrue("Tests that setter method sets the hourlyrate correctly", 100.0 == e.getHourlyRate());
  }
  
  /**
   * Tests the getHoursWorked method
   */
  @Test
  public void testGetHoursWorked(){
    HourlySupervisor e = new HourlySupervisor("Zack","Thomas","567",50.0);
    e.setHoursWorked(30.0);
    assertTrue("Tests that getter method returns correct hoursworked value", 30.0 == e.getHoursWorked());
  }
  
  /**
   * Tests the setHoursWorked method
   */
  @Test
  public void testSetHoursWorked(){
    HourlySupervisor e = new HourlySupervisor("Zack","Thomas","567",50.0);
    e.setHoursWorked(40.0);
    assertTrue("Tests that setter method sets the hoursworked correctly", 40.0 == e.getHoursWorked());
  }
  
  /**
   * Tests the getBonus method
   */
  @Test
  public void testGetBonus(){
    HourlySupervisor e = new HourlySupervisor("Zack","Thomas","567",50.0);
    e.setBonus(700.0);
    assertTrue("Tests that getter method returns correct bonus value", 700.0 == e.getBonus());
  }
  
  /**
   * Tests the setBonus method
   */
  @Test
  public void testSetBonus(){
    HourlySupervisor e = new HourlySupervisor("Zack","Thomas","567",50.0);
    e.setBonus(500.0);
    assertTrue("Tests that setter method sets bonus value correctly", 500.0 == e.getBonus());
  }
  
  /**
   * Tests the getAmountEarned method
   */
  @Test
  public void testGetAmountEarned(){
    HourlySupervisor e = new HourlySupervisor("Zack","Thomas","567",50.0);
    e.setHoursWorked(40.0);
    e.setBonus(500.0);
    assertTrue("Tests that method returns correct amount earned", 2500.0 == e.getAmountEarned());
  }
  
  /**
   * Tests the adjustPay method
   */
  @Test 
  public void testAdjustPay(){
    HourlySupervisor a = new HourlySupervisor("Fey","Thomas","667",50.0);
    HourlySupervisor e = new HourlySupervisor("Zack","Thomas","567",50.0);
    e.adjustPay(0.1);
    a.adjustPay(-0.1);
    assertTrue("Tests that method adjusts pay correctly", 55.0 == e.getHourlyRate());
    assertTrue("Tests that method adjusts pay correctly", 45.0 == a.getHourlyRate());
  }
  
  /**
   * Tests the toString method overrider 
   */
  @Test
  public void testToString(){
    HourlySupervisor e = new HourlySupervisor("Zack","Thomas","567",50.0);
    assertEquals("Tests that method returns correct string expression", "567:Thomas,Zack,Hourly Supervisor", e.toString());
  }
  
  /**
   * Tests the equals method overrider 
   */
  @Test
  public void testEquals(){
    HourlySupervisor e = new HourlySupervisor("Zack","Thomas","567",50.0);
    HourlySupervisor a = new HourlySupervisor("Zack","Thomas","567",60.0);
    HourlySupervisor b = new HourlySupervisor("Fey","Thomas","567",60.0);
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
    HourlySupervisor e = new HourlySupervisor("basher","thomas1","567",50.0);
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
    HourlySupervisor e = new HourlySupervisor("basher","thomas","567",50.0);
    e.setHoursWorked(5.0);
    assertTrue("Tests that method compares earnings correctly", 0 == e.compareToByEarnings(250.0));
    assertTrue("Tests that method compares earnings correctly", -1 == e.compareToByEarnings(260.0));
    assertTrue("Tests that method compares earnings correctly", 1 == e.compareToByEarnings(240.0));
  }
  
  /**
   * Tests the setSupervisor method
   */
  @Test
  public void testSetSupervisor(){
    HourlySupervisor e = new HourlySupervisor("Zack","Thomas","567",50.0);
    SalariedSupervisor a = new SalariedSupervisor("basher","thomas","567",50.0);
    e.setSupervisor(a);
    assertTrue("Tests that the setter method sets a salaried supervisor correctly", a.equals(e.getSupervisor()));
    HourlySupervisor b = new HourlySupervisor("zasher","uganda","667",70.0);
    e.setSupervisor(b);
    assertTrue("Tests that the setter method sets a hourly supervisor correctly", b.equals(e.getSupervisor()));
    SalesSupervisor c = new SalesSupervisor("basher","spank","889",90.0,30.0);
    e.setSupervisor(c);
    assertTrue("Tests that the setter method sets a sales supervisor correctly", c.equals(e.getSupervisor()));
  }
  
  /**
   * Tests the getSupervisor method
   */
  @Test
  public void testGetSupervisor(){
    HourlySupervisor e = new HourlySupervisor("Zack","Thomas","567",50.0);
    SalariedSupervisor a = new SalariedSupervisor("basher","thomas","567",50.0);
    e.setSupervisor(a);
    assertTrue("Tests that the getter method returns a supervisor", a.equals(e.getSupervisor()));
  }
}
