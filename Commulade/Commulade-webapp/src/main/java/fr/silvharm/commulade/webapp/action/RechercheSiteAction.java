package fr.silvharm.commulade.webapp.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import fr.silvharm.commulade.business.contract.SiteInteractions;
import fr.silvharm.commulade.model.bean.SiteSearchFormBean;
import fr.silvharm.commulade.model.pojo.ConfigContainer;
import fr.silvharm.commulade.model.pojo.Site;


public class RechercheSiteAction extends ActionSupport {
	
	private ConfigContainer configContainer;
	private List<Site> list;
	private SiteInteractions siteInteractions;
	private SiteSearchFormBean formBean;
	private String contentJsp = "recherche-site", css = "recherche-site", js = "recherche-site",
			title = "Recherche de Site";
	@SuppressWarnings("unused") // is used by struts in the jsp
	private String photoPath;
	
	
	public String execute() {
		if (formBean != null) {
			list = siteInteractions.getSearchSite(formBean);
			
			// if no result found
			if (list != null && list.isEmpty()) {
				list = null;
			}
			// if formBean wasn't valid
			else if (list == null) {
				list = siteInteractions.getAllSite();
			}
		}
		else {
			list = siteInteractions.getAllSite();
		}
		
		return SUCCESS;
	}
	
	
	/********************************
	 * Getters & Setters
	 *******************************/
	
	/**
	 * @param configContainer
	 *           the configContainer to set
	 */
	public void setConfigContainer(ConfigContainer configContainer) {
		this.configContainer = configContainer;
	}
	
	
	/**
	 * @return the contentJsp
	 */
	public String getContentJsp() {
		return contentJsp;
	}
	
	
	/**
	 * @return the css
	 */
	public String getCss() {
		return css;
	}
	
	
	/**
	 * @return the formBean
	 */
	public SiteSearchFormBean getFormBean() {
		return formBean;
	}
	
	
	/**
	 * @param formBean
	 *           the formBean to set
	 */
	public void setFormBean(SiteSearchFormBean formBean) {
		this.formBean = formBean;
	}
	
	
	/**
	 * @return the js
	 */
	public String getJs() {
		return js;
	}
	
	
	/**
	 * @return the list
	 */
	public List<Site> getList() {
		return list;
	}
	
	
	/**
	 * @return the photoPath
	 */
	public String getPhotoPath() {
		return configContainer.getSitePhotoPath();
	}
	
	
	/**
	 * @param siteInteractions
	 *           the siteInteractions to set
	 */
	public void setSiteInteractions(SiteInteractions siteInteractions) {
		this.siteInteractions = siteInteractions;
	}
	
	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	
}
