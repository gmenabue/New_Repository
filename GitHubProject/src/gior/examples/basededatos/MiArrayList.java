/**
 * 
 */
package gior.examples.basededatos;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Giordano Menabue
 *
 */
public class MiArrayList extends ArrayList<EmpleadoDTO> {
	
	/**
	 * Constructor de la clase MiArrayList
	 */
	public MiArrayList() {
		super();
		// TODO Auto-generated constructor stub
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String devolver = "";
		
		//Iterador para recorrer el String
		Iterator<EmpleadoDTO> iterador_empleados = super.iterator();
		while (iterador_empleados.hasNext()) {
			devolver += iterador_empleados.next()+ "\n";
			//devolver = devolver + iterador_empleados.next()+ "\n";
			//Tambien se puede hacer de esta manera!!
		}
		return devolver;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = -6156832175880340560L;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
