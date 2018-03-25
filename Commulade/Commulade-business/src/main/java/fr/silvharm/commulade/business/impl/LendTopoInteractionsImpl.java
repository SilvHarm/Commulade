package fr.silvharm.commulade.business.impl;

import java.util.List;

import fr.silvharm.commulade.business.contract.LendTopoInteractions;
import fr.silvharm.commulade.consumer.contract.dao.LendingTopoDao;
import fr.silvharm.commulade.model.pojo.LendingTopo;


public class LendTopoInteractionsImpl implements LendTopoInteractions {
	
	private LendingTopoDao lendingTopoDao;
	
	
	public List<LendingTopo> getLendDateOfTopoOwned(int topoOwnedId) {
		return lendingTopoDao.findByIdAfterToday(topoOwnedId);
	}
	
	
	/********************************
	 * Getters & Setters
	 *******************************/
	
	/**
	 * @param lendingTopoDao
	 *           the lendingTopoDao to set
	 */
	public void setLendingTopoDao(LendingTopoDao lendingTopoDao) {
		this.lendingTopoDao = lendingTopoDao;
	}
	
}
