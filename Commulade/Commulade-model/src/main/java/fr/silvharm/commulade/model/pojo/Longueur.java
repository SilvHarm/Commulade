package fr.silvharm.commulade.model.pojo;


public class Longueur {
	
	private int height, nombrePoints;
	private Integer id, previousLongueurId, voieId;
	private String cotation;
	
	
	public Longueur() {
	}
	
	
	/**
	 * @param id
	 * @param voieId
	 * @param previousLongueurId
	 * @param height
	 * @param nombrePoints
	 * @param cotation
	 */
	public Longueur(Integer id, Integer voieId, Integer previousLongueurId, int height, int nombrePoints,
			String cotation) {
		this.id = id;
		this.voieId = voieId;
		this.previousLongueurId = previousLongueurId;
		this.height = height;
		this.nombrePoints = nombrePoints;
		this.cotation = cotation;
	}
	
	
	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}
	
	
	/**
	 * @param height
	 *           the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	
	
	/**
	 * @param id
	 *           the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	/**
	 * @return the nombrePoints
	 */
	public int getNombrePoints() {
		return nombrePoints;
	}
	
	
	/**
	 * @param nombrePoints
	 *           the nombrePoints to set
	 */
	public void setNombrePoints(int nombrePoints) {
		this.nombrePoints = nombrePoints;
	}
	
	
	/**
	 * @return the previousLongueurId
	 */
	public Integer getPreviousLongueurId() {
		return previousLongueurId;
	}
	
	
	/**
	 * @param previousLongueurId
	 *           the previousLongueurId to set
	 */
	public void setPreviousLongueurId(Integer previousLongueurId) {
		this.previousLongueurId = previousLongueurId;
	}
	
	
	/**
	 * @return the voieId
	 */
	public Integer getVoieId() {
		return voieId;
	}
	
	
	/**
	 * @param voieId
	 *           the voieId to set
	 */
	public void setVoieId(Integer voieId) {
		this.voieId = voieId;
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
	
}
