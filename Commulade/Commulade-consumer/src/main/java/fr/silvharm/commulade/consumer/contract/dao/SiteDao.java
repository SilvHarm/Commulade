package fr.silvharm.commulade.consumer.contract.dao;

import fr.silvharm.commulade.model.pojo.Site;

public interface SiteDao {
	
	public void create(Site site);
	
	
	public void delete(int id);
	
	
	public Site find(int id);
	
	
	public void update(Site site);
	
}
