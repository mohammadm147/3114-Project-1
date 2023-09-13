/**
 * HashTable Class
 * 
 * @author mohammadm21
 * @author jaetrim
 * @version 1.0
 */
public class HashTable {

    private int seminarCount;
    private int hashSize;
    private Record[] hashTable;

    /**
     * Initializes the HashTable using an inputed size
     * 
     * @param size
     *            size of table to be made
     */
    public HashTable(int size) {
        hashSize = size;
        hashTable = new Record[hashSize];
        seminarCount = 0;
    }


    /**
     * Inserts a new record into the hash table
     * 
     * @param id
     *            id of record to be inserted
     *
     * @param record
     *            record that associates id to key value
     */
    public void insert(int id, Record record) {
        if (seminarCount >= (hashSize / 2)) {
            rehash();
            System.out.println("Hash table expanded to " + hashSize
                + " records");
        }
        record.setId(id);
        int key = keyFinder1(id);
        while ((hashTable[key] != null) && (hashTable[key].getId() != -1)) {
            key = keyFinder2(id, key);
        }
        record.setKey(key);
        hashTable[record.getKey()] = record;
        seminarCount++;
    }


    /**
     * Searches for a record associated with
     * a given id within the hash table
     * 
     * @param id
     *            id to search for
     * 
     * @return boolean
     *         Returns true is id is found.
     *         False otherwise
     */
    public int search(int id) {
        // Prints the record with ID value if found
        int found = -1;
        int key = keyFinder1(id);
        while (hashTable[key] != null) {
            if (hashTable[key].getId() == id) {
                found = key;
                return found;
            }
            else {
                key = keyFinder2(id, key);
            }
        }
        return found;
    }


    /**
     * Deletes a record associated with a
     * given id within the hash table
     * 
     * @param id
     *            id to be deleted
     */
    public void delete(int id) {
        int found = this.search(id);

        if (found != -1) {
            Record temp = new Record();
            temp.setId(-1);
            temp.setKey(found);
            hashTable[found] = temp;
            System.out.println("Record with ID " + id
                + " successfully deleted from the database");
            seminarCount--;
        }
        else {
            System.out.println("Delete FAILED -- There is no record with ID "
                + id);
        }
    }


    private void rehash() {
        hashSize = hashSize * 2;
        HashTable updatedHashTable = new HashTable(hashSize);

        for (int i = 0; i < hashTable.length; i++) {
            if ((hashTable[i] != null) && (hashTable[i].getId() != -1)) {
                int tempId = hashTable[i].getId();
                updatedHashTable.insert(tempId, hashTable[i]);
            }
        }
        hashTable = updatedHashTable.getArr();
    }


    private int keyFinder1(int id) {
        int key = (id % hashSize);
        return key;
    }


    private int keyFinder2(int id, int key) {
        int step = (((id / hashSize) % (hashSize / 2)) * 2) + 1;
        key = key + step;
        key = key % hashSize;
        return key;
    }


    /**
     * Returns the array within the hash table
     * 
     * @return record[]
     *         Returns array of record objects
     */
    public Record[] getArr() {
        return hashTable;
    }


    /**
     * Returns the size of the hash table
     * 
     * @return int
     *         Returns size as an integer
     */
    public int getSize() {
        return hashSize;
    }


    /**
     * Returns the number of objects in the hash table
     * 
     * @return int
     *         Returns count as an integer
     */
    public int getCount() {
        return seminarCount;
    }
}
