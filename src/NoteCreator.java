import javax.xml.parsers.SAXParser;
import java.io.*;

/**
 * Created by vishnuiyer on 5/17/17.
 */
public class NoteCreator implements Creator {
    private File file;
    private PrintWriter writer;

    /** constructor for the class, takes in XML file name (without the ".xml" at the end which
     * will be compiled */
    public NoteCreator(String filename) throws Exception {
        file = new File(filename + ".xml");
        writer = new PrintWriter(new BufferedWriter( new FileWriter(file)));
    }

    /** Given the string "filename", create a file "filename.tex" which contains the content of the
     *  note */
    public void compile(String filename) throws Exception {

    }
}
