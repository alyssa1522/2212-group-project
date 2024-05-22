import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
/** 
 * This class represents a student. Defines student information and commands they can do
 * @author allison so
 */


public class Student{
  /**
   * String object to store student user name login 
   */
  private String username;
  /**
   * String object to store student user name password 
   */
  private String password;
  /**
   * manageSavedGames object to store games list
   */
  manageSavedGames gamesList;
  /**
   * String object to store first game name
   */
  private String gameName1;
  /**
   * String object to store second game name
   */
  private String gameName2;
  /**
   * String object to store third game name
   */
  private String gameName3;
  /**
   * String object to store score to first game
   */
  private String Score1;
  /**
   * String object to store score to second game
   */
  private String Score2;
  /**
   * String object to store score to third game
   */
  private String Score3;
  /**
   * Array list of strings to store classes the student is in 
   */
  private ArrayList<String> classes = new ArrayList<String>();
  manageUserCSV userList;

  /**
   * Constructor creates a Student with the given username, password, and classes
   * @param user username of student
   * @param pw password of student's account
   * @param id id of student
   * @param classes list of classes that student has
   */
   public Student(String user, String pw){
    this.username = user;
    this.password = pw;
    this.gamesList = new manageSavedGames(user);
    this.classes = getClasses(user);
    //this.prof = new Professor("prof", "test");
    this.gameName1 = gamesList.getGameName(user, 1);
    this.gameName2 = gamesList.getGameName(user, 2);
    this.gameName3 = gamesList.getGameName(user, 3);
    this.Score1 = gamesList.getScore(user, 1);
    this.Score2 = gamesList.getScore(user, 2);
    this.Score3 = gamesList.getScore(user, 3);
   }
   /**
    * Gets the classes of student
    * @param user the username 
    * @return an array list of strings that stores the classes that the student is in 
    */
   public ArrayList<String> getClasses(String user){
    FileReader fr;
    String line;

    try {
      fr = new FileReader("classCodes.csv");
      BufferedReader br = new BufferedReader(fr);
      try {
        while ((line =br.readLine()) != null){
          String[] parts = line.split(" - ");
          for (String name : parts[2].split(",")){
            if (name.equals(user)){
                classes.add(parts[2]);
            }
          }
        }
        fr.close(); // Close the FileWriter when done
        br.close();
        return classes;
    } catch (Exception e) {
        e.printStackTrace(); // Print any exceptions that occur during file writing
    }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    return classes;
   }
   /**
    * Gets game name 1
    * @return gameName1
    */
   public String getGameName1(){
    return this.gameName1;
   }
   /**
    * Gets game name 2
    * @return gameName2
    */
   public String getGameName2(){
    return this.gameName2;
   }
   /**
    * Gets game name 3
    * @return gameName3
    */
   public String getGameName3(){
    return this.gameName3;
   }
   /**
    * Gets score 1
    * @return Score1
    */
   public String getScore1(){
    return this.Score1;
   }
   /**
    * Gets score 2
    * @return Score2
    */
   public String getScore2(){
    return this.Score2;
   }
   /**
    * Gets score 3
    * @return Score3
    */
   public String getScore3(){
    return this.Score3;
   }
   /**
    * Gets the password of user
    * @return the password of user
    */
   protected String getPassword(){
    return this.password;
   }

   /**
    * Adds a class to array list of student's classes 
    * @param code The class code student that represents the classes the student is in
    */
   public void addClass(String code){
    classes.add(code);
   }

   /**
    * Gets list of class student is in 
    * @return the array list of classes
    */
   public ArrayList<String> getClasses(){
    return classes;
   }

   /**
    * Gets name of student
    * @return the username of the student
    */
   public String getName(){
    return username;
   }

 }