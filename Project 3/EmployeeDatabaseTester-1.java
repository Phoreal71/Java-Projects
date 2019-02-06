import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;

public class EmployeeDatabaseTester{
  
  @Test
  public void testEmployeeDatabase(){
    EmployeeDatabase e = new EmployeeDatabase(3);
    GenEmployee[] a = new GenEmployee[3];
    assertTrue("Tests that constructor initializes database field correctly",Arrays.equals(a,(GenEmployee[])e.getDatabase()));
  }
  
  @Test
  public void testGetDatabase(){
    EmployeeDatabase e = new EmployeeDatabase(3);
    HourlyEmployee a = new HourlyEmployee("Basher","Thomas","456",50.0);
    SalariedEmployee b = new SalariedEmployee("Zack","Thomas","567",50.0);
    SalariedSupervisor c = new SalariedSupervisor("Fey","Jackson","776",30.0);
    GenEmployee[] d = new GenEmployee[3];
    d[0] = a;
    d[1] = b;
    d[2] = c;
    e.setDatabase(d);
    assertTrue("Tests that getter method returns database field correctly",Arrays.equals(d,(GenEmployee[]) e.getDatabase()));
  }
  
  @Test
  public void testSetDatabase(){
    EmployeeDatabase e = new EmployeeDatabase(3);
    HourlyEmployee a = new HourlyEmployee("Basher","Thomas","456",50.0);
    SalariedEmployee b = new SalariedEmployee("Zack","Thomas","567",50.0);
    SalariedSupervisor c = new SalariedSupervisor("Fey","Jackson","776",30.0);
    GenEmployee[] d = new GenEmployee[3];
    d[0] = a;
    d[1] = b;
    d[2] = c;
    e.setDatabase(d);
    assertTrue("Tests that setter method sets database correctly",Arrays.equals(d,(GenEmployee[]) e.getDatabase()));
  }
  
  @Test
  public void testGetGenemployee(){
    EmployeeDatabase e = new EmployeeDatabase(3);
    HourlyEmployee a = new HourlyEmployee("Basher","Thomas","456",50.0);
    e.setGenemployee(a);
    assertTrue("Tests that getter method returns genemployee correctly",a.equals(e.getGenemployee()));
  }
  
  @Test
  public void testSetGenemployee(){
    EmployeeDatabase e = new EmployeeDatabase(3);
    HourlyEmployee a = new HourlyEmployee("Basher","Thomas","456",50.0);
    e.setGenemployee(a);
    assertTrue("Tests that setter method sets genemployee correctly",a.equals(e.getGenemployee()));
  }
  
  @Test
  public void testAdd(){
    try{
      EmployeeDatabase e = new EmployeeDatabase(3);
      HourlyEmployee a = new HourlyEmployee("Basher","Thomas","456",50.0);
      e.add(a);
      assertTrue("Tests that method adds employee to database correctly",a.equals(((GenEmployee[]) e.getDatabase())[0])); 
      EmployeeDatabase b = new EmployeeDatabase(1);
      HourlyEmployee c = new HourlyEmployee("Basher","Thomas","456",50.0);
      b.add(c);
      HourlyEmployee d = new HourlyEmployee("Zack","Thomas","667",50.0);
      b.add(d);
    }
    catch(EmployeeDatabaseFullException a){
      System.out.println("Employee database is already full my guy!");
    }
  }
  
