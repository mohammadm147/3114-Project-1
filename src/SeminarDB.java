
/**
 * SeminarDB or World class
 */
public class SeminarDB {

    private HashTable table;
    private Handle handle;

    // purpose of seminars is to know that you have to insert them

    public SeminarDB(int memory, int hash, String fileName) throws Exception {
        table = new HashTable(hash);
    }


    public void insert(Seminar sem, int id) throws Exception {
        handle = new Handle();
        if (table.search(id) == true) {
            System.out.println(
                "Insert FAILED - There is already a record with ID " + id);
        }
        else {
            table.insert(id, handle);
            System.out.println("Sucessfully inserted record with ID " + id);
        }
        System.out.println(sem.toString());
        int length = sem.serialize().length;
        System.out.println("Size: " + length);
    }


    public void search(int id) {

    }


    public void print(String command) {

    }


    public void delete(int id) {

    }
}
