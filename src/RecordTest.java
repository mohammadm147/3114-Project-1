import student.TestCase;

/**
 * Tests the record class
 * 
 * @author mohammadm21
 * @author jaetrim
 * 
 * @version 1.0 2023-09-05
 */
public class RecordTest extends TestCase {

    private Record record;

    /**
     * Sets up the test variables
     */
    public void setUp() {
        record = new Record();
    }


    /**
     * Tests the key setter and getter
     */
    public void testKey() {
        record.setKey(10);
        assertEquals(record.getKey(), 10);
    }


    /**
     * Tests the id setter and getter
     */
    public void testId() {
        record.setId(10);
        assertEquals(record.getId(), 10);
    }
}
