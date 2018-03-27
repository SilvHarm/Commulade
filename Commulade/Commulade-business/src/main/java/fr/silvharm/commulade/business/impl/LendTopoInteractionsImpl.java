package fr.silvharm.commulade.business.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.silvharm.commulade.business.contract.LendTopoInteractions;
import fr.silvharm.commulade.consumer.contract.dao.LendingTopoDao;
import fr.silvharm.commulade.consumer.contract.dao.TopoOwnedByUserDao;
import fr.silvharm.commulade.model.pojo.LendingTopo;


public class LendTopoInteractionsImpl implements LendTopoInteractions {
	
	private LendingTopoDao lendingTopoDao;
	private TopoOwnedByUserDao topoOwnedByUserDao;
	
	
	public Boolean borrowTopoOwned(LendingTopo lendingTopoToAdd) {
		LocalDate endDate = lendingTopoToAdd.getLendingEnd();
		LocalDate startDate = lendingTopoToAdd.getLendingStart();
		
		if (startDate.isAfter(LocalDate.now()) && (startDate.isBefore(endDate) || startDate.isEqual(endDate))
				&& startDate.plusDays(7).isAfter(endDate)) {
			if (isAlreadyLend(lendingTopoToAdd)) {
				lendingTopoDao.create(lendingTopoToAdd);
				
				return true;
			}
		}
		
		return false;
	}
	
	
	public Boolean cancelLending(int lendingId, int ownerId) {
		LendingTopo lendingTopo = lendingTopoDao.findById(lendingId);
		
		if (topoOwnedByUserDao.findById(lendingTopo.getTopoOwnedId()).getOwnerId() == ownerId) {
			lendingTopoDao.deleteById(lendingId);
			
			return true;
		}
		
		return false;
	}
	
	
	public List<LendingTopo> getBorrowedByUserTopoOwned(int topoOwnedId, int borrowerId) {
		return lendingTopoDao.findByIdBorrowerId(topoOwnedId, borrowerId);
	}
	
	
	public List<LocalDate[]> getFreeDateOfTopoOwned(int topoOwnedId) {
		List<LocalDate[]> dateList = new ArrayList<LocalDate[]>();
		
		List<LendingTopo> lendingList = getLendDateOfTopoOwned(topoOwnedId);
		
		
		LendingTopo tempLendTopo;
		LocalDate lastDate = LocalDate.now().plusDays(1), monthsLater = LocalDate.now().plusMonths(2), tempEnd, tempStart;
		
		if (lendingList.size() != 0) {
			tempStart = lendingList.get(0).getLendingStart();
			tempEnd = lendingList.get(0).getLendingEnd();
			
			// if the first LendingTopo as already started
			if (tempStart.isBefore(lastDate) || tempStart.isEqual(lastDate)) {
				lastDate = tempEnd.plusDays(1);
				
				lendingList.remove(0);
				
				// if there is no more LendingTopo after the first one that was deleted
				if (lendingList.size() == 0) {
					dateList.add(new LocalDate[] { lastDate, monthsLater });
					
					return dateList;
				}
			}
			
			for (int i = 0; i < lendingList.size(); i++) {
				tempLendTopo = lendingList.get(i);
				tempStart = tempLendTopo.getLendingStart();
				tempEnd = tempLendTopo.getLendingEnd();
				
				if (lastDate.isBefore(tempStart)) {
					dateList.add(new LocalDate[] { lastDate, tempStart.minusDays(1) });
					
					lastDate = tempEnd.plusDays(1);
				}
				else if (lastDate.equals(tempStart)) {
					lastDate = tempEnd.plusDays(1);
				}
				
				if (lastDate.isAfter(monthsLater)) {
					break;
				}
				
				if ((i + 1) >= lendingList.size()) {
					dateList.add(new LocalDate[] { lastDate, monthsLater });
				}
			}
		}
		else {
			dateList.add(new LocalDate[] { lastDate, monthsLater });
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
	
	
	/**
	 * @param topoOwnedByUserDao
	 *           the topoOwnedByUserDao to set
	 */
	public void setTopoOwnedByUserDao(TopoOwnedByUserDao topoOwnedByUserDao) {
		this.topoOwnedByUserDao = topoOwnedByUserDao;
	}
	
}
