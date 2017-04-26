import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        File in = new File("input.txt");
        File out = new File("output.txt");
        Scanner scan = null;
        PrintWriter pw = null;

        try {
            scan = new Scanner(in);
        }
        catch (FileNotFoundException e) {
            System.err.println(e);
            System.exit(0);
        }

        try {
            pw = new PrintWriter(out);
        }
        catch (FileNotFoundException e) {
            System.err.println(e);
            scan.close();
            System.exit(0);
        }

        while (scan.hasNext()) {
            pw.println(scan.next());
        }

        pw.close();
        scan.close();
    }
}
