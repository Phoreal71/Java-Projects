// Packages imported for junit testing
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * This class represents a junit testing class for the SalariedEmployee class
 * 
 * @author Christopher Tam
 */
public class SalariedEmployeeTester{
  /**
   * Tests the SalariedEmployee constructor
   */
  @Test
  public void testSalariedEmployee(){
    SalariedEmployee e = new SalariedEmployee("Zack","Thomas","567",50.0);                  
    assertEquals("Tests that constructor initializes firstname field correctly", "Zack", e.getFirstName());
    assertEquals("Tests that constructor initializes lastname field correctly", "Thomas", e.getLastName());
    assertEquals("Tests that constructor initializes number field correctly", "567", e.getNumber());
    assertTrue("Tests that constructor initializes salary field correctly", 50.0 == e.getSalary());
  }
  
  /**
   * Tests the getFirstName method
   */
  @Test
  public void testGetFirstName(){                                          
    SalariedEmployee e = new SalariedEmployee("Zack","Thomas","567",50.0);                 
    assertEquals("Tests that getter method returns correct firstname value", "Zack", e.getFirstName());
  }
  
  /**
   * Tests the getLastName method
   */
  @Test
  public void testGetLastName(){                                                          
    SalariedEmployee e = new SalariedEmployee("Zack","Thomas","567",50.0);
    assertEquals("Tests that getter method returns correct lastname value", "Thomas", e.getLastName());
  }
  
  /**
   * Tests the setName method
   */
  @Test                                                                                  
  public void testSetName(){
    SalariedEmployee e = new SalariedEmployee("Zack","Thomas","567",50.0);
    e.setName("Chris","Puckers");
    assertEquals("Tests that setter method sets firstname value", "Chris", e.getFirstName());
    assertEquals("Tests that setter method sets lastname value", "Puckers", e.getLastName());
  }
  
  /**
   * Tests the getNumber method
   */
  @Test
  public void testGetNumber(){                                                          
    SalariedEmployee e = new SalariedEmployee("Zack","Thomas","567",50.0);
    assertEquals("Tests that getter method returns correct number value", "567", e.getNumber());
  }
  
  /**
   * Tests the getSalary method
   */
  @Test
  public void testGetSalary(){                                                         
    SalariedEmployee e = new SalariedEmployee("Zack","Thomas","567",50.0);
    assertTrue("Tests that getter method returns correct salary value", 50.0 == e.getSalary());
  }
  
  /**
   * Tests the setSalary method
   */
  @Test
  public void testSetSalary(){                                                        
    SalariedEmployee e = new SalariedEmployee("Zack","Thomas","567",50.0);
    e.setSalary(100.0);
    assertTrue("Tests that setter method sets salary value correctly", 100.0 == e.getSalary());
  }
  
  /**
   * Tests the getBonus method
   */
  @Test
  public void testGetBonus(){                                                         
    SalariedEmployee e = new SalariedEmployee("Zack","Thomas","567",50.0);
    e.setBonus(700.0);
    assertTrue("Tests that getter method returns correct bonus value", 700.0 == e.getBonus());
  }
  
  /**
   * Tests the setBonus method
   */
  @Test
  public void testSetBonus(){                                                          
    SalariedEmployee e = new SalariedEmployee("Zack","Thomas","567",50.0);
    e.setBonus(500.0);
    assertTrue("Tests that setter method sets bonus value correctly", 500.0 == e.getBonus());
  }
  
  /**
   * Tests the getAmountEarned method
   */
  @Test
  public void testGetAmountEarned(){                                                   
    SalariedEmployee e = new SalariedEmployee("Zack","Thomas","567",50.0);
    e.setBonus(500.0);
    assertTrue("Tests that method returns correct amount earned", 550.0 == e.getAmountEarned());
  }
  
  /**
   * Tests the adjustPay method
   */
  @Test 
  public void testAdjustPay(){                                                        
    SalariedEmployee a = new SalariedEmployee("Fey","Thomas","667",50.0);
    SalariedEmployee e = new SalariedEmployee("Zack","Thomas","567",50.0);
    e.adjustPay(0.1);
    a.adjustPay(-0.1);
    assertTrue("Tests that method adjusts pay correctly", 55.0 == e.getSalary());
    assertTrue("Tests that method adjusts pay correctly", 45.0 == a.getSalary());
  }
  
