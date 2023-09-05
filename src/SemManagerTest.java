import student.TestCase;

/**
 * @author {Your Name Here}
 * @version {Put Something Here}
 */
public class SemManagerTest extends TestCase {

    SemManager sem;

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
            thrown = true;
        }
        assertTrue(thrown);
    }


    public void testPowerOfTwo() throws Exception {
        String[] args = new String[3];
        boolean thrown = false;
        try {
            SemManager.main(args);
        }
        catch (Exception e) {
            thrown = true;
        }
        assertTrue(thrown);
        args[0] = "3";
        args[1] = "2";
        thrown = false;
        try {
            SemManager.main(args);
        }
        catch (Exception e) {
            thrown = true;
        }
        assertTrue(thrown);
        args[0] = "2";
        args[1] = "2";
        thrown = false;
        try {
            SemManager.main(args);
        }
        catch (Exception e) {
            thrown = true;
        }
        assertFalse(thrown);
        args[0] = "2";
        args[1] = "3";
        thrown = false;
        try {
            SemManager.main(args);
        }
        catch (Exception e) {
            thrown = true;
        }

    }

}
