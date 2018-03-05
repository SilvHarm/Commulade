package fr.silvharm.commulade.business.contract;

import java.util.List;

import fr.silvharm.commulade.model.bean.SiteSearchFormBean;
import fr.silvharm.commulade.model.pojo.Site;

public interface SiteInteractions {
	
	/**
	 * Call the appropriate method in the consumer module to get a List of the all
	 * the Site of the database
	 * 
	 * @return a List containing all the Site of the database
	 */
	public List<Site> getAllSite();
	
	
	/**
	 * Call the appropriate method in the consumer module to get a List of the all
	 * Site in the database whom the id is equal to the ones provided in the List
	 * 
	 * @param list
	 * @return a List of Site whom the id are equal to the ones provided or null if
	 *         none of them exist
	 */
	public List<Site> getListSite(List<Integer> list);
	
	
	/**
	 * Call the appropriate method in the consumer module to get a List of the all
	 * Site in the database that meets the search criteria
	 * 
	 * @param formBean
	 * @return a List containing all the Site that meet the search criteria or null
	 *         if formBean isn't valid
	 */
	public List<Site> getSearchSite(SiteSearchFormBean formBean);
	
	
	/**
	 * Call the appropriate method in the consumer module to get the Site in the
	 * database whom the id is equal to the one provided
	 * 
	 * @param id
	 * @return a Site whom the id is equal to the one provided or null if it doesn't
	 *         exist
	 */
	public Site getSite(int id);
	
}
