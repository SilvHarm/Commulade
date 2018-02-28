package fr.silvharm.commulade.business;

import java.util.List;

import fr.silvharm.commulade.consumer.impl.dao.SiteDaoImpl;
import fr.silvharm.commulade.model.bean.SiteSearchFormBean;
import fr.silvharm.commulade.model.pojo.Site;

public class SiteInteractions {
	
	private SiteDaoImpl siteDao;
	
	
	/**
	 * Call the Dao method to get all the Site of the database
	 * 
	 * @return a List containing all the Site of the database
	 */
	public List<Site> getAllSite() {
		return siteDao.getAllSite();
	}
	
	
	/**
	 * 
	 * @param formBean
	 * @return a List containing all the Site that meet the search criteria
	 */
	public List<Site> getSearchSite(SiteSearchFormBean formBean) {
		return siteDao.findBySearch(formBean);
	}
	
	
	/********************************
	 * Getters & Setters
	 *******************************/
	
	/**
	 * @param siteDao
	 *           the siteDao to set
	 */
	public void setSiteDao(SiteDaoImpl siteDao) {
		this.siteDao = siteDao;
	}
	
}
