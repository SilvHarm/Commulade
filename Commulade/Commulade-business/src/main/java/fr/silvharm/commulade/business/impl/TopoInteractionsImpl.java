package fr.silvharm.commulade.business.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.silvharm.commulade.business.contract.TopoInteractions;
import fr.silvharm.commulade.consumer.contract.dao.TopoDao;
import fr.silvharm.commulade.model.pojo.Topo;


public class TopoInteractionsImpl implements TopoInteractions {
	
	private static final Logger logger = LogManager.getLogger();
	
	private TopoDao topoDao;
	
	
	public List<Topo> getAllTopo() {
		return topoDao.getAllTopo();
	}
	
	
	public List<Topo> getTopoByName(String topoName) {
		if (!nameVerification(topoName)) {
			return null;
		}
		
		return topoDao.getByName(topoName);
	}
	
	
	private Boolean nameVerification(String name) {
		if (name.length() > 48) {
			logger.info("name length is unexpected");
			
			return false;
		}
		
		return true;
	}
	
	
	/********************************
	 * Getters & Setters
	 *******************************/
	
	/**
	 * @param topoDao
	 *           the topoDao to set
	 */
	public void setTopoDao(TopoDao topoDao) {
		this.topoDao = topoDao;
	}
	
}
