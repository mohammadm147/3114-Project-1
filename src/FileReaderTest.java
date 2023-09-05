
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
    private ArrayList<Seminar> seminars;

    public void setUp() throws Exception {
        reader = new FileReader();
        seminars = reader.readFile("src/P1Sample_input.txt");

    }


    public void testSeminarArraySize() {
        int seminarLength = seminars.size();
        assertEquals(seminarLength, 5);
    }


    public void testSize() throws Exception {
        Seminar sem = seminars.get(0);
        int length = sem.serialize().length;
        assertEquals(length, 173);
    }


    public void testFirstSeminar() {
        Seminar sem = seminars.get(0);
        assertEquals(sem.toString(),
            "ID: 1, Title: Overview of HCI Research at VT\r\n"
                + "Date: 0610051600, Length: 90, X: 10, Y: 10, Cost: 45\r\n"
                + "Description: This seminar will present an overview of HCI research at VT\r\n"
                + "Keywords: HCI, Computer_Science, VT, Virginia_Tech");

    }


    public void testSecondSeminar() {
        Seminar sem = seminars.get(1);
        assertEquals(sem.toString(),
            "ID: 2, Title: Computational Biology and Bioinformatics in CS at Virginia Tech\r\n"
                + "Date: 0610071600, Length: 60, X: 20, Y: 10, Cost: 30\r\n"
                + "Description:  Introduction to bioinformatics and computation biology\r\n"
                + "Keywords: Bioinformatics, computation_biology, Biology, Computer_Science, VT, Virginia_Tech");
    }


    public void testThirdSeminar() {
        Seminar sem = seminars.get(2);
        assertEquals(sem.toString(),
            "ID: 3, Title: Computing Systems Research at VT\r\n"
                + "Date: 0701250830, Length: 30, X: 30, Y: 10, Cost: 17\r\n"
                + "Description:  Seminar about the Computing systems research at VT\r\n"
                + "Keywords: high_performance_computing, grids, VT, computer, science");
    }


    public void testFourthSeminar() {
        Seminar sem = seminars.get(3);
        assertEquals(sem.toString(),
            "ID: 3, Title: Overview of HPC and CSE Research at VT\r\n"
                + "Date: 0703301125, Length: 35, X: 0, Y: 0, Cost: 25\r\n"
                + "Description: Learn what kind of research is done on HPC and CSE at VT\r\n"
                + "Keywords: , HPC, CSE, computer_science");
    }
}
