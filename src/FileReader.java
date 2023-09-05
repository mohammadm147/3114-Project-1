import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class containing the FileReader that parses the input file
 * 
 * @author Jae Trimboli (jaetrim)
 * @author Mohammad Mian (mohammadm21)
 * @version 2023-09-05
 */
public class FileReader {

    private ArrayList<Seminar> seminars;

    /**
     * General constructor for the FileReader class
     * 
     * @throws Exception
     */
    public FileReader() throws Exception {
    }


    /**
     * Parses through the input file and storing important information and using
     * the information to create Seminar objects
     * 
     * @param fileName
     *            takes in the name of the input file
     * @return a list of seminar objects after parsing the file
     * @throws Exception
     */
    public ArrayList<Seminar> readFile(String fileName) throws Exception {
        File f = new File("src/P1Sample_input.txt");
        Scanner sc = new Scanner(f);

        seminars = new ArrayList<Seminar>();

        while (sc.hasNextLine()) {

            // Deals with only insert functions in which the Seminar object is
            // created
            String currentLine = sc.nextLine();
            if (currentLine.contains("insert")) {
                String[] insertLine = currentLine.split("\\s+");
                int id = Integer.parseInt(insertLine[1]);
                String title = sc.nextLine();
                String date = sc.next();
                int length = Integer.parseInt(sc.next());
                short xCoord = (short)Integer.parseInt(sc.next());
                short yCoord = (short)Integer.parseInt(sc.next());
                int cost = Integer.parseInt(sc.next());
                sc.nextLine();
                String keywordLine = sc.nextLine();
                String[] keywords = keywordLine.split("\\s+");
                String description = sc.nextLine();
                String formatDesc = description.replaceAll("\\s+", " ");
                Seminar sem = new Seminar(id, title, date, length, xCoord,
                    yCoord, cost, keywords, formatDesc);
                System.out.println(sem.toString());
                int size = sem.serialize().length;
                System.out.println("Size: " + size);
                seminars.add(sem);
            }
// else if (currentLine.contains("search")) {
// String[] searchLine = currentLine.split("\\s+");
// int id = Integer.parseInt(searchLine[1]);
// }
// else if (currentLine.contains("print")) {
// String[] printLine = currentLine.split("\\s+");
// String command = printLine[1];
// }
// else if (currentLine.contains("delete")) {
// String[] deleteLine = currentLine.split("\\s+");
// int id = Integer.parseInt(deleteLine[1]);
// }
        }
        sc.close();
        return seminars;
    }

}
