import static org.junit.Assert.*;
import org.junit.*;

/**
 * Junit testing of the gamescreen class
 * @author Samantha Chang, Alyssa Spasic
 */
public class GameScreenTest {
    private GameScreen screen;

    @Before
    public void setUp(){
        screen = new GameScreen();
    }
    
    @Test
    public void testConstructor(){
        System.out.println("GameScreen()");
        assertNotNull(screen);
    }

    @Test
    public void testGenerateQuestion(){
        System.out.println("generateQuestion()");
        String question = screen.generateQuestion(1, " + ");
        assertNotNull(question);
    }

    @Test
     public void testViewGameScreen(){
         System.out.println("viewGameScreen");
         
        
     }

     @Test
     public void testViewLevelScreen(){
         System.out.println("viewLevelScreen");
        
     }

    @Test
    public void testGenerateRandomCode(){
        System.out.println("generateRandomCode");
        String code = screen.generateRandomCode();
        assertNotNull(code);
    }
}
