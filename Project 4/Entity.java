/** 
 * This class represents an entity (person,organization,etc.) in the given social network
 * 
 * @author Christopher Tam
 */
public class Entity implements Comparable<Entity>{
  // Stores the name of the entity
  private String name;
  // Stores the health status of the entity
  private Health healthstatus;
  // Stores the entity relations list of the entity
  private LinkedList<Entity> relations;
  /**
   * Creates a new Entity object
   * @param name The name of the entity
   */
  public Entity(String name){
    this.name = name;
    this.healthstatus = Health.Uninfected;
    this.relations = new LinkedList<Entity>();
  }
  
  /**
   * Returns the name of the entity
   * @return A string that represents the name of the entity
   */
  public String getName(){
    return name;
  }
  
  /**
   * Sets the name of the entity
   * @param name The name of the entity
   */
  public void setName(String name){
    this.name = name;
  }
  
  /**
   * Returns the health status of the entity
   * @return A Health enum that represents the health status of the entity
   */
  public Health getHealthStatus(){
    return healthstatus;
  }
  
  /**
   * Sets the health of the entity
   * @param status The health status of the entity
   */
  public void setHealthStatus(Health status){
    this.healthstatus = status;
  }
  
