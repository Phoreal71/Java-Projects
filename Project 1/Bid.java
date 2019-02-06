/* Author: Christopher Tam; this class represents a bid that a contractor makes for a contract */
public class Bid{
  /* Stores the contract for the bid as a Contract object */
  private final Contract contract;
  /* Stores the contractor for the bid as a Contractor object */
  private final Contractor contractor;
  /* Stores the value of the bid as a double */
  private final double bid;
  
  /* Initializes the Bid class fields */
  public Bid(Contract contract, Contractor contractor, double bid){
    this.contract = contract;                  /* stores a contract object */
    this.contractor = contractor;              /* stores a contractor object */
    this.bid = bid;                            /* stores a the value of the bid as a double */
  }
  
  /* Returns the contract object stored in the class field contract */
  public Contract getContract(){
    return contract;
  }
  
  /* Returns the contractor object stored in the class field contractor */
  public Contractor getContractor(){
    return contractor;
  }
  
  /* Returns the double value of the class field bid */
  public double getValue(){
    return bid;
  }
}
