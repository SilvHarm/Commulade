package fr.silvharm.commulade.model.pojo;

import java.time.LocalDate;

public class Site {
	
	private Integer id;
	private LocalDate date;
	private String name, pathIndication, photoName, place;
	
	
	public Site() {
	}
	
	
	/**
	 * @param id
	 * @param name
	 * @param date
	 * @param photoName
	 * @param place
	 * @param pathIndication
	 */
	public Site(Integer id, String name, LocalDate date, String photoName, String place, String pathIndication) {
		this.id = id;
		this.name = name;
		this.date = date;
		this.photoName = photoName;
		this.place = place;
		this.pathIndication = pathIndication;
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
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}
	
	
	/**
	 * @param date
	 *           the date to set
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	
	/**
	 * @param name
	 *           the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
	/**
	 * @return the pathIndication
	 */
	public String getPathIndication() {
		return pathIndication;
	}
	
	
	/**
	 * @param pathIndication
	 *           the pathIndication to set
	 */
	public void setPathIndication(String pathIndication) {
		this.pathIndication = pathIndication;
	}
	
	
	/**
	 * @return the photoName
	 */
	public String getPhotoName() {
		return photoName;
	}
	
	
	/**
	 * @param photoName
	 *           the photoName to set
	 */
	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}
	
	
	/**
	 * @return the place
	 */
	public String getPlace() {
		return place;
	}
	
	
	/**
	 * @param place
	 *           the place to set
	 */
	public void setPlace(String place) {
		this.place = place;
	}
	
}