  @Test
  public void testRemove(){
    try{
      EmployeeDatabase u = new EmployeeDatabase(1);
      HourlyEmployee a = new HourlyEmployee("b","thomas","456",50.0);
      HourlyEmployee b = new HourlyEmployee("basher","thomas","456",50.0);
      HourlyEmployee c = new HourlyEmployee("basher","t","456",50.0);
      HourlyEmployee d = new HourlyEmployee("basher","thomas","456",50.0);
      HourlyEmployee e = new HourlyEmployee("basher","thomas","4",50.0);
      HourlyEmployee f = new HourlyEmployee("basher","thomas","456",50.0);
      HourlyEmployee g = new HourlyEmployee("","thomas","456",50.0);
      u.add(a);
      u.remove(a.getFirstName(),a.getLastName(),a.getNumber());
      assertTrue("Tests first string input length 1",null == ((GenEmployee[]) u.getDatabase())[0]);
      u.add(b);
      u.remove(b.getFirstName(),b.getLastName(),b.getNumber());
      assertTrue("Tests first string input length more than 1",null == ((GenEmployee[]) u.getDatabase())[0]);
      u.add(c);
      u.remove(c.getFirstName(),c.getLastName(),c.getNumber());
      assertTrue("Tests second string input length 1",null == ((GenEmployee[]) u.getDatabase())[0]);
      u.add(d);
      u.remove(d.getFirstName(),d.getLastName(),d.getNumber());
      assertTrue("Tests second string input length more than 1",null == ((GenEmployee[]) u.getDatabase())[0]);
      u.add(e);
      u.remove(e.getFirstName(),e.getLastName(),e.getNumber());
      assertTrue("Tests third string input length 1",null == ((GenEmployee[]) u.getDatabase())[0]);
      u.add(f);
      u.remove(f.getFirstName(),f.getLastName(),f.getNumber());
      assertTrue("Tests third string input length more than 1",null == ((GenEmployee[]) u.getDatabase())[0]);
      u.add(g);
      u.remove(g.getFirstName(),g.getLastName(),g.getNumber());
    }
    catch(EmployeeDatabaseFullException z){
      System.out.println("Employee database is already full my guy!");
    }
    catch(NoSuchEmployeeException p){
      System.out.println("No such employee exists in the database my guy!");
    }
  }
  
  @Test
  public void testFind(){
    try{
      EmployeeDatabase u = new EmployeeDatabase(1);
      HourlyEmployee a = new HourlyEmployee("b","thomas","456",50.0);
      HourlyEmployee b = new HourlyEmployee("basher","thomas","456",50.0);
      HourlyEmployee c = new HourlyEmployee("basher","t","456",50.0);
      HourlyEmployee d = new HourlyEmployee("basher","thomas","456",50.0);
      HourlyEmployee e = new HourlyEmployee("basher","thomas","4",50.0);
      HourlyEmployee f = new HourlyEmployee("basher","thomas","456",50.0);
      HourlyEmployee g = new HourlyEmployee("","thomas","456",50.0);
      u.add(a);
      assertTrue("Tests first string input length 1",a.equals(u.find(a.getFirstName(),a.getLastName(),a.getNumber())));
      u.remove(a.getFirstName(),a.getLastName(),a.getNumber());
      u.add(b);
      assertTrue("Tests first string input length more than 1",b.equals(u.find(b.getFirstName(),b.getLastName(),b.getNumber()))); 
      u.remove(b.getFirstName(),b.getLastName(),b.getNumber());
      u.add(c);       
      assertTrue("Tests second string input length 1",c.equals(u.find(c.getFirstName(),c.getLastName(),c.getNumber()))); 
      u.remove(c.getFirstName(),c.getLastName(),c.getNumber());
      u.add(d);           
      assertTrue("Tests second string input length more than 1",d.equals(u.find(d.getFirstName(),d.getLastName(),d.getNumber())));
      u.remove(d.getFirstName(),d.getLastName(),d.getNumber());
      u.add(e);
      assertTrue("Tests third string input length 1",e.equals(u.find(e.getFirstName(),e.getLastName(),e.getNumber())));
      u.remove(e.getFirstName(),e.getLastName(),e.getNumber());
      u.add(f);           
      assertTrue("Tests third string input length more than 1",f.equals(u.find(f.getFirstName(),f.getLastName(),f.getNumber())));
      u.remove(f.getFirstName(),f.getLastName(),f.getNumber());
      u.add(g);
      u.find(g.getFirstName(),g.getLastName(),g.getNumber());
    }
    catch(EmployeeDatabaseFullException z){
      System.out.println("Employee database is already full my guy!");
    }
    catch(NoSuchEmployeeException p){
      System.out.println("No such employee exists in the database my guy!");
    }
  }
  
