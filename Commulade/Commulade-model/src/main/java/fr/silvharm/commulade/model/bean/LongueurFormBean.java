package fr.silvharm.commulade.model.bean;


public class LongueurFormBean {
	
	private String cotation, height, nombrePoints;
	
	
	public LongueurFormBean() {}
	
	
	/********************************
	 * Getters & Setters
	 *******************************/
	
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
	 * @return the height
	 */
	public String getHeight() {
		return height;
	}
	
	
	/**
	 * @param height
	 *           the height to set
	 */
	public void setHeight(String height) {
		this.height = height;
	}
	
	
	/**
	 * @return the nombrePoints
	 */
	public String getNombrePoints() {
		return nombrePoints;
	}
	
	
	/**
	 * @param nombrePoints
	 *           the nombrePoints to set
	 */
	public void setNombrePoints(String nombrePoints) {
		this.nombrePoints = nombrePoints;
	}
}
