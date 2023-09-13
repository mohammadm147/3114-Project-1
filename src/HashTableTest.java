
/**
 * 
 */

import student.TestCase;

/**
 * HashTable test class
 * 
 * @author Jae Trimboli (jaetrim)
 * @author Mohammad Mian (mohammadm21)
 * @version 2023-09-06
 */
public class HashTableTest extends TestCase {

    private HashTable hashTable;
    private Record record;

    /**
     * SetUp constructor for HashTable test
     */
    public void setUp() {
        hashTable = new HashTable(4);
        record = new Record();
    }


    /**
     * test class for insert function
     */
    public void testInsert() {
        int id = 4;
        hashTable.insert(id, record);
        assertEquals(record.getId(), 4);
        assertEquals(record.getKey(), 0);
        assertEquals(hashTable.getArr()[0], record);
        record = new Record();
        hashTable.insert(0, record);
        assertEquals(record.getKey(), 1);
        record = new Record();
        hashTable.insert(12, record);
        assertEquals(record.getKey(), 7);
        record = new Record();
        hashTable.insert(7, record);
        assertEquals(record.getKey(), 1);
    }


    /**
     * test function for insert when array is half full
     */
    public void testInsertWhenArrayHalfFull() {
        for (int i = 0; i < 10; i++) {
            record = new Record();
            hashTable.insert(i, record);
        }
        assertEquals(record.getId(), 9);
        assertEquals(hashTable.getSize(), 32);
        record = new Record();
        hashTable.insert(10, record);
        assertEquals(record.getId(), 10);
        assertEquals(hashTable.getArr()[record.getKey()], record);
        assertEquals(hashTable.getSize(), 32);
        for (int i = 11; i < 20; i++) {
            int tempId = i;
            hashTable.insert(tempId, record);
        }
        assertEquals(hashTable.getSize(), 64);
        assertEquals(record.getId(), 19);
    }


    /**
     * test function for search
     */
    public void testSearch() {
        Record record2 = new Record();
        for (int i = 0; i < 20; i++) {
            record2 = new Record();
            hashTable.insert(i, record2);
        }
        assertEquals(record2.getId(), 19);
        assertEquals(record2.getKey(), 19);
        assertEquals(hashTable.search(10), 10);
        assertEquals(hashTable.search(21), -1);
        assertEquals(hashTable.search(7), 7);
        assertEquals(hashTable.search(3), 3);
        record2 = new Record();
        hashTable.insert(50, record2);
        assertEquals(record2.getKey(), 50);
        assertEquals(record2.getId(), 50);
        assertEquals(hashTable.search(50), 50);
        assertEquals(hashTable.getArr()[19].getId(), 19);
        record2 = new Record();
        hashTable.insert(90, record2);
        assertEquals(record2.getKey(), 26);
        assertEquals(record2.getId(), 90);
        assertEquals(hashTable.getArr()[26].getId(), 90);
        assertEquals(hashTable.search(50), 50);
        assertEquals(hashTable.search(80), -1);

    }


    /**
     * test function for delete
     */
    public void testDelete() {
        Record record2 = new Record();
        for (int i = 0; i < 11; i++) {
            record2 = new Record();
            hashTable.insert(i, record2);
        }
        assertEquals(hashTable.getCount(), 11);
        hashTable.delete(20);
        assertEquals(hashTable.getCount(), 11);
        hashTable.delete(5);
        assertEquals(hashTable.getCount(), 10);
        record2 = new Record();
        hashTable.insert(50, record2);
        assertEquals(hashTable.getCount(), 11);
        assertEquals(hashTable.getArr()[18], record2);
        hashTable.delete(50);
        assertEquals(hashTable.getCount(), 10);
        assertEquals(hashTable.getArr()[18].getId(), -1);
        record2 = new Record();
        hashTable.insert(50, record2);
        assertEquals(hashTable.getArr()[18].getId(), 50);
        record2 = new Record();
        hashTable.insert(90, record2);
        assertEquals(hashTable.getArr()[26].getId(), 90);
    }
    
    /**
     * more test function for delete
     */
    public void testDeleteOveright()
    {
        Record record2 = new Record();
        hashTable.insert(90, record2);
        assertEquals(hashTable.getArr()[record2.getKey()], record2);
        record2 = new Record();
        hashTable.insert(50, record2);
        assertEquals(hashTable.getArr()[record2.getKey()], record2);
        record2 = new Record();
        hashTable.insert(160, record2);
        assertEquals(hashTable.getArr()[record2.getKey()], record2);
        System.out.print(hashTable.getArr().toString());
        hashTable.delete(90);
        hashTable.delete(50);
        record2 = new Record();
        hashTable.insert(7, record2);
        record2 = new Record();
        hashTable.delete(27);
        hashTable.insert(2, record2);
        record2 = new Record();
        hashTable.insert(27, record2);
        hashTable.delete(27);
        record2 = new Record();
        hashTable.insert(10054, record2);
        hashTable.delete(27);
        record2 = new Record();
        hashTable.insert(3762, record2);
    }


    /**
     * test function for an empty hash table
     */
    public void testEmptyTable() {
        assertEquals(hashTable.search(32), -1);
        hashTable.delete(32);
    }
    
    public void testHashTableTobmstoneInsert() {
        Record record2 = new Record();
        for (int i = 0; i < 15; i++) {
            record2 = new Record();
            hashTable.insert(i, record2);
        }
        assertEquals(hashTable.getCount(), 15);
        assertEquals(hashTable.search(14), 14);
        hashTable.delete(14);
        assertEquals(hashTable.getCount(), 14);
        assertEquals(hashTable.getArr()[14].getId(), -1);
        record2 = new Record();
        hashTable.insert(14, record2);
    }
    
    public void testDeleteCollision()
    {
        Record record2 = new Record();
        hashTable.insert(8, record2);
        assertEquals(hashTable.search(8), 0);
        record2 = new Record();
        hashTable.insert(0, record2);
        assertEquals(hashTable.search(0), 1);
        record2 = new Record();
        hashTable.insert(256, record2);
        assertEquals(hashTable.search(256), 2);
        record2 = new Record();
        hashTable.insert(16, record2);
        assertEquals(hashTable.search(16), 5);
        hashTable.delete(16);
        assertEquals(hashTable.search(16), -1);
        record2 = new Record();
        hashTable.insert(32, record2);
        assertEquals(hashTable.search(32), 3);
        record2 = new Record();
        hashTable.insert(1024, record2);
        hashTable.delete(128);
        assertEquals(hashTable.search(16), -1);
        assertEquals(hashTable.search(1024), 2);
        record2 = new Record();
        hashTable.insert(128, record2);
        assertEquals(hashTable.search(128), 3);
        record2 = new Record();
        hashTable.insert(512, record2);
        assertEquals(hashTable.search(512), 4);
        record2 = new Record();
        hashTable.insert(64, record2);
        assertEquals(hashTable.search(64), 9);
    }
}
