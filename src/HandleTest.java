
import student.TestCase;

/**
 * Handle test
 * 
 * @author Jae Trimboli (jaetrim)
 * @author Mohammad Mian (mohammadm21)
 * @version 2023-09-10
 */
public class HandleTest extends TestCase {

    private Handle handle;

    /**
     * Constructor
     */
    public void setUp() {
        handle = new Handle();
    }

    /**
     * test start
     */
    public void testStart() {
        handle.setStart(1);
        assertEquals(handle.getStart(), 1);
    }

    /**
     * test end
     */
    public void testEnd() {
        handle.setEnd(1);
        assertEquals(handle.getEnd(), 1);
    }

}
