/**
 * Created by vishnuiyer on 5/17/17.
 */
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.PrintWriter;

public class NoteHandler extends DefaultHandler {
    private boolean bnote = false;
    private boolean bsection = false;
    private boolean bsubsection = false;
    private boolean bdef = false;
    private boolean bthm = false;
    private boolean blemma = false;
    private boolean bprp = false;
    private boolean brmk = false;
    private boolean bhighlight = false;
    private boolean bmath = false;
    private boolean bdmath = false;
    private boolean bproof = false;
    private PrintWriter writer;

    public NoteHandler(PrintWriter writer) {
        this.writer = writer;
    }

    @Override
    public void startElement(String uri, String localName, String qname, Attributes attributes)
        throws SAXException {
        if (qname.equalsIgnoreCase("note")) {
            bnote = true;
            String name = attributes.getValue("name");
            String number = attributes.getValue("number");
            writer.printf("\\makeheading{%s}{%s}\n", number, name);
        } else if (qname.equalsIgnoreCase("section")) {
            bsection = true;
            String name = attributes.getValue("name");
            writer.printf("\\sect{%s}\n", name);
        } else if (qname.equalsIgnoreCase("subsection")) {
            bsubsection = true;
            String name = attributes.getValue("name");
            writer.printf("\\subsection{%s}\n", name);
        } else if (qname.equalsIgnoreCase("def")) {
            bdef = true;
            String name = attributes.getValue("name");
            writer.printf("\\begin{definition}{%s}\n", name);
        } else if (qname.equalsIgnoreCase("thm")) {
            bthm = true;
            String name = attributes.getValue("name");
            writer.printf("\\begin{theorem}{%s}\n", name);
        } else if (qname.equalsIgnoreCase("lemma")) {
            blemma = true;
            writer.printf("\\begin{lemma}\n");
        } else if (qname.equalsIgnoreCase("prp")) {
            bprp = true;
            writer.printf("\\begin{proposition}\n");
        } else if (qname.equalsIgnoreCase("rmk")) {
            brmk = true;
            writer.printf("\\begin{remark}\n");
        } else if (qname.equalsIgnoreCase("highlight")) {
            bhighlight = true;
            writer.printf("\\highlight{");
        } else if (qname.equalsIgnoreCase("math")) {
            bmath = true;
            writer.printf(" $ ");
        } else if (qname.equalsIgnoreCase("dmath")) {
            bdmath = true;
            writer.printf("$$");
        } else if (qname.equalsIgnoreCase("proof")) {
            bproof = true;
            writer.printf("\\begin{proof}\n");
        }
    }

    @Override
    public void endElement(String uri, String localName, String qname)
            throws SAXException {
        if (qname.equalsIgnoreCase("note")) {
            bnote = false;
        } else if (qname.equalsIgnoreCase("section")) {
            bsection = false;
        } else if (qname.equalsIgnoreCase("subsection")) {
            bsubsection = false;
        } else if (qname.equalsIgnoreCase("def")) {
            bdef = false;
            writer.printf("\\end{definition}\n");
        } else if (qname.equalsIgnoreCase("thm")) {
            bthm = false;
            writer.printf("\\end{theorem}\n");
        } else if (qname.equalsIgnoreCase("lemma")) {
            blemma = false;
            writer.printf("\\end{lemma}\n");
        } else if (qname.equalsIgnoreCase("prp")) {
            bprp = false;
            writer.printf("\\end{proposition}\n");
        } else if (qname.equalsIgnoreCase("rmk")) {
            brmk = false;
            writer.printf("\\end{remark}\n");
        } else if (qname.equalsIgnoreCase("highlight")) {
            bhighlight = false;
            writer.printf("}");
        } else if (qname.equalsIgnoreCase("math")) {
            bmath = false;
            writer.printf(" $");
        } else if (qname.equalsIgnoreCase("dmath")) {
            bdmath = false;
            writer.printf("$$");
        } else if (qname.equalsIgnoreCase("proof")) {
            bproof = false;
            writer.printf("\\end{proof}\n");
        }
    }

    @Override
    public void characters(char [] ch, int start, int length) {
        writer.print(new String(ch, start, length).trim());
    }
}
