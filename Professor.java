import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class to initialize, store and manipulate professor components
 * 
 * @author Allison So, 
 */
public class Professor extends Student{
	/**
	 * String object to store professor user name login
	 */
	private String userName;
	/**
	 * String object to store professor password login
	 */
	private String password;
	/**
	 * ArrayList of String objects, each String being a unique class code
	 */
	private ArrayList<String> classes;

	/**
	 * Constructor creates new professor object, using the username to pull an existing classlist
	 * @param user represents the username to login
	 * @param pass represents the password to login
	 */
	public Professor(String user, String pass) {
		super(user, pass);
		this.userName = user;
		this.password = pass;
		this.classes = getClassList(userName);

	}

	/**
	 * Constructor creates new professor object
	 * @param user represents the username to login
	 * @param pass represents the password to login
	 * @param classList represents the list of classes this professor has
	 */
	public Professor(String user, String pass, ArrayList<String> classList) {
		super(user, pass);
		this.userName = user;
		this.password = pass;
		this.classes = classList;
	}
	/**
	 * Gets username
	 * @return the username
	 */
	public String getUserName() {
		return this.userName;
	}
	/**
	 * Gets password 
	 * @return returns password 
	 */
	public String getPassword() {
		return this.password;
	}
	/**
	 * Gets the class list
	 * @return the class list
	 */
	public ArrayList<String> getClassList() {
		return this.classes;
	}

	/**
	 * 
	 * @param userName
	 * @return list of class codes (representing classes) started by this professor
	 */
	public ArrayList<String> getClassList(String userName){
		String line;
		ArrayList<String> newList = new ArrayList<String>();	  
		try {
			// Reading file
			FileReader fr = new FileReader("classCodes.csv");
			BufferedReader br = new BufferedReader(fr);
			
			// Reading each line in file to see if the username and game name is in file
			while ((line=br.readLine()) != null){
				String[] parts = line.split(" - ");
				if (parts[0].equals(userName)) {
					newList.add(parts[1]);
				}
			}
			fr.close();
			br.close();
			return newList;
		} catch(Exception e){}
		return newList;
	}
	/**
	 * Gets the student's name
	 * @param userName the username of student
	 * @return an array list of string of student 
	 */
	public ArrayList<String> getStudentwName(String userName){
		String line;
		ArrayList<String> stuList = new ArrayList<String>();	  
		try {
			// Reading file
			FileReader fr = new FileReader("classCodes.csv");
			BufferedReader br = new BufferedReader(fr);
			
			// Reading each line in file to see if the username and game name is in file
			while ((line=br.readLine()) != null){
				String[] parts = line.split(" - ");
			  	if (parts[0].equals(userName)) {
					stuList.add(parts[2]);
				}
			}
			fr.close();
			br.close();
			return stuList;
		} catch(Exception e){}
		return stuList;
	}
	/**
	 * Gets the class code
	 * @param courseCode the course code of class
	 * @return an array list of strings with added class code 
	 */
	public ArrayList<String> getClasswCode(String courseCode){
		String line;
		ArrayList<String> newList = new ArrayList<String>();	  
		try {
			// Reading file
			FileReader fr = new FileReader("classCodes.csv");
			BufferedReader br = new BufferedReader(fr);
			
			// Reading each line in file to see if the username and game name is in file
			while ((line=br.readLine()) != null){
				String[] parts = line.split(" - ");
				if (parts[0]==userName) {
					newList.add(parts[1]);
				}
			}
			fr.close();
			br.close();
			return newList;
		} catch(Exception e){}
		return newList;
	}
	/**
	 * Gets the student list
	 * @param cCode the class code 
	 * @return an array list of string of students in their class
	 */
	public ArrayList<String> getStudentList(String cCode){
		String line;
		ArrayList<String> stuList = new ArrayList<String>();	  
		try {
			// Reading file
			FileReader fr = new FileReader("classCodes.csv");
			BufferedReader br = new BufferedReader(fr);
			
			// Reading each line in file to see if the username and game name is in file
			while ((line=br.readLine()) != null){
				String[] parts = line.split(" - ");
			  	if (parts[1]==cCode) {
					stuList.add(parts[2]);
				}
			}
			fr.close();
			br.close();
			return stuList;
		} catch(Exception e){}
		return stuList;
	}
	/**
	 * This overrides adding the given class to file
	 * @param courseCode the code of class
	 */
	@Override
	public void addClass(String courseCode) {
		String profName = userName;
		ArrayList<String> classList = getClassList(profName);
		ArrayList<String> temp = classList;
		classList.add(courseCode);

		try{
			FileWriter fw = new FileWriter("classCodes.csv", true);
			fw.write("\n"+profName+" - "+courseCode+" - "+"");
			fw.close();
		}
		catch (IOException e){
			System.out.println(e.toString());
		}
		
	}

	public String getProf(String courseCode) {
		String line;
		String prof = "";	  
		try {
			// Reading file
			FileReader fr = new FileReader("classCodes.csv");
			BufferedReader br = new BufferedReader(fr);
			
			// Reading each line in file to see if the username and game name is in file
			while ((line=br.readLine()) != null){
				String[] parts = line.split(" - ");
			  	if (parts[1]==courseCode) {
					prof = parts[0];
				}
			}
			fr.close();
			br.close();
			return prof;
		} catch(Exception e){}
		return prof;
	}
}
