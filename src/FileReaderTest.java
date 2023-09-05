
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
    private ArrayList<Command> seminars;

    public void setUp() throws Exception {
        reader = new FileReader();
        seminars = reader.readFile("src/P1Sample_input.txt");

    }
}
