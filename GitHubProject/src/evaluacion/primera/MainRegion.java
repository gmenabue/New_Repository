/**
 * 
 */
package evaluacion.primera;

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
	region = RegionDAO.recuperarPorID(3);
	System.out.println(region);
	
	
	RegionDTO nueva_region = new RegionDTO(5, "Oceanía");
	RegionDAO.insertar_region(nueva_region);
	System.out.println(nueva_region + ": Ha sido agregada exitosamente a la base de datos");
	
	
	/*
	boolean borrar_region;
	borrar_region = RegionDAO.delete_region(5);
	System.out.println("Región eliminada de la base de datos!");
	*/
	
	
		// TODO Auto-generated method stub

	}

}
