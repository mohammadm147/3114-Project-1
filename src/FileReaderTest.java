
/**
 * 
 */
import java.util.ArrayList;
import student.TestCase;

/**
 * 
 */
public class FileReaderTest extends TestCase {

    private FileReader reader;
    private ArrayList<Command> commands;

    public void setUp() throws Exception {
        reader = new FileReader();
        commands = reader.readFile("src/P1Sample_input.txt");
    }


    public void testSize() {
        assertEquals(commands.size(), 13);
    }


    public void testInsert() {
        assertEquals("insert", commands.get(0).command);
        assertEquals("1", commands.get(0).id);
    }


    public void testSearch() {
        assertEquals("search", commands.get(5).command);
        assertEquals("3", commands.get(5).id);
    }


    public void testPrint() {
        assertEquals("print", commands.get(6).command);
    }


    public void testDelete() {
        assertEquals("delete", commands.get(8).command);
    }

}
