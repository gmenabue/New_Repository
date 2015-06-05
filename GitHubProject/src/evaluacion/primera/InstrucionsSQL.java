/**
 * 
 */
package evaluacion.primera;

/**
 * @author alumno
 *
 */
public class InstrucionsSQL {
	
	public static final String consulta_region_all = "SELECT * FROM REGIONS";
	
	
	public static final String consulta_region_id = "SELECT * FROM REGIONS WHERE REGION_ID = ?";
	
	
	public static final String insertar_region = "INSERT INTO REGIONS (region_id, region_name) VALUES (?,?)";

}
