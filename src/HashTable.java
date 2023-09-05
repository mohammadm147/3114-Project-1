
public class HashTable {

    private int hashSize;
    private int seminarCount;
    private Handle[] hashTable;

    public HashTable(int hash_size) {
        hashSize = hash_size;
        hashTable = new Handle[hashSize];
        seminarCount = 0;
    }


    public void insert(int id, Handle handle) {
        if (seminarCount >= (hashSize / 2)) {
            rehash();
            System.out.println("Hash table expanded to " + hashSize + " records");
        }

        handle.setId(id);
        handle.setKey(keyFinder(id));

        hashTable[handle.getKey()] = handle;

        seminarCount++;
    }


    public boolean search(int id) {
        // Prints the record with ID value if found
        boolean found = false;
        int key = (id % hashSize);
        if (hashTable[key] == null) {
            return found;
        }
        else if (hashTable[key].getId() != id) {
            key = key + (((id / hashSize) % (hashSize / 2)) * 2) + 1;
        }
        found = true;
        return found;
    }


    public void delete(int id) {
        int key = (id % hashSize);
        if (hashTable[key] != null) {
            hashTable[key] = null;
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
            if (hashTable[i] != null) {
                int tempId = hashTable[i].getId();
                updatedHashTable.insert(tempId, hashTable[i]);
            }
        }
        hashTable = updatedHashTable.getArr();
    }


    private int keyFinder(int id) {
        int key = (id % hashSize);

        if (hashTable[key] != null) {
            key = key + (((id / hashSize) % (hashSize / 2)) * 2) + 1;
            while (key >= hashSize) {
                key--;
            }
        }
        return key;
    }


    public Handle[] getArr() {
        return hashTable;
    }


    public int getSize() {
        return hashSize;
    }
}
