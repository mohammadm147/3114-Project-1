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
        assertEquals(handle.getKey(), 1);
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
        hashTable.insert(1, handle);
        assertEquals(handle.getId(), 1);
    }
    
    


}
