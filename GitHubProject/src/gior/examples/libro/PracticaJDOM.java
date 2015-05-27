package gior.examples.libro;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class PracticaJDOM {
	
	public static void main(String[] args) throws FileNotFoundException,
	JDOMException, IOException {
		

Integer contador = 0;
String titulo = null;
String autor = null;
String anyo = null;
String editorial = null;
String isbn = null;

List<Libro> lista_libro = new ArrayList<Libro>();


//CREAMOS EL PARSER
SAXBuilder builder = new SAXBuilder();


// Construimos el arbol DOM a partir del fichero xml
Document documentJDOM = builder.build(new FileInputStream("libros.xml"));


//MOSTRAMOS EL DOCUMENTO
Element raiz = documentJDOM.getRootElement();


// Recorremos los hijos de la etiqueta raíz
List<Element> libros = raiz.getChildren();


for (Element libro : libros) {
	
	Libro book = new Libro();
	//para cada libro, obtenemos su detalle
	 isbn = libro.getAttributeValue("isbn");
	//System.out.println(libro.getAttribute("isbn"));
	
	List<Element> detalles = libro.getChildren();

	for (Element detalle : detalles) {

		//System.out.println("Nombre =" + detalle.getName());
		//System.out.println("Valor =" + detalle.getValue());
		
		String etiqueta = detalle.getName();
		switch (etiqueta) {
		
		
		case "titulo" : titulo = detalle.getValue();
			break;
			
		case "autor" : autor = detalle.getValue();
		break;
		
		case "anyo" : anyo = detalle.getValue();
		break;
		
		case "editorial" : editorial = detalle.getValue();
		break;

		default: System.out.println("Error En El Elemento");
			break;
			
			
		}
		
		
	}
	
	book.setIsbn(isbn);	
	book.setTitulo(titulo);
	book.setAutor(autor);
	book.setAnyo(anyo);
	book.setEditorial(editorial);
	
	lista_libro.add(book);
	}

	OrdenarLibro ordenar = new OrdenarLibro();
	lista_libro.sort(ordenar);
	
	System.out.println(lista_libro);
		
	
	Element raiz2 = new Element("librosnuevos");
	Document doc = new Document(raiz2);
	doc.getRootElement();
	
	
	for (Libro l : lista_libro) {
		
		contador++;
		
		Element nuevo_libro = new Element("libro");
		nuevo_libro.addContent(l.getIsbn());
		raiz2.addContent(nuevo_libro);
		
		Element titulo1 = new Element("titulo");
		titulo1.addContent(l.getTitulo());
		nuevo_libro.addContent(titulo1);
		
		Element autor1 = new Element("autor");
		autor1.addContent(l.getAutor());
		nuevo_libro.addContent(autor1);
		
		Element anyo1 = new Element("anyo");
		anyo1.addContent(l.getAnyo());
		nuevo_libro.addContent(anyo1);
		
		Element editorial1 = new Element("editorial");
		editorial1.addContent(l.getEditorial());
		nuevo_libro.addContent(editorial1);
		
		/*Element total = new Element("total");
		total.setAttribute("total", contador.toString());
		nuevo_libro.addContent(total);		*/
		
	}
	
		raiz2.setAttribute("total", contador.toString());
		
		Format format = Format.getPrettyFormat();
	    // Creamos el serializador con el formato deseado  
	    XMLOutputter xmloutputter = new XMLOutputter(format);
	    // Serializamos el document parseado  
	    String docStr = xmloutputter.outputString(doc); 
	    //Volcamos en un fichero
	    FileWriter fw = new FileWriter("lsalida30.xml");
	    fw.write(docStr);
	    fw.close();
	



	}

}

	

