
import java.util.ArrayList;

/**
 * SeminarDB or World class
 */
public class SeminarDB {

    private FileReader reader;
    private HashTable table;
    public ArrayList<Command> commands;
    public Handle handle;

    // purpose of seminars is to know that you have to insert them

    public SeminarDB(int memory, int hash, String fileName) throws Exception {
        reader = new FileReader();
        table = new HashTable(hash);
        commands = reader.readFile(fileName);
        printCommands();

    }


    public void printCommands() throws Exception {
        for (int i = 0; i < commands.size(); i++) {
            if (commands.get(i).command == "insert") {
                handle = new Handle();
                int id = Integer.parseInt(commands.get(i).id);
//                if (table.search(id) == (true)) {
//                    System.out.println(
//                        "Insert FAILED - There is already a record with ID "
//                            + id);
//                }
                table.insert(id, handle);
                System.out.println(commands.get(i).seminar.toString());
                int length = commands.get(i).seminar.serialize().length;
                System.out.println("Size of: " + length);
            }
            else if (commands.get(i).command == "search") {

            }
            else if (commands.get(i).command == "print") {

            }
            else {

            }
        }
    }
}
