import java.io.FileNotFoundException;
import student.TestCase;

/**
 * 
 * Creates SemManagerTest to test the Sem Manager
 * 
 * @author Jae Trimboli (jaetrim)
 * @author Mohammad Mian (mohammadm21)
 * @version 2023-09-06
 * 
 */
public class SemManagerTest extends TestCase {

    private SemManager sem;

    /**
     * Sets up the tests that follow. In general, used for initialization
     */
    public void setUp() {
        // Nothing here
    }


    /**
     * Get code coverage of the class declaration.
     * 
     * @throws Exception
     */
    public void testMInitx() throws Exception {
        sem = new SemManager();
        assertNotNull(sem);
        boolean thrown = false;
        try {
            SemManager.main(null);
        }
        catch (Exception e) {
            Exception nullExc = new Exception("Arguments are null.");
            assertEquals(e.toString(), nullExc.toString());
            thrown = true;
        }
        assertTrue(thrown);
        
        
    }


    /**
     * 
     * Creates test method to test if memory and has are powers of two
     * 
     * @throws Exception
     */
    public void testPowerOfTwo() throws Exception {
        assertEquals(SemManager.powerOfTwo(2), true);
        assertEquals(SemManager.powerOfTwo(3), false);

    }


    /**
     * Test no exception
     * 
     * @throws Exception
     */
    public void testFileNotFound() throws Exception {
        String[] args = new String[] { "2", "2", "testname" };
        boolean thrown = false;
        try {
            SemManager.main(args);
        }
        catch (FileNotFoundException e) {
            thrown = true;
        }
        assertTrue(thrown);

    }

    /**
     * Test Power of Two Exception
     * @throws Exception
     */
    public void testPowerOfTwoException() throws Exception {
        String[] args = new String[] {"3", "2", "testname"};
        boolean thrown = false;
        try {
            SemManager.main(args);
        }
        catch (Exception e) {
            Exception temp = new Exception("Memory Size Not A Power of 2");
            thrown = true;      
            assertEquals(e.toString(), temp.toString());
        }
        assertTrue(thrown);
        
        String[] args2 = new String[] {"2", "3", "testname"};
        thrown = false;
        try {
            SemManager.main(args2);
        }
        catch (Exception e) {
            Exception temp = new Exception("Hash Size Not A Power of 2");
            thrown = true;      
            assertEquals(e.toString(), temp.toString());
        }
        assertTrue(thrown);
        
    }

}
