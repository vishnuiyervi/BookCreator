import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by vishnuiyer on 5/17/17.
 */
public interface Creator {
    /** compiles XML file into LaTeX document "filename.tex" */
    void compile(String filename) throws Exception;

    default void initialize(PrintWriter writer, String template) throws IOException {
        writer.println("\\documentclass[12pt]{article}");
        writer.println("\\usepackage[margin=0.7in]{geometry}");
        writer.println("\\usepackage{article}");
    }
}
