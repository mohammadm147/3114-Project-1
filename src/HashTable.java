
public class HashTable {

    private int hashSize;
    private int seminar_count;
    private Seminar[] hashTable;

    public HashTable(int hash_size) {
        hashTable = new Seminar[hashSize];
        hashSize = hash_size;
        seminar_count = 0;
    }


    private void insert(int id, Seminar sem) 
    {
        if (seminar_count == (hashSize / 2))
        {
            rehash();
        }
                
        int key = (id % hashSize);

        while (hashTable[key] != null)
        {
            key = (key + ((id / hashSize) % (hashSize / 2) * 2) + 1);
            
            while (key >= hashSize)
            {
                key--;
            }
        }
        
        hashTable[key] = sem;
        
        seminar_count++;
    }


    private void search(int id) {
        // Prints the record with ID value if found
        
    }


    private void delete(int id) {
        // Removes record if in database

    }


    private void rehash() {

    }

}
