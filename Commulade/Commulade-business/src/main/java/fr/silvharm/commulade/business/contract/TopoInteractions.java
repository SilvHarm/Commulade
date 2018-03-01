package fr.silvharm.commulade.business.contract;

import java.util.List;

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
	 * database whom the name ressemble to the one provided
	 * 
	 * @param topoName
	 * @return a List containing all the Topo that meet the search criteria or null
	 *         if topoName isn't valid
	 */
	public List<Topo> getTopoByName(String topoName);
	
}
