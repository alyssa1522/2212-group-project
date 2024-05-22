import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * This class contains functions that reads and writes to user csv file.
 * 
 * @version %I%,%G%
 * @author Julie Vo
 */

 public class manageUserCSV{
  /** The file name the user wishes to write/read to. */
  public String file;

  /**
   * Constructs a FileHandler object with the specified file name
   * @param fileName The name of file to be handled
   */
   public manageUserCSV(String fileName){
      file = fileName;
   }

   /**
    * This function returns a list of the user's info and 
    * @param username
    * @return A list that includes username, password, userType, and score 
    */
   public String[] findUserInfo(String username){
       // Verifying login and seeing if username is in file
       String[] parts = new String[4];
       try {
           // Reading file
           FileReader fr = new FileReader(file);
           BufferedReader br = new BufferedReader(fr);
           String line;

           // Reading each line in file and seeing if the username is in file
           while ((line=br.readLine()) != null){
               // Separating username, password, userType, score
               parts = line.split(","); 
               // If the username is found in file, then break out of loop
               if (parts.length > 0 && parts[0].equals(username)){
                   break; 
               }                
           }
           fr.close();
       } catch(Exception e){}
       return parts;
   }


   /**
    * Writes the user info into file
    * @param fileName The name of file 
    * @param username String username of user
    * @param password String password of user
    * @param userType Int of userType (can be 0 or 1)  
    * @param score Int of score 
    */
    public void writeUserInfo(String username, String password, int userType, int score){
      // Opening csv file and writing to file
      try {
         FileWriter fw = new FileWriter(file,true);
         fw.write("\n"+username +  "," + password  + "," + userType +  ","+ score);
         fw.close();
      }
      catch (Exception e){}
 }
}
