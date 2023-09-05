/**
 * 
 */

import student.TestCase;

/**
 * 
 */
public class HashTableTest extends TestCase{
    
    private HashTable hashTable;
    private Handle handle;
    
    public void setUp() {
        hashTable = new HashTable(20);
        handle = new Handle();
    }
    
    public void testInsert()
    {
        int id = 4;
        hashTable.insert(id, handle);
        assertEquals(handle.getId(), 4);
        assertEquals(handle.getKey(), 4);
        assertEquals(hashTable.getArr()[4], handle);
        hashTable.insert(id, handle);
        assertEquals(handle.getKey(), 5);
    }
    
    public void testInsertWhenArrayHalfFull()
    {
        for (int i = 0; i < 10; i++)
        {
            int tempId = i;
            hashTable.insert(tempId, handle);
        }
        assertEquals(handle.getId(), 9);
        assertEquals(hashTable.getSize(), 20);
        hashTable.insert(10, handle);
        assertEquals(handle.getId(), 10);
        assertEquals(hashTable.getArr()[handle.getKey()], handle);
        assertEquals(hashTable.getSize(), 40);
        for (int i = 11; i < 20; i++)
        {
            int tempId = i;
            hashTable.insert(tempId, handle);
        }
        assertEquals(hashTable.getSize(), 40);
        assertEquals(handle.getId(), 19);
    }
    
    public void testSearch()
    {
        Handle handle2 = new Handle();;
        for (int i = 0; i < 11; i++)
        {
            handle2 = new Handle();
            hashTable.insert(i, handle2);
        }
        
        assertEquals(handle2.getId(), 10);
        assertEquals(handle2.getKey(), 10);
        boolean found = hashTable.search(10);
        assertTrue(found);
        found = hashTable.search(20);
        assertFalse(found);
        found = hashTable.search(7);
        assertTrue(found);
        found = hashTable.search(3);
        assertTrue(found);
        hashTable.insert(50, handle2);
        assertEquals(handle2.getKey(), 13);
    }
}