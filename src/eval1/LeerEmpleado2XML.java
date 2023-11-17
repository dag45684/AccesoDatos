package eval1;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class LeerEmpleado2XML {

	public static void main(String[] args) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document d = (Document) builder.parse(new File("rndData\\EmpleadosEDIT.xml"));
			d.getDocumentElement().normalize();
			System.out.println("Root: " + d.getDocumentElement().getNodeName());
			NodeList l = d.getElementsByTagName("empleado");
			
			for(int i=0; i<l.getLength(); i++) {
				Element e = (Element) l.item(i);
				System.out.println("Id: " + e.getAttribute("id"));
				System.out.println("Surname: " + e.getElementsByTagName("apellido").item(0).getTextContent());
				System.out.println("dept: " + e.getElementsByTagName("dept").item(0).getTextContent());
				System.out.println("salary: " + e.getElementsByTagName("salario").item(0).getTextContent() + '\n');
			}
		} catch (Exception e) { System.err.println("Something went wrong: " + e);}
	
	}

}
