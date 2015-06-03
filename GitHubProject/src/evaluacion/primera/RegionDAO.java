/**
 * 
 */
package evaluacion.primera;

import gior.examples.basededatos.Conexionbd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Giordano Menabue
 *
 */
public class RegionDAO {
	
	
	
	/**
	 * Método para recuperar todas las regiones
	 * @return
	 */
	public static List<RegionDTO> recuperarTodos(){
		List<RegionDTO>lista_region_all = null;
		RegionDTO region1;
		Statement stmt = null;
		Connection conexion = null;
		ResultSet rset = null;
		
		try {
			conexion = Conexion.obtenerConexion();
			stmt = conexion.createStatement(); 
			rset = stmt.executeQuery(InstrucionsSQL.consulta_region_all);
			lista_region_all = new ArrayList<RegionDTO>();
				while (rset.next())
				{
			
					region1 = componerObjeto(rset);
					lista_region_all.add(region1);
			
				}
			}
		catch (ClassNotFoundException | SQLException e)
			{
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		
		finally
		{
			Conexionbd.liberarRecursos(conexion, stmt, rset);
		}
			
		
		return lista_region_all;
		
	}

	/**
	 * Método para recuperar las regiones por ID
	 * @return
	 */
	public static List<RegionDTO> recuperarPorID(){
		List<RegionDTO>lista_region_id = null;
		RegionDTO region2 = null;
		Statement stmt = null;
		Connection conexion = null;
		ResultSet rset = null;
		
		try {
			conexion = Conexion.obtenerConexion();
			stmt = conexion.createStatement(); 
			PreparedStatement pstmt = conexion.prepareStatement(InstrucionsSQL.consulta_region_id);
			pstmt.setInt(1, 1);
			rset = pstmt.executeQuery();
			
			lista_region_id = new ArrayList<RegionDTO>();
				while (rset.next())
				{
			
					region2 = componerObjeto(rset);
					lista_region_id.add(region2);
			
				}
			}
		catch (ClassNotFoundException | SQLException e)
			{
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		
		finally
		{
			Conexionbd.liberarRecursos(conexion, stmt, rset);
		}
			
		
		return lista_region_id;
		
	}
	
	
	/**
	 * 
	 * @param rset
	 * @return
	 * @throws SQLException
	 */
	private static RegionDTO componerObjeto(ResultSet rset) throws SQLException{
		RegionDTO region = null;
		
		int REGION_ID = rset.getInt(1);
		String REGION_NAME = rset.getString(2);
		
		region = new RegionDTO(REGION_ID, REGION_NAME);
		
		return region;
		
	}
}
