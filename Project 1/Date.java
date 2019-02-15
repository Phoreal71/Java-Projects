/* Author: Christopher Tam; this class represents a date, which includes a day, a month, and a year */
public class Date{
  /* Stores the day as an integer */
  private final int Day;
  /* Stores the month as an integer */
  private final int Month;
  /* Stores the year as an integer */
  private final int Year;
  
  /* Initializes the Date class fields */
  public Date(int day, int month, int year){
    this.Day = day;                       /* day stores the day as an integer */
    this.Month = month;                   /* month stores the month as an integer */
    this.Year = year;                     /* year stores the year as an integer */
  }
  
  /* Returns the int value of the class field Day */ 
  public int getDay(){
    return Day;
  }
  
  /* Returns the int value of the class field Month */
  public int getMonth(){
    return Month;
  }
  
  /* Returns the int value of the class field Year */
  public int getYear(){
    return Year;
  }
  
  /* Overrides the toString method inherited from Object and returns a string in the form of "month/day/year" */
  public String toString(){
    return getMonth() + "/" + getDay() + "/" + getYear();
  }
  
  /* Overrides the equals method inherited from Object and sets the date equal to the input object if they share the same day, month, and year */
  public boolean equals(Object o){        /* o stores an object */
    if (o instanceof Date){
      Date d = (Date) o;                         
      if (this.getDay() == d.getDay() && this.getMonth() == d.getMonth() && this.getYear() == d.getYear()){
        return this.getDay() == d.getDay() && this.getMonth() == d.getMonth() && this.getYear() == d.getYear();}
      else 
       return false;
      }
    else
      return false;
    }
  
  /* Returns the number of days between a given date and January 1st of the same year */
  public int daysFromJan1(){
    if (this.getMonth() == 2){
      return 30 + this.getDay();
    }
    else if (this.getMonth() == 3){
      return 58 + this.getDay();
    }
    else if (this.getMonth() == 4){
      return 89 + this.getDay();
    }
    else if (this.getMonth() == 5){
      return 119 + this.getDay();
    }
    else if (this.getMonth() == 6){
      return 150 + this.getDay();
    }
    else if (this.getMonth() == 7){
      return 180 + this.getDay();
    }
    else if (this.getMonth() == 8){
      return 211 + this.getDay();
    }
    else if (this.getMonth() == 9){
      return 242 + this.getDay();
    }
    else if (this.getMonth() == 10){
      return 272 + this.getDay();
    }
    else if (this.getMonth() == 11){
      return 303 + this.getDay();
    }
    else if (this.getMonth() == 12){
      return 333 + this.getDay();
    }
    else
      return this.getDay() - 1;
  }
  
  /* Returns the difference (can be negative or positive) in days between two inputted dates */
  public static int difference(Date date1, Date date2){
    if (date1.getYear() == date2.getYear()){
      return date1.daysFromJan1() - date2.daysFromJan1();
    }
    else if (date1.getYear() < date2.getYear()){
      if (date1.getMonth() < date2.getMonth()){
        return (date1.getYear() - date2.getYear())*365 - 1 - (date2.daysFromJan1() - date1.daysFromJan1());
      }
      else if (date1.getMonth() == date2.getMonth()){
        if (date1.getDay() > date2.getDay()){
          return (date1.getYear() - date2.getYear())*365 - 1 + (date1.daysFromJan1() - date2.daysFromJan1());
        }
        else if (date1.getDay() == date2.getDay()){
          return (date1.getYear() - date2.getYear())*365;
        }
        else{
          return (date1.getYear() - date2.getYear())*365 - 1 - (date2.daysFromJan1() - date1.daysFromJan1());
        }
      }
      else {
        return (((date1.getYear() - date2.getYear())*365) - 1 - (date2.daysFromJan1() - date1.daysFromJan1()));
      }
    }
    
    else{
      if (date1.getMonth() > date2.getMonth()){
        return ((date1.getYear() - date2.getYear())*365 + 1 + (date1.daysFromJan1() - date2.daysFromJan1()));
      }
      else if (date1.getMonth() == date2.getMonth()){
        if (date1.getDay() > date2.getDay()){
          return (date1.getYear() - date2.getYear())*365 + 1 + (date1.daysFromJan1() - date2.daysFromJan1());
        }
        else if (date1.getDay() == date2.getDay()){
          return (date1.getYear() - date2.getYear())*365;
        }
        else{
          return (date1.getYear() - date2.getYear())*365 + 1 - (date2.daysFromJan1() - date1.daysFromJan1());
        }
      }
       
      else{
        return ((date1.getYear() - date2.getYear())*365 + 1 - (date2.daysFromJan1() - date1.daysFromJan1()));
      }
    }
  }
}
  
           
  
    