/**
 * 
 */

import student.TestCase;

/**
 * Tests the HashTable Class
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
            handle = new Handle();
            hashTable.insert(i, handle);
        }
        assertEquals(handle.getId(), 9);
        assertEquals(hashTable.getSize(), 20);
        handle = new Handle();
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
        for (int i = 0; i < 20; i++)
        {
            handle2 = new Handle();
            hashTable.insert(i, handle2);
        }
        assertEquals(handle2.getId(), 19);
        assertEquals(handle2.getKey(), 19);
        boolean found = hashTable.search(10);
        assertTrue(found);
        found = hashTable.search(21);
        assertFalse(found);
        found = hashTable.search(7);
        assertTrue(found);
        found = hashTable.search(3);
        assertTrue(found);
        handle2 = new Handle();
        hashTable.insert(50, handle2);
        assertEquals(handle2.getKey(), 50);
        assertEquals(handle2.getId(), 50);
        found = hashTable.search(50);
        assertTrue(found);
        assertEquals(hashTable.getArr()[19].getId(), 19);
        handle2 = new Handle();
        hashTable.insert(90, handle2);
        assertEquals(handle2.getKey(), 22);
        assertEquals(handle2.getId(), 90);
        assertEquals(hashTable.getArr()[22].getId(), 90);
        found = hashTable.search(50);
        assertTrue(found);
        found = hashTable.search(80);
        assertFalse(found);

        
    }
    
    public void testDelete()
    {
        Handle handle2 = new Handle();;
        for (int i = 0; i < 11; i++)
        {
            handle2 = new Handle();
            hashTable.insert(i, handle2);
        }
        assertEquals(hashTable.getCount(), 11);
        hashTable.delete(20);
        assertEquals(hashTable.getCount(), 11);
        hashTable.delete(5);
        assertEquals(hashTable.getCount(), 10);
        handle2 = new Handle();
        hashTable.insert(50, handle2);
        assertEquals(hashTable.getCount(), 11);
        assertEquals(hashTable.getArr()[13], handle2);
        hashTable.delete(50);
        assertEquals(hashTable.getCount(), 10);
        assertEquals(hashTable.getArr()[13], null);
    }
}