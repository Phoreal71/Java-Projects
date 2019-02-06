import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.paint.Color;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Bloom;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
/** 
 * This class represents a modified version of the game "Toot and Otto"
 * 
 * @author Christopher Tam
 */
public class TootAndOtto extends Application implements EventHandler<ActionEvent>{
  // Stores the value indicating whether it is player 1 or player 2's turn
  private static int turn = 1;
  // Stores the array of buttons that is used to display the game board
  private static Button[][] array;
  // Stores the value indicating whether there is a game win or not
  private static int win = 0;
  /**
   * Creates and displays the game board 
   * @param primaryStage Contains and displays the contents added to the stage (game board)
   */
  public void start(Stage primarystage){
    // Checks that no dimensions are specified in main method call
    if(getParameters().getRaw().size() == 0){
      // Default 6x6 Button array created 
      setArray(new Button[6][6]);
      /* Goal: To iterate through each row in the created button array */
      for(int i = 0; i <= getArray().length - 1; i++){
        /* Goal: To iterate through each column in the created button area for a given row, added a clickable button to each cell */
        for(int j = 0; j <= getArray()[0].length - 1; j++){
          // Button a is a button that is added to each cell (square) of the game board
          Button a = new Button("   ");
          // shadow is used to add a dropshadow effect to the game board
          DropShadow shadow = new DropShadow();
          a.setEffect(shadow);
          a.setOnAction(this);
          getArray()[i][j] = a;
        }
      }
      // pane stores a new gridpane 
      GridPane pane = new GridPane();
      /* Goal: To iterate through each row in the button array */
      for(int i = 0; i <= getArray().length - 1; i++){
        /* Goal: To store each button in the array to its corresponding cell location in the gridpane */
        for(int j = 0; j <= getArray()[0].length - 1; j++){
          pane.add(getArray()[i][j],j,i);
        }
      }
      // scene stores a scene that contains the gridpane
      Scene scene = new Scene(pane);
      primarystage.setScene(scene);
      primarystage.show();
    }
    // Checks that additional dimensions are specified in main method call 
    else if(getParameters().getRaw().size() == 2){
      try{
        // Button array created with dimensions equal to the additional dimensions specified in main method call
        setArray(new Button[Integer.parseInt(getParameters().getRaw().get(0))][Integer.parseInt(getParameters().getRaw().get(1))]);
        /* Goal: To iterate through each row in the created button array */
        for(int i = 0; i <= getArray().length - 1; i++){
          /* Goal: To iterate through each column in the created button area for a given row, added a clickable button to each cell */
          for(int j = 0; j <= getArray()[0].length - 1; j++){
            // Button a is a button that is added to each cell (square) of the game board
            Button a = new Button("   ");
            // shadow is used to add a dropshadow effect to the game board
            DropShadow shadow = new DropShadow();
            a.setEffect(shadow);
            a.setOnAction(this);
            getArray()[i][j] = a;
          }
        }
        // pane stores a new gridpane 
        GridPane pane = new GridPane();
        /* Goal: To iterate through each row in the button array */
        for(int i = 0; i <= getArray().length - 1; i++){
           /* Goal: To store each button in the array to its corresponding cell location in the gridpane */
          for(int j = 0; j <= getArray()[0].length - 1; j++){
            pane.add(getArray()[i][j],j,i);
          }
        }
        // scene stores a scene that contains the gridpane
        Scene scene = new Scene(pane);
        primarystage.setScene(scene);
        primarystage.show();
      }
      // Catches any runtime exceptions that may occur as a result of non-realistic dimensions being entered into the main method call 
      catch(RuntimeException e){
        System.out.println("Non-integer array dimensions entered!");
      }    
    }
  }
  
  /**
   * Returns the win value 
   * @return An int value indicating whether there is a winner or not
   */
  public static int getWin(){
    return win;
  }
  
  /**
   * Sets the win value
   * @param i The value indicating that there is a winner
   */
  public static void setWin(int i){
    win = i;
  }
  
