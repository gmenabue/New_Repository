/**
 * 
 */
package gior.examples.ficheropropiedades;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;



/**
 * @author Giordano Menabue
 *
 */
public class MainCuento {
	
	public static void fichero_propiedades(FileInputStream fis) throws IOException {
		
		
		Properties propiedades = new Properties ();
		File f = null;
		FileWriter fw = null;
		propiedades.load(fis);
		
		
		f = new File(propiedades.getProperty("outfile"));
		f.createNewFile();
		fw = new FileWriter(f);
		fw.write(propiedades.getProperty("start")+"\n");
		fw.write(propiedades.getProperty("body")+"\n");
		fw.write(propiedades.getProperty("end")+"\n");
		fw.close();
		
        
	}
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = null;
		
		switch (args[1]) {
		case "IT":
			System.out.print("Italiano: ");
			fis = new FileInputStream("story_it.properties");
			break;
		case "EN":
			System.out.print("Ingles: ");
			fis = new FileInputStream("story_en.properties");
			break;
			
		case "ES":
			System.out.print("Espa�ol: ");
			fis = new FileInputStream("story_es.properties");
			break;	

		default: 
			System.out.print("Idioma no existe: ");
			break;
		}
		
		fichero_propiedades(fis);
		
		// TODO Auto-generated method stub

	}

}
