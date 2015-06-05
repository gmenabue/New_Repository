/**
 * 
 */
package examples.region;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Giordano Menabue
 *
 */
public class MiArrayList extends ArrayList<RegionDAO> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6156832175880340560L;
	
	
	
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
		Iterator<RegionDAO> iterador_empleados = super.iterator();
		while (iterador_empleados.hasNext()) {
			devolver += iterador_empleados.next()+ "\n";
			//devolver = devolver + iterador_empleados.next()+ "\n";
			//Tambien se puede hacer de esta manera!!
		}
		return devolver;
	}




	
}
