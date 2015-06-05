package evaluacion.primera;
/**
 * Clase para construir el dato.
 * @author Giordano Menabue
 *
 */
public class RegionDTO {

	int REGION_ID = 0;
	String REGION_NAME = "";
	
	/**
	 * Construnctor de la clase Región.
	 * @param region_id
	 * @param region_name
	 */
	public RegionDTO(int region_id, String region_name) {
		super();
		this.REGION_ID = region_id;
		this.REGION_NAME = region_name;
	}

	/**
	 * @return the region_id
	 */
	public int getREGION_ID() {
		return REGION_ID;
	}

	/**
	 * @param region_id the region_id to set
	 */
	public void setREGION_ID(int region_id) {
		REGION_ID = region_id;
	}

	/**
	 * @return the region_name
	 */
	public String getREGION_NAME() {
		return REGION_NAME;
	}

	/**
	 * @param region_name the region_name to set
	 */
	public void setREGION_NAME(String region_name) {
		REGION_NAME = region_name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RegionDTO [REGION_ID=" + REGION_ID + ", REGION_NAME="
				+ REGION_NAME + "]";
	}
	
	
}
