package Sperms;
import java.util.*;
import java.io.*;

// class which contains game details
public class GameAssets {
  public static InputStreamReader r=new InputStreamReader(System.in);    
  public static BufferedReader br=new BufferedReader(r);      
  public static ArrayList<GameLevel> levels = new ArrayList<>();
  
  // views levels
  public static void viewLevels(){
    for(int i = 0; i < levels.size(); i++){
      System.out.println();
      levels.get(i).printDetails();
      System.out.println();
    }
  }
  
  // creates levels
  public static void createLevel() throws IOException{
    String code;
    int lvl;
    
    System.out.print("Enter game code: ");
    code = br.readLine();
    System.out.print("Enter game level: ");
    lvl = Integer.parseInt(br.readLine());
    
    levels.add(new GameLevel(code, lvl));
    System.out.print("Successfully created game level.");
  }
  
  // imports assets in levels
  public static void importAsset()throws IOException{
    String code;
    
    System.out.print("Enter Game Code: ");
    code = br.readLine();
    
    for(int i = 0; i < levels.size(); i++){
      if(code == levels.get(i).lvlCode){
        levels.get(i).importAssets();
        System.out.print("Successfully imported asset.");
        return;
      }
    }
    
    System.out.print("Couldnot find the game level.");
  }
  
  // edits game levels
  public static void editLevel()throws IOException{
      String code;
    
      System.out.print("Enter Game Code: ");
      code = br.readLine();
      for(int i = 0; i < levels.size(); i++){
          if(code == levels.get(i).lvlCode){
            System.out.print("Enter the new level: ");
            levels.get(i).level = Integer.parseInt(br.readLine());
            System.out.print("Successfully edited the level of the game.");
            return;
          }
      }
    
      System.out.print("Couldnot find the game level.");
  }
  
  // deletes a game
  public static void deleteGame()throws IOException{
    String code;
    
    System.out.print("Enter Game Code: ");
    code = br.readLine();
    for(int i = 0; i < levels.size(); i++){
      if(code == levels.get(i).lvlCode){
        levels.remove(i);
        System.out.print("Successfully deleted game level.");
        return;
      }
    }
    
    System.out.print("Couldnot find the game level.");
  }
  
  // execution begins from here
  public static void main(String args[])throws IOException{
    int choice = 0;
    boolean run = true;
    
    while(run){
      // asking for user choice
      System.out.println("\n\nGame Development Panel");
      System.out.println("1. View All Levels");
      System.out.println("2. Create Level");
      System.out.println("3. Import an Asset");
      System.out.println("4. Edit Game Level");
      System.out.println("5. Delete a Game Level");
      System.out.println("6. Exit the Panel");
      System.out.print(">> ");
      
      // getting user choice
      try{
        choice = Integer.parseInt(br.readLine());
      }
      catch(Exception e){
        System.out.println("Couldnt handle user input");
      }
      
      switch(choice){
        case 6: // exit
          run = false;
          break;
          
        case 1: // view levels
          viewLevels();
          break;
          
        case 2: // create level
          createLevel();
          break;
          
        case 3: // import asset
          importAsset();
          break;
          
        case 4: // edit level
          editLevel();
          break;
          
        case 5: // delete game
          deleteGame();
          break;
          
        default: // when no input match
          System.out.print("Invalid integer provided as input.");
      }
    }
  } 
}

// GameLevel class for game levels
class GameLevel{
  private int assets;
  public int level;
  public String lvlCode;
  
  GameLevel(String code, int lvl){
    lvlCode = code;
    level = lvl;
  }
  
  public void importAssets(){
    assets++;
  }
  
  public void removeAssets(){
    if(assets > 0) assets--;
  }
  
  public void printDetails(){
    System.out.println("Game Code: " + lvlCode);
    System.out.println("Game Level: " + level);
    System.out.println("Total Assets: " + assets);
  }
}