  /**
   * Tests the toString method overrider 
   */
  @Test
  public void testToString(){
    SalariedEmployee e = new SalariedEmployee("Zack","Thomas","567",50.0);
    assertEquals("Tests that method returns correct string expression", "567:Thomas,Zack,Salaried Employee", e.toString());
  }
  
  /**
   * Tests the equals method overrider 
   */
  @Test
  public void testEquals(){
    SalariedEmployee e = new SalariedEmployee("Zack","Thomas","567",50.0);
    SalariedEmployee a = new SalariedEmployee("Zack","Thomas","567",60.0);
    SalariedEmployee b = new SalariedEmployee("Fey","Thomas","567",60.0);
    HourlyEmployee c = new HourlyEmployee("Zack","Thomas","567",60.0);
    assertTrue("Tests that equals method functions correctly", e.equals(a));
    assertFalse("Tests that equals method functions correctly", e.equals(b));
    assertFalse("Tests that equals method functions correctly", e.equals(c));
  }
  
  /**
   * Tests the compareToByName method
   */
  @Test
  public void testCompareToByName(){
    SalariedEmployee e = new SalariedEmployee("basher","thomas1","567",50.0);
    assertTrue("Tests that method compares names correctly", 0 == e.compareToByName("basher","thomas1")); //Conditional when names are same
    assertTrue("Tests that method compares names correctly", -1 == e.compareToByName("zasher","uganda")); //Conditional when last names are different
    assertTrue("Tests that method compares names correctly", 1 == e.compareToByName("zasher","spank"));
    assertTrue("Tests that method compares names correctly", -1 == e.compareToByName("basher","uganda"));
    assertTrue("Tests that method compares names correctly", 1 == e.compareToByName("basher","spank"));
    assertTrue("Tests that method compares names correctly", -1 == e.compareToByName("matlab","thomas1")); //Conditional when last names are same but first name different
    assertTrue("Tests that method compares names correctly", 1 == e.compareToByName("asher","thomas1"));
  }
  
  /**
   * Tests the compareToByEarnings method
   */
  @Test
  public void testCompareToByEarnings(){
    SalariedEmployee e = new SalariedEmployee("basher","thomas","567",50.0);
    assertTrue("Tests that method compares earnings correctly", 0 == e.compareToByEarnings(50.0));
    assertTrue("Tests that method compares earnings correctly", -1 == e.compareToByEarnings(60.0));
    assertTrue("Tests that method compares earnings correctly", 1 == e.compareToByEarnings(40.0));
  }
  
  /**
   * Tests the setSupervisor method
   */
  @Test
  public void testSetSupervisor(){
    SalariedEmployee e = new SalariedEmployee("Zack","Thomas","567",50.0);
    SalariedSupervisor a = new SalariedSupervisor("basher","thomas","567",50.0);
    e.setSupervisor(a);
    assertTrue("Tests that the setter method sets an hourly supervisor correctly", a.equals(e.getSupervisor()));
    HourlySupervisor b = new HourlySupervisor("zasher","uganda","667",70.0);
    e.setSupervisor(b);
    assertTrue("Tests that the setter method sets a salaried supervisor correctly", b.equals(e.getSupervisor()));
    SalesSupervisor c = new SalesSupervisor("basher","spank","889",90.0,30.0);
    e.setSupervisor(c);
    assertTrue("Tests that the setter method sets a sales supervisor correctly", c.equals(e.getSupervisor()));
  }
  
  /**
   * Tests the getSupervisor method
   */
  @Test
  public void testGetSupervisor(){
    SalariedEmployee e = new SalariedEmployee("Zack","Thomas","567",50.0);
    SalariedSupervisor a = new SalariedSupervisor("basher","thomas","567",50.0);
    e.setSupervisor(a);
    assertTrue("Tests that the getter method returns a supervisor", a.equals(e.getSupervisor()));
  }
}
