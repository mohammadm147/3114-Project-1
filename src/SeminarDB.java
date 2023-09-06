
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
        if (table.search(id) == true) {
            System.out.println(
                "Insert FAILED - There is already a record with ID " + id);
        }
        else {
            handle = new Handle();
            table.insert(id, handle);
            System.out.println("Sucessfully inserted record with ID " + id);
            System.out.println(sem.toString());
            int length = sem.serialize().length;
            System.out.println("Size: " + length);
        }

    }


    public void search(int id) {
        if (table.search(id) == true) {
            System.out.println("Found record with ID " + id + ":");

        }
        else {
            System.out.println("Search FAILED -- There is no record with ID "
                + id);
        }
    }


    public void print(String command) {
        if (command.equals("hashtable")) {
            System.out.println("Hashtable:");
            for (int i = 0; i < table.getSize(); i++) {
                if (table.getArr()[i] != null) {
                    if (table.getArr()[i].getId() == -1)
                    {
                        System.out.println(table.getArr()[i].getKey() + ": TOMBSTONE");
                    }
                    else
                    {
                        System.out.println(table.getArr()[i].getKey() + ": " + table
                            .getArr()[i].getId());
                    }
                }
            }
            System.out.println("Total Records: " + table.getCount());
        }
        else if (command == "blocks") {

        }
    }


    public void delete(int id) {

    }
}
