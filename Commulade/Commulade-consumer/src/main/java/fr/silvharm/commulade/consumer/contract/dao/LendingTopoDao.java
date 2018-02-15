package fr.silvharm.commulade.consumer.contract.dao;

import fr.silvharm.commulade.model.pojo.LendingTopo;

public interface LendingTopoDao {
	
	public void create(LendingTopo lendingTopo);
	
	
	public void delete(int id);
	
	
	public LendingTopo find(int id);
	
	
	public void update(LendingTopo lendingTopo);
	
}
