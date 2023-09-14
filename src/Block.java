/**
 * 
 */

/**
 * Class for a free Block
 * 
 * @author Jae Trimboli (jaetrim)
 * @author Mohammad Mian (mohammadm21)
 * @version 2023-09-08
 */
public class Block {

    private int start;
    private int end;

    /**
     * Block constructor
     * 
     * @param start
     *            position of the block
     * @param end
     *            of the block
     */
    public Block(int start, int end) {
        this.start = start;
        this.end = end;

    }


    /**
     * Gets the start of the block
     * 
     * @return the start pos
     */
    public int getStart() {
        return start;
    }


    /**
     * Sets the start to new start index
     * 
     * @param newStart
     *            index
     */
    public void setStart(int newStart) {
        this.start = newStart;
    }


    /**
     * Gets the end of the block
     * 
     * @return block end
     */
    public int getEnd() {
        return end;
    }


    /**
     * Gets the end index of the block
     * 
     * @param end
     *            index
     */
    public void setEnd(int end) {
        this.end = end;
    }


    /**
     * Gets Length of block
     * 
     * @return the end - start
     */
    public int getLength() {
        return Math.abs(end - start);
    }

}
