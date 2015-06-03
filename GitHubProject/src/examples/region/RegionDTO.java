package examples.region;

public class RegionDTO {

	int REGION_ID = 0;
	String REGION_NAME = "";
	
	/**
	 * Construnctor de la clase Región.
	 * @param rEGION_ID
	 * @param rEGION_NAME
	 */
	public RegionDTO(int region_id, String region_name) {
		super();
		this.REGION_ID = region_id;
		this.REGION_NAME = region_name;
	}

	/**
	 * @return the rEGION_ID
	 */
	public int getREGION_ID() {
		return REGION_ID;
	}

	/**
	 * @param rEGION_ID the rEGION_ID to set
	 */
	public void setREGION_ID(int rEGION_ID) {
		REGION_ID = rEGION_ID;
	}

	/**
	 * @return the rEGION_NAME
	 */
	public String getREGION_NAME() {
		return REGION_NAME;
	}

	/**
	 * @param rEGION_NAME the rEGION_NAME to set
	 */
	public void setREGION_NAME(String rEGION_NAME) {
		REGION_NAME = rEGION_NAME;
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