  @Test
  public void testGetPayrollAmount(){
    EmployeeDatabase e = new EmployeeDatabase(3);
    HourlyEmployee a = new HourlyEmployee("Basher","Thomas","456",50.0);
    a.setHoursWorked(2.0);
    SalariedEmployee b = new SalariedEmployee("Zack","Thomas","567",50.0);
    SalariedSupervisor c = new SalariedSupervisor("Fey","Jackson","776",30.0);
    GenEmployee[] d = new GenEmployee[3];
    d[0] = a;
    d[1] = b;
    d[2] = c;
    e.setDatabase(d);
    assertTrue("Tests that method finds total payroll amount from database correctly",180.0 == e.getPayrollAmount());
    EmployeeDatabase z = new EmployeeDatabase(3);
    assertTrue("Tests that method finds total payroll amount from database correctly",0.0 == z.getPayrollAmount());
  }
  
  @Test
  public void testGetMaximumEarned(){
    EmployeeDatabase e = new EmployeeDatabase(3);
    HourlyEmployee a = new HourlyEmployee("Basher","Thomas","456",50.0);
    a.setHoursWorked(2.0);
    SalariedEmployee b = new SalariedEmployee("Zack","Thomas","567",50.0);
    SalariedSupervisor c = new SalariedSupervisor("Fey","Jackson","776",30.0);
    GenEmployee[] d = new GenEmployee[3];
    d[0] = a;
    d[1] = b;
    d[2] = c;
    e.setDatabase(d);
    assertTrue("Tests that method finds employee with maximum payroll amount from database correctly",a.equals(e.getMaximumEarned()));
    EmployeeDatabase z = new EmployeeDatabase(3);
    assertTrue("Tests that method returns null correctly",null == z.getMaximumEarned());
  }
  
  @Test
  public void testGetMinimumEarned(){
    EmployeeDatabase e = new EmployeeDatabase(3);
    HourlyEmployee a = new HourlyEmployee("Basher","Thomas","456",50.0);
    a.setHoursWorked(2.0);
    SalariedEmployee b = new SalariedEmployee("Zack","Thomas","567",50.0);
    SalariedSupervisor c = new SalariedSupervisor("Fey","Jackson","776",30.0);
    GenEmployee[] d = new GenEmployee[3];
    d[0] = a;
    d[1] = b;
    d[2] = c;
    e.setDatabase(d);
    assertTrue("Tests that method finds employee with minimum payroll amount from database correctly",c.equals(e.getMinimumEarned()));
    EmployeeDatabase z = new EmployeeDatabase(3);
    assertTrue("Tests that method returns null correctly",null == z.getMaximumEarned());
  }
  
  @Test
  public void testGetMaxSales(){
    try{
      EmployeeDatabase e = new EmployeeDatabase(3);
      SalesSupervisor a = new SalesSupervisor("Basher","Thomas","456",50.0,20.0);
      a.setNumSales(5);
      SalesEmployee b = new SalesEmployee("Zack","Thomas","567",50.0,30.0);
      b.setNumSales(4);
      SalesSupervisor c = new SalesSupervisor("Fey","Jackson","776",30.0,10.0);
      c.setNumSales(3);
      GenEmployee[] d = new GenEmployee[3];
      d[0] = a;
      d[1] = b;
      d[2] = c;
      e.setDatabase(d);
      assertTrue("Tests that method finds Supervisor with the most number of sales from database correctly",a.equals(e.getMaxSales()));
      EmployeeDatabase j = new EmployeeDatabase(3);
      SalesEmployee f = new SalesEmployee("Basher","Thomas","456",50.0,20.0);
      a.setNumSales(5);
      SalesSupervisor g = new SalesSupervisor("Zack","Thomas","567",50.0,30.0);
      b.setNumSales(4);
      SalesSupervisor h = new SalesSupervisor("Fey","Jackson","776",30.0,10.0);
      c.setNumSales(3);
      GenEmployee[] i = new GenEmployee[3];
      d[0] = f;
      d[1] = g;
      d[2] = h;
      j.setDatabase(i);
      assertTrue("Tests that method finds Employee with the most number of sales from database correctly",f.equals(j.getMaxSales()));
      EmployeeDatabase k = new EmployeeDatabase(3);
      k.getMaxSales();
    }
    catch(NoSuchEmployeeException l){
      System.out.println("No employees exist in the database my guy!");
    }
  }
  
