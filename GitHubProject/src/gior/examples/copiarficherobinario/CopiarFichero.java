/**
 * 
 */
package gior.examples.copiarficherobinario;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**Clase creada con el proposito de copiar ficheros binarios.
 * @author Giordano Menabue
 *
 */
public class CopiarFichero {
	/**
	 * Método que sirve para copiar ficheros binarios.
	 * @param fichero_origen
	 * @param fichero_destino
	 * @return
	 * @throws IOException
	 */
	private static boolean copiaFichero ( String fichero_origen, String fichero_destino) throws IOException
	{
		boolean copiado = true;
		
		
		File origen = new File(fichero_origen);//Creamos el objeto para almacenar el fichero de origen.
		FileInputStream input = new FileInputStream(origen);//Creamos un objeto de fileImputStream para leer del archivo.
		
		File destino = new File(fichero_destino);//Creamos un objeto para almacenar el fichero destino.	
		FileOutputStream output = new FileOutputStream(destino);//Creamos un objeto de fileOutputStream para escribir en el nuevo archivo.
		
		int i;//Creo una variable para almacenar el valor del contador.
		for (i = 0; i < fichero_origen.length(); i++){//Recorremos el contenido del fichero
			
		}
		
		byte[] contenido = new byte[i];//Declaro la variable contenido para almacenar lo leido y le doy el tamaño de i que es el contador del tamaño del fichero.
		@SuppressWarnings("unused")
		int len = 0;
		 
		while ((input.read(contenido)) > -1) 
		{
		  (output).write(contenido);
		  
		}
		input.close();
		output.close();
		System.out.println("Archivo Copiado");
		return copiado;
	}
	

	/**Método main, para ejecutar el programa.
	 * @param args
	 * @throws IOException 
	 */
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws IOException {
		
		CopiarFichero cf = new CopiarFichero();
		cf.copiaFichero("tigre.jpg", "copiatigre.jpg");
		// TODO Auto-generated method stub

		
	}

}
