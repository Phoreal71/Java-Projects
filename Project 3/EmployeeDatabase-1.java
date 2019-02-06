public class EmployeeDatabase{
  private GenEmployee[] database;
  private GenEmployee genemployee;
 
  public EmployeeDatabase(int maxnum){
    this.database = new GenEmployee[maxnum];
  }
  
  public GenEmployee[] getDatabase(){
    return database;
  }
  
  public void setDatabase(GenEmployee[] args){
      this.database = args;
  }
  
  public GenEmployee getGenemployee(){
    return genemployee;
  }
  
  public void setGenemployee(GenEmployee input){
    this.genemployee = input;
  }
  
  public void add(GenEmployee e) throws EmployeeDatabaseFullException{
    EmployeeDatabaseFullException error = new EmployeeDatabaseFullException("Maximum number of employees are already stored in database!");
    int j = 0;
    for(int i = 0; i <= (this.getDatabase()).length - 1; i++){   
      if((this.getDatabase())[i] == null && j == 0 && (e.getFirstName()).length() != 0 && (e.getLastName()).length() != 0 && (e.getNumber()).length() != 0){
        (this.getDatabase())[i] = e;
        j = j + 1;
      }
      else if(i == (this.getDatabase()).length - 1 && (this.getDatabase())[i] != null){
        throw error;
      }
    }
  }
  
  public GenEmployee remove(String firstname, String lastname, String number) throws NoSuchEmployeeException{
    NoSuchEmployeeException error = new NoSuchEmployeeException("No employees exist!");
    int j = 0;
    for(int i = 0; i <= (this.getDatabase()).length - 1; i++){
      if(((this.getDatabase())[i]) != null){
        if((((this.getDatabase())[i]).getFirstName()).equals(firstname) && (((this.getDatabase())[i]).getLastName()).equals(lastname) && (((this.getDatabase())[i]).getNumber()).equals(number)){
          setGenemployee((this.getDatabase())[i]);
          (this.getDatabase())[i] = null;
          j = 1;
        }
      }
    }
    if(j != 0){
      return genemployee;
    }
    else
      throw error;
  }
  
  public GenEmployee find(String firstname, String lastname, String number) throws NoSuchEmployeeException{
    NoSuchEmployeeException error = new NoSuchEmployeeException("No such employee exists!");
    int j = 0;
    int z = 0;
    for(int i = 0; i <= (this.getDatabase()).length - 1; i++){
      if(((this.getDatabase())[i]) != null){
        if((((this.getDatabase())[i]).getFirstName()).equals(firstname) && (((this.getDatabase())[i]).getLastName()).equals(lastname) && (((this.getDatabase())[i]).getNumber()).equals(number)){
          j = i;
          z = z + 1;
        }
      }
    }
    if(z != 0){
      return (this.getDatabase())[j];
    }
    else 
      throw error;
  }
  
  public double getPayrollAmount(){
    double sum = 0.0;
    for(int i = 0; i <= (this.getDatabase()).length - 1; i++){
      if((this.getDatabase())[i] != null){
        sum = sum + ((this.getDatabase())[i]).getAmountEarned();
      }
    }
    return sum;
  }
  
  public GenEmployee getMaximumEarned(){
    int j = 0;
    int z = 0;
    double sum = 0.0;
    for(int i = 0; i <= (this.getDatabase()).length - 1; i++){
      if((this.getDatabase())[i] != null){
        if(((this.getDatabase())[i]).getAmountEarned() > sum){
          sum = ((this.getDatabase())[i]).getAmountEarned();
          j = i;
          z = z + 1;
        }
      }
    }
    if(z != 0){
      return (this.getDatabase())[j];
    }
    else
      return null;
  }
  
  public GenEmployee getMinimumEarned(){
    int j = 0;
    int z = 0;
    double sum = 0.0;
    for(int i = 0; i <= (this.getDatabase()).length - 1; i++){
      if((this.getDatabase())[i] != null){
        if(z == 0){
          sum = ((this.getDatabase())[i]).getAmountEarned();
          z = z + 1;
        }
        else{
          if(((this.getDatabase())[i]).getAmountEarned() < sum){
            sum = ((this.getDatabase())[i]).getAmountEarned();
            j = i;
          }
        }
      }
    }
    if(j != 0){
      return (this.getDatabase())[j];
    }
    else
      return null;
  }
  
  public GenEmployee getMaxSales() throws NoSuchEmployeeException{
    NoSuchEmployeeException error = new NoSuchEmployeeException("No employees exist!");
    int j = 0;
    int z = 0;
    double sum = 0.0;
    for(int i = 0; i <= (this.getDatabase()).length - 1; i++){
      if((this.getDatabase())[i] != null){
        if((this.getDatabase())[i] instanceof SalesEmployee){
          if(z == 0){
            SalesEmployee s = (SalesEmployee)(this.getDatabase())[i];
            sum = s.getNumSales();
            z = z + 1;
          }
          else{
            SalesEmployee s = (SalesEmployee)(this.getDatabase())[i];
              if(s.getNumSales() > sum){
                sum = s.getNumSales();
                j = i;
              }
          }
        }
        else if((this.getDatabase())[i] instanceof SalesSupervisor){
           if(z == 0){
            SalesSupervisor s = (SalesSupervisor)(this.getDatabase())[i];
            sum = s.getNumSales();
            z = z + 1;
          }
           else{
             SalesSupervisor s = (SalesSupervisor)(this.getDatabase())[i];
               if(s.getNumSales() > sum){
                 sum = s.getNumSales();
                 j = i;
               }
           }
        }
      }
    }
    if(j != 0){
      return (this.getDatabase())[j];
    }
    else
      throw error;
  }
  
  public GenEmployee getMinSales() throws NoSuchEmployeeException{
    NoSuchEmployeeException error = new NoSuchEmployeeException("No employees exist!");
    int j = 0;
    int z = 0;
    double sum = 0.0;
    for(int i = 0; i <= (this.getDatabase()).length - 1; i++){
      if((this.getDatabase())[i] != null){
        if((this.getDatabase())[i] instanceof SalesEmployee){
          if(z == 0){
            SalesEmployee s = (SalesEmployee)(this.getDatabase())[i];
            sum = s.getNumSales();
            z = z + 1;
          }
          else{
            SalesEmployee s = (SalesEmployee)(this.getDatabase())[i];
              if(s.getNumSales() < sum){
                sum = s.getNumSales();
                j = i;
              }
          }
        }
        else if((this.getDatabase())[i] instanceof SalesSupervisor){
          if(z == 0){
            SalesSupervisor s = (SalesSupervisor)(this.getDatabase())[i];
            sum = s.getNumSales();
            z = z + 1;
          }
          else{
            SalesSupervisor s = (SalesSupervisor)(this.getDatabase())[i];
              if(s.getNumSales() < sum){
                sum = s.getNumSales();
                j = i;
              }
          }
        }
      }
    }
    if(j != 0){
      return (this.getDatabase())[j];
    }
    else
      throw error;
  }
  
  public GenEmployee getMaxHoursWorked() throws NoSuchEmployeeException{
    NoSuchEmployeeException error = new NoSuchEmployeeException("No employees exist!");
    int j = 0;
    int z = 0;
    double sum = 0.0;
    for(int i = 0; i <= (this.getDatabase()).length - 1; i++){
      if((this.getDatabase())[i] != null){
        if((this.getDatabase())[i] instanceof HourlyEmployee){
          if(z == 0){
            HourlyEmployee s = (HourlyEmployee)(this.getDatabase())[i];
            sum = s.getHoursWorked();
            z = z + 1;
          }
          else{
            HourlyEmployee s = (HourlyEmployee)(this.getDatabase())[i];
              if(s.getHoursWorked() > sum){
                sum = s.getHoursWorked();
                j = i;
              }
          }
        }
        else if((this.getDatabase())[i] instanceof HourlySupervisor){
          if(z == 0){
            HourlySupervisor s = (HourlySupervisor)(this.getDatabase())[i];
            sum = s.getHoursWorked();
            z = z + 1;
          }
          else{
            HourlySupervisor s = (HourlySupervisor)(this.getDatabase())[i];
              if(s.getHoursWorked() > sum){
                sum = s.getHoursWorked();
                j = i;
              }
          }
        }
      }
    }
    if(j != 0){
      return (this.getDatabase())[j];
    }
    else
      throw error;
  }
  
  public GenEmployee getMinHoursWorked() throws NoSuchEmployeeException{
    NoSuchEmployeeException error = new NoSuchEmployeeException("No employees exist!");
    int j = 0;
    int z = 0;
    double sum = 0.0;
    for(int i = 0; i <= (this.getDatabase()).length - 1; i++){
      if((this.getDatabase())[i] != null){
        if((this.getDatabase())[i] instanceof HourlyEmployee){
          if(z == 0){
            HourlyEmployee s = (HourlyEmployee)(this.getDatabase())[i];
            sum = s.getHoursWorked();
            z = z + 1;
          }
          else{
            HourlyEmployee s = (HourlyEmployee)(this.getDatabase())[i];
            if(s.getHoursWorked() < sum){
              sum = s.getHoursWorked();
              j = i;
            }
          }
        }
        else if((this.getDatabase())[i] instanceof HourlySupervisor){
          if(z == 0){
            HourlySupervisor s = (HourlySupervisor)(this.getDatabase())[i];
            sum = s.getHoursWorked();
            z = z + 1;
          }
          else{
             HourlySupervisor s = (HourlySupervisor)(this.getDatabase())[i];
               if(s.getHoursWorked() < sum){
                 sum = s.getHoursWorked();
                 j = i;
               }
          }
        }
      }
    }
    if(j != 0){
      return (this.getDatabase())[j];
    }
    else
      throw error;
  }
   
  public GenEmployee[] getSupervisees(Supervisor supervisor){
    int sum = 0;
    for(int i = 0; i <= (this.getDatabase()).length - 1; i++){
      if((((this.getDatabase())[i]).getSupervisor()).equals(supervisor)){
        sum = sum + 1;
      }
    }
    GenEmployee[] array = new GenEmployee[sum];
    int j = 0;
    for(int i = 0; i <= (this.getDatabase()).length - 1; i++){
      if((((this.getDatabase())[i]).getSupervisor()).equals(supervisor)){
        array[j] = (this.getDatabase())[i];
        j = j + 1;
      }
    }
    return array;
  }
            
}     
    