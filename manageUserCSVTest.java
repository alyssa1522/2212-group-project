import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

/**
 * Junit testing for manageUserCSV class
 * 
 * @author Julie Vo, Alyssa Spasic
 */
public class manageUserCSVTest {

  private static final String TEST_FILE_NAME = "test.csv";
  private manageUserCSV userCSV;

  @Before
    public void setUp() throws IOException {
        // Prepare a test file
        FileWriter writer = new FileWriter(TEST_FILE_NAME);
        writer.write("user1,password1,0,100\n");
        writer.write("user2,password2,1,200\n");
        writer.write("user3,password3,0,300\n");
        writer.close();

        // Initialize the class with the test file
        userCSV = new manageUserCSV(TEST_FILE_NAME);
    }

    @Test
    public void testFindUserInfo() {
        // Test finding user info
        String[] userInfo1 = userCSV.findUserInfo("user1");
        assertArrayEquals(new String[]{"user1", "password1", "0", "100"}, userInfo1);
    }

    @Test
    public void testWriteUserInfo() {
        // Test writing user info
        userCSV.writeUserInfo("user4", "password4", 1, 400);

        // Check if the newly written info is retrievable
        String[] userInfo = userCSV.findUserInfo("user4");
        assertArrayEquals(new String[]{"user4", "password4", "1", "400"}, userInfo);
    }

  
}