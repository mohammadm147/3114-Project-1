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
    private Handle[] hashTable;

    /**
     * Initializes the HashTable using an inputed size
     * 
     * @param size
     *            size of table to be made
     */
    public HashTable(int size) {
        hashSize = size;
        hashTable = new Handle[hashSize];
        seminarCount = 0;
    }


    /**
     * Inserts a new record into the hash table
     * 
     * @param id
     *            id of record to be inserted
     *
     * @param handle
     *            handle that associates id to key value
     */
    public void insert(int id, Handle handle) {
        if (seminarCount >= (hashSize / 2)) {
            rehash();
            System.out.println("Hash table expanded to " + hashSize
                + " records");
        }
        handle.setId(id);
        int key = keyFinder1(id);
        while ((hashTable[key] != null) && (hashTable[key].getId() != -1)) {
            key = keyFinder2(id, key);
        }
        handle.setKey(key);
        hashTable[handle.getKey()] = handle;
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
    public boolean search(int id) {
        // Prints the record with ID value if found
        boolean found = false;
        int key = keyFinder1(id);
        while ((key <= hashSize) && (hashTable[key] != null)) {
            if (hashTable[key].getId() == id) {
                found = true;
            }
            key = keyFinder2(id, key);
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
        int key = keyFinder1(id);
        if (hashTable[key] != null) {
            while (hashTable[key].getId() != id) {
                key = keyFinder2(id, key);
            }
            Handle temp = new Handle();
            temp.setId(-1);
            temp.setKey(key);
            hashTable[key] = temp;
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
        int newKey = key + (((id / hashSize) % (hashSize / 2)) * 2) + 1;
        return newKey;
    }


    /**
     * Returns the array within the hash table
     * 
     * @return Handle[]
     *         Returns array of handle objects
     */
    public Handle[] getArr() {
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
