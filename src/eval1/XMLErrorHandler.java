package eval1;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.XMLReader;

public class XMLErrorHandler {
	public static void main(String[] args) {
		String path = "rndData\\Empleados.xml";
		try {
			SAXParserFactory sFact = SAXParserFactory.newInstance();
			SAXParser sp = sFact.newSAXParser();
			XMLReader reader = sp.getXMLReader();
			reader.parse(path);
			reader.setContentHandler(new EXTERNAL_AnalizaDocHandler());
			System.out.println("End of the analysis");
		}catch (Exception e) { System.err.println("Something went wrong: " + e);}
	}

}
