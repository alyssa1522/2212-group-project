import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import java.util.ArrayList;

/**
 *
 * @author allisonso, cpaventi, alyssaspasic, samanthachang
 */
public class StudentTest {

    public Student student;
    String username = "meowy";
    String password = "meow123";
    String user2 = "jellodoe4";
    manageSavedGames savedGames;
    
    @Before
    public void setUpClass() {
        student = new Student(username,password);
        savedGames = new manageSavedGames(user2);
    }

    @Test
    public void testGetClasseswUser(){
        System.out.println("getClasses()");
        String expResult = "[]";
        String result = student.getClasses(username).toString();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetGameName1(){
        System.out.println("getGetName1()");
        String expResult = "hehe";
        String result = savedGames.getGameName(user2, 1);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetGameName2(){
        System.out.println("getGetName2()");
        String expResult = "hihi";
        String result = savedGames.getGameName(user2, 2);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetGameName3(){
        System.out.println("getGetName3()");
        String expResult = "haha";
        String result = savedGames.getGameName(user2, 3);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetScore1(){
        System.out.println("getScore1()");
        String expResult = "40";
        String result = savedGames.getScore(user2, 1);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetScore2(){
        System.out.println("getScore2()");
        String expResult = "50";
        String result = savedGames.getScore(user2, 2);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetScore3(){
        System.out.println("getScore3()");
        String expResult = "60";
        String result = savedGames.getScore(user2, 3);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetPassword(){
        System.out.println("getPassword()");
        String expResult = "meow123";
        String result = student.getPassword();
        assertEquals(expResult, result);
    }

    @Test
    public void testAddClass(){
        System.out.println("addClass()");
        ArrayList<String> newClass = student.getClasses(username);
        newClass.add("1A2B3C");
        assertTrue(newClass.contains("1A2B3C"));
    }

    @Test
    public void testGetClasses(){
        System.out.println("getClasses()");
        String expResult = "[]";
        String result = student.getClasses().toString();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getusername method, of class Student.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser()");
        String expResult = "meowy";
        String result = student.getName();
        assertEquals(expResult, result);
    }
}

    