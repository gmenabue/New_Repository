/**
 * 
 */
package examples.region;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Giordano Menabue
 *
 */
public class MainRegion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	List<RegionDTO> lista_regiones = new ArrayList<RegionDTO>();
	lista_regiones = RegionDAO.recuperarTodos();
	System.out.println(lista_regiones.toString());
	
	RegionDTO region;
	region = RegionDAO.recuperarPorID(1);
	System.out.println(region);
	
	RegionDTO nueva_region = new RegionDTO(5, "Ocean�a");
	RegionDAO.insertar_region(nueva_region);
	System.out.println(nueva_region + "ha sido agregada exitosamente a la base de datos");
	
		// TODO Auto-generated method stub

	}

}
