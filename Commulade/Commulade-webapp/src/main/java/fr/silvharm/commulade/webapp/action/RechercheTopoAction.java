package fr.silvharm.commulade.webapp.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import fr.silvharm.commulade.business.contract.TopoInteractions;
import fr.silvharm.commulade.model.pojo.Topo;

public class RechercheTopoAction extends ActionSupport {
	
	private List<Topo> list;
	private String contentJsp = "recherche-topo", css = "recherche-site-topo", js = "recherche-site-topo", name,
			title = "Topos";
	private TopoInteractions topoInteractions;
	
	
	public String execute() {
		if (!(name == null)) {
			list = topoInteractions.getTopoByName(name);
			
			// if no result found
			if (list != null && list.isEmpty()) {
				list = null;
			}
			// if name wasn't valid
			else if (list == null) {
				list = topoInteractions.getAllTopo();
			}
		}
		else {
			list = topoInteractions.getAllTopo();
		}
		
		return SUCCESS;
	}
	
	
	/********************************
	 * Getters & Setters
	 *******************************/
	
	/**
	 * @return the contentJsp
	 */
	public String getContentJsp() {
		return contentJsp;
	}
	
	
	/**
	 * @return the css
	 */
	public String getCss() {
		return css;
	}
	
	
	/**
	 * @return the js
	 */
	public String getJs() {
		return js;
	}
	
	
	/**
	 * @return the list
	 */
	public List<Topo> getList() {
		return list;
	}
	
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	
	/**
	 * @param name
	 *           the topoInteractions to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	
	
	/**
	 * @param topoInteractions
	 *           the topoInteractions to set
	 */
	public void setTopoInteractions(TopoInteractions topoInteractions) {
		this.topoInteractions = topoInteractions;
	}
	
}