  @Test
  public void testGetMinSales(){
    try{
      EmployeeDatabase e = new EmployeeDatabase(3);
      SalesSupervisor a = new SalesSupervisor("Basher","Thomas","456",50.0,20.0);
      a.setNumSales(5);
      SalesEmployee b = new SalesEmployee("Zack","Thomas","567",50.0,30.0);
      b.setNumSales(4);
      SalesSupervisor c = new SalesSupervisor("Fey","Jackson","776",30.0,10.0);
      c.setNumSales(3);
      GenEmployee[] d = new GenEmployee[3];
      d[0] = a;
      d[1] = b;
      d[2] = c;
      e.setDatabase(d);
      assertTrue("Tests that method finds Supervisor with the least number of sales from database correctly",c.equals(e.getMinSales()));
      EmployeeDatabase j = new EmployeeDatabase(3);
      SalesEmployee f = new SalesEmployee("Basher","Thomas","456",50.0,20.0);
      a.setNumSales(5);
      SalesSupervisor g = new SalesSupervisor("Zack","Thomas","567",50.0,30.0);
      b.setNumSales(4);
      SalesEmployee h = new SalesEmployee("Fey","Jackson","776",30.0,10.0);
      c.setNumSales(3);
      GenEmployee[] i = new GenEmployee[3];
      d[0] = f;
      d[1] = g;
      d[2] = h;
      j.setDatabase(i);
      assertTrue("Tests that method finds Employee with the least number of sales from database correctly",h.equals(j.getMinSales()));
      EmployeeDatabase k = new EmployeeDatabase(3);
      k.getMinSales();
    }
    catch(NoSuchEmployeeException l){
      System.out.println("No employees exist in the database my guy!");
    }
  }
  
  @Test
  public void testGetMaxHoursWorked(){
    try{
      EmployeeDatabase e = new EmployeeDatabase(3);
      HourlySupervisor a = new HourlySupervisor("Basher","Thomas","456",50.0);
      a.setHoursWorked(5);
      HourlyEmployee b = new HourlyEmployee("Zack","Thomas","567",50.0);
      b.setHoursWorked(4);
      HourlySupervisor c = new HourlySupervisor("Fey","Jackson","776",30.0);
      c.setHoursWorked(3);
      GenEmployee[] d = new GenEmployee[3];
      d[0] = a;
      d[1] = b;
      d[2] = c;
      e.setDatabase(d);
      assertTrue("Tests that method finds Supervisor with the max hours worked from database correctly",a.equals(e.getMaxHoursWorked()));
      EmployeeDatabase j = new EmployeeDatabase(3);
      HourlySupervisor f = new HourlySupervisor("Basher","Thomas","456",50.0);
      f.setHoursWorked(4);
      HourlyEmployee g = new HourlyEmployee("Zack","Thomas","567",50.0);
      g.setHoursWorked(5);
      HourlySupervisor h = new HourlySupervisor("Fey","Jackson","776",30.0);
      h.setHoursWorked(3);
      GenEmployee[] i = new GenEmployee[3];
      d[0] = f;
      d[1] = g;
      d[2] = h;
      j.setDatabase(i);
      assertTrue("Tests that method finds Employee with the max hours worked from database correctly",g.equals(j.getMaxHoursWorked()));
      EmployeeDatabase k = new EmployeeDatabase(3);
      k.getMaxHoursWorked();
    }
    catch(NoSuchEmployeeException l){
      System.out.println("No employees exist in the database my guy!");
    }
  }
  
