/**
 * 
 */
package gior.examples.basededatos;

import java.sql.SQLException;
import java.util.List;

/**
 * @author alumno
 *
 */
public class MainBaseDeDatos {

	/**
	 * @param args
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
			 
				List<EmpleadoDTO> lista_empleados = new MiArrayList();
				lista_empleados = EmpleadoDAO.recuperarTodos();
				System.out.println(lista_empleados.toString());
		
		/*
		 * EmpleadoDAO.recuperarTodos
		 */
		// TODO Auto-generated method stub

	}

}
