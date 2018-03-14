package fr.silvharm.commulade.business.impl;

import java.time.LocalDate;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.silvharm.commulade.business.contract.SiteInteractions;
import fr.silvharm.commulade.business.contract.TopoInteractions;
import fr.silvharm.commulade.business.helper.FormConverterHelper;
import fr.silvharm.commulade.business.helper.FormVerificationHelper;
import fr.silvharm.commulade.consumer.contract.dao.SiteTopoDao;
import fr.silvharm.commulade.consumer.contract.dao.TopoDao;
import fr.silvharm.commulade.model.bean.TopoFormBean;
import fr.silvharm.commulade.model.pojo.Site;
import fr.silvharm.commulade.model.pojo.Topo;


public class TopoInteractionsImpl implements TopoInteractions {
	
	private static final Logger logger = LogManager.getLogger();
	
	private SiteInteractions siteInteractions;
	private SiteTopoDao siteTopoDao;
	private TopoDao topoDao;
	
	
	public List<Topo> getAllTopo() {
		return topoDao.getAllTopo();
	}
	
	
	public Topo getTopo(int id) {
		Topo topo = topoDao.findById(id);
		
		if (topo == null) {
			return null;
		}
		
		topo.setListSite(siteInteractions.getListSiteByTopoId(id));
		
		return topo;
	}
	
	
	public List<Topo> getTopoByName(String topoName) {
		if (!nameVerification(topoName)) {
			return null;
		}
		
		return topoDao.getByName(FormConverterHelper.stringSqlConform(topoName));
	}
	
	
	private Boolean nameVerification(String name) {
		if (name.length() > 48) {
			logger.info("name length is unexpected");
			
			return false;
		}
		
		return true;
	}
	
	
	public Boolean isUpToDate(Topo topo) {
		LocalDate topoDate = topo.getEditionDate().plusDays(1);
		
		for (Site site : topo.getListSite()) {
			if (site.getDate().isAfter(topoDate)) {
				return false;
			}
		}
		
		return true;
	}
	
	
	public Integer shareTopo(TopoFormBean topoForm) {
		if (FormVerificationHelper.shareTopo(topoForm)) {
			Topo topo = FormConverterHelper.topoFormToTopo(topoForm);
			
			int topoId = topoDao.create(topo);
			
			List<Integer> siteIdList = siteInteractions.shareListSite(topoForm.getListSite(), topo.getEditionDate());
			
			siteTopoDao.createList(topoId, siteIdList);
			
			return topoId;
		}
		
		return null;
	}
	
	
	/********************************
	 * Getters & Setters
	 *******************************/
	
	/**
	 * @param siteInteractions
	 *           the siteInteractions to set
	 */
	public void setSiteInteractions(SiteInteractions siteInteractions) {
		this.siteInteractions = siteInteractions;
	}
	
	
	/**
	 * @param siteTopoDao
	 *           the siteTopoDao to set
	 */
	public void setSiteTopoDao(SiteTopoDao siteTopoDao) {
		this.siteTopoDao = siteTopoDao;
	}
	
	
	/**
	 * @param topoDao
	 *           the topoDao to set
	 */
	public void setTopoDao(TopoDao topoDao) {
		this.topoDao = topoDao;
	}
	
}
