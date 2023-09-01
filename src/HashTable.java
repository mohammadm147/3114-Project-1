
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
                
        int key = keyFinder(id);
        
        hashTable[key] = sem;
        
        seminar_count++;
    }


    private void search(int id) {
        // Prints the record with ID value if found
        int key = keyFinder(id);
        if (hashTable[key] != null)
        {
            System.out.print("Search FAILED -- There is no record with ID " + id);
        }
        System.out.print(hashTable[key]);
    }


    private void delete(int id) {
        // Removes record if in database

    }


    private void rehash() {

    }
    
    private int keyFinder(int id)
    {
        int key = (id % hashSize);

        while (hashTable[key] != null)
        {
            key = (key + ((id / hashSize) % (hashSize / 2) * 2) + 1);
            
            while (key >= hashSize)
            {
                key--;
            }
        }
        return key;
    }
}