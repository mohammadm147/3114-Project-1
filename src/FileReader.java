import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class FileReader {

    public FileReader(String file) throws FileNotFoundException {
        readFile(file);
    }


    private void readFile(String fileName) throws FileNotFoundException {
        File newFile = new File(fileName);
        Scanner sc = new Scanner(newFile);
        while (sc.hasNextLine()) {
            System.out.println("asffFf");
        }
        sc.close();
    }

}
