/**
 * Created by vishnuiyer on 5/17/17.
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class BookCreator implements Creator {
    private File file;
    private PrintWriter writer;

    /** constructor for the class, takes in XML file name (without the ".xml" at the end which
     * will be compiled */
    public BookCreator(String filename) throws Exception {
        file = new File(filename + ".xml");
        writer = new PrintWriter(new BufferedWriter(new FileWriter(file)));
    }

    /** Given the string "filename", create a file "filename.tex" which contains the content of the
     *  book */
    public void compile(String filename) throws Exception {

    }
}
