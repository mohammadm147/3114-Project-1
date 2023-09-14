
/**
 * 
 */

import student.TestCase;

/**
 * Test class for Block
 * 
 * @author Jae Trimboli (jaetrim)
 * @author Mohammad Mian (mohammadm21)
 * @version 2023-09-13
 */
public class BlockTest extends TestCase {

    private Block block;

    /**
     * SetUp Constructor
     */
    public void setUp() {
        block = new Block(10, 20);
    }


    /**
     * Test start
     */
    public void testStart() {
        assertEquals(block.getStart(), 10);
        block.setStart(11);
        assertEquals(block.getStart(), 11);
    }


    /**
     * Test end
     */
    public void testEnd() {
        assertEquals(block.getEnd(), 20);
        block.setEnd(30);
        assertEquals(block.getEnd(), 30);
    }


    /**
     * Test length
     */
    public void testLength() {
        block.setEnd(10);
        block.setStart(5);
        assertEquals(block.getLength(), 5);
    }
}
