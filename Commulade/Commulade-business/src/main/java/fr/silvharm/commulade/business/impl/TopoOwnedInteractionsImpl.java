package fr.silvharm.commulade.business.impl;

import fr.silvharm.commulade.business.contract.TopoOwnedInteractions;
import fr.silvharm.commulade.consumer.contract.dao.TopoOwnedByUserDao;
import fr.silvharm.commulade.model.pojo.TopoOwnedByUser;


public class TopoOwnedInteractionsImpl implements TopoOwnedInteractions {
	
	private TopoOwnedByUserDao topoOwnedByUserDao;
	
	
	public Boolean isTopoOwned(int topoId, int userId) {
		TopoOwnedByUser topoOwned = topoOwnedByUserDao.findByTopoOwnerId(userId, topoId);
		
		if (topoOwned != null) {
			return true;
		}
		
		return false;
	}
	
	
	public void startSharing(int topoId, int userId) {
		topoOwnedByUserDao.create(userId, topoId);
	}
	
	
	public void stopSharing(int topoId, int userId) {
		topoOwnedByUserDao.deleteByUserTopoId(userId, topoId);
	}
	
	
	/********************************
	 * Getters & Setters
	 *******************************/
	
	/**
	 * @param topoOwnedByUserDao
	 *           the topoOwnedByUserDao to set
	 */
	public void setTopoOwnedByUserDao(TopoOwnedByUserDao topoOwnedByUserDao) {
		this.topoOwnedByUserDao = topoOwnedByUserDao;
	}
}
