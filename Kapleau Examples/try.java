import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        File in = new File("input.txt");
        File out = new File("output.txt");

        try (Scanner scan = new Scanner(in);
             PrintWriter pw = new PrintWriter(out)) {

            while (scan.hasNext()) {
                pw.println(scan.next());
            }
        }
        catch (FileNotFoundException e) {
            System.err.println(e);
            System.exit(0);
        }
    }
}
