import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.io.*;
import java.util.Scanner;

/**
 * Created by vishnuiyer on 5/17/17.
 */
public class NoteCreator implements Creator {
    private File file;
    private File template;

    /** constructor for the class, takes in XML file name (without the ".xml" at the end which
     * will be compiled */
    public NoteCreator(String filename, String templateName) throws Exception {
        file = new File(filename + ".xml");
        System.out.println("Reading file at " + filename + ".xml");
        template = new File(templateName + ".tex");
        System.out.println("Reading template at " + templateName + ".tex");
    }

    /** Given the string "filename", create a file "filename.tex" which contains the content of the
     *  note */
    public void compile(String filename) throws Exception {
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(new File(filename
                + ".tex"))));
        System.out.println("Writing to file at " + filename +".tex");
        initialize(writer, template);
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        parser.parse(file, new NoteHandler());
        terminate(writer);
    }

    void initialize(PrintWriter writer, File template) throws Exception {
        System.out.println("Initializing preamble.");
        writer.println("\\documentclass[12pt]{article}");
        Scanner temp = new Scanner(template);
        boolean importedGeometry = false;
        while(temp.hasNext()) {
            String line = temp.nextLine();
            if (line.contains("{geometry}")) {
                importedGeometry = true;
            }
            if (line.contains("\\begin{document}")) {
                throw new RuntimeException("Template file is full document.");
            }
            writer.println(line);
        }
        if (!importedGeometry) {
            writer.println("\\usepackage[margin=0.7in]{geometry}");
        }
        writer.println("\\begin{document}");
    }

    void terminate(PrintWriter writer) {
        System.out.println("Terminating write process.");
        writer.println("\\end{document}");
        writer.close();
    }
}
