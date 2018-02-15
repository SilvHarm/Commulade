package fr.silvharm.commulade.consumer.contract.dao;

import fr.silvharm.commulade.model.pojo.Longueur;

public interface LongueurDao {
	
	public void create(Longueur longueur);
	
	
	public void delete(int id);
	
	
	public Longueur find(int id);
	
	
	public void update(Longueur longueur);
	
}
