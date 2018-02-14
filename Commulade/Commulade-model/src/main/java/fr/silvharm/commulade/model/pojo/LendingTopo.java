package fr.silvharm.commulade.model.pojo;

import java.time.LocalDate;

public class LendingTopo {
	
	private Integer borrowerId, id, topoOwnedId;
	private LocalDate lendingEnd, lendingStart;
	
	
	/**
	 * @param id
	 * @param topoOwnedId
	 * @param borrowerId
	 * @param lendingStart
	 * @param lendingEnd
	 */
	public LendingTopo(Integer id, Integer topoOwnedId, Integer borrowerId, LocalDate lendingStart,
			LocalDate lendingEnd) {
		this.id = id;
		this.topoOwnedId = topoOwnedId;
		this.borrowerId = borrowerId;
		this.lendingStart = lendingStart;
		this.lendingEnd = lendingEnd;
	}
	
	
	/**
	 * @return the borrowerId
	 */
	public Integer getBorrowerId() {
		return borrowerId;
	}
	
	
	/**
	 * @param borrowerId
	 *           the borrowerId to set
	 */
	public void setBorrowerId(Integer borrowerId) {
		this.borrowerId = borrowerId;
	}
	
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	
	
	/**
	 * @param id
	 *           the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	/**
	 * @return the topoOwnedId
	 */
	public Integer getTopoOwnedId() {
		return topoOwnedId;
	}
	
	
	/**
	 * @param topoOwnedId
	 *           the topoOwnedId to set
	 */
	public void setTopoOwnedId(Integer topoOwnedId) {
		this.topoOwnedId = topoOwnedId;
	}
	
	
	/**
	 * @return the lendingEnd
	 */
	public LocalDate getLendingEnd() {
		return lendingEnd;
	}
	
	
	/**
	 * @param lendingEnd
	 *           the lendingEnd to set
	 */
	public void setLendingEnd(LocalDate lendingEnd) {
		this.lendingEnd = lendingEnd;
	}
	
	
	/**
	 * @return the lendingStart
	 */
	public LocalDate getLendingStart() {
		return lendingStart;
	}
	
	
	/**
	 * @param lendingStart
	 *           the lendingStart to set
	 */
	public void setLendingStart(LocalDate lendingStart) {
		this.lendingStart = lendingStart;
	}
	
}
