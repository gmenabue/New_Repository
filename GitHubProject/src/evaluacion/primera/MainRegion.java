/**
 * 
 */
package evaluacion.primera;

import java.util.ArrayList;
import java.util.List;

/**
 * @author alumno
 *
 */
public class MainRegion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<RegionDTO> lista_regiones = new ArrayList<RegionDTO>();
	lista_regiones = RegionDAO.recuperarPorID();
	System.out.println(lista_regiones.toString());
		// TODO Auto-generated method stub

	}

}
