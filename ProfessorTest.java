import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import java.util.ArrayList;

/**
 * 
 * @author samanthachang
 */
public class ProfessorTest {
    private Professor prof;
    String user = "mock";
    String pass = "test";
    ArrayList<String> classes;
    ArrayList<String> stuList;
    ArrayList<String> profList;
    String cCode = "1A2B3C";

    @Before
    public void setUp(){
        prof = new Professor(user, pass);
        classes = prof.getClassList(user);
        stuList = prof.getStudentList(cCode);
        profList = prof.getClasswCode(cCode);
    }

    @Test
    public void testGetUserName(){
        System.out.println("getUserName()");
        assertEquals(user, prof.getUserName());
    }

    @Test
    public void testGetPassword(){
        System.out.println("getPassword()");
        assertEquals(pass, prof.getPassword());
    }

    @Test
    public void testGetClassList(){
        System.out.println("getClassList()");
        assertEquals(classes, prof.getClassList(user));
    }

    @Test
    public void testGetClasswCode(){
        System.out.println("getClassWithCode()");
        assertEquals(profList, prof.getClasswCode(cCode));
    }

    @Test
    public void testGetStudentList(){
        System.out.println("getStudentList()");
        assertEquals(stuList, prof.getStudentList(cCode));    
    }

    @Test
    public void testAddClass(){
        System.out.println("addClass()");
        prof.addClass(cCode);
        assertTrue(prof.getClassList(user).contains(cCode));
    }    
}
        
