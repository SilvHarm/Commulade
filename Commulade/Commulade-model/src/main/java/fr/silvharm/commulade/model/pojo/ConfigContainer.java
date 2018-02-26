package fr.silvharm.commulade.model.pojo;


public class ConfigContainer {
	
	private String secteurPhotoPath, sitePhotoPath;
	
	
	public ConfigContainer() {
		
	}
	
	
	/**
	 * @param secteurPhotoPath
	 * @param sitePhotoPath
	 */
	public ConfigContainer(String secteurPhotoPath, String sitePhotoPath) {
		this.secteurPhotoPath = secteurPhotoPath;
		this.sitePhotoPath = sitePhotoPath;
	}
	
	
	/**
	 * @return the secteurPhotoPath
	 */
	public String getSecteurPhotoPath() {
		return secteurPhotoPath;
	}
	
	
	/**
	 * @param secteurPhotoPath
	 *           the secteurPhotoPath to set
	 */
	public void setSecteurPhotoPath(String secteurPhotoPath) {
		this.secteurPhotoPath = secteurPhotoPath;
	}
	
	
	/**
	 * @return the sitePhotoPath
	 */
	public String getSitePhotoPath() {
		return sitePhotoPath;
	}
	
	
	/**
	 * @param sitePhotoPath
	 *           the sitePhotoPath to set
	 */
	public void setSitePhotoPath(String sitePhotoPath) {
		this.sitePhotoPath = sitePhotoPath;
	}
	
}
