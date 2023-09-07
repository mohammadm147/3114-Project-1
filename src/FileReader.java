import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class containing the FileReader that parses the input file
 * 
 * @author Jae Trimboli (jaetrim)
 * @author Mohammad Mian (mohammadm21)
 * @version 1.0 2023-09-05
 */
public class FileReader {

    private SeminarDB world;

    /**
     * FileReader constructor that creates SeminarDB object and calls to read
     * the file
     * 
     * @param mem
     *            representing memory Size
     * @param hash
     *            representing hash Size
     * @param file
     *            representing the inputed file that is being parsed
     * @throws Exception
     */
    public FileReader(int mem, int hash, String file) throws Exception {
        world = new SeminarDB(mem, hash, file);
        readFile(file);
    }


    /**
     * Parses through the input file and passing commands into world
     * 
     * @param fileName
     *            takes in the name of the input file
     * @throws Exception
     */
    public void readFile(String fileName) throws Exception {
        File f = new File(fileName);
        Scanner sc = new Scanner(f);
        while (sc.hasNextLine()) {

            // Deals with only insert functions in which the Seminar object is
            // created
            String currentLine = sc.nextLine();
            currentLine.trim();

            if (currentLine.contains("insert")) {
                String[] insertLine = currentLine.split("\\s+");
                if (insertLine.length == 2) {
                    char[] charArray = insertLine[1].toCharArray();
                    boolean found = false;
                    for (int i = 0; i < charArray.length; i++) {
                        if (!Character.isDigit(charArray[i])) {
                            found = true;
                        }
                    }
                    if (found == false) {

                        int id = Integer.parseInt(insertLine[1]);
                        String title = sc.nextLine();
                        String date = sc.next();
                        int length = Integer.parseInt(sc.next());
                        short xCoord = Short.parseShort(sc.next());
                        short yCoord = Short.parseShort(sc.next());
                        int cost = Integer.parseInt(sc.next());
                        sc.nextLine();
                        String keywordLine = sc.nextLine().trim();
                        String[] keywords = keywordLine.split("\\s+");
                        String description = sc.nextLine();
                        String formatDesc = description.trim();
                        Seminar sem = new Seminar(id, title, date, length,
                            xCoord, yCoord, cost, keywords, formatDesc);
                        world.insert(sem, id);
                    }
                    else {
                        sc.nextLine();
                        sc.nextLine();
                        sc.nextLine();
                        sc.nextLine();
                    }

                }
                else {
                    sc.nextLine();
                    sc.nextLine();
                    sc.nextLine();
                    sc.nextLine();
                }

            }
            else if (currentLine.contains("search")) {
                String[] searchLine = currentLine.split("\\s+");
                int id = Integer.parseInt(searchLine[1]);
                world.search(id);

            }
            else if (currentLine.contains("print")) {
                String[] printLine = currentLine.split("\\s+");
                String print = printLine[1];
                world.print(print);

            }
            else if (currentLine.contains("delete")) {
                String[] deleteLine = currentLine.split("\\s+");
                if (deleteLine.length == 3) {
                    int id = Integer.parseInt(deleteLine[2]);
                    world.delete(id);
                }
                else {
                    int id = Integer.parseInt(deleteLine[1]);
                    world.delete(id);
                }

            }
        }

        sc.close();
    }

}
