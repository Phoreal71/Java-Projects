import org.junit.Test;
import static org.junit.Assert.*;
/**
 * This class represents a junit testing class for the PropogationStudy class
 * 
 * @author Christopher Tam
 */
public class PropogationStudyTester{
  /**
   * Tests the PropogationStudy constructor
   */
  @Test
  public void testPropogationStudy(){
    Network a = new Network();
    Entity f = new Entity("Zack");
    a.getNetwork().addToFront(f);
    double b = 0.3;
    double c = 0.5;
    double d = 0.7;
    PropogationStudy e = new PropogationStudy(a,b,c,d);
    assertEquals("Tests that constructor initializes network field correctly",f,e.getNetwork().getNetwork().getFront().getElement());
    assertTrue("Tests that constructor initializes infectionrate field correctly",b == e.getInfectionRate());
    assertTrue("Tests that constructor initializes healrate field correctly",c == e.getHealRate());
    assertTrue("Tests that constructor initializes wearrate field correctly",d == e.getWearRate());
  }
  
  /**
   * Tests the getNetwork method
   */
  @Test
  public void testGetNetwork(){
    Network a = new Network();
    Entity f = new Entity("Zack");
    a.getNetwork().addToFront(f);
    double b = 0.3;
    double c = 0.5;
    double d = 0.7;
    PropogationStudy e = new PropogationStudy(a,b,c,d);
    assertEquals("Tests that getter method returns correct network value",f,e.getNetwork().getNetwork().getFront().getElement());
  }
  
  /**
   * Tests the setNetwork method
   */
  @Test
  public void testSetNetwork(){
    Network a = new Network();
    Network h = new Network();
    Entity f = new Entity("Zack");
    h.getNetwork().addToFront(f);
    double b = 0.3;
    double c = 0.5;
    double d = 0.7;
    PropogationStudy e = new PropogationStudy(a,b,c,d);
    e.setNetwork(h);
    assertEquals("Tests that setter method sets network value correctly",f,e.getNetwork().getNetwork().getFront().getElement());
  }
  
  /**
   * Tests the getInfectionRate method
   */
  @Test
  public void testGetInfectionRate(){
    Network a = new Network();
    double b = 0.3;
    double c = 0.5;
    double d = 0.7;
    PropogationStudy e = new PropogationStudy(a,b,c,d);
    assertTrue("Tests that getter method returns correct infection rate",b == e.getInfectionRate());
  }
  
  /**
   * Tests the setInfectionRate method
   */
  @Test
  public void testSetInfectionRate(){
    Network a = new Network();
    double b = 0.3;
    double c = 0.5;
    double d = 0.7;
    PropogationStudy e = new PropogationStudy(a,b,c,d);
    e.setInfectionRate(0.6);
    assertTrue("Tests that setter method sets infection rate correctly",0.6 == e.getInfectionRate());
  }
  
  /**
   * Tests the getHealRate method
   */
  @Test
  public void testGetHealRate(){
    Network a = new Network();
    double b = 0.3;
    double c = 0.5;
    double d = 0.7;
    PropogationStudy e = new PropogationStudy(a,b,c,d);
    assertTrue("Tests that getter method returns correct heal rate",c == e.getHealRate());
  }
  
  /**
   * Tests the setHealRate method
   */
  @Test
  public void testSetHealRate(){
    Network a = new Network();
    double b = 0.3;
    double c = 0.5;
    double d = 0.7;
    PropogationStudy e = new PropogationStudy(a,b,c,d);
    e.setHealRate(0.9);
    assertTrue("Tests that setter method sets heal rate correctly",0.9 == e.getHealRate());
  }
  
  /**
   * Tests the getWearRate method
   */
  @Test
  public void testGetWearRate(){
    Network a = new Network();
    double b = 0.3;
    double c = 0.5;
    double d = 0.7;
    PropogationStudy e = new PropogationStudy(a,b,c,d);
    assertTrue("Tests that getter method returns correct wear rate",d == e.getWearRate());
  }
  
  /**
   * Tests the setWearRate method
   */
  @Test
  public void testSetWearRate(){
    Network a = new Network();
    double b = 0.3;
    double c = 0.5;
    double d = 0.7;
    PropogationStudy e = new PropogationStudy(a,b,c,d);
    e.setWearRate(0.9);
    assertTrue("Tests that setter method sets wear rate correctly",0.9 == e.getWearRate());
  }
  
  /**
   * Tests the infect method
   */
  @Test
  public void testInfect(){
    Network a = new Network();
    Entity f = new Entity("Chris");
    a.getNetwork().addToFront(f);
    double b = 0.3;
    double c = 0.5;
    double d = 0.7;
    PropogationStudy e = new PropogationStudy(a,b,c,d);
    e.infect(f);
    assertTrue("Tests that method infects entity object correctly",e.getNetwork().getNetwork().getFront().getElement().getHealthStatus() == Entity.Health.Infected);
  }
  
  /**
   * Tests the inoculate method
   */
  @Test
  public void testInoculate(){
    Network a = new Network();
    Entity f = new Entity("Chris");
    a.getNetwork().addToFront(f);
    double b = 0.3;
    double c = 0.5;
    double d = 0.7;
    PropogationStudy e = new PropogationStudy(a,b,c,d);
    e.inoculate(f);
    assertTrue("Tests that method inoculates entity object correctly",e.getNetwork().getNetwork().getFront().getElement().getHealthStatus() == Entity.Health.Inoculated);
  }
  
  /**
   * Tests the getNumUninfected method
   */
  @Test
  public void testGetNumUninfected(){
    Network a = new Network();
    Entity f = new Entity("Chris");
    a.getNetwork().addToFront(f);
    double b = 0.3;
    double c = 0.5;
    double d = 0.7;
    PropogationStudy e = new PropogationStudy(a,b,c,d);
    assertTrue("Tests that method returns correct number of uninfected entities in network",1 == e.getNumUninfected());
  }
  
  /**
   * Tests the getNumInoculated method
   */
  @Test
  public void testGetNumInoculated(){
    Network a = new Network();
    Entity f = new Entity("Chris");
    f.setHealthStatus(Entity.Health.Inoculated);
    a.getNetwork().addToFront(f);
    double b = 0.3;
    double c = 0.5;
    double d = 0.7;
    PropogationStudy e = new PropogationStudy(a,b,c,d);
    assertTrue("Tests that method returns correct number of inoculated entities in network",1 == e.getNumInoculated());
  }
  
  /**
   * Tests the getNumInfected method
   */
  @Test
  public void testGetNumInfected(){
    Network a = new Network();
    Entity f = new Entity("Chris");
    f.setHealthStatus(Entity.Health.Infected);
    a.getNetwork().addToFront(f);
    double b = 0.3;
    double c = 0.5;
    double d = 0.7;
    PropogationStudy e = new PropogationStudy(a,b,c,d);
    assertTrue("Tests that method returns correct number of infected entities in network",1 == e.getNumInfected());
  }
   
  /**
   * Tests the resetNetwork method
   */
  @Test
  public void testResetNetwork(){
    Network a = new Network();
    Entity f = new Entity("Chris");
    f.setHealthStatus(Entity.Health.Infected);
    Entity g = new Entity("Chris");
    g.setHealthStatus(Entity.Health.Infected);
    a.getNetwork().addToFront(f);
    a.getNetwork().addToFront(g);
    double b = 0.3;
    double c = 0.5;
    double d = 0.7;
    PropogationStudy e = new PropogationStudy(a,b,c,d);
    e.resetNetwork();
    assertTrue("Tests that method resets network correctly",2 == e.getNumUninfected());
  }
  
}