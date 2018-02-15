package fr.silvharm.commulade.consumer.contract.dao;

import fr.silvharm.commulade.model.pojo.Voie;

public interface VoieDao {
	
	public void create(Voie voie);
	
	
	public void delete(int id);
	
	
	public Voie find(int id);
	
	
	public void update(Voie voie);
	
}
