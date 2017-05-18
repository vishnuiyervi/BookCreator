import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by vishnuiyer on 5/17/17.
 */
public interface Creator {
    /** compiles XML file into LaTeX document "filename.tex" */
    void compile(String filename) throws Exception;
}
