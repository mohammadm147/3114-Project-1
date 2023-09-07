
/**
 * Seminar DB class acts as world and prints and works with memory manager and
 * hash table
 * 
 * @author Jae Trimboli (jaetrim)
 * @author Mohammad Mian (mohammadm21)
 * @version 2023-09-06
 * 
 */
public class SeminarDB {

    private HashTable table;
    private Record record;

    /**
     * SeminarDB Constructor that initializes hashtable and takes in memory,
     * hash, and the file
     * 
     * @param memory
     *            represents the size of the memory
     * @param hash
     *            represents the size of the hash
     * @param fileName
     *            represents the name of the input file
     * @throws Exception
     */
    public SeminarDB(int memory, int hash, String fileName) throws Exception {
        table = new HashTable(hash);
    }


    /**
     * Inserts id and record into hash table and prints info into console
     * 
     * @param sem
     *            represents Seminar object
     * @param id
     *            represents Seminar's corresponding id
     * @throws Exception
     */
    public void insert(Seminar sem, int id) throws Exception {
        if (table.search(id) == true) {
            System.out.println(
                "Insert FAILED - There is already a record with ID " + id);
        }
        else {
            record = new Record();
            table.insert(id, record);
            System.out.println("Successfully inserted record with ID " + id);
            System.out.println(sem.toString());
            int length = sem.serialize().length;
            System.out.println("Size: " + length);
        }

    }


    /**
     * Searches for record at a given id and prints info
     * 
     * @param id
     *            represents record id
     */
    public void search(int id) {
        if (table.search(id) == true) {
            System.out.println("Found record with ID " + id + ":");

        }
        else {
            System.out.println("Search FAILED -- There is no record with ID "
                + id);
        }
    }


    /**
     * Prints hashtable or blocks based on passed command
     * 
     * @param command
     *            represents hashtable or block command that is found when
     *            parsing
     */
    public void print(String command) {
        if (command.equals("hashtable")) {
            System.out.println("Hashtable:");
            for (int i = 0; i < table.getSize(); i++) {
                if (table.getArr()[i] != null) {
                    if (table.getArr()[i].getId() == -1) {
                        System.out.println(table.getArr()[i].getKey()
                            + ": TOMBSTONE");
                    }
                    else {
                        System.out.println(table.getArr()[i].getKey() + ": "
                            + table.getArr()[i].getId());
                    }
                }
            }
            System.out.println("Total Records: " + table.getCount());
        }
        else if (command.equals("blocks")) {

        }
    }


    /**
     * Deletes a record at an id
     * 
     * @param id
     *            represents id
     */
    public void delete(int id) {
        table.delete(id);

    }
}
