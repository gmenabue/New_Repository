package evaluacion.primera;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;


/**Clase conectarse al servidor!
 * @author Giordano Menabue
 *
 */
public class Conexion {
	//obtener conexion
	//liberar recursos
	//implementar el patron single tone (solo se va a tener un objeto de esa clase)
	
	
	static ResultSet rset ;
	static Statement stmt ;
	static Savepoint save ;
	private static Conexion conexion = new Conexion();




/**
 * Constructor de la clase conexion
 */
private Conexion()  {
	   //Constructor de la clase conexion!!     	        
}


/**
 * Método para conectarnos a la base de datos
 * @return
 * @throws ClassNotFoundException
 * @throws SQLException
 */
public Connection nueva_conexion() throws ClassNotFoundException, SQLException 
{
	
		Connection conn = null;
		//registro el driver, en realidad, hago que se ejecuten unas pocas líneas de la clase OracleDriver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());// método equivalente al anterior
		//Sea como sea, es, <<oye, si te piden una conexión, se la pides a esa clase!>>
			
		conn = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe", "HR", "GIOR1987");
			
		//Usamos la clase Connection para crear una conexión
		stmt = conn.createStatement();
		        
		//connection.setAutoCommit(false);
	
	return conn;
	
	
}

/**
 * Clase para obtener una conexión ya que usamos en metodo singleton y el constructor es privado!
 * @return
 * @throws ClassNotFoundException
 * @throws SQLException
 */
public static  Connection obtenerConexion () throws ClassNotFoundException, SQLException{
	
	return conexion.nueva_conexion();
}



	/**
	 * Método para cerrar las conexiones y liberar los recursos
	 * @param conn
	 * @param stmt
	 * @param rset
	 */
	public static void liberarRecursos (Connection conn, Statement stmt, ResultSet rset)
	{
		//libero recursos, de "adentro a fuera" , ResultSet, Statment, Conexion
		if (rset != null) 	{ try { rset.close(); } catch (Exception e2) { e2.printStackTrace(); }}
		if (stmt != null)	{ try {	stmt.close(); } catch (Exception e2) { e2.printStackTrace(); }}
		if (conn != null) 	{ try { conn.close(); } catch (Exception e3) { e3.printStackTrace(); }}
	}

}

