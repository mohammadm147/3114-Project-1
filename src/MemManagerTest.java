import student.TestCase;

/**
 * MemManager test class
 * 
 * @author Jae Trimboli (jaetrim)
 * @author Mohammad Mian (mohammadm21)
 * @version 2023-09-09
 */
public class MemManagerTest extends TestCase {

    private MemManager mem;
    private byte[] memArray;
    private DLList<Block> freeBlocks;
    private int memorySize;

    /**
     * setUp constructor
     */
    public void setUp() {
        memorySize = 512;
        mem = new MemManager(memorySize);
        memArray = new byte[memorySize];
        freeBlocks = new DLList<Block>();

    }


    /**
     * Test for merge
     */
    public void testMerge() {
        freeBlocks.add(new Block(0, 1));
        freeBlocks.add(new Block(1, 2));
        freeBlocks.add(new Block(2, 3));
        freeBlocks.add(new Block(3, 4));
        mem.merge(freeBlocks);
        assertEquals(freeBlocks.size(), 1);

        freeBlocks.clear();

        Block lessThanZero = new Block(23, 40);
        Block lessThanZero2 = new Block(0, 20);
        freeBlocks.add(lessThanZero);
        freeBlocks.add(lessThanZero2);
        mem.merge(freeBlocks);
        assertEquals(freeBlocks.size(), 2);

        assertEquals(freeBlocks.get(0).getLength(), 17);
        assertEquals(freeBlocks.get(1).getLength(), 20);

        freeBlocks.clear();

        Block first = new Block(0, 10);
        Block second = new Block(10, 20);
        freeBlocks.add(first);
        freeBlocks.add(second);

        assertEquals(freeBlocks.get(0), first);
        assertEquals(freeBlocks.get(1), second);
        assertEquals(freeBlocks.size(), 2);
        assertEquals(freeBlocks.get(0).getEnd(), 10);
        assertEquals(freeBlocks.get(1).getEnd(), 20);

        mem.merge(freeBlocks);

        assertEquals(freeBlocks.size(), 1);

        assertEquals(freeBlocks.get(0).getEnd(), 20);
        assertEquals(freeBlocks.get(0).getStart(), 0);

        Block newBlock = new Block(20, 40);
        freeBlocks.add(newBlock);
        assertEquals(freeBlocks.size(), 2);
        mem.merge(freeBlocks);
        assertEquals(freeBlocks.size(), 1);
        assertEquals(freeBlocks.get(0).getEnd(), 40);
        assertEquals(freeBlocks.get(0).getStart(), 0);

        freeBlocks.clear();

        first = new Block(0, 256);
        second = new Block(256, 512);
        newBlock = new Block(512, 1024);

        freeBlocks.add(first);
        freeBlocks.add(second);
        freeBlocks.add(newBlock);

        mem.merge(freeBlocks);

        assertEquals(freeBlocks.size(), 1);

    }

    /**
     * test Dump
     */
    public void testDump() {
        systemOut().clearHistory();
        mem = new MemManager(256);
        systemOut().print(mem.dump());
        String output = "Freeblock List:\r\n" + "256: 0";
        assertFuzzyEquals(systemOut().getHistory(), output);
    }

    /**
     * Test Remove
     * @throws Exception
     */
    public void testRemove() throws Exception {
        Handle handle = new Handle();
        handle.setStart(0);
        handle.setEnd(173);
        assertEquals(mem.getArr().length, 512);
        byte[] newSem = new byte[173];
        int count = 0;
        while (count < 173) {
            newSem[count] = 99;
            count++;
        }
        mem.insert(newSem, 173);
        assertEquals(mem.getArr()[10], 99);
        mem.remove(handle);
        assertEquals(mem.getArr()[10], 0);
    }
}
