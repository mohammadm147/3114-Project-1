
public class HashTable {

    private int hashSize;
    private int seminar_count;

    public HashTable(int hash_size) {
        Seminar[] hashtable = new Seminar[hashSize];
        hashSize = hash_size;
        seminar_count = 0;
    }


    private void insert(int id) {
        int key1 = (id % hashSize);
        int key2 = ((id / hashSize) % (hashSize / 2) * 2) + 1;

        seminar_count++;
    }


    private void search(int id) {
        // Prints the record with ID value if found
    }


    private void delete(int id) {
        // Removes record if in database

    }


    private void reHash() {

    }

}
