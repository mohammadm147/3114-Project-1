import student.TestCase;

/**
 * Tests the handle class
 * 
 * @author mohammadm21
 * @author jaetrim
 * 
 * @version 1.0 2023-09-05
 */
public class HandleTest extends TestCase {

    private Handle handle;

    /**
     * Sets up the test variables
     */
    public void setUp() {
        handle = new Handle();
    }


    /**
     * Tests the key setter and getter
     */
    public void testKey() {
        handle.setKey(10);
        assertEquals(handle.getKey(), 10);
    }


    /**
     * Tests the id setter and getter
     */
    public void testId() {
        handle.setId(10);
        assertEquals(handle.getId(), 10);
    }
}
