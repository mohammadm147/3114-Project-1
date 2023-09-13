/**
 * 
 */

/**
 * Handle class that creates Handle
 * 
 * @author Jae Trimboli (jaetrim)
 * @author Mohammad Mian (mohammadm21)
 * @version 2023-09-07
 */
public class Handle {

    private int start;
    private int end;

    /**
     * Handle Constructor
     * 
     * @param start
     *            is start of record
     * @param end
     *            is end of record
     */
    public Handle() {
    }


    /**
     * Getter for start
     * 
     * @return start position
     */
    public int getStart() {
        return start;
    }


    /**
     * Sets start of record
     * 
     * @param start
     *            of record
     */
    public void setStart(int start) {
        this.start = start;
    }


    /**
     * Getter for end
     * 
     * @return end position
     */
    public int getEnd() {
        return end;
    }


    /**
     * Sets end of record
     * 
     * @param end
     *            of record
     */
    public void setEnd(int end) {
        this.end = end;
    }

}
