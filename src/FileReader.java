import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.Scanner;

public class FileReader {

    public FileReader(String file) throws FileNotFoundException, URISyntaxException {
        readFile(file);
    }


    private void readFile(String fileName) throws FileNotFoundException, URISyntaxException {
        URL path = ClassLoader.getSystemResource(fileName);
        File newFile = new File(path.toURI());
        Scanner sc = new Scanner(newFile);
        while (sc.hasNextLine()) {
            System.out.println("asffFf");
        }
        sc.close();
    }

}
