
/**
 * 
 */
import student.TestCase;

/**
 * 
 */
public class HandleTest extends TestCase {

    private Handle handle;

    public void setUp() {
        handle = new Handle();
    }


    public void testKey() {
        handle.setKey(10);
        assertEquals(handle.getKey(), 10);
    }


    public void testId() {
        handle.setId(10);
        assertEquals(handle.getId(), 10);
    }
}
