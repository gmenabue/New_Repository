package gior.examples.libro;

import java.io.FileInputStream;
import java.io.IOException;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class ProcesoSAX {

	public static void main(String[] args) {  
		
		
			Libro libro = new Libro();
			
			LibroXML libro_xml = new LibroXML(libro);
		 
	      try {  
	         // Creamos nuestro objeto libro vacío  
	    	 //Libro libro = new Libro();  
	         // Creamos la factoria de parseadores por defecto  
	         XMLReader reader = XMLReaderFactory.createXMLReader();  
	         // Añadimos nuestro manejador al reader pasandole el objeto libro  
	         reader.setContentHandler(libro_xml);           
	         // Procesamos el xml de ejemplo  
	         reader.parse(new InputSource(new FileInputStream("libros.xml")));  
	         
	         
	       
	      
	                 
	      } catch (SAXException e) {  
	         e.printStackTrace();  
	      } catch (IOException e) {  
	         e.printStackTrace();  
	      }  
	  
	   }  
}