   @Test
  public void testGetMinHoursWorked(){
    try{
      EmployeeDatabase e = new EmployeeDatabase(3);
      HourlySupervisor a = new HourlySupervisor("Basher","Thomas","456",50.0);
      a.setHoursWorked(5);
      HourlyEmployee b = new HourlyEmployee("Zack","Thomas","567",50.0);
      b.setHoursWorked(4);
      HourlySupervisor c = new HourlySupervisor("Fey","Jackson","776",30.0);
      c.setHoursWorked(3);
      GenEmployee[] d = new GenEmployee[3];
      d[0] = a;
      d[1] = b;
      d[2] = c;
      e.setDatabase(d);
      assertTrue("Tests that method finds Supervisor with the least hours worked from database correctly",c.equals(e.getMinHoursWorked()));
      EmployeeDatabase j = new EmployeeDatabase(3);
      HourlySupervisor f = new HourlySupervisor("Basher","Thomas","456",50.0);
      f.setHoursWorked(4);
      HourlyEmployee g = new HourlyEmployee("Zack","Thomas","567",50.0);
      g.setHoursWorked(5);
      HourlyEmployee h = new HourlyEmployee("Fey","Jackson","776",30.0);
      h.setHoursWorked(3);
      GenEmployee[] i = new GenEmployee[3];
      d[0] = f;
      d[1] = g;
      d[2] = h;
      j.setDatabase(i);
      assertTrue("Tests that method finds Employee with the least hours worked from database correctly",h.equals(j.getMinHoursWorked()));
      EmployeeDatabase k = new EmployeeDatabase(3);
      k.getMinHoursWorked();
    }
    catch(NoSuchEmployeeException l){
      System.out.println("No employees exist in the database my guy!");
    }
  }
  
  @Test
  public void testGetSupervisees(){
    EmployeeDatabase z = new EmployeeDatabase(3);
    HourlyEmployee a = new HourlyEmployee("Basher","Thomas","456",50.0);
    a.setHoursWorked(2.0);
    SalariedEmployee b = new SalariedEmployee("Zack","Thomas","567",50.0);
    SalariedSupervisor c = new SalariedSupervisor("Fey","Jackson","776",30.0);
    HourlySupervisor d = new HourlySupervisor("Yuck","Suck","580",70.0);
      
    SalesSupervisor e = new SalesSupervisor("Chrispy","Boy","777",90.0,100.0);
    HourlySupervisor f = new HourlySupervisor("Jonny","Boy","888",40.0);
    SalariedSupervisor k = new SalariedSupervisor("Chao","Bao","999",50.0);
    
    a.setSupervisor(e);
    b.setSupervisor(e);
    c.setSupervisor(f);
    d.setSupervisor(f);
    
    GenEmployee[] g = new GenEmployee[4];
    g[0] = a;
    g[1] = b;
    g[2] = c;
    g[3] = d;
    z.setDatabase(g);
    GenEmployee[] array = new GenEmployee[2];
    array[0] = a;
    array[1] = b;
    GenEmployee[] array1 = new GenEmployee[2];
    array1[0] = c;
    array1[1] = d;
    GenEmployee[] array2 = new GenEmployee[0];
    assertTrue("Tests that supervisor e corresponds to employees a and b",Arrays.equals(array,z.getSupervisees(e)));
    assertTrue("Tests that supervisor f corresponds to employees c and d",Arrays.equals(array1,z.getSupervisees(f)));
    assertTrue("Tests that supervisor k corresponds to no employees",Arrays.equals(array2,z.getSupervisees(k)));
  }
}