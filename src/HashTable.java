
public class HashTable {

    private int hashSize;
    private int seminar_count;
    private Handle[] hashTable;

    public HashTable(int hash_size) {
        hashTable = new Handle[hashSize];
        hashSize = hash_size;
        seminar_count = 0;
    }


    public void insert(int id, Handle handle) {
        if (seminar_count == (hashSize / 2)) {
            rehash();
        }

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
        }
        seminar_count--;
    }


    private void rehash() {
        hashSize = hashSize * 2;
        Handle[] updated_hashtable = new Handle[hashSize];

    }


    private int keyFinder(int id) {
        int key = (id % hashSize);

        while (hashTable[key] != null) {
            key = (key + ((id / hashSize) % (hashSize / 2) * 2) + 1);

            while (key >= hashSize) {
                key--;
            }
        }
        return key;
    }
}