  /**
   * Returns the turn value
   * @return An int value indicating whether it is player 1 or player 2's turn
   */
  public static int getTurn(){
    return turn;
  }
  
  /**
   * Sets the turn value
   * @param number The value indicating whether it is player 1 or player 2's turn
   */
  public static void setTurn(int number){
    turn = number;
  }
  
  /**
   * Returns the button array
   * @return Button[][] An array of buttons that is used to display the game board
   */
  public static Button[][] getArray(){
    return array;
  }
  
  /**
   * Sets the button array
   * @param b The button array that will be set to display the game board
   */
  public static void setArray(Button[][] b){
    array = b;
  }
  
  /**
   * Handles the game mechanics of Toot and Otto associated with every button click on the game board
   * @param e An ActionEvent representing a single button click
   */
  public void handle(ActionEvent e){
    // b stores the button that was clicked on the game board
    Button b = (Button)e.getSource();
    // fill dictates that every T and O added should be first added to the bottom of a game board column
    int fill = 0;
    // Checks that there is no winner and game can continue proceeding
    if(getWin() == 0){
      /* Goal: To iterate through each row in the game board */
      for(int i = 0; i <= getArray().length - 1; i++){
        /* Goal: To iterate through each column in the game board for a given row to locate which button was clicked */
        for(int j = 0; j <= getArray()[0].length - 1; j++){
          // Checks that the clicked button was found 
          if(getArray()[i][j].equals(b)){
            /* Goal: To iterate through a game board column from bottom up to fill the bottom most empty button */
            for(int k = getArray().length - 1; k >= 0; k--){
              // Checks that a buttom most empty button is found
              if(getArray()[k][j].getText().equals("   ") && fill == 0){
                fill = 1;
                // Set button to T
                if(getTurn() % 2 == 1){
                  getArray()[k][j].setText("T");
                  // Stores number of columns of array
                  int v = getArray()[0].length - 1;
                  // Stores number of rows of array
                  int z = getArray().length - 1;
                  /* Goal: To find each T in the game board and check its eight directions (up, down, left, right, bottom/top right, 
                   * bottom/top left)to see if 'TOOT' is spelled out in any of the directions; if it is spelled out, the TOOT is colored
                   * in green and the game has a winner */
                  for(int n = 0; n <= getArray().length - 1; n++){
                    for(int m = 0; m <= getArray()[0].length - 1; m++){
                      // Finds a T 
                      if(getArray()[n][m].getText().equals("T")){
                        // Checks if any TOOTs above this T
                        if(m + 1 <= v && m + 2 <= v && m + 3 <= v && getArray()[n][m + 1].getText().equals("O") && getArray()[n][m + 2].getText().equals("O") && getArray()[n][m + 3].getText().equals("T")){
                          getArray()[n][m].setTextFill(Color.GREEN);
                          getArray()[n][m + 1].setTextFill(Color.GREEN);
                          getArray()[n][m + 2].setTextFill(Color.GREEN);
                          getArray()[n][m + 3].setTextFill(Color.GREEN);
                          setWin(getWin() + 1);
                        }
                        // Checks if any TooTs to the top right corner of this T
                        if(m + 1 <= v && m + 2 <= v && m + 3 <= v && n + 1 <= z && n + 2 <= z && n + 3 <= z && getArray()[n + 1][m + 1].getText().equals("O") && getArray()[n + 2][m + 2].getText().equals("O") && getArray()[n + 3][m + 3].getText().equals("T")){
                          getArray()[n][m].setTextFill(Color.GREEN);
                          getArray()[n + 1][m + 1].setTextFill(Color.GREEN);
                          getArray()[n + 2][m + 2].setTextFill(Color.GREEN);
                          getArray()[n + 3][m + 3].setTextFill(Color.GREEN);
                          setWin(getWin() + 1);
                        }
                        // Checks if any TOOTs to the right of this T
                        if(n + 1 <= z && n + 2 <= z && n + 3 <= z && getArray()[n + 1][m].getText().equals("O") && getArray()[n + 2][m].getText().equals("O") && getArray()[n + 3][m].getText().equals("T")){
                          getArray()[n][m].setTextFill(Color.GREEN);
                          getArray()[n + 1][m].setTextFill(Color.GREEN);
                          getArray()[n + 2][m].setTextFill(Color.GREEN);
                          getArray()[n + 3][m].setTextFill(Color.GREEN);
                          setWin(getWin() + 1);
                        }
                        // Checks if any TooTs to the bottom right corner of this T
                        if(n + 1 <= z && n + 2 <= z && n + 3 <= z && m - 1 >= 0 && m - 2 >= 0 && m - 3 >= 0 && getArray()[n + 1][m - 1].getText().equals("O") && getArray()[n + 2][m - 2].getText().equals("O") && getArray()[n + 3][m - 3].getText().equals("T")){
                          getArray()[n][m].setTextFill(Color.GREEN);
                          getArray()[n + 1][m - 1].setTextFill(Color.GREEN);
                          getArray()[n + 2][m - 2].setTextFill(Color.GREEN);
                          getArray()[n + 3][m - 3].setTextFill(Color.GREEN);
                          setWin(getWin() + 1);
                      }
                        // Checks if any TOOTs to the bottom of this T  
                        if(m - 1 >= 0 && m - 2 >= 0 && m - 3 >= 0 && getArray()[n][m - 1].getText().equals("O") && getArray()[n][m - 2].getText().equals("O") && getArray()[n][m - 3].getText().equals("T")){
                          getArray()[n][m].setTextFill(Color.GREEN);
                          getArray()[n][m - 1].setTextFill(Color.GREEN);
                          getArray()[n][m - 2].setTextFill(Color.GREEN);
                          getArray()[n][m - 3].setTextFill(Color.GREEN);
                          setWin(getWin() + 1);
                        }
                        // Checks if any TOOTs to the bottom left corner of this T
                        if(m - 1 >= 0 && m - 2 >= 0 && m - 3 >= 0 && n - 1 >= 0 && n - 2 >= 0 && n -3 >= 0 && getArray()[n - 1][m - 1].getText().equals("O") && getArray()[n - 2][m - 2].getText().equals("O") && getArray()[n - 3][m - 3].getText().equals("T")){
                          getArray()[n][m].setTextFill(Color.GREEN);
                          getArray()[n - 1][m - 1].setTextFill(Color.GREEN);
                          getArray()[n - 2][m - 2].setTextFill(Color.GREEN);
                          getArray()[n - 3][m - 3].setTextFill(Color.GREEN);
                          setWin(getWin() + 1);
                        }
                        // Checks if any TOOTs to the left of this T
                        if(n - 1 >= 0 && n - 2 >= 0 && n -3 >= 0 && getArray()[n - 1][m].getText().equals("O") && getArray()[n - 2][m].getText().equals("O") && getArray()[n - 3][m].getText().equals("T")){
                          getArray()[n][m].setTextFill(Color.GREEN);
                          getArray()[n - 1][m].setTextFill(Color.GREEN);
                          getArray()[n - 2][m].setTextFill(Color.GREEN);
                          getArray()[n - 3][m].setTextFill(Color.GREEN);
                          setWin(getWin() + 1);
                        }
                        // Checks if any TOOTs to the top left corner of this T
                        if(n - 1 >= 0 && n - 2 >= 0 && n -3 >= 0 && m + 1 <= v && m + 2 <= v && m + 3 <= v && getArray()[n - 1][m + 1].getText().equals("O") && getArray()[n - 2][m + 2].getText().equals("O") && getArray()[n - 3][m + 3].getText().equals("T")){
                          getArray()[n][m].setTextFill(Color.GREEN);
                          getArray()[n - 1][m + 1].setTextFill(Color.GREEN);
                          getArray()[n - 2][m + 2].setTextFill(Color.GREEN);
                          getArray()[n - 3][m + 3].setTextFill(Color.GREEN);
                          setWin(getWin() + 1);
                        }
                      }
                    }
                  }
                  /* Goal: To find each O in the game board and check its eight directions (up, down, left, right, bottom/top right, 
                   * bottom/top left)to see if 'OTTO' is spelled out in any of the directions; if it is spelled out, the OTTO is 
                   * colored in green and the game has a winner */
                  for(int n = 0; n <= getArray().length - 1; n++){
                    for(int m = 0; m <= getArray()[0].length - 1; m++){
                      // Finds an O
                      if(getArray()[n][m].getText().equals("O")){
                        // Checks if any OTTOs above this O
                        if(m + 1 <= v && m + 2 <= v && m + 3 <= v && getArray()[n][m + 1].getText().equals("T") && getArray()[n][m + 2].getText().equals("T") && getArray()[n][m + 3].getText().equals("O")){
                          getArray()[n][m].setTextFill(Color.GREEN);
                          getArray()[n][m + 1].setTextFill(Color.GREEN);
                          getArray()[n][m + 2].setTextFill(Color.GREEN);
                          getArray()[n][m + 3].setTextFill(Color.GREEN);
                          setWin(getWin() + 1);
                        }
                        // Checks if any OTTOs to the top right corner of this O
                        if(m + 1 <= v && m + 2 <= v && m + 3 <= v && n + 1 <= z && n + 2 <= z && n + 3 <= z && getArray()[n + 1][m + 1].getText().equals("T") && getArray()[n + 2][m + 2].getText().equals("T") && getArray()[n + 3][m + 3].getText().equals("O")){
                          getArray()[n][m].setTextFill(Color.GREEN);
                          getArray()[n + 1][m + 1].setTextFill(Color.GREEN);
                          getArray()[n + 2][m + 2].setTextFill(Color.GREEN);
                          getArray()[n + 3][m + 3].setTextFill(Color.GREEN);
                          setWin(getWin() + 1);
                        }
                        // Checks if any OTTOs to the right of this O
                        if(n + 1 <= z && n + 2 <= z && n + 3 <= z && getArray()[n + 1][m].getText().equals("T") && getArray()[n + 2][m].getText().equals("T") && getArray()[n + 3][m].getText().equals("O")){
                          getArray()[n][m].setTextFill(Color.GREEN);
                          getArray()[n + 1][m].setTextFill(Color.GREEN);
                          getArray()[n + 2][m].setTextFill(Color.GREEN);
                          getArray()[n + 3][m].setTextFill(Color.GREEN);
                          setWin(getWin() + 1);
                        }
                        // Checks if any OTTOs to the bottom right corner of this O
                        if(n + 1 <= z && n + 2 <= z && n + 3 <= z && m - 1 >= 0 && m - 2 >= 0 && m - 3 >= 0 && getArray()[n + 1][m - 1].getText().equals("T") && getArray()[n + 2][m - 2].getText().equals("T") && getArray()[n + 3][m - 3].getText().equals("O")){
                          getArray()[n + 1][m - 1].setTextFill(Color.GREEN);
                          getArray()[n + 2][m - 2].setTextFill(Color.GREEN);
                          getArray()[n + 3][m - 3].setTextFill(Color.GREEN);
                          setWin(getWin() + 1);
                      }
                        // Checks if any OTTOs to the bottom of this O  
                        if(m - 1 >=0 && m - 2 >= 0 && m - 3 >= 0 && getArray()[n][m - 1].getText().equals("T") && getArray()[n][m - 2].getText().equals("T") && getArray()[n][m - 3].getText().equals("O")){
                          getArray()[n][m].setTextFill(Color.GREEN);
                          getArray()[n][m - 1].setTextFill(Color.GREEN);
                          getArray()[n][m - 2].setTextFill(Color.GREEN);
                          getArray()[n][m - 3].setTextFill(Color.GREEN);
                          setWin(getWin() + 1);
                        }
                        // Checks if any OTTOs to the bottom left corner of this O
                        if(m - 1 >=0 && m - 2 >= 0 && m - 3 >= 0 && n - 1 >= 0 && n - 2 >= 0 && n - 3 >= 0 && getArray()[n - 1][m - 1].getText().equals("T") && getArray()[n - 2][m - 2].getText().equals("T") && getArray()[n - 3][m - 3].getText().equals("O")){
                          getArray()[n][m].setTextFill(Color.GREEN);
                          getArray()[n - 1][m - 1].setTextFill(Color.GREEN);
                          getArray()[n - 2][m - 2].setTextFill(Color.GREEN);
                          getArray()[n - 3][m - 3].setTextFill(Color.GREEN);
                          setWin(getWin() + 1);
                        }
                        // Checks if any OTTOs to the left of this O
                        if(n - 1 >= 0 && n - 2 >= 0 && n - 3 >= 0 && getArray()[n - 1][m].getText().equals("T") && getArray()[n - 2][m].getText().equals("T") && getArray()[n - 3][m].getText().equals("O")){
                          getArray()[n][m].setTextFill(Color.GREEN);
                          getArray()[n - 1][m].setTextFill(Color.GREEN);
                          getArray()[n - 2][m].setTextFill(Color.GREEN);
                          getArray()[n - 3][m].setTextFill(Color.GREEN);
                          setWin(getWin() + 1);
                        }
                        // Checks if any OTTOs to the top left corner of this O
                        if(n - 1 >= 0 && n - 2 >= 0 && n - 3 >= 0 && m + 1 <= v && m + 2 <= v && m + 3 <= v && getArray()[n - 1][m + 1].getText().equals("T") && getArray()[n - 2][m + 2].getText().equals("T") && getArray()[n - 3][m + 3].getText().equals("O")){
                          getArray()[n][m].setTextFill(Color.GREEN);
                          getArray()[n - 1][m + 1].setTextFill(Color.GREEN);
                          getArray()[n - 2][m + 2].setTextFill(Color.GREEN);
                          getArray()[n - 3][m + 3].setTextFill(Color.GREEN);
                          setWin(getWin() + 1);
                        }
                      }
                    }
                  }
                  // Checks if player one wins, displays appropriate dialog box 
                  if(getWin() != 0){
                    if(getWin() == 2){
                      JFrame frame = new JFrame();
                      frame.setSize(1000,1000);
                      JOptionPane.showMessageDialog(frame, "Player one wins!");
                    }
                    // Checks if there's a tie and displays appropriate dialog box
                    else if(getWin() == 4){
                      JFrame frame = new JFrame();
                      frame.setSize(1000,1000);
                      JOptionPane.showMessageDialog(frame, "Its a tie!");
                    }
                  }
                  // Advances to next player's turn
                  setTurn(getTurn() + 1);
                }
                // Set button to O
                else if(getTurn() % 2 == 0){
                  getArray()[k][j].setText("O");
                  // Stores number of columns of array
                  int v = getArray()[0].length - 1;
                  // Stores number of rows of array
                  int z = getArray().length - 1;
                  /* Goal: To find each T in the game board and check its eight directions (up, down, left, right, bottom/top right, 
                   * bottom/top left)to see if 'TOOT' is spelled out in any of the directions; if it is spelled out, the TOOT is colored
                   * in green and the game has a winner */
                  for(int n = 0; n <= getArray().length - 1; n++){
                    for(int m = 0; m <= getArray()[0].length - 1; m++){
                      // Finds a T 
                      if(getArray()[n][m].getText().equals("T")){
                        // Checks if any TOOTs above this T
                        if(m + 1 <= v && m + 2 <= v && m + 3 <= v && getArray()[n][m + 1].getText().equals("O") && getArray()[n][m + 2].getText().equals("O") && getArray()[n][m + 3].getText().equals("T")){
                          getArray()[n][m].setTextFill(Color.GREEN);
                          getArray()[n][m + 1].setTextFill(Color.GREEN);
                          getArray()[n][m + 2].setTextFill(Color.GREEN);
                          getArray()[n][m + 3].setTextFill(Color.GREEN);
                          setWin(getWin() + 1);
                        }
                        // Checks if any TooTs to the top right corner of this T
                        if(m + 1 <= v && m + 2 <= v && m + 3 <= v && n + 1 <= z && n + 2 <= z && n + 3 <= z && getArray()[n + 1][m + 1].getText().equals("O") && getArray()[n + 2][m + 2].getText().equals("O") && getArray()[n + 3][m + 3].getText().equals("T")){
                          getArray()[n][m].setTextFill(Color.GREEN);
                          getArray()[n + 1][m + 1].setTextFill(Color.GREEN);
                          getArray()[n + 2][m + 2].setTextFill(Color.GREEN);
                          getArray()[n + 3][m + 3].setTextFill(Color.GREEN);
                          setWin(getWin() + 1);
                        }
                        // Checks if any TOOTs to the right of this T
                        if(n + 1 <= z && n + 2 <= z && n + 3 <= z && getArray()[n + 1][m].getText().equals("O") && getArray()[n + 2][m].getText().equals("O") && getArray()[n + 3][m].getText().equals("T")){
                          getArray()[n][m].setTextFill(Color.GREEN);
                          getArray()[n + 1][m].setTextFill(Color.GREEN);
                          getArray()[n + 2][m].setTextFill(Color.GREEN);
                          getArray()[n + 3][m].setTextFill(Color.GREEN);
                          setWin(getWin() + 1);
                        }
                        // Checks if any TooTs to the bottom right corner of this T
                        if(n + 1 <= z && n + 2 <= z && n + 3 <= z && m - 1 >= 0 && m - 2 >= 0 && m - 3 >= 0 && getArray()[n + 1][m - 1].getText().equals("O") && getArray()[n + 2][m - 2].getText().equals("O") && getArray()[n + 3][m - 3].getText().equals("T")){
                          getArray()[n][m].setTextFill(Color.GREEN);
                          getArray()[n + 1][m - 1].setTextFill(Color.GREEN);
                          getArray()[n + 2][m - 2].setTextFill(Color.GREEN);
                          getArray()[n + 3][m - 3].setTextFill(Color.GREEN);
                          setWin(getWin() + 1);
                      }
                        // Checks if any TOOTs to the bottom of this T  
                        if(m - 1 >= 0 && m - 2 >= 0 && m - 3 >= 0 && getArray()[n][m - 1].getText().equals("O") && getArray()[n][m - 2].getText().equals("O") && getArray()[n][m - 3].getText().equals("T")){
                          getArray()[n][m].setTextFill(Color.GREEN);
                          getArray()[n][m - 1].setTextFill(Color.GREEN);
                          getArray()[n][m - 2].setTextFill(Color.GREEN);
                          getArray()[n][m - 3].setTextFill(Color.GREEN);
                          setWin(getWin() + 1);
                        }
                        // Checks if any TOOTs to the bottom left corner of this T
                        if(m - 1 >= 0 && m - 2 >= 0 && m - 3 >= 0 && n - 1 >= 0 && n - 2 >= 0 && n -3 >= 0 && getArray()[n - 1][m - 1].getText().equals("O") && getArray()[n - 2][m - 2].getText().equals("O") && getArray()[n - 3][m - 3].getText().equals("T")){
                          getArray()[n][m].setTextFill(Color.GREEN);
                          getArray()[n - 1][m - 1].setTextFill(Color.GREEN);
                          getArray()[n - 2][m - 2].setTextFill(Color.GREEN);
                          getArray()[n - 3][m - 3].setTextFill(Color.GREEN);
                          setWin(getWin() + 1);
                        }
                        // Checks if any TOOTs to the left of this T
                        if(n - 1 >= 0 && n - 2 >= 0 && n -3 >= 0 && getArray()[n - 1][m].getText().equals("O") && getArray()[n - 2][m].getText().equals("O") && getArray()[n - 3][m].getText().equals("T")){
                          getArray()[n][m].setTextFill(Color.GREEN);
                          getArray()[n - 1][m].setTextFill(Color.GREEN);
                          getArray()[n - 2][m].setTextFill(Color.GREEN);
                          getArray()[n - 3][m].setTextFill(Color.GREEN);
                          setWin(getWin() + 1);
                        }
                        // Checks if any TOOTs to the top left corner of this T
                        if(n - 1 >= 0 && n - 2 >= 0 && n -3 >= 0 && m + 1 <= v && m + 2 <= v && m + 3 <= v && getArray()[n - 1][m + 1].getText().equals("O") && getArray()[n - 2][m + 2].getText().equals("O") && getArray()[n - 3][m + 3].getText().equals("T")){
                          getArray()[n][m].setTextFill(Color.GREEN);
                          getArray()[n - 1][m + 1].setTextFill(Color.GREEN);
                          getArray()[n - 2][m + 2].setTextFill(Color.GREEN);
                          getArray()[n - 3][m + 3].setTextFill(Color.GREEN);
                          setWin(getWin() + 1);
                        }
                      }
                    }
                  }
                  /* Goal: To find each O in the game board and check its eight directions (up, down, left, right, bottom/top right, 
                   * bottom/top left)to see if 'OTTO' is spelled out in any of the directions; if it is spelled out, the OTTO is 
                   * colored in green and the game has a winner */ 
                  for(int n = 0; n <= getArray().length - 1; n++){
                    for(int m = 0; m <= getArray()[0].length - 1; m++){
                      // Finds an O
                      if(getArray()[n][m].getText().equals("O")){
                        // Checks if any OTTOs above this O
                        if(m + 1 <= v && m + 2 <= v && m + 3 <= v && getArray()[n][m + 1].getText().equals("T") && getArray()[n][m + 2].getText().equals("T") && getArray()[n][m + 3].getText().equals("O")){
                          getArray()[n][m].setTextFill(Color.GREEN);
                          getArray()[n][m + 1].setTextFill(Color.GREEN);
                          getArray()[n][m + 2].setTextFill(Color.GREEN);
                          getArray()[n][m + 3].setTextFill(Color.GREEN);
                          setWin(getWin() + 1);
                        }
                        // Checks if any OTTOs to the top right corner of this O
                        if(m + 1 <= v && m + 2 <= v && m + 3 <= v && n + 1 <= z && n + 2 <= z && n + 3 <= z && getArray()[n + 1][m + 1].getText().equals("T") && getArray()[n + 2][m + 2].getText().equals("T") && getArray()[n + 3][m + 3].getText().equals("O")){
                          getArray()[n][m].setTextFill(Color.GREEN);
                          getArray()[n + 1][m + 1].setTextFill(Color.GREEN);
                          getArray()[n + 2][m + 2].setTextFill(Color.GREEN);
                          getArray()[n + 3][m + 3].setTextFill(Color.GREEN);
                          setWin(getWin() + 1);
                        }
                        // Checks if any OTTOs to the right of this O
                        if(n + 1 <= z && n + 2 <= z && n + 3 <= z && getArray()[n + 1][m].getText().equals("T") && getArray()[n + 2][m].getText().equals("T") && getArray()[n + 3][m].getText().equals("O")){
                          getArray()[n][m].setTextFill(Color.GREEN);
                          getArray()[n + 1][m].setTextFill(Color.GREEN);
                          getArray()[n + 2][m].setTextFill(Color.GREEN);
                          getArray()[n + 3][m].setTextFill(Color.GREEN);
                          setWin(getWin() + 1);
                        }
                        // Checks if any OTTOs to the bottom right corner of this O
                        if(n + 1 <= z && n + 2 <= z && n + 3 <= z && m - 1 >= 0 && m - 2 >= 0 && m - 3 >= 0 && getArray()[n + 1][m - 1].getText().equals("T") && getArray()[n + 2][m - 2].getText().equals("T") && getArray()[n + 3][m - 3].getText().equals("O")){
                          getArray()[n][j].setTextFill(Color.GREEN);
                          getArray()[n + 1][m - 1].setTextFill(Color.GREEN);
                          getArray()[n + 2][m - 2].setTextFill(Color.GREEN);
                          getArray()[n + 3][m - 3].setTextFill(Color.GREEN);
                          setWin(getWin() + 1);
                      }
                        // Checks if any OTTOs to the bottom of this O  
                        if(m - 1 >=0 && m - 2 >= 0 && m - 3 >= 0 && getArray()[n][m - 1].getText().equals("T") && getArray()[n][m - 2].getText().equals("T") && getArray()[n][m - 3].getText().equals("O")){
                          getArray()[n][m].setTextFill(Color.GREEN);
                          getArray()[n][m - 1].setTextFill(Color.GREEN);
                          getArray()[n][m - 2].setTextFill(Color.GREEN);
                          getArray()[n][m - 3].setTextFill(Color.GREEN);
                          setWin(getWin() + 1);
                        }
                        // Checks if any OTTOs to the bottom left corner of this O
                        if(m - 1 >=0 && m - 2 >= 0 && m - 3 >= 0 && n - 1 >= 0 && n - 2 >= 0 && n - 3 >= 0 && getArray()[n - 1][m - 1].getText().equals("T") && getArray()[n - 2][m - 2].getText().equals("T") && getArray()[n - 3][m - 3].getText().equals("O")){
                          getArray()[n][m].setTextFill(Color.GREEN);
                          getArray()[n - 1][m - 1].setTextFill(Color.GREEN);
                          getArray()[n - 2][m - 2].setTextFill(Color.GREEN);
                          getArray()[n - 3][m - 3].setTextFill(Color.GREEN);
                          setWin(getWin() + 1);
                        }
                        // Checks if any OTTOs to the left of this O
                        if(n - 1 >= 0 && n - 2 >= 0 && n - 3 >= 0 && getArray()[n - 1][m].getText().equals("T") && getArray()[n - 2][m].getText().equals("T") && getArray()[n - 3][m].getText().equals("O")){
                          getArray()[n][m].setTextFill(Color.GREEN);
                          getArray()[n - 1][m].setTextFill(Color.GREEN);
                          getArray()[n - 2][m].setTextFill(Color.GREEN);
                          getArray()[n - 3][m].setTextFill(Color.GREEN);
                          setWin(getWin() + 1);
                        }
                        // Checks if any OTTOs to the top left corner of this O
                        if(n - 1 >= 0 && n - 2 >= 0 && n - 3 >= 0 && m + 1 <= v && m + 2 <= v && m + 3 <= v && getArray()[n - 1][m + 1].getText().equals("T") && getArray()[n - 2][m + 2].getText().equals("T") && getArray()[n - 3][m + 3].getText().equals("O")){
                          getArray()[n][m].setTextFill(Color.GREEN);
                          getArray()[n - 1][m + 1].setTextFill(Color.GREEN);
                          getArray()[n - 2][m + 2].setTextFill(Color.GREEN);
                          getArray()[n - 3][m + 3].setTextFill(Color.GREEN);
                          setWin(getWin() + 1);
                        }
                      }
                    }
                  }
                  // Checks if player two wins, displays appropriate dialog box
                  if(getWin() != 0){
                    if(getWin() == 2){
                      JFrame frame = new JFrame();
                      frame.setSize(1000,1000);
                      JOptionPane.showMessageDialog(frame, "Player two wins!");
                    }
                    // Checks if there's a tie, displays appropriate dialog box
                    else if(getWin() == 4){
                      JFrame frame = new JFrame();
                      frame.setSize(1000,1000);
                      JOptionPane.showMessageDialog(frame, "Its a tie!");
                    }
                  }
                  // Advances to the next player's turn
                  setTurn(getTurn() + 1);
                }
              }
            }
          }
        }
      }
    }
  }
  
  /**
   * The main method of the class; launches the game by displaying a game board, which can be the default 6x6 dimension or 
   * a board with specified dimensions found in the main method call
   * @param args A command line argument that can contain 0 or 2 arguments
   */
  public static void main(String[] args){
      Application.launch(args);
  }
}
      
