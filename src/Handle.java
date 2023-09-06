
/**
 * Handle stores key and id for hash table
 * 
 * @author Jae Trimboli (jaetrim)
 * @author Mohammad Mian (mohammadm21)
 * 
 * @version 1.0 2023-09-05
 */
public class Handle {

    private int key;
    private int id;

    /**
     * Handle class.  Holds a key/value pair
     */
    public Handle() {
        key = 0;
        id = 0;
    }


    /**
     * Returns the handle's key
     * 
     * @return int
     *      Returns an int representing the key
     */
    public int getKey() {
        return key;
    }

    /**
     * Returns the handle's id
     * 
     * @return int
     *      Returns an int representing the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the handle's key
     * 
     * @param int
     *      inputed key
     */
    public void setKey(int key1) {
        key = key1;
    }

    /**
     * Sets the handle's id
     * 
     * @param int
     *      inputed id
     */

    public void setId(int id1) {
        id = id1;
    }
}