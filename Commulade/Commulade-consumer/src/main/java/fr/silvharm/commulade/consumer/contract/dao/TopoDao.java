package fr.silvharm.commulade.consumer.contract.dao;

import fr.silvharm.commulade.model.pojo.Topo;

public interface TopoDao {
	
	public void create(Topo topo);
	
	
	public void delete(int id);
	
	
	public Topo find(int id);
	
	
	public void update(Topo topo);
	
}
