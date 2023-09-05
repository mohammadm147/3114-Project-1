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


    public void testNull() {
        String[] args = new String[3];
        boolean thrown = false;
        try {
            SemManager.main(args);
        }
        catch (Exception e) {
            thrown = true;
        }
        assertTrue(thrown);

    }

}
