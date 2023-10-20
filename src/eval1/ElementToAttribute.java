package eval1;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class ElementToAttribute {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException {
		//existing xml
		File f = new File("rndData\\Empleados.xml");
		
		//instances of the builder
		DocumentBuilderFactory raf = DocumentBuilderFactory.newInstance();
	    DocumentBuilder builder = raf.newDocumentBuilder();
	    Document d = builder.parse(f);

	    //we get the root
	    Element root = d.getDocumentElement();
	    //then for getting the childs divide by two since it gets the open and close tag for some reason
	    for (int i=0; i<root.getChildNodes().getLength()/2; i++) {
			Element parent = (Element) root.getElementsByTagName("empleado").item(i); //get the tag at i
			Element child = (Element) parent.getElementsByTagName("id").item(0); //get its id
			parent.setAttribute("id", child.getTextContent()); //set the id as attribute
			parent.removeChild(child); //remove the inner tag
	    }

	    //instances of the transformer
		Source src = new DOMSource(d);
		StreamResult res = new StreamResult(new File("rndData\\EmpleadosEDIT.xml"));
		Transformer tr = TransformerFactory.newInstance().newTransformer();
		tr.transform(src, res);
	}

}
