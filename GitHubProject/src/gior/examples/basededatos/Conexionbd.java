package gior.examples.basededatos;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class Conexionbd {
	//obtener conexion
	//liberar recursos
	//implementar el patron single tone (solo se va a tener un objeto de esa clase)
	
	
	Connection connection ;
	static ResultSet rset ;
	static Statement stmt ;
	static Savepoint save ;
	private static Conexionbd conexion = new Conexionbd();





private Conexionbd()  {
	        
	        
}

public Connection nueva_conexion() throws ClassNotFoundException, SQLException {
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

public static  Connection obtenerConexion () throws ClassNotFoundException, SQLException{
	
	return conexion.nueva_conexion();
}



	
	public static void liberarRecursos (Connection conn, Statement stmt, ResultSet rset)
	{
		//libero recursos, de "adentro a fuera" , ResultSet, Statment, Conexion
		if (rset != null) 	{ try { rset.close(); } catch (Exception e2) { e2.printStackTrace(); }}
		if (stmt != null)	{ try {	stmt.close(); } catch (Exception e2) { e2.printStackTrace(); }}
		if (conn != null) 	{ try { conn.close(); } catch (Exception e3) { e3.printStackTrace(); }}
	}
	




/**
 * @param args
 */
public static void main(String[] args) {
	
	
	
	
	
	// TODO Auto-generated method stub

}

}

