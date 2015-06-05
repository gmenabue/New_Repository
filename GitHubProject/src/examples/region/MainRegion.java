/**
 * 
 */
package examples.region;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Giordano Menabue
 *
 */
public class MainRegion {

	/**Método main para ejecutar el programa
	 * @param args
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//Aquí recuperamos todos los datos de la base de datos y los mostramos.
	List<RegionDTO> lista_regiones = new ArrayList<RegionDTO>();
	lista_regiones = RegionDAO.recuperarTodos();
	System.out.println(lista_regiones.toString());
	
	//Aquí recuperamos un dato dado su ID.
	RegionDTO region;
	region = RegionDAO.recuperarPorID(3);
	System.out.println(region);
	
	//Aquí agregamos un nuevo objeto a la base de datos.	
	
	RegionDTO nueva_region = new RegionDTO(5, "Oceanía");
	RegionDAO.insertar_region(nueva_region);
	System.out.println(nueva_region + ": Ha sido agregada exitosamente a la base de datos");
	
	
	//Aquí eliminamos objetos a la base de datos.
	/*
	boolean borrar_region;
	borrar_region = RegionDAO.delete_region(5);
	System.out.println("Región eliminada de la base de datos!");
	*/
	
	
		// TODO Auto-generated method stub

	}

}
