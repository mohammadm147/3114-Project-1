

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

    /*
     * MemManager contains Seminars that are serialized
     * MemManager is a byte array containing serialized seminars and freeblocks
     * Handle connects MemManager and HashTable
     * HashTable has records which have id key and Handle
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
     *            representing free block
     * @return the index
     */
    public int findIndex(Block block) {
        int temp = 0;
        for (int i = 0; i < freeBlocks.size(); i++) {
            if (freeBlocks.get(i).getEnd() <= block.getStart()) {
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

        // gets smallest fitting freeblock based on requested size
        int temp = 2;
        int seminarStart = 0;
        while (temp <= size) {
            temp = temp * 2;
        }

        // splits free blocks
        int count = findFit(temp);
        while ((freeBlocks.get(count).getLength() / 2) >= temp) {
            int half = freeBlocks.get(count).getLength() / 2;
            Block b1 = new Block(freeBlocks.get(count).getStart(), freeBlocks
                .get(count).getEnd() - half);
            Block b2 = new Block(freeBlocks.get(count).getEnd() - half,
                freeBlocks.get(count).getEnd());
            freeBlocks.remove(freeBlocks.get(count));
            freeBlocks.add(count, b1);
            freeBlocks.add(count + 1, b2);
        }

        // deleting freeblock that will be filled
        int j = findFit(size);
        seminarStart = freeBlocks.get(j).getStart();
        freeBlocks.remove(freeBlocks.get(j));

        // copies back to orignial mem array
        System.arraycopy(tempArray, 0, memArray, 0, tempArray.length);

        // creates handle, merges free blocks, and returns handle
        Handle handle = new Handle();
        handle.setStart(seminarStart);
        handle.setEnd(seminarStart + size);
        merge(freeBlocks);
        return handle;
    }


    /**
     * Helper method for insert that loops through free block lost
     * and looks for block that best fits the inputted block
     * 
     * @param size
     *            representing the size of the record
     * @return the index of freeblock that fits best
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
        // if there is no free block found, then resize
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

        Block block = new Block(memArray.length, newSize);
        // new block represnting increase in size
        freeBlocks.add(findIndex(block), block);

        // updated memory array
        memArray = updatedArray;
        memPoolSize = newSize;
        // merge free blocks
        merge(freeBlocks);

        System.out.println("Memory pool expanded to " + memArray.length
            + " bytes");

    }


    /**
     * Merge two freeblocks
     * 
     * @param freeBlockList
     *            for freeBlocks
     */
    public void merge(DLList<Block> freeBlockList) {
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


    /**
     * Free a block at the position specified by theHandle.
     * Merge adjacent free blocks.
     * 
     * @param handle
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


    /**
     * Get memory array
     * 
     * @return the memory array
     */
    public byte[] getArr() {
        return memArray;
    }


    /**
     * Dump a printout of the freeblock list
     * 
     * @return the dumped out freeblock list
     */
    public String dump() {
        System.out.print("Freeblock List:");
        StringBuilder res = new StringBuilder();
        if (freeBlocks.size() == 0) {
            res.append("\nThere are no freeblocks in the memory pool");
        }
        else {
            int smallestBlockLength = Integer.MAX_VALUE;
            int biggestBlockLength = Integer.MIN_VALUE;
            for (int j = 0; j < freeBlocks.size(); j++) {
                if (freeBlocks.get(j).getLength() < smallestBlockLength) {
                    smallestBlockLength = freeBlocks.get(j).getLength();
                }
                if (freeBlocks.get(j).getLength() > biggestBlockLength) {
                    biggestBlockLength = freeBlocks.get(j).getLength();
                }
            }
            while (smallestBlockLength <= biggestBlockLength) {
                int count = 1;
                for (int i = 0; i < freeBlocks.size(); i++) {
                    int length = freeBlocks.get(i).getLength();
                    if ((count == 1) && (length == smallestBlockLength)) {
                        res.append("\n" + smallestBlockLength + ":");
                        count++;
                    }
                    if (length == smallestBlockLength) {
                        res.append(" " + freeBlocks.get(i).getStart());
                    }
                }
                smallestBlockLength = smallestBlockLength * 2;
            }
        }
        return res.toString();
    }
}
