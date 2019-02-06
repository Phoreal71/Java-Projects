/* Author: Christopher Tam, this class represents the same function as the contractor class, except it overrides the toString method again to append ": approved governemnt contractor" to the end of the string returned */
public class GovernmentContractor extends Contractor{
  
  /* Inherits Constructor from super class */
  public GovernmentContractor(String contractname, String addressname, String contactname){
    super(contractname, addressname, contactname);
  }
  
  /* Overrides toString method inherited by Object */
  public String toString(){
    return getName() + ":" + " " + getAddress() + ": approved government contractor";
  }
}