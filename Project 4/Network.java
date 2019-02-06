import java.util.Iterator;
import java.util.Scanner;
import java.io.*;
/**
 * This class represents a social network of entities
 * 
 * @author Christopher Tam
 */
public class Network implements Iterable<Entity>{
  // Stores the entities of the network
  private LinkedList<Entity> network;
  
  /**
   * Creates a new network object
   */
  public Network(){
    this.network = new LinkedList<Entity>();
  }
  
  /**
   * Returns the linkedlist storing the entities of the network
   * @return A LinkedList containing the entites of the network
   */
  public LinkedList<Entity> getNetwork(){
    return network;
  }
  
  /**
   * Returns the iterator of the class
   * @return A Iterator that allows for iteration through the linked list of the class
   */
  @Override 
  public NetworkIterator<Entity> iterator(){
    return new NetworkIterator<Entity>(this.getNetwork().getFront());
  }
  
  /**
   * Takes two input Entity objects and adds both to the network if neither are in it, as well as adding the other entity
   * to each entity's relations list
   * @param e1 The first entity input
   * @param e2 The second entity input
   */
  public void addRelation(Entity e1, Entity e2){
    // e stores an iterator for the network
    NetworkIterator<Entity> e = this.iterator();
    // i stores a value that determines if the first entity input should be added to the network
    int i = 0;
    // i stores a value that determines if the second entity input should be added to the network
    int j = 0;
    /* Goal: To iterate through the network to see if either entity input is already stored */
    while(e.hasNext()){
      if(e.next().equals(e1)){
        i = i + 1;
      }
      if(e.next().equals(e2)){
        j = j + 1;
      }
    }
    if(i == 0){
      (this.getNetwork()).addToFront(e1);
    }
    if(j == 0){
      (this.getNetwork()).addToFront(e2);
    }
    // Each entity input stores the other entity input in its relations list
    (e1.getRelations()).addToFront(e2);
    (e2.getRelations()).addToFront(e1);
  }
  
  /**
   * Takes two entity inputs, and for each entity, removes the other entity from its relations list
   * @param e1 The first entity input
   * @param e2 The second entity input
   */
  public void removeRelation(Entity e1, Entity e2){
    // a stores an interator to iterate through the first entity input's relations list
    Iterator<Entity> a = (e1.getRelations()).iterator();
    // b stores an interator to iterate through the second entity input's relations list
    Iterator<Entity> b = (e2.getRelations()).iterator();
    /* Goal: Iterate through the first entity's relations list to see if the second entity is stored in it */
    while(a.hasNext()){
      // element stores the next entity in the list
      Entity element = a.next();
      if(element.equals(e2) == false){
        element = null;
      }
    }
    /* Goal: Iterate through the second entity's relations list to see if the first entity is stored in it */
    while(b.hasNext()){
      // element stores the next entity in the list
      Entity element = b.next();
      if(element.equals(e1) == false){
        element = null;
      }
    }
  }
  
  /**
   * Takes a file containing a list of relations with a pair of names per line, and adds each pair of names to the network as 
   * a relation of Entity objects
   * @param file The file input
   */
  public void addRelations(File file) throws IOException{
    // line stores each line of text in the file
    String line;
    // a stores the first name of the text line as an entity
    Entity a = new Entity("");
    // b stores the second name of the text line as an entity
    Entity b = new Entity("");
    // scan1 iterates through the file
    Scanner scan1;
    // scan2 iterates through each line in the file
    Scanner scan2;
    scan1 = new Scanner(file);
    /* Goal: Iterate through the file input on a line-by-line basis */
    while(scan1.hasNext()){
      // i determines if the first or second name of the text line is stored as an entity
      int i = 0;
      line = scan1.nextLine();
      scan2 = new Scanner(line);
      scan2.useDelimiter(",");
      /* Goal: Iterate through a line of the file in order to create two Entity objects */
      while(scan2.hasNext()){
        if(i == 0){
          a = new Entity(scan2.next());
          i = 1;
        }
        else
          b = new Entity(scan2.next());
      }
      scan2.close();
      this.addRelation(a,b);
    }
    scan1.close();
  }
  
  /** 
   * Takes an even variable length parameter of Strings, creating an entity Object for each name and adding every pair of names to the 
   * network as a relation
   * @param ...string The variable length argument of strings, containing strings separated by commas
   */
  public void addRelations(String ...string) throws NotAnEvenStringException{
    // c stores a NotAnEvenStringException 
    NotAnEvenStringException c = new NotAnEvenStringException("There is an odd number of strings inputted!");
    if(string.length % 2 == 0){
      // a stores the second name of a pair as an entity
      Entity a = new Entity("");
      // b stores the first name of a pair as an entity
      Entity b = new Entity("");
      // j determines if the string being considered is the first or second name of a pair
      int j = 0;
      /* Goal: To iterate through the variable length string argument and add pairs of string to the network as a relation */
      for(String i : string){
        j = j + 1;
        if(j % 2 == 0){
          a = new Entity(i);
          this.addRelation(a,b);
        }
        else
          b = new Entity(i);
      }
    }
    else
      throw c;
  } 
}