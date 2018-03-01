package fr.silvharm.commulade.business.contract;

import java.util.List;

import fr.silvharm.commulade.model.bean.SiteSearchFormBean;
import fr.silvharm.commulade.model.pojo.Site;

public interface SiteInteractions {
	
	/**
	 * Call the appropriate method in the consumer module to get all the Site of the
	 * database
	 * 
	 * @return a List containing all the Site of the database
	 */
	public List<Site> getAllSite();
	
	
	/**
	 * Call the appropriate method in the consumer module to get the Site in the
	 * database that meets the search criteria
	 * 
	 * @param formBean
	 * @return a List containing all the Site that meet the search criteria or null
	 *         if formBean isn't valid
	 */
	public List<Site> getSearchSite(SiteSearchFormBean formBean);
	
}
