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

}
