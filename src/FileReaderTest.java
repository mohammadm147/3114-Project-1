
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
    private SeminarDB db;

    public void setUp() throws Exception {
        int mem = 512;
        int hash = 4;
        String file = "P1Sample_input.txt";
        reader = new FileReader(mem, hash, file);
        db = new SeminarDB(mem, hash, file);
    }


    public void testInsert() throws Exception {
        String output = "Successfully inserted record with ID 1\r\n"
            + "ID: 1, Title: Overview of HCI Research at VT\r\n"
            + "Date: 0610051600, Length: 90, X: 10, Y: 10, Cost: 45\r\n"
            + "Description: This seminar will present an overview of HCI research at VT\r\n"
            + "Keywords: HCI, Computer_Science, VT, Virginia_Tech\r\n"
            + "Size: 173\r\n" + "Successfully inserted record with ID 2\r\n"
            + "ID: 2, Title: Computational Biology and Bioinformatics in CS at Virginia Tech\r\n"
            + "Date: 0610071600, Length: 60, X: 20, Y: 10, Cost: 30\r\n"
            + "Description: Introduction to   bioinformatics and computation biology\r\n"
            + "Keywords: Bioinformatics, computation_biology, Biology, Computer_Science, VT, Virginia_Tech\r\n"
            + "Size: 244\r\n" + "Hash table expanded to 8 records\r\n"
            + "Successfully inserted record with ID 3\r\n"
            + "ID: 3, Title: Computing Systems Research at VT\r\n"
            + "Date: 0701250830, Length: 30, X: 30, Y: 10, Cost: 17\r\n"
            + "Description: Seminar about the      Computing systems research at      VT\r\n"
            + "Keywords: high_performance_computing, grids, VT, computer, science\r\n"
            + "Size: 192\r\n"
            + "Insert FAILED - There is already a record with ID 3\r\n"
            + "Successfully inserted record with ID 10\r\n"
            + "ID: 10, Title: Overview of HPC and CSE Research at VT\r\n"
            + "Date: 0703301125, Length: 35, X: 0, Y: 0, Cost: 25\r\n"
            + "Description: Learn what kind of    research is done on HPC  and CSE at VT\r\n"
            + "Keywords: HPC, CSE, computer_science\r\n" + "Size: 168\r\n"
            + "Found record with ID 3:\r\n" + "Hashtable:\r\n" + "1: 1\r\n"
            + "2: 2\r\n" + "3: 3\r\n" + "5: 10\r\n" + "Total Records: 4\r\n"
            + "Record with ID 2 successfully deleted from the database\r\n"
            + "Search FAILED -- There is no record with ID 2\r\n"
            + "Hashtable:\r\n" + "1: 1\r\n" + "2: TOMBSTONE\r\n" + "3: 3\r\n"
            + "5: 10\r\n" + "Total Records: 3\r\n"
            + "Delete FAILED -- There is no record with ID 6\r\n"
            + "Successfully inserted record with ID 2\r\n"
            + "ID: 2, Title: Much More Computational Biology and Bioinformatics in CS at Virginia Tech\r\n"
            + "Date: 0610071600, Length: 60, X: 20, Y: 10, Cost: 30\r\n"
            + "Description: Introduction to bioinformatics and lots of computation biology\r\n"
            + "Keywords: Bioinformatics, computation_biology, Biology, Computer_Science, VT, Virginia_Tech\r\n"
            + "Size: 260\r\n"
            + "Record with ID 10 successfully deleted from the database\r\n"
            + "Hashtable:\r\n" + "1: 1\r\n" + "2: 2\r\n" + "3: 3\r\n"
            + "5: TOMBSTONE\r\n" + "Total Records: 3";
        assertFuzzyEquals(systemOut().getHistory(), output);
    }
}
