/**
 * This class represents an interface implemented by SalesEmployee types
 * 
 * @author Christopher Tam
 */
public interface SalesE extends Employee, SalariedE{
  /**
   * Method stub for commission getter
   */
  double getCommission();
  
  /**
   * Method stub for commission setter
   */
  void setCommission(double commission);
  
  /** 
   * Method stub for num sales getter
   */
  int getNumSales();
  
  /**
   * Method stub for num sales setter
   */
  void setNumSales(int numSales);
}