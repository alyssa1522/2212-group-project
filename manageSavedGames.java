import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;


/**
 * This class contains functions that reads and writes to user csv file.
 * 
 * @version %I%,%G%
 * @author Julie Vo, Alyssa Spasic, Allison So
 */

 public class manageSavedGames {
  public String filePath;

  public manageSavedGames(String username){
    // Create a file with user's name 
    filePath = "UserSavedStates/" + username + ".txt";
  }

  /**
   * This writes the game info to the file dedicated to user
   * @param username The name of the user
   * @param gameName The name of the game
   * @param score The score
   * @throws FileNotFoundException
   */
  public void writeGameInfo(String username, String gameName, int score) throws FileNotFoundException {

    try {
        FileWriter fw = new FileWriter("UserSavedStates/" + username + ".txt", true); // Append mode (true) to add to existing file

        fw.write("\n"+gameName + "," + score);

        fw.close(); // Close the FileWriter when done
    } catch (Exception e) {
        e.printStackTrace(); // Print any exceptions that occur during file writing
    }
  }
    /**
     * This returns a boolean if the game name is in the file or not
     * @param username The name of the user
     * @param gameName The name of the game
     * @return a boolean, true if the game name is in file, false otherwise
     * @throws FileNotFoundException
     */
    public boolean gameNameFound(String username, String gameName) throws FileNotFoundException{
    // Reading file
    FileReader fr = new FileReader("UserSavedStates/" + username + ".txt");
    BufferedReader br = new BufferedReader(fr);
    String[] parts = new String[2];
    try {
        FileWriter fw = new FileWriter(filePath, true); // Append mode (true) to add to existing file
        String line;

        while ((line=br.readLine()) != null){
          parts = line.split(","); 
          if (parts[0].equals(gameName)){
            fw.close();
            br.close();
            return true;
          }
        }
        fw.close(); // Close the FileWriter when done
    } catch (Exception e) {
        e.printStackTrace(); // Print any exceptions that occur during file writing
    }
    return false;
    }
  

  public String getGameName(String username, int gameNum){
    String[] parts = new String[7];
    try {
      // Reading file
      FileReader fr = new FileReader("UserSavedStates/" + username + ".txt");
      BufferedReader br = new BufferedReader(fr);
      String line;
      String fResult = "N/A";

      // Reading each line in file to see if the username and game name is in file
      while ((line=br.readLine()) != null){
          // Separating username part
          parts = line.split(","); 
          // If game name is found in file, then break out of loop
              if (gameNum==1){
                fResult = parts[0];
                return fResult;
              }
              else if (gameNum==2){
                line = br.readLine();
                parts = line.split(",");
                fResult = parts[0];
                return parts[0];
              }
              else {
                line = br.readLine();
                line = br.readLine();
                parts = line.split(",");
                fResult = parts[0];
                return parts[0];
              }
          }
      fr.close();
      br.close();
      return fResult;
  } catch(Exception e){}
    return "N/A";
  }


  public String getScore(String username, int gameNum){
    String[] parts = new String[7];
    try {
      // Reading file
      FileReader fr = new FileReader("UserSavedStates/" + username + ".txt");
      BufferedReader br = new BufferedReader(fr);
      String line;
      String fResult = "N/A";

      // Reading each line in file to see if the username and game name is in file
      while ((line=br.readLine()) != null){
        // Separating username part
        parts = line.split(","); 
        // If game name is found in file, then break out of loop
            if (gameNum==1){
              fResult = parts[1];
              return fResult;
            }
            else if (gameNum==2){
              line = br.readLine();
              parts = line.split(",");
              fResult = parts[1];
              return fResult;
            }
            else {
              line = br.readLine();
              line = br.readLine();
              parts = line.split(",");
              fResult = parts[1];
              return fResult;
            }
        }
      fr.close();
      br.close();
      return fResult;
  } catch(Exception e){}
    return "N/A";
  }
}

  


