package fr.silvharm.commulade.business.contract;

import java.util.List;

import fr.silvharm.commulade.model.bean.TopoFormBean;
import fr.silvharm.commulade.model.pojo.Topo;

public interface TopoInteractions {
	
	/**
	 * Call the appropriate method in the consumer module to get all the Topo of the
	 * database
	 * 
	 * @return a List containing all the Topo of the database
	 */
	public List<Topo> getAllTopo();
	
	
	/**
	 * Call the appropriate method in the consumer module to get the Topo in the
	 * database whom the id is equal to the one provided
	 * 
	 * @param id
	 * @return a Topo whom the id is equal to the one provided or null if it doesn't
	 *         exist
	 */
	public Topo getTopo(int id);
	
	
	/**
	 * Call the appropriate method in the consumer module to get the Topo in the
	 * database whom the name ressemble to the one provided
	 * 
	 * @param topoName
	 * @return a List containing all the Topo that meet the search criteria or null
	 *         if topoName isn't valid
	 */
	public List<Topo> getTopoByName(String topoName);
	
	
	/**
	 * Verify if there is one or more Site whom the Date is more recent than the
	 * Topo Date
	 * 
	 * @param topo
	 * @return true if there is no Site more recent or false
	 */
	public Boolean isUpToDate(Topo topo);
	
	
	/**
	 * Verify the Form and call the consumer module to add it to the database if
	 * everything is conform
	 * 
	 * @param topoForm
	 * @return the id of the new Topo or null
	 */
	public Integer shareTopo(TopoFormBean topoForm);
}
