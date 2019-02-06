/* Author: Christopher Tam; this class represents a contractor and contains information about its name, address, contact information, and total amount paid to the contractor */
public class Contractor{
  /* Stores the name of the contractor as as string */
  private String contractorName;
  /* Stores the address of the contractor as a string */
  private String contractorAddress;
  /* Stores the name of the contractor contact as a string */
  private String contactName;
  /* Stores the total amount paid to the contractor as a double */
  private double total = 10000.0;
  
  /* Initializes the Contractor class fields */
  public Contractor(String contractname, String addressname, String contactname){
    this.contractorName = contractname;              /* contractname stores name of contractor as a string */
    this.contractorAddress = addressname;            /* addressname stores address of contractor as a string */
    this.contactName = contactname;                  /* contactname stores name of contractor contact as a string */
  }
  
  /* Returns the string value of the class field contractorName */
  public String getName(){
    return contractorName;
  }
  
  /* Sets the string value of the contractorName field to that of the contractname variable */
  public void setName(String contractname){
    this.contractorName = contractname;
  }
  
  /* Returns the string value of the class field contractorAddress */
  public String getAddress(){
    return contractorAddress;
  }
  
  /* Sets the string value of the contractorAddress field to that of the addressname variable */
  public void setAddress(String addressname){
    this.contractorAddress = addressname;
  }
  
  /* Returns the string value of the private field contactName */
  public String getContact(){
    return contactName;
  }
  
  /* Sets the string value of the contactName field to that of the contactname variable */
  public void setContact(String contactname){
    this.contactName = contactname;
  }
  
  /* Returns the double value of the class field total */
  public double getAmountPaid(){
    return total;
  }
  
  /* Adds the double value of variable num to the total field and sets this as the new total value */
  public void pay(double payment){
    total = total + payment;                          /* payment stores a specified amount paid to the contractor as a double */ 
  }
  
  /* Overrides the toString method inherited from Object and returns a string in the form of "name: address" */
  public String toString(){
    return getName() + ":" + " " + getAddress();
  }
}
  
  