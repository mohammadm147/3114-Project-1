
public class HashTable {

    private int hashSize;
    private int seminar_count;
    private Handle[] hashTable;

    public HashTable(int hash_size) {
        hashSize = hash_size;
        hashTable = new Handle[hashSize];
        seminar_count = 0;
    }


    public void insert(int id, Handle handle) {
        if (seminar_count == (hashSize / 2)) {
            rehash();
        }

        handle.setId(id);
        handle.setKey(keyFinder(id));

        hashTable[handle.getKey()] = handle;

        seminar_count++;
    }


    public void search(int id) {
        // Prints the record with ID value if found
        int key = (id % hashSize);
        if (hashTable[key] == null) {
            System.out.print("Search FAILED -- There is no record with ID "
                + id);
        }
        System.out.print(hashTable[key]);
    }


    public void delete(int id) {
        int key = (id % hashSize);
        if (hashTable[key] != null) {
            hashTable[key] = null;
            System.out.print("Record with ID " + id + " successfully deleted from the database");
            seminar_count--;
        }
        else
        {
            System.out.print("Delete FAILED -- There is no record with ID " + id);
        }
    }


    private void rehash() {
        hashSize = hashSize * 2;
        HashTable updatedHashTable = new HashTable(hashSize);
        
        for (int i = 0; i < hashTable.length; i++)
        {
            if (hashTable[i] != null)
            {
                int tempId = hashTable[i].getId();
                updatedHashTable.insert(tempId, hashTable[i]);
            }
        }
        hashTable = updatedHashTable.getArr();
    }


    private int keyFinder(int id) {
        int key = (id % hashSize);

        if (hashTable[key] != null) {
            key = (((id / hashSize) % (hashSize / 2)) * 2) + 1;
            while (key >= hashSize) {
                key--;
            }
        }
        return key;
    }
    
    public Handle[] getArr()
    {
        return hashTable;
    }
    
    public int getSize()
    {
        return hashSize;
    }
}