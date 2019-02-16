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
  
  /**
   * Returns the relations list of the entity
   * @return A LinkedList that containing entities that represents the relations list of the entity
   */
  public LinkedList<Entity> getRelations(){
    return relations;
  }
  
  /**
   * Overrides the equals method inherited by object, checks if two Entity objects are equal 
   * @return o An input (parameter) object
   * @param A boolean value that tells if the parameter object is equal to the instance Entity
   */
  @Override
  public boolean equals(Object o){
    if(o instanceof Entity){
      // e stores the parameter object if it is an instance of Entity 
      Entity e = (Entity) o;
      if(this.getName().equals(e.getName())){
        return true;
      }
      else
        return false;
    }
    else
      return false;
  }
  
  /**
   * Overrides the string method inherited by object 
   * @return A string in the form of "name, healthstatus"
   */
  @Override
  public String toString(){
    return this.getName() + "," + this.getHealthStatus();
  }
  
  /**
   * Overrides the compareTo method of the Comparable interface
   * @return A positive, negative, or zero int value that represents if the instance entity comes after,before, or is equal 
   *         to the parameter entity object, respectively.
   * @param e An input (parameter) Entity object
   */
  @Override
  public int compareTo(Entity e){
    // j represents the returned int value
    int j = 0;
    if(this.getName().equals(e.getName())){
      return 0;
    }
    else{
      for(int i = 0; j == 0; i++){
        if(this.getName().charAt(i) < e.getName().charAt(i)){
          j = -1;
        }
        else if(this.getName().charAt(i) > e.getName().charAt(i)){
          j = 1;
        }
      }
      return j;
    }
  }
  
  /**
   * Represents the enumerated type of the class, which allows an Entity type to store the values Uninfected, 
   * Infected, Inoculated, BeingInfected, or BeingInoculated
   */
  enum Health{ Uninfected, Infected, Inoculated, BeingInfected, BeingInoculated }
}