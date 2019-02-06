/* Author: Christopher Tam; this class represents the same function as the Contract class, except it overrides the makeBid method inherited from the Contract class to check if the bid contractor is a government contractor */
public class GovernmentContract extends Contract{
  
  /* Inherits Constructor from super class */
  public GovernmentContract(String contractid, double minvalue, double maxvalue, double bonus, double penalty, Date deadline){
    super(contractid, minvalue, maxvalue, bonus, penalty, deadline);
  }
  
  /* Overrides makeBid method inherited from Contract class */
  public boolean makeBid(Bid bid){
    if (this.isAcceptingBids() == true && (bid.getContract()).getID() == this.getID() && bid.getValue() <= this.getMaxValue() && bid.getValue() >= this.getMinValue() && (this.getBestBid()).getValue() > bid.getValue()){
      return true;
    }
    else
      return false;
  }
}
  