package eval1;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class XMLCreator {

	public static void main(String[] args) throws IOException {
		File f = new File("rndData\\AleatorioEmple.dat");
		RandomAccessFile raf = new RandomAccessFile(f, "r");
		int id = 0;
		int dept = 0;
		int pos = 0;
		double salary = 0;
		char aux;
		String surname = "";
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			DOMImplementation dimp = builder.getDOMImplementation();
			Document d = dimp.createDocument(null, "Empleados", null);
			d.setXmlVersion("1.0");
			
			while(true) {
				raf.seek(pos);
				id = raf.readInt();
				for(int i=0; i<10; i++) {
					aux = raf.readChar();
					surname += aux;
				}
				dept = raf.readInt();
				salary = raf.readDouble();
				
				if(id>0) {
					Element root = d.createElement("empleado");
					d.getDocumentElement().appendChild(root);
					
					newElement("id", Integer.toString(id), root, d);
					newElement("apellido", surname.replaceAll("\\W+", ""), root, d);
					newElement("dept", Integer.toString(dept), root, d);
					newElement("salario", Double.toString(salary), root, d);
				}
				surname = "";
				pos += 36;
				if (raf.getFilePointer() >= raf.length()) break;
			}
			Source src = new DOMSource(d);
			StreamResult res = new StreamResult(new File("rndData\\Empleados.xml"));
			Transformer tr = TransformerFactory.newInstance().newTransformer();
			tr.transform(src, res);
			
		}catch (Exception e) {System.err.println("Something went wrong: " + e);}
		raf.close();

	}
	
	public static void newElement(String dat, String val, Element root, Document d) {
		Element e = d.createElement(dat);
		Text t = d.createTextNode(val);
		root.appendChild(e);
		e.appendChild(t);
	}

}
