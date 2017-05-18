import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * Created by vishnuiyer on 5/17/17.
 */
public class Runner {
    public static void main(String [] args) throws Exception {
        if (args.length != 4) {
            System.out.println("ERROR: Invalid document type. Please specify if book or note " +
                    "is to be compiled.");
            System.exit(0);
        }
        Creator creator;
        if (args[0].equals("book")) {
            creator = new BookCreator(args[0]);
        } else if (args[0].equals("note")) {
            creator = new NoteCreator(args[1], args[2]);
        } else {
            System.out.println("ERROR: Invalid document type. Please specify if book or note " +
                    "is to be compiled.");
            creator = null;
            System.exit(0);
        }
        try {
            creator.compile(args[3]);
            System.out.println("Query executed successfully.");
        } catch (RuntimeException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        System.exit(0);
    }
}
