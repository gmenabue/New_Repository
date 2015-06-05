/**
 * 
 */
package examples.region;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase para definir cómo accedemos a los datos.
 * @author Giordano Menabue
 *
 */
public class RegionDAO {
	
	
	/**
	 * Método para recuperar todas las regiones.
	 * @return Devuelve una lista con todos los datos obtenidos.
	 * @throws ClassNotFoundException 
	 * @throws SQLException
	 */
	public static List<RegionDTO> recuperarTodos()throws ClassNotFoundException, SQLException{
		List<RegionDTO>lista_region_all = null;
		RegionDTO region1;
		Statement stmt = null;
		Connection conexion = null;
		ResultSet rset = null;
		Savepoint save = null;
		
		try {
			//Creo un objeto PreparedStatement para llamar a la instruccion y darle el valor
			//que va a borrar de la base de datos.
			conexion = Conexion.obtenerConexion();
			stmt = conexion.createStatement(); 
			
			//Le digo que no haga commit automaticamente.
			conexion.setAutoCommit(false);
			
			//Creo un savepoint.
			save = conexion.setSavepoint();
			
			//Creo un objeto de ResultSet para almacenar los datos obtenidos para despues iterar sobre el.
			rset = stmt.executeQuery(InstrucionsSQL.consulta_region_all);
			//Creo un ArrayList para almacenar los resultados obtenidos.
			lista_region_all = new ArrayList<RegionDTO>();
			//Recorro el objeto de ResultSet para almacenar los resultados en el ArrayList.
				while (rset.next())
				{
			
					region1 = componerObjeto(rset);
					lista_region_all.add(region1);
					//Hago commit para que los cambios tengan efecto sobre la base de datos.
					conexion.commit();
				}
			}
		catch (ClassNotFoundException | SQLException e)
			{
			e.printStackTrace();
			}
		
		finally
		{
			//Liberamos los recursos!
			Conexion.liberarRecursos(conexion, stmt, rset);
		}
			
		
		return lista_region_all;
		
	}
	

	/**
	 * Método para recuperar las regiones por ID.
	 * @return Devuelvo un objeto de RegionDTO.
	 * @throws ClassNotFoundException 
	 * @throws SQLException
	 */
	public static RegionDTO recuperarPorID(int region_id)throws ClassNotFoundException, SQLException{
		
		RegionDTO region2 = null;
		Statement stmt = null;
		Connection conexion = null;
		ResultSet rset = null;
		Savepoint save = null;
		
		try {
			//Creo un objeto Connection y ejecuto la conexión, mediante el metodo obtenerConexion.
			conexion = Conexion.obtenerConexion();
			stmt = conexion.createStatement(); 
			
			//Le digo que no haga commit automaticamente.
			conexion.setAutoCommit(false);
			
			//Creo un savepoint.
			save = conexion.setSavepoint();
			
			//Creo un objeto PreparedStatement para llamar a la instruccion y darle el valor
			//que va a borrar de la base de datos.
			PreparedStatement pstmt = conexion.prepareStatement(InstrucionsSQL.consulta_region_id);
			pstmt.setInt(1, region_id);
			rset = pstmt.executeQuery();
			
			
				while (rset.next())
				{
			
					region2 = componerObjeto(rset);
					//Hago commit para que los cambios tengan efecto sobre la base de datos.
					conexion.commit();
			
				}
			}
		catch (ClassNotFoundException | SQLException e)
			{
			e.printStackTrace();
			}
		
		finally
		{
			//Liberamos los recursos!
			Conexion.liberarRecursos(conexion, stmt, rset);
		}
			
		
		return region2;
		
	}
	
	
	
	/**
	 * Método para insertar regiones a la base de datos.
	 * @param region3
	 * @throws ClassNotFoundException 
	 * @throws SQLException
	 */
	public static boolean insertar_region(RegionDTO region3)throws ClassNotFoundException, SQLException{
		boolean insertado = false;
		Statement stmt = null;
		Connection conexion = null;
		ResultSet rset = null;
		Savepoint save = null;
		
		try {
			//Creo un objeto Connection y ejecuto la conexión, mediante el metodo obtenerConexion.
			conexion = Conexion.obtenerConexion();
			stmt = conexion.createStatement(); 
			
			//Le digo que no haga commit automaticamente.
			conexion.setAutoCommit(false);
			
			//Creo un savepoint.
			save = conexion.setSavepoint();
			
			//Creo un objeto PreparedStatement para llamar a la instruccion y darle el valor
			//que va a borrar de la base de datos.
			PreparedStatement pstmt = conexion.prepareStatement(InstrucionsSQL.insertar_region);
			pstmt.setInt(1, region3.getREGION_ID());
			pstmt.setString(2, region3.getREGION_NAME());
			pstmt.executeQuery();
			insertado = true;
			System.out.println(insertado);
			
			//Hago commit para que los cambios tengan efecto sobre la base de datos.
			conexion.commit();
			
			}
		catch (ClassNotFoundException | SQLException e)
			{
			e.printStackTrace();
			}
		
		finally
		{
			//Liberamos los recursos!
			Conexion.liberarRecursos(conexion, stmt, rset);
		}
		return insertado;
			
		
	}
	
	
	
	/**
	 * Método para borrar regiones de la base de datos.
	 * @param region3
	 * @throws ClassNotFoundException 
	 * @throws SQLException
	 */
	public static boolean delete_region(int region_id)throws ClassNotFoundException, SQLException{
		boolean borrado = false;
		Statement stmt = null;
		Connection conexion = null;
		ResultSet rset = null;
		Savepoint save = null;
		
		try {
			//Creo un objeto Connection y ejecuto la conexión, mediante el metodo obtenerConexion.
			conexion = Conexion.obtenerConexion();
			stmt = conexion.createStatement(); 
			
			//Le digo que no haga commit automaticamente.
			conexion.setAutoCommit(false);
			
			//Creo un savepoint.
			save = conexion.setSavepoint();
			
			//Creo un objeto PreparedStatement para llamar a la instruccion y darle el valor
			//que va a borrar de la base de datos.
			PreparedStatement pstmt = conexion.prepareStatement(InstrucionsSQL.delete_region);
			pstmt.setInt(1, region_id);
			pstmt.executeQuery();
			borrado = true;
			//Hago commit para que los cambios tengan efecto sobre la base de datos.
			conexion.commit();
			System.out.println(borrado);
			
			}
		catch (ClassNotFoundException | SQLException e)
			{
			e.printStackTrace();
			}
		
		finally
		{
			//Liberamos los recursos!
			Conexion.liberarRecursos(conexion, stmt, rset);
		}
		return borrado;
			
		
	}
	
	
	
	/**
	 * Método para componer los objetos y anadir sus valores.
	 * @param rset
	 * @return Devuleve un objeto de RegionDTO.
	 * @throws SQLException
	 */
	private static RegionDTO componerObjeto(ResultSet rset) throws SQLException{
		RegionDTO region = null;
		
		//Compongo el objeto
		int REGION_ID = rset.getInt(1);
		String REGION_NAME = rset.getString(2);
		
		//Creo el objeto con los valores obtenidos
		region = new RegionDTO(REGION_ID, REGION_NAME);
		
		return region;
		
	}
}
