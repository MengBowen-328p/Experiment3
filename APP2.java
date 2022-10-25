import java.io.File;
import java.util.Scanner;

public class APP2 {

    public static void main(String[] args) throws Exception {
        try (Scanner reader = new Scanner(System.in)) {
            String fileName = reader.nextLine();
            File f = new File(".\\Files\\Test.txt" + fileName);
            try (Scanner fi = new Scanner(f)) {
                String sLine = null;
                int index = 0;
                while (fi.hasNext()) {
                    sLine = fi.nextLine();
                    System.out.println(++index + " " + sLine);
                }
            }
        }
    }
}