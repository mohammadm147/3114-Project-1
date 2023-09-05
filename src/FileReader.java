import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {

    private ArrayList<Seminar> seminars;

    /**
     * General constructor for the FileReader class
     * 
     * @param file
     *            takes in the name of the input file
     * @throws Exception 
     */
    public FileReader(String file)
        throws Exception {
        readFile(file);
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
    public ArrayList<Seminar> readFile(String fileName)
        throws Exception {
        URL path = ClassLoader.getSystemResource(fileName);
        File newFile = new File(path.toURI());
        Scanner sc = new Scanner(newFile);

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
                short x_coord = (short)Integer.parseInt(sc.next());
                short y_coord = (short)Integer.parseInt(sc.next());
                int cost = Integer.parseInt(sc.next());
                sc.nextLine();
                String keywordLine = sc.nextLine();
                String[] keywords = keywordLine.split("\\s+");
                String description = sc.nextLine();
                String format_des = description.replaceAll("\\s+", " ");
                Seminar sem = new Seminar(id, title, date, length, x_coord,
                    y_coord, cost, keywords, format_des);
                System.out.println(sem.toString());
                int size = sem.serialize().length;
                System.out.println("Size: " + size);
                seminars.add(sem);
            }
            else if (currentLine.contains("search")) {
                String[] search_line = currentLine.split("\\s+");
                int id = Integer.parseInt(search_line[1]);
            }
            else if (currentLine.contains("print")) {
                String[] print_line = currentLine.split("\\s+");
                String command = print_line[1];
            }
            else if (currentLine.contains("delete")) {
                String[] delete_line = currentLine.split("\\s+");
                int id = Integer.parseInt(delete_line[1]);
            }
        }
        sc.close();
        return seminars;
    }

}
