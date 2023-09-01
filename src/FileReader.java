import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {

    public FileReader(String file)
        throws FileNotFoundException,
        URISyntaxException {
        readFile(file);
    }


    /*
     * Parses through the input file and storing important information and using
     * the information to create Seminar objects
     */
    private void readFile(String fileName)
        throws FileNotFoundException,
        URISyntaxException {
        URL path = ClassLoader.getSystemResource(fileName);
        File newFile = new File(path.toURI());
        Scanner sc = new Scanner(newFile);

        ArrayList<Seminar> seminar_list = new ArrayList<Seminar>();

        while (sc.hasNextLine()) {

            // Deals with only insert functions in which the Seminar object is
            // created
            String insert_line = sc.nextLine();
            if (insert_line.contains("insert")) {
                String[] insert = insert_line.split("\\s+");
                int id = Integer.parseInt(insert[1]);
                String title = sc.nextLine();
                String date = sc.next();
                int length = Integer.parseInt(sc.next());
                short x_coord = (short)Integer.parseInt(sc.next());
                short y_coord = (short)Integer.parseInt(sc.next());
                int cost = Integer.parseInt(sc.next());
                sc.nextLine();
                String keyword_line = sc.nextLine();
                String[] keywords = keyword_line.split("\\s+");
                String description = sc.nextLine();
                String format_des = description.replaceAll("\\s+", " ");
                Seminar sem = new Seminar(id, title, date, length, x_coord,
                    y_coord, cost, keywords, format_des);
                System.out.println(sem.toString());
                seminar_list.add(sem);
            }

            // Search and Delete commands later
        }
        sc.close();
    }

}
