/**
 * 
 */
package gior.examples.basededatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.List;

/**
 * @author alumno
 *
 */
public class PracticaBaseDeDatos {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		List<EmpleadoDTO> array_empleados = new MiArrayList();
		//Map<Integer, Empleado> map_empleado = new TreeMap<Integer, Empleado>();
		EmpleadoDTO empleado = null;

		Connection conn = null;
		ResultSet rset = null;
		Statement stmt = null;
		Savepoint save = null;
		
		
		
		
		try
		{
			//registro el driver, en realidad, hago que se ejecuten unas pocas líneas de la clase OracleDriver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());// método equivalente al anterior
			//Sea como sea, es, <<oye, si te piden una conexión, se la pides a esa clase!>>
			
			conn = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe", "HR", "GIOR1987");
			
			//Usamos la clase Connection para crear una conexión
  	        stmt = conn.createStatement();
  	        
  	        conn.setAutoCommit(false);
  	        save = conn.setSavepoint();
  	        //Creamos un objeto de PreparedStatement para indicar la sentencia
  	        PreparedStatement pstmt = conn.prepareStatement("Select * from employees where salary > 3000 order by salary");
  	        
  	        //ResultSet es la clase que emplearemos para gestionar los resultados de nuestras conusultas
  	        rset = pstmt.executeQuery();
  	        
  	        
  	        
  	        //Deberemos iterar sobre él, para ir recorriendo los resultados de nuestras consultas

  	      while (rset.next()){
		        // rset.getString();
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
  	    	
  	    	array_empleados.add(empleado);
  	    	//map_empleado.put(empleado.getSALARY(), empleado);
		    conn.commit();  
		}

  	      //System.out.println(map_empleado);
  	      System.out.println(array_empleados);
		
			
		}
		catch(Exception e)
		{
			conn.rollback(save);
			e.printStackTrace();
			
		}
		finally //libero recursos, de "adentro a fuera" , ResultSet, Statment, Conexion
		{
			if (rset != null) 	{ try { rset.close(); } catch (Exception e2) { e2.printStackTrace(); }}
			if (stmt != null)	{ try {	stmt.close(); } catch (Exception e2) { e2.printStackTrace(); }}
			if (conn != null) 	{ try { conn.close(); } catch (Exception e3) { e3.printStackTrace(); }}
		  	   
		}   

	}

}
