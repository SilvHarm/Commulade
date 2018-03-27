package fr.silvharm.commulade.business.impl;

import java.util.List;

import fr.silvharm.commulade.business.contract.TopoOwnedInteractions;
import fr.silvharm.commulade.consumer.contract.dao.TopoOwnedByUserDao;
import fr.silvharm.commulade.model.pojo.TopoOwnedByUser;


public class TopoOwnedInteractionsImpl implements TopoOwnedInteractions {
	
	private TopoOwnedByUserDao topoOwnedByUserDao;
	
	
	public TopoOwnedByUser doesTopoOwnedExist(int topoOwnedId) {
		return topoOwnedByUserDao.findById(topoOwnedId);
	}
	
	
	public List<TopoOwnedByUser> getAllExceptUserTopoOwned(int userId) {
		return topoOwnedByUserDao.getAllExceptOwnerId(userId);
	}
	
	
	public List<TopoOwnedByUser> getAllTopoOwned() {
		return topoOwnedByUserDao.getAll();
	}
	
	public List<TopoOwnedByUser> getBorrowedTopoOwned(int userId)	{
		return topoOwnedByUserDao.findByBorrowerIdAfterToday(userId);
	}
	
	
	public List<TopoOwnedByUser> getUserTopoOwned(int userId) {
		return topoOwnedByUserDao.findByOwnerId(userId);
	}
	
	
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
