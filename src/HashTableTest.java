
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
        hashTable = new HashTable(20);
        record = new Record();
    }


    /**
     * test class for insert function
     */
    public void testInsert() {
        int id = 4;
        hashTable.insert(id, record);
        assertEquals(record.getId(), 4);
        assertEquals(record.getKey(), 4);
        assertEquals(hashTable.getArr()[4], record);
        hashTable.insert(id, record);
        assertEquals(record.getKey(), 5);
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
        assertEquals(hashTable.getSize(), 20);
        record = new Record();
        hashTable.insert(10, record);
        assertEquals(record.getId(), 10);
        assertEquals(hashTable.getArr()[record.getKey()], record);
        assertEquals(hashTable.getSize(), 40);
        for (int i = 11; i < 20; i++) {
            int tempId = i;
            hashTable.insert(tempId, record);
        }
        assertEquals(hashTable.getSize(), 40);
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
        boolean found = hashTable.search(10);
        assertTrue(found);
        found = hashTable.search(21);
        assertFalse(found);
        found = hashTable.search(7);
        assertTrue(found);
        found = hashTable.search(3);
        assertTrue(found);
        record2 = new Record();
        hashTable.insert(50, record2);
        assertEquals(record2.getKey(), 50);
        assertEquals(record2.getId(), 50);
        found = hashTable.search(50);
        assertTrue(found);
        assertEquals(hashTable.getArr()[19].getId(), 19);
        record2 = new Record();
        hashTable.insert(90, record2);
        assertEquals(record2.getKey(), 22);
        assertEquals(record2.getId(), 90);
        assertEquals(hashTable.getArr()[22].getId(), 90);
        found = hashTable.search(50);
        assertTrue(found);
        found = hashTable.search(80);
        assertFalse(found);

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
        assertEquals(hashTable.getArr()[13], record2);
        hashTable.delete(50);
        assertEquals(hashTable.getCount(), 10);
        assertEquals(hashTable.getArr()[13].getId(), -1);
        record2 = new Record();
        hashTable.insert(50, record2);
        assertEquals(hashTable.getArr()[13].getId(), 50);
    }


    /**
     * test function for an empty hash table
     */
    public void testEmptyTable() {
        assertEquals(hashTable.search(32), false);
        hashTable.delete(32);
    }
    
    public void testHashTableTobmstoneInsert() {
        Record record2 = new Record();
        for (int i = 0; i < 15; i++) {
            record2 = new Record();
            hashTable.insert(i, record2);
        }
        assertEquals(hashTable.getCount(), 15);
        assertTrue(hashTable.search(14));
        hashTable.delete(14);
        assertEquals(hashTable.getCount(), 14);
        assertEquals(hashTable.getArr()[14].getId(), -1);
        record2 = new Record();
        hashTable.insert(14, record2);
    }
}
