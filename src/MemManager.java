/**
 * MemManager class
 * 
 * @author Jae Trimboli (jaetrim)
 * @author Mohammad Mian (mohammadm21)
 * @version 2023-09-06
 */
public class MemManager {

    /**
     * MemManager constructor
     * 
     * @param poolsize
     *            defines the size of the memory pool in bytes
     */
    public MemManager(int poolsize) {

    }


    /**
     * Insert a record and return its position handle.
     * 
     * @param space
     *            contains the record to be inserted,
     * @param size
     *            is length of record
     * @return null temp
     */
    public Handle insert(byte[] space, int size) {
        return null;

    }


    /**
     * Return the length of the record associated with theHandle
     * 
     * @param theHandle
     *            representing Handle
     * @return 0 temp
     */
    public int length(Handle theHandle) {
        return 0;

    }


    /**
     * Free a block at the position specified by theHandle.
     * Merge adjacent free blocks.
     * 
     * @param theHandle
     *            representing handle
     */
    public void remove(Handle theHandle) {

    }


    /**
     * Return the record with handle posHandle, up to size bytes, by copying it
     * into space.
     * Return the number of bytes actually copied into space.
     * 
     * @param space
     *            representing space
     * @param theHandle
     *            representing handle
     * @param size
     *            representing byte size
     * @return the byte size
     */
    public int get(byte[] space, Handle theHandle, int size) {
        return size;

    }


    /**
     * Dump a printout of the freeblock list
     */
    public void dump() {

    }
}
