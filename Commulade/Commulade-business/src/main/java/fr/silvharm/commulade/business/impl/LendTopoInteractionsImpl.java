package fr.silvharm.commulade.business.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.silvharm.commulade.business.contract.LendTopoInteractions;
import fr.silvharm.commulade.consumer.contract.dao.LendingTopoDao;
import fr.silvharm.commulade.model.pojo.LendingTopo;


public class LendTopoInteractionsImpl implements LendTopoInteractions {
	
	private LendingTopoDao lendingTopoDao;
	
	
	public Boolean borrowTopoOwned(LendingTopo lendingTopoToAdd) {
		LocalDate endDate = lendingTopoToAdd.getLendingEnd();
		LocalDate startDate = lendingTopoToAdd.getLendingStart();
		
		if (startDate.isAfter(LocalDate.now()) && startDate.isBefore(endDate) && startDate.plusDays(7).isAfter(endDate)) {
			if (isAlreadyLend(lendingTopoToAdd)) {
				lendingTopoDao.create(lendingTopoToAdd);
				
				return true;
			}
		}
		
		return false;
	}
	
	
	public List<LocalDate[]> getFreeDateOfTopoOwned(int topoOwnedId) {
		List<LocalDate[]> dateList = new ArrayList<LocalDate[]>();
		
		List<LendingTopo> lendingList = getLendDateOfTopoOwned(topoOwnedId);
		
		
		LendingTopo tempLendTopo;
		LocalDate lastDate = LocalDate.now().plusDays(1), tempDate;
		LocalDate[] toAdd = new LocalDate[2];
		
		if (lendingList.size() != 0) {
			tempDate = lendingList.get(0).getLendingStart();
			
			// if the first LendingTopo as already started
			if (tempDate.isBefore(lastDate) || tempDate.isEqual(lastDate)) {
				lastDate = lendingList.get(0).getLendingEnd().plusDays(1);
				
				lendingList.remove(0);
				
				// if there is no more LendingTopo after the first one that was deleted
				if (lendingList.size() == 0) {
					toAdd[0] = lastDate;
					toAdd[1] = LocalDate.now().plusMonths(2);
					
					dateList.add(toAdd);
					
					return dateList;
				}
			}
			
			for (int i = 0; i < lendingList.size(); i++) {
				// TODO
				
				tempLendTopo = lendingList.get(i);
				
				toAdd[0] = lastDate;
				toAdd[1] = tempLendTopo.getLendingStart().minusDays(1);
				
				dateList.add(toAdd);
			}
		}
		else {
			toAdd[0] = LocalDate.now().plusDays(1);
			toAdd[1] = LocalDate.now().plusMonths(2);
			
			dateList.add(toAdd);
		}
		
		return dateList;
	}
	
	
	public List<LendingTopo> getLendDateOfTopoOwned(int topoOwnedId) {
		return lendingTopoDao.findByIdAfterToday(topoOwnedId);
	}
	
	
	public List<LendingTopo> getMoreLendDateOfTopoOwned(int topoOwnedId) {
		return lendingTopoDao.findByIdSincePreviousMonth(topoOwnedId);
	}
	
	
	public Boolean isAlreadyLend(LendingTopo lendingTopo) {
		List<LendingTopo> borrowedList = getLendDateOfTopoOwned(lendingTopo.getTopoOwnedId());
		
		LocalDate start = lendingTopo.getLendingStart();
		LocalDate end = lendingTopo.getLendingEnd();
		
		int i = 0;
		LendingTopo temp;
		LocalDate tempEnd, tempStart;
		while (i < borrowedList.size()) {
			temp = borrowedList.get(0);
			tempStart = temp.getLendingStart();
			tempEnd = temp.getLendingEnd();
			
			if ((start.isAfter(tempStart) && start.isBefore(tempEnd))
					|| (end.isAfter(tempStart) && end.isBefore(tempEnd))) {
				return false;
			}
			
			i++;
		}
		
		return true;
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
