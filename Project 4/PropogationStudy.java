import java.util.NoSuchElementException;
import java.util.Iterator;
import java.io.*;
import java.util.Scanner;
/**
 * This class runs a simulation on a given network of entities, creating a study that takes the network as well as 
 * an infection rate, healing rate, and a wear rate value
 *
 * @author Christopher Tam
 */
public class PropogationStudy{
  // Stores the given network
  private Network network;
  // Stores the infection rate 
  private double infectionrate;
  // Stores the heal rate
  private double healrate;
  // Stores the wear rate
  private double wearrate;
  /**
   * Creates a new propogation study
   * @param network The given network of the study
   * @param infect The given infection rate of the study
   * @param heal The given healing rate of the study
   * @param wear The given wear rate of the study
   */
  public PropogationStudy(Network network, double infect, double heal, double wear){
    this.network = network;
    this.infectionrate = infect;
    this.healrate = heal;
    this.wearrate = wear;
  }
  
  /**
   * Returns the network of the study
   * @return A Network representing the network of the study
   */
  public Network getNetwork(){
    return network;
  }
  
  /**
   * Sets the network of the study
   * @param network The network
   */
  public void setNetwork(Network network){
    this.network = network;
  }
  
  /**
   * Returns the infection rate of the study
   * @return A double value representing the infection rate
   */
  public double getInfectionRate(){
    return infectionrate;
  }
  
  /**
   * Sets the infection rate of the study
   * @param infectionrate The infection rate 
   */
  public void setInfectionRate(double infectionrate){
    this.infectionrate = infectionrate;
  }
  
  /**
   * Returns the heal rate of the study
   * @return A double value representing the heal rate
   */
  public double getHealRate(){
    return healrate;
  }
  
  /**
   * Sets the heal rate of the study
   * @param healrate The heal rate 
   */
  public void setHealRate(double healrate){
    this.healrate = healrate;
  }
  
  /**
   * Returns the wear rate of the study
   * @return A double value representing the wear rate
   */
  public double getWearRate(){
    return wearrate;
  }
  
  /**
   * Sets the wear rate of the study
   * @param wearrate The wear rate
   */
  public void setWearRate(double wearrate){
    this.wearrate = wearrate;
  }
  
  /**
   * Infects an entity in the network matching the parameter entity, and throws a NoSuchElementException if no such entity is found
   * @param e The input entity
   */
  public void infect(Entity e) throws NoSuchElementException{
    // i determines if the input entity is in the network
    int i = 0;
    // a iterates through the network of the study
    NetworkIterator<Entity> a = this.getNetwork().iterator();
    /* Goal: To iterate through the network of the study and infect an entity if it matches the input entity */
    while(a.hasNext()){
      // element stores the next entity in the list
      Entity element = a.next();
      if(element.equals(e)){
        element.setHealthStatus(Entity.Health.Infected);
        i = 1;
      }
    }
    if(i == 0){
      throw new NoSuchElementException("No such element exists in the network!");
    }
  }
  
  /**
   * Takes a double value, and each entity in the network will be infected with a probability equal to this double value
   * @param prob The probability of infection
   */
  public void infect(double prob){
    // a iterates through the network of the study
    NetworkIterator<Entity> a = this.getNetwork().iterator();
    /* Goal: To iterate through the network of the study and infect each entity at the given probability of infection */
    while(a.hasNext()){
      // element stores the next entity in the list
      Entity element = a.next();
      if(Math.random() < prob){
        this.infect(element);
      }
    }
  }
  
  /**
   * Inoculates an entity in the network matching the parameter entity, and throws a NoSuchElementException if no such entity is found
   * @param e The input entity
   */
  public void inoculate(Entity e) throws NoSuchElementException{
    // i determines if the input entity is in the network
    int i = 0;
    // a iterates through the network of the study
    NetworkIterator<Entity> a = this.getNetwork().iterator();
    /* Goal: To iterate through the network of the study and inoculate an entity if it matches the input entity */
    while(a.hasNext()){
      // element stores the next entity in the list
      Entity element = a.next();
      if(element.equals(e)){
        element.setHealthStatus(Entity.Health.Inoculated);
        i = 1;
      }
    }
    if(i == 0){
      throw new NoSuchElementException("No such element exists in the network!");
    }
  }
  
