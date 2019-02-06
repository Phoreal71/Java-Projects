/**
 * This class represents an interface that is implemented by employee and supervisor types
 * 
 * @author Christopher Tam
 */
public interface GenEmployee{
  
  /**
   * Method stub for firstname getter
   */
  String getFirstName();
  
  /**
   * Method stub for lastname getter
   */
  String getLastName();
  
  /**
   * Method stub for firstname and lastname setter
   */
  void setName(String firstName, String lastName);
  
  /**
   * Method stub for number getter
   */
  String getNumber();
  
  /**
   * Method stub for bonus getter
   */
  double getBonus();
  
  /**
   * Method stub for bonus setter
   */
  void setBonus(double bonus);
  
  /**
   * Method stub for amount earned getter
   */
  double getAmountEarned();
  
  /**
   * Method stub for adjust pay method
   */
  void adjustPay(double percentage);
  
  /**
   * Method stub for compare names method
   */
  int compareToByName(String first, String last);
  
  /**
   * Method stub for compare earnings method
   */
  int compareToByEarnings(double earnings);
  
  /**
   * Method stub for supervisor setter method
   */
  void setSupervisor(Supervisor supervisor);
  
  /**
   * Method stub for supervisor getter method
   */
  Supervisor getSupervisor();
}