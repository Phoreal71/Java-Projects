/* Author: Christopher Tam; this class represents a contract */
public class Contract{
  /* Stores the identifying number of the contract as a string*/
  private String contractid;
  /* Stores the minimum value of the contract as a double */
  private double minvalue;
  /* Stores the maximum value of the contract as a double */
  private double maxvalue;
  /* Stores the per day bonus rate of the contract as a double */
  private double bonus;
  /* Stores the per day penalty rate of the contract as a double */
  private double penalty;
  /* Stores the deadline of the contract as a Date object */
  private Date deadline;
  /* nobids is an arbitrary value that determines whether the contract is accepting bids, is stored as an integer */
  private int nobids = 0;
  /* Stores the date of completion of the contract as a Date object */
  private Date datecomp = null;
  /* completestatus is an arbitrary value that determines the completed status of the contract, is stored as an integer */
  private int completestatus = 0;
  /* Stores the best bid to the contract as a Bid object */
  private Bid bestbid = null;
  
  /* Initializes the Contract class fields */
  public Contract (String contractid, double minvalue, double maxvalue, double bonus, double penalty, Date deadline){
    this.contractid = contractid;                       /* contractid stores the identifying number of the contract as a string */
    this.minvalue = minvalue;                           /* minvalue stores the minimum value of the contract as a double */
    this.maxvalue = maxvalue;                           /* maxvalue stores the maximum value of the contrat as a double */
    this.bonus = bonus;                                 /* bonus stores the per day bonus rate of the contract as a double */
    this.penalty = penalty;                             /* penalty stores the per day penalty rate of the contract as a double */
    this.deadline = deadline;                           /* deadline stores the deadline of the contract as a Date object */
  }
  
  /* Returns the string value of the class field contractid */
  public String getID(){
    return contractid;
  }
  
  /* Returns the double value of the class field minvalue */
  public double getMinValue(){
    return minvalue;
  }
  
  /* Sets the double value of the minvalue field to that of the minvalue variable */
  public void setMinValue(double minvalue){
    this.minvalue = minvalue;
  }
  
  /* Returns the double value of the class field maxvalue */
  public double getMaxValue(){
    return maxvalue;
  }
  
  /* Sets the double value of the maxvalue field to that of the maxvalue variable */
  public void setMaxValue(double maxvalue){
    this.maxvalue = maxvalue;
  }
  
  /* Returns the double value of the class field bonus */
  public double getBonus(){
    return bonus;
  }
  
  /* Sets the double value of the bonus field to that of the bonus variable */
  public void setBonus(double bonus){
    this.bonus = bonus;
  }
  
  /* Returns the double value of the class field penalty */
  public double getPenalty(){
    return penalty;
  }
  
  /* Sets the double value of the penalty field to that of the penalty variable */
  public void setPenalty(double penalty){
    this.penalty = penalty;
  }
  
  /* Returns the Date object stored in the class field deadline */
  public Date getDeadline(){
    return deadline;
  }
  
  /* Stores the inputted Date object deadline in the deadline field */
  public void setDeadline(Date deadline){
    this.deadline = deadline;
  }
  
  /* Overrides the equals method inherited from Object and sets the contract equal to the input object if they share the same contractid */
  public boolean equals(Object o){                      /* o stores an object */
    if (o instanceof Contract){
      Contract d = (Contract) o;                         
      if ((this.getID()).equals(d.getID())){
        return true;
      }
      else 
       return false;
      }
    else
      return false;
  }
  
  /* Indicates whether the contract is accepting binds from contractors */
  public boolean isAcceptingBids(){
    if (this.nobids == 0){
      return true;}
    else
      return false;
  }
  
  /* Returns the best bid for the contract */
  public Bid getBestBid(){
    return bestbid;
  }
  /* Processes a bid and either accepts it, updating it as the current best bid, or rejects it */ 
  public boolean makeBid(Bid bid){                      /* bid stores a bid to the contract as a Bid object */
    if (this.getBestBid() != null){
      if (this.isAcceptingBids() == true && this.equals(bid.getContract()) && bid.getValue() <= this.getMaxValue() && bid.getValue() >= this.getMinValue() && (this.getBestBid()).getValue() > bid.getValue()){
        this.bestbid = bid;
        return true;
      }
      else
        return false;
    }
    else
      if (this.isAcceptingBids() == true && this.equals(bid.getContract()) && bid.getValue() <= this.getMaxValue() && bid.getValue() >= this.getMinValue()){
      this.bestbid = bid;
      return true;
      }
      else
        return false;
    }
  
  /* Determines that the contract is no longer accepting bids */
  public void awardContract(){
    this.nobids = 1;
  }
  
  /* Indicates whether the contract has been completed or not */
  public boolean isComplete(){
    if (this.completestatus == 0){
      return false;
    }
    else
      return true;    
  }
    
  /* Returns the date that the contract was completed */
  public Date completeDate(){
    return datecomp;
  }
  
  /* Sets the contract status as completed, sets the date of the contract completion, and pays the contractor of the best bid */
  public void setComplete(Date date){                                                                                         /* date stores a contract completion date as a Date object */
    double pv1 = ((this.getBestBid()).getValue() - ((double)(Date.difference(date, this.getDeadline())))*this.getPenalty());  /* pv1 stores the amount paid to the best bid contractor in a penalty scenario as a double */
    double pv2 = (((this.getBestBid()).getValue() + ((double)(Date.difference(date, this.getDeadline())))*this.getBonus()));  /* pv2 stores the amount paid to the best bid contractor in a bonus scenario as a double */
    double pv3 = (((this.getBestBid()).getValue()));                                                                          /* pv3 stores the amount paid to the best bid contractor as a double */
    this.completestatus = 1;
    this.datecomp = date;
    if (Date.difference(date, this.getDeadline()) < 0){
      if (0.0 <= pv2 && pv2 <= this.getMaxValue()){
      ((this.getBestBid()).getContractor()).pay(((this.getBestBid()).getValue() - ((double)(Date.difference(date, this.getDeadline())))*this.getBonus()));
      }
    }
    else if (Date.difference(date, this.getDeadline()) > 0){
      if (0.0 <= pv1 && pv1 <= this.getMaxValue()){
      ((this.getBestBid()).getContractor()).pay((this.getBestBid()).getValue() - ((double)(Date.difference(date, this.getDeadline())))*this.getPenalty());
      }
    }
    else{
      if (0.0 <= pv3 && pv3 <= this.getMaxValue()){
      ((this.getBestBid()).getContractor()).pay(((this.getBestBid()).getValue()));
      }
    }
  }   
}
    
    