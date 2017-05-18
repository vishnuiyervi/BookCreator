/**
 * Created by vishnuiyer on 5/17/17.
 */
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class NoteHandler extends DefaultHandler {
    public void startElement(String uri, String localName, String qname, Attributes attributes)
        throws SAXException {
        if (qname.equalsIgnoreCase(""))
    }
}
