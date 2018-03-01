package fr.silvharm.commulade.model.bean;


public class SiteSearchFormBean {
	
	private String cotation, maxHeight, minHeight, maxPointNumber, minPointNumber, siteName;
	
	
	public SiteSearchFormBean() {
		
	}
	
	
	/**
	 * @param siteName
	 * @param maxHeight
	 * @param minHeight
	 * @param maxPointNumber
	 * @param minPointNumber
	 * @param minVoieNumber
	 */
	public SiteSearchFormBean(String siteName, String maxHeight, String minHeight, String maxPointNumber,
			String minPointNumber, String cotation) {
		this.siteName = siteName;
		this.maxHeight = maxHeight;
		this.minHeight = minHeight;
		this.maxPointNumber = maxPointNumber;
		this.minPointNumber = minPointNumber;
		this.cotation = cotation;
	}
	
	
	/**
	 * @return the maxHeight
	 */
	public String getMaxHeight() {
		return maxHeight;
	}
	
	
	/**
	 * @param maxHeight
	 *           the maxHeight to set
	 */
	public void setMaxHeight(String maxHeight) {
		this.maxHeight = maxHeight;
	}
	
	
	/**
	 * @return the minHeight
	 */
	public String getMinHeight() {
		return minHeight;
	}
	
	
	/**
	 * @param minHeight
	 *           the minHeight to set
	 */
	public void setMinHeight(String minHeight) {
		this.minHeight = minHeight;
	}
	
	
	/**
	 * @return the maxPointNumber
	 */
	public String getMaxPointNumber() {
		return maxPointNumber;
	}
	
	
	/**
	 * @param maxPointNumber
	 *           the maxPointNumber to set
	 */
	public void setMaxPointNumber(String maxPointNumber) {
		this.maxPointNumber = maxPointNumber;
	}
	
	
	/**
	 * @return the minPointNumber
	 */
	public String getMinPointNumber() {
		return minPointNumber;
	}
	
	
	/**
	 * @param minPointNumber
	 *           the minPointNumber to set
	 */
	public void setMinPointNumber(String minPointNumber) {
		this.minPointNumber = minPointNumber;
	}
	
	
	/**
	 * @return the cotation
	 */
	public String getCotation() {
		return cotation;
	}
	
	
	/**
	 * @param cotation
	 *           the cotation to set
	 */
	public void setCotation(String cotation) {
		this.cotation = cotation;
	}
	
	
	/**
	 * @return the siteName
	 */
	public String getSiteName() {
		return siteName;
	}
	
	
	/**
	 * @param siteName
	 *           the siteName to set
	 */
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	
}
