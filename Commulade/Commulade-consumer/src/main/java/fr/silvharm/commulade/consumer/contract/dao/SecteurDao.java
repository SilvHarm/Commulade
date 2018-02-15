package fr.silvharm.commulade.consumer.contract.dao;

import fr.silvharm.commulade.model.pojo.Secteur;

public interface SecteurDao {
	
	public void create(Secteur secteur);
	
	
	public void delete(int id);
	
	
	public Secteur find(int id);
	
	
	public void update(Secteur secteur);
	
}
