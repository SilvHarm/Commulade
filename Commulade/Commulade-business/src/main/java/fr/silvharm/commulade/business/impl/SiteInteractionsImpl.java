package fr.silvharm.commulade.business.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.silvharm.commulade.business.contract.SiteInteractions;
import fr.silvharm.commulade.consumer.contract.dao.SiteDao;
import fr.silvharm.commulade.model.bean.SiteSearchFormBean;
import fr.silvharm.commulade.model.pojo.Site;

public class SiteInteractionsImpl implements SiteInteractions {
	
	private static final Logger logger = LogManager.getLogger();
	
	private SiteDao siteDao;
	
	
	/**
	 * Verify if the form properties have the format expected, if not it's set them
	 * to "" or just return null
	 * 
	 * @return the formBean verificated and corrected if necessary or null
	 */
	private Boolean formVerification(SiteSearchFormBean formBean) {
		// if every properties are empty
		if ((formBean.getSiteName() + formBean.getMinHeight() + formBean.getMaxHeight() + formBean.getMinPointNumber()
				+ formBean.getMaxPointNumber() + formBean.getCotation()).isEmpty()) {
			logger.info("All propertiesof the Form are empty");
			
			return false;
		}
		
		if (formBean.getSiteName().length() > 48) {
			logger.info("siteName property length is unexpected");
			
			return false;
		}
		
		int i;
		try {
			// if form field wasn't left empty
			if (!formBean.getMinHeight().isEmpty()) {
				// test if field content is an Integer
				i = Integer.parseInt(formBean.getMinHeight());
				// test if value is unexpected
				if (i < 1 && 99 < i) {
					logger.info("minHeight property value is unexpected");
					
					return false;
				}
			}
			
			if (!formBean.getMaxHeight().isEmpty()) {
				i = Integer.parseInt(formBean.getMaxHeight());
				if (i < 2 && 100 < i) {
					logger.info("maxHeight property value is unexpected");
					
					return false;
				}
			}
			
			if (!formBean.getMinPointNumber().isEmpty()) {
				i = Integer.parseInt(formBean.getMinPointNumber());
				if (i < 1 && 99 < i) {
					logger.info("minPointNumber property value is unexpected");
					
					return false;
				}
			}
			
			if (!formBean.getMaxPointNumber().isEmpty()) {
				i = Integer.parseInt(formBean.getMaxPointNumber());
				if (i < 2 && 100 < i) {
					logger.info("maxPointNumber property value is unexpected");
					
					return false;
				}
			}
			
			if (!formBean.getCotation().isEmpty()) {
				i = Integer.parseInt(formBean.getCotation());
				if (i < 3 && 9 < i) {
					logger.info("cotation property value is unexpected");
					
					return false;
				}
			}
		}
		catch (NumberFormatException e) {
			logger.info("A property of the form who should have been an Integer wasn't one\n", e);
			
			return false;
		}
		
		
		return true;
	}
	
	
	public List<Site> getAllSite() {
		return siteDao.getAllSite();
	}
	
	
	public List<Site> getSearchSite(SiteSearchFormBean formBean) {
		if (!formVerification(formBean)) {
			return null;
		}
		
		return siteDao.findBySearch(formBean);
	}
	
	
	/********************************
	 * Getters & Setters
	 *******************************/
	
	/**
	 * @param siteDao
	 *           the siteDao to set
	 */
	public void setSiteDao(SiteDao siteDao) {
		this.siteDao = siteDao;
	}
	
}
