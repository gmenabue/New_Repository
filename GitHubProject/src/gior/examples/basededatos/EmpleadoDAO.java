/**
 * 
 */
package gior.examples.basededatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


/**
 * @author alumno
 *
 */
public class EmpleadoDAO {
	
	
	
	public static List<EmpleadoDTO> recuperarTodos() throws ClassNotFoundException, SQLException{
		
		List<EmpleadoDTO>array_empleado_dto = null;
		EmpleadoDTO empleado1 = null;
		Statement stmt = null;
		Connection conexion = null;
		ResultSet rset = null;
	
	
	
	conexion = Conexionbd.obtenerConexion();
	
	
    stmt = conexion.createStatement(); 
	rset = stmt.executeQuery(InstruccionesSQL.consulta_empleado);
	array_empleado_dto = new MiArrayList();
	while (rset.next()) {
		
		empleado1 = componerObjeto(rset);
		array_empleado_dto.add(empleado1);
		
		
	}
		Conexionbd.liberarRecursos(conexion, stmt, rset);
    	return array_empleado_dto;
	}

	private static EmpleadoDTO componerObjeto(ResultSet rset) throws SQLException {
		
		EmpleadoDTO empleado = null;
		
		
	    	int EMPLOYEE_ID = rset.getInt(1);
	    	String FIRST_NAME = rset.getString(2);
	    	String LAST_NAME = rset.getString(3);
	    	String EMAIL = rset.getString(4);
	    	String PHONE_NUMBER = rset.getString(5);
	    	String HIRE_DATE = rset.getString(6);
	    	String JOB_ID = rset.getString(7);
	    	int SALARY = rset.getInt(8);
	    	int COMISSION_PCT = rset.getInt(9);
	    	int MANAGER_ID = rset.getInt(10);
	    	int DEPARTMENT_ID = rset.getInt(11);
	    	
	    	empleado = new EmpleadoDTO(EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, HIRE_DATE,
	    			JOB_ID, SALARY, COMISSION_PCT, MANAGER_ID, DEPARTMENT_ID);
	    	
	    	
		 return empleado;
	}


}
