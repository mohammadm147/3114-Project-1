import java.nio.ByteBuffer;

/**
 * MemManager class
 * 
 * @author Jae Trimboli (jaetrim)
 * @author Mohammad Mian (mohammadm21)
 * @version 2023-09-06
 */
public class MemManager {

    private int memPoolSize;
    private byte[] memArray;
    private DLList<Block> freeBlocks;
    private int byteSize = 2;

    /*
     * MemManager contains Seminars that are serialized
     * MemManager is a byte array containing serialized seminars and freeblocks
     * Handle connects MemManager and HashTable
     * HashTable has records which have id key and Handle
     * DB is gonna
     */

    /**
     * MemManager constructor
     * 
     * @param poolsize
     *            defines the size of the memory pool in bytes
     */
    public MemManager(int poolsize) {
        memPoolSize = poolsize;
        memArray = new byte[memPoolSize];
        freeBlocks = new DLList<Block>();
        freeBlocks.add(new Block(0, memPoolSize));
    }


    /**
     * Returns freeBlocks
     * 
     * @return freeBlocks
     */
    public DLList<Block> getFreeList() {
        return freeBlocks;
    }


    /**
     * Finds the index to insert
     * 
     * @param block
     * @return
     */
    public int findIndex(Block block) {
        int temp = 0;
        for (int i = 0; i < freeBlocks.size(); i++) {
            if ((freeBlocks.get(i).getLength() <= block.getLength())
                && (freeBlocks.get(i).getEnd() < block.getStart())) {
                temp = i + 1;
            }
        }
        return temp;
    }


    /**
     * Insert a record and return its position handle.
     * 
     * @param space
     *            contains the record to be inserted,
     * @param size
     *            is length of record
     * @return handle output
     */
    public Handle insert(byte[] space, int size) {

        // looks for best fitting free block
        int bestFit = findFit(size);

        // temp array for copying past bytes that is same size of pool
        byte[] tempArray = new byte[memArray.length];
        // system copy to temp array
        System.arraycopy(memArray, 0, tempArray, 0, memArray.length);
        // copies space to temp array at correct spot
        System.arraycopy(space, 0, tempArray, freeBlocks.get(bestFit)
            .getStart(), size);

        int temp = 2;
        int seminarStart = 0;
        while (temp <= size) {
            temp = temp * 2;
        }

        // for (int j = 0; j < freeBlocks.size(); j++) {

        int count = findFit(temp);
        while ((freeBlocks.get(count).getLength() / 2) >= temp) {
            Block b1 = new Block(freeBlocks.get(count).getStart(), freeBlocks
                .get(count).getEnd() - temp);
            Block b2 = new Block(freeBlocks.get(count).getEnd() - temp,
                freeBlocks.get(count).getEnd());
            freeBlocks.remove(freeBlocks.get(count));
            freeBlocks.add(count, b1);
            freeBlocks.add(count + 1, b2);
        }
        // }

        int j = findFit(size);
        if (freeBlocks.get(j).getLength() >= size) {
            seminarStart = freeBlocks.get(j).getStart();
            freeBlocks.remove(freeBlocks.get(j));

        }
        // copies back to orignial mem array
        System.arraycopy(tempArray, 0, memArray, 0, tempArray.length);

        Handle handle = new Handle();
        handle.setStart(seminarStart);
        handle.setEnd(seminarStart + size);
        return handle;
    }


    /**
     * Helper method for insert that loops through free block lost
     * and looks for block that best fits the inputted block
     * 
     * @param size
     *            representing the size of the record
     */
    private int findFit(int size) {

        // Current minimum
        int tempMin = Integer.MAX_VALUE;

        // check if there is no freeblock of requested size
        int startIndex = -1;
        int index = 0;
        for (int i = 0; i < freeBlocks.size(); i++) {
            Block block = freeBlocks.get(i);
            // update the min to be the smallest fitable freeblock
            if (block.getLength() >= size && block.getEnd() < tempMin) {
                startIndex = block.getStart();
                tempMin = block.getEnd();
                index = i;
            }
        }
        if (startIndex == -1) {
            resize();
            return findFit(size);
        }
        return index;
    }


    /**
     * If there is no freeblock of requested size then resize array
     */
    private void resize() {
        int newSize = memArray.length + memPoolSize;
        // makes updated array of proper size
        byte[] updatedArray = new byte[newSize];
        System.arraycopy(memArray, 0, updatedArray, 0, memArray.length);
        // prints to console

        Block block = new Block(memArray.length, newSize);
        // new block represnting increase in size
        freeBlocks.add(findIndex(block), block);

        merge(freeBlocks);

        memArray = updatedArray;
        memPoolSize = newSize;

        System.out.println("Memory pool expanded to " + memArray.length
            + " bytes");

    }


    /**
     * Merge two freeblocks
     * 
     * @param blocks
     *            being free block list
     */
    public void merge(DLList<Block> freeBlockList) {
        if (freeBlockList.size() > 0) {
            for (int i = 0; i < freeBlockList.size() - 1; i++) {
                int length = freeBlockList.get(i).getLength();
                int length2 = freeBlockList.get(i + 1).getLength();
                if ((freeBlockList.get(i).getStart() | length) == (freeBlockList
                    .get(i + 1).getStart() | length2)) {
                    int secondBlockEnd = freeBlockList.get(i + 1).getEnd();
                    Block newBlock = new Block(freeBlockList.get(i).getStart(),
                        secondBlockEnd);
                    freeBlockList.remove(i + 1);
                    freeBlockList.remove(i);
                    freeBlockList.add(findIndex(newBlock), newBlock);
                    merge(freeBlockList);

                }
            }
        }
    }


    /**
     * Free a block at the position specified by theHandle.
     * Merge adjacent free blocks.
     * 
     * @param theHandle
     *            representing handle
     */
    public void remove(Handle handle) {

        for (int i = handle.getStart(); i < handle.getEnd() + 1; i++) {
            memArray[i] = 0;
        }
        int temp = 2;
        while (temp < (handle.getEnd() - handle.getStart())) {
            temp = temp * 2;
        }
        Block removedBlock = new Block(handle.getStart(), handle.getStart()
            + temp);
        freeBlocks.add(findIndex(removedBlock), removedBlock);
        merge(freeBlocks);

    }


    public byte[] getArr() {
        return memArray;
    }


    /**
     * Dump a printout of the freeblock list
     */
    public String dump() {
        System.out.println("Freeblock List:");
        StringBuilder res = new StringBuilder();
        if (freeBlocks.size() == 0) {
            res.append("There are no freeblocks in the memory pool");
        }
        else {
            int length = 0;
            int count = 1;
            for (int i = 0; i < freeBlocks.size(); i++) {
                if (freeBlocks.get(i).getLength() == length) {
                    res.append(" " + freeBlocks.get(i).getStart());
                }
                else {
                    length = freeBlocks.get(i).getLength();
                    if (count == 1) {
                        res.append(length + ": " + freeBlocks.get(i)
                            .getStart());
                        count++;
                    }
                    else {
                        res.append("\n" + length + ": " + freeBlocks.get(i)
                            .getStart());
                        count++;
                    }

                }

            }

        }
        return res.toString();
    }
}