  /**
   * Takes a double value, and each entity in the network will be inoculated with a probability equal to this double value
   * @param prob The probability of inoculation
   */
  public void inoculate(double prob){
    // a iterates through the network of the study
    NetworkIterator<Entity> a = this.getNetwork().iterator();
    /* Goal: To iterate through the network of the study and inoculate each entity at the given probability of inoculation */
    while(a.hasNext()){
      // element stores the next entity in the list
      Entity element = a.next();
      if(Math.random() < prob){
        this.inoculate(element);
      }
    }
  }
  
  /**
   * Returns the number of entities that are uninfected in the network
   * @return An int value representing the number of uninfected entities 
   */
  public int getNumUninfected(){
    // i stores the number of uninfected entities
    int i = 0;
    // a iterates through the network of the study
    NetworkIterator<Entity> a = this.getNetwork().iterator();
    /* Goal: Iterate through the network and count how many uninfected entities exist */
    while(a.hasNext()){
      // element stores the next entity in the list
      Entity element = a.next();
      if(element.getHealthStatus() == Entity.Health.Uninfected){
        i = i + 1;
      }
    }
    return i;
  }
  
  /**
   * Returns the number of entities that are inoculated in the network
   * @return An int value representing the number of inoculated entities 
   */
  public int getNumInoculated(){
    // i stores the number of inoculated entities
    int i = 0;
    // a iterates through the network of the study
    NetworkIterator<Entity> a = this.getNetwork().iterator();
    /* Goal: Iterate through the network and count how many inoculated entities exist */
    while(a.hasNext()){
      // element stores the next entity in the list
      Entity element = a.next();
      if(element.getHealthStatus() == Entity.Health.Inoculated){
        i = i + 1;
      }
    }
    return i;
  }
  
  /**
   * Returns the number of entities that are infected in the network
   * @return An int value representing the number of infected entities 
   */
  public int getNumInfected(){
    // i stores the number of infected entities
    int i = 0;
    // a iterates through the network of the study
    NetworkIterator<Entity> a = this.getNetwork().iterator();
    /* Goal: Iterate through the network and count how many infected entities exist */
    while(a.hasNext()){
      // element stores the next entity in the list
      Entity element = a.next();
      if(element.getHealthStatus() == Entity.Health.Infected){
        i = i + 1;
      }
    }
    return i;
  }
  
  /**
   * Changes the health status of every entity in the network to uninfected
   */
  public void resetNetwork(){
    // a iterates through the network of the study
    NetworkIterator<Entity> a = this.getNetwork().iterator();
    /* Goal: To iterate through every entity in the network, changing each entity's health status to uninfected in the process */
    while(a.hasNext()){
      // element stores the next entity in the list
      Entity element = a.next();
      element.setHealthStatus(Entity.Health.Uninfected);
    }
  }
  
  /** 
   * Prints each entity's name and health status in the network, ordering the printed output by the names of the entities
   */
  public void printNetwork(){
    // a iterates through the network of the study
    NetworkIterator<Entity> a = this.getNetwork().iterator();
    /* Goal: To iterate through the network and print each entity's name and health status */
    while(a.hasNext()){
      // element stores the next entity in the list
      Entity element = a.next();
      System.out.println(element.getName() + "," + element.getHealthStatus());
    }
    System.out.println();
  }
  
