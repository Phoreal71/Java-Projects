/** 
 * This class represents a sales supervisor that earns a small salary plus a commission on every sale made
 * 
 * @author Christopher Tam
 */
public class SalesSupervisor implements SalesS{
  // Stores the first name of the employee
  private String firstname;
  // Stores the last name of the employee
  private String lastname;
  // Stores the employee number
  private String number;
  // Stores the salary of the employee
  private double salary;
  // Stores the commission of the employee
  private double commission;
  // Stores the bonus of the employee
  private double bonus = 0.0;
  // Stores the number of sales made by the employee
  private int sales;
  // Stores the supervisor of the employee
  private Supervisor supervisor;
  /**
   * Creates a new SalesSupervisor object.
   * @param firstName The first name of the employee
   * @param lastName The last name of the employee
   * @param number The employee number 
   * @param salary The salary of the employee
   * @param commission The commission of the employee
   */
  public SalesSupervisor(String firstName, String lastName, String number, double salary, double commission){
    this.firstname = firstName;
    this.lastname = lastName;
    this.number = number;
    this.salary = salary;
    this.commission = commission;
  }
  
  /**
   * Returns the first name of the employee 
   * @return A string that represents the first name of the employee
   */
  public String getFirstName(){
    return firstname;
  }
  
  /**
   * Returns the last name of the employee
   * @return A string that represents the last name of the employee
   */
  public String getLastName(){
    return lastname;
  }
  
  
  /**
   * Sets the first and last names of the employee
   * @param firstName The first name of the employee
   * @param lastName The last name of the employee
   */
  public void setName(String firstName, String lastName){
    this.firstname = firstName;
    this.lastname = lastName;
  }
  
  /**
   * Returns the employee number
   * @return A string that represents the employee number
   */
  public String getNumber(){
    return number;
  }
  
  /**
   * Returns the salary of the employee
   * @return A double value that represents the salary of the employee
   */
  public double getSalary(){
    return salary;
  }
  
  /**
   * Sets the salary of the employee
   * @param salary A new salary value
   */
  public void setSalary(double salary){
    this.salary = salary;
  }
  
  /**
   * Returns the commission of the employee
   * @return A double value that represents the commission of the employee
   */
  public double getCommission(){
    return commission;
  }
  
  /**
   * Sets the commission of the employee
   * @param commission The commission of the employee
   */
  public void setCommission(double commission){
    this.commission = commission;
  }
  
  /**
   * Returns the number of sales made by the employee
   * @return An int value that represents the number of sales made by the employee
   */
  public int getNumSales(){
    return sales;
  }
  
  /**
   * Sets the number of sales made by the employee
   * @param numSales The number of sales made by the employee
   */
  public void setNumSales(int numSales){
    this.sales = numSales;
  }
  
  /**
   * Returns the bonus of the employee
   * @return A double value that represents the bonus of the employee
   */
  public double getBonus(){
    return bonus;
  }
  
  /**
   * Sets the bonus of the employee
   * @param bonus A new bonus value of the employee
   */
  public void setBonus(double bonus){
    this.bonus = bonus;
  }
  
  /**
   * Returns the total amount earned by the employee
   * @return A double value that represents the sum of the employee's salary, bonus, and commission multiplied by the number of sales made
   */
  public double getAmountEarned(){
    return getSalary() + getBonus() + getCommission() * getNumSales();
  }
  
  /**
   * Sets the commission of the employee 
   * @param percentage The percentage that the employee commission is adjusted by
   */
  public void adjustPay(double percentage){
    this.commission = getCommission() + getCommission() * percentage;
  }
  
  /**
   * Overrides the string method inherited by object 
   * @return A string in the form of "number: last name, first name, Sales Supervisor"
   */
  public String toString(){
    return getNumber() + ":" + getLastName() + "," + getFirstName() + "," + "Sales Supervisor";
  }
  
  /**
   * Overrides the equals method inherited by object, checks if two SalesSupervisor objects are equal 
   * @param o An input (parameter) object
   * @return A boolean value that tells if the parameter object is equal to the instance SalesSupervisor
   */
  public boolean equals(Object o){
    if (o instanceof SalesSupervisor){
      // d stores the parameter object if it is an instance of SalesSupervisor
      SalesSupervisor d = (SalesSupervisor) o;                         
      if (this.getNumber() == d.getNumber() && this.getFirstName().equals(d.getFirstName()) && this.getLastName().equals(d.getLastName())){
        return true;
      }
      else 
       return false;
    }
    else
      return false;
  }
  
  /** 
   * Checks if the parameter name (first,last) is equal to the name (first,last) of the instance SalesSupervisor
   * @param first The first name of the parameter
   * @param last The last name of the parameter
   * @return An int value that indicates if the employee name alphabetically precedes, comes after, or is the same 
   *         as the parameter name
   */
  public int compareToByName(String first, String last){
    // Checks if the names are equal
    if(this.getFirstName().equals(first) && this.getLastName().equals(last)){
      return 0;
    }
    // Checks the alphabetical order if the last names are not equal
    else if(this.getLastName().equals(last) == false){
      // i stores the index of both last names
      int i = 0;
      /* Goal: To iterate through both last names simultaneously until an unmatching character is found */
      while(this.getLastName().charAt(i) == last.charAt(i)){
        i = i + 1;
      }
      if((int)this.getLastName().charAt(i) < (int)last.charAt(i)){
        return -1;
      }
      else if((int)this.getLastName().charAt(i) > (int)last.charAt(i)){
        return 1;
      }
      else
        return 7;
    }
    // Checks the alphabetical order if the last names are equal, but the first names are not
    else if(this.getLastName().equals(last) && this.getFirstName().equals(first) == false){
      // i stores the index of both first names
      int i = 0;
      /* Goal: To iterate through both first names simultaneously until an unmatching character is found */
      while(this.getFirstName().charAt(i) == first.charAt(i)){
        i = i + 1;
      }
      if((int)this.getFirstName().charAt(i) < (int)first.charAt(i)){
        return -1;
      }
      else if((int)this.getFirstName().charAt(i) > (int)first.charAt(i)){
        return 1;
      }
      else
        return 7;
    }
    else
      return 7;
  }
  
  /**
   * Checks if the earnings of the employee is smaller than, greater than, or equal to the parameter value
   * @param earnings The value that the employee earnings is compared to 
   * @return An int value that indicates if the earnings of the employee is smaller than, greater than, or equal to the 
   *         parameter value
   */
  public int compareToByEarnings(double earnings){
    if(this.getAmountEarned() < earnings){
      return -1; 
    }
    else if(this.getAmountEarned() > earnings){
      return 1;
    }
    else
      return 0;
  }  
  
  /**
   * Sets the supervisor of the employee 
   * @param supervisor The supervisor of the employee
   */
  public void setSupervisor(Supervisor supervisor){
    this.supervisor = supervisor;
  }
  
  /**
   * Returns the supervisor of the employee
   * @return The supervisor of the employee
   */
  public Supervisor getSupervisor(){
    return supervisor;
  }
}