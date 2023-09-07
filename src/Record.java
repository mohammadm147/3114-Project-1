
/**
 * record stores key and id for hash table
 * 
 * @author Jae Trimboli (jaetrim)
 * @author Mohammad Mian (mohammadm21)
 * 
 * @version 1.0 2023-09-05
 */
public class Record {

    private int key;
    private int id;

    /**
     * record class. Holds a key/value pair
     */
    public Record() {
        key = 0;
        id = 0;
    }


    /**
     * Returns the record's key
     * 
     * @return key
     *         Returns an int representing the key
     */
    public int getKey() {
        return key;
    }


    /**
     * Returns the record's id
     * 
     * @return id
     *         Returns an int representing the id
     */
    public int getId() {
        return id;
    }


    /**
     * Sets the record's key
     * 
     * @param key1
     *            inputed key
     */
    public void setKey(int key1) {
        key = key1;
    }


    /**
     * Sets the record's id
     * 
     * @param id1
     *            inputed id
     */

    public void setId(int id1) {
        id = id1;
    }
}
