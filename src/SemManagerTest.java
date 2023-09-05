import student.TestCase;

/**
 * @author {Your Name Here}
 * @version {Put Something Here}
 */
public class SemManagerTest extends TestCase {
    /**
     * Sets up the tests that follow. In general, used for initialization
     */
    public void setUp() {
        // Nothing here
    }


    /**
     * Get code coverage of the class declaration.
     * @throws Exception 
     */
    public void testMInitx() throws Exception
    {
        SemManager sem = new SemManager();
        assertNotNull(sem);
        boolean thrown = false;
        try {
            SemManager.main(null);
        } catch (Exception e) {
            thrown = true;
        }
        assertTrue(thrown);
    }
}

