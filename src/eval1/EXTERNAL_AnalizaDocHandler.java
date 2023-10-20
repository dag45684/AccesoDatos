package eval1;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

/**
 * Para poder hacer algo útil con los datos XML según se analizan,
 *  debemos usar un manejador de contenido.
 * Un manejador es una clase con una serie de métodos.
 * Estos mñetodos se ejecutan cuando el analizador detecta determinados eventos 
 * que se producen al leer un documento (empieza el documento, se abre un elemento,
 * se cierra, etc.).
 * añadimos el manejador, que implementa ContentHandler. Los métos se sobreescriben
 * con el código apropiado para el programa que estemos realizando en cada momento, 
 * en este caso añadiremos algo de código a los métodos del manejador para ilustrar
 * su funcionamiento. Simplemente escribiremos mensajes por la consola
 *  cuando se detecten los eventos.:
 */
public class EXTERNAL_AnalizaDocHandler implements ContentHandler {
	

	@Override
	public void setDocumentLocator(Locator locator) {
		// TODO Auto-generated method stub

	}

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println ("Empieza el análisis...");
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println ("...Termina el análisis");
	}

	@Override
	public void startPrefixMapping(String prefix, String uri) throws SAXException {
		// TODO Auto-generated method stub
		//los dos métodos que sirven para controlar las declaraciones de espacios de nombres
		//son startPrefixMapping y endPrefixMapping. 
		//El primero se ejecuta al declarar un espacio de nombres mediante el atributo xmlns, 
		//mientras que el segundo se ejecuta al cerrar el elemento en el que se declar� el espacio 
		//(normalmente el elemento ra�z):
		System.out.println("Comienza el uso del prefijo " + 
	            (prefix.equals("")? "(vacio)": prefix) +  
	            " correspondiente a la URI " + uri);
	}

	@Override
	public void endPrefixMapping(String prefix) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("Termina el uso del prefijo " + 
	            (prefix.equals("")? "(vacio)": prefix));  
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
		// TODO Auto-generated method stub
		//El comienzo y el final de cada elemento invocan a los m�todos startElement y endElement,
		//dentro ello tenemos informaci�n sobre el nombre del elemento, sus atributos y el espacio de nombres al que pertenece
		System.out.print("Se abre elemento: " + localName);
		if (!uri.equals("")) {
			  System.out.println(" URI " + uri + 
					    " (" + qName + ")");
					  } else {
					    System.out.println(" sin espacio de nombres asociado");
					  }
					  for (int i=0; i<atts.getLength(); i++) {
					    System.out.println("  Atributo: " + atts.getLocalName(i) +
					    "=" + atts.getValue(i));          
					  }
		  }


	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		 System.out.println("Se cierra elemento: " + localName + "\n");     
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		//La lectura del texto contenido en cada elemento genera una llamada al m�todo characters,
		//dentro del cual disponemos del texto en un vector de caracteres acotado con una posici�n de comienzo y otra de fin
		String s = new String(ch, start, length);
		  System.out.println("Contenido: " + s);
	}

	@Override
	public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		//El m�todo ignorableWhitespace lleva control de los espacios en blanco
	}

	@Override
	public void processingInstruction(String target, String data) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("PI: Destino:" + target + ", Datos:" + data);
	}

	@Override
	public void skippedEntity(String name) throws SAXException {
		// TODO Auto-generated method stub
		//Tiene lugar en algunos analizadores que se saltan las entidades cuando no est�n validando, pero es dif�cil encontrar casos as
	}

}