  /**
   * Iterates through the study's network, and for each Infected entity: runs through its relations list and sets each uninfected entity's 
   * health status in this list to BeingInfected at a random probability, as well as also setting the infected entity's health status to 
   * BeingInoculated at a random probability; Inoculated entity: set its health status to Uninfected at a random probability; Beinginfected 
   * entity: set its health status to Infected; BeingInoculated entity: set its health status to Inoculated
   */ 
  public void runPropogation(){
    // a iterates through the network of the study
    NetworkIterator<Entity> a = this.getNetwork().iterator();
    /* Goal: To iterate through the study's network and perform the specified functions listed above */
    while(a.hasNext()){
      // element stores the next entity in the network list
      Entity element = a.next();
      if(element.getHealthStatus() == Entity.Health.Infected){
        // b iterates through the relations list of the element
        Iterator<Entity> b = (element.getRelations()).iterator();
        /* Goal: To iterate through the element's relations list and change uninfected entities to being infected */
        while(b.hasNext()){
          // element1 stores the next entity in the relations list
          Entity element1 = b.next();
          if(element1.getHealthStatus() == Entity.Health.Uninfected){
            /** if a randomly generated value is less than the study's infection rate change uninfected entity's status 
              * to BeingInfected
              */
            if(Math.random() < this.getInfectionRate()){
              element1.setHealthStatus(Entity.Health.BeingInfected);
            }
          }
        }
        // If a randomly generated value is less than the study's heal rate set infected entity's health status to BeingInoculated 
        if(Math.random() < this.getHealRate()){
          element.setHealthStatus(Entity.Health.BeingInoculated);
        }
      }
      // If a randomly generated value is less than the study's wear rate set Inoculated entity's health status to Uninfected
      if(element.getHealthStatus() == Entity.Health.Inoculated){
        if(Math.random() < this.getWearRate()){
          element.setHealthStatus(Entity.Health.Uninfected);
        }
      }
      // Sets a BeingInfected entity's health status to Infected
      if(element.getHealthStatus() == Entity.Health.BeingInfected){
        element.setHealthStatus(Entity.Health.Infected);
      }
      // Sets a BeingInoculated entity's health status to Inoculated
      if(element.getHealthStatus() == Entity.Health.BeingInoculated){
        element.setHealthStatus(Entity.Health.Inoculated);
      }
    }
  } 
  
  /**
   * Calls the runPropogation method a number of times equal to the input int value
   * @param value The number of times runPropogation must be called
   */
  public void runPropogation(int value){
    if(value > 0){
      for(int i = 0; i <= value; i++){
        this.runPropogation();
      }
    }
  }
  
  /**
   * The main method of the PropogationStudy class; creates a PropogationStudy object using the first five string arguments, and 
   * inoculates the entites found in the sixth string argument and infects the entities found in the seventh string argument
   * @param args A command line argument containing seven strings
   */
  public static void main(String[] args){
    try{
      if(args.length == 7){
        // network stores new created network
        Network network = new Network();
        // file1 stores the first string argument as a file
        File file1 = new File(args[0]);
        // the entities of file1 are added to the network as relations
        network.addRelations(file1);
        // second string argument is taken as an infection rate
        double infectrate = Double.parseDouble(args[1]);
        // third string argument is taken as a heal rate
        double healrate = Double.parseDouble(args[2]);
        // fourth string argument is taken as a wear rate
        double wearrate = Double.parseDouble(args[3]);
        // fifth string argument is taken as the number of times runPropogation method must be called
        int numrounds = Integer.parseInt(args[4]);
        PropogationStudy study = new PropogationStudy(network,infectrate,healrate,wearrate);
        // filescan1 iterates through the file created from the sixth string argument
        Scanner filescan1 = new Scanner(new File(args[5]));
        // line iterates through each line in the file
        String line;
        // inoculatedlist is a list storing inoculated entites from the file
        LinkedList<Entity> inoculatedlist = new LinkedList<Entity>();
        /* Goal: Iterate through the file line by line */
        while(filescan1.hasNext()){
          line = filescan1.nextLine();
          // stores an inoculated entity from the file
          Entity element  = new Entity(line);
          element.setHealthStatus(Entity.Health.Inoculated);
          inoculatedlist.addToFront(element);
        }
        filescan1.close();
        // filescan2 iterates through the file created from the seventh string argument
        Scanner filescan2 = new Scanner(new File(args[6]));
        // line1 iterates through each line in the file 
        String line1;
        // infectedlist is a list storing infected entites from the file
        LinkedList<Entity> infectedlist = new LinkedList<Entity>();
        /* Goal: Iterate through the file line by line */
        while(filescan2.hasNext()){
          line1 = filescan2.nextLine();
          // stores an inoculated entity from the file
          Entity element  = new Entity(line1);
          element.setHealthStatus(Entity.Health.Infected);
          infectedlist.addToFront(element);
        }
        filescan2.close();
        study.runPropogation(numrounds);
        System.out.println("Infected:" + study.getNumInfected() + ", Uninfected:" + study.getNumUninfected() + ", Inoculated:" + study.getNumInoculated());
      }
    }
    // Catches any IOException error that may come from creating files from the string arguments
    catch(IOException error){
      System.out.println("Trouble reading from file, either nothing in file or doesnt exist!");
    }
  }
}