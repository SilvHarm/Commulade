package fr.silvharm.commulade.webapp.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import fr.silvharm.commulade.business.contract.CommentInteractions;
import fr.silvharm.commulade.model.bean.CommentBean;

public class CommentAction extends ActionSupport {
	
	private CommentInteractions commentInteractions;
	private Integer postId, postType;
	private List<CommentBean> beanList;
	
	
	public String execute() {
		if (postId != null && postType != null) {
			beanList = commentInteractions.getListCommentOfPost(postId, postType);
			
			return SUCCESS;
		}
		
		return ERROR;
	}
	
	
	/********************************
	 * Getters & Setters
	 *******************************/
	
	
	/**
	 * @return the beanList
	 */
	public List<CommentBean> getBeanList() {
		return beanList;
	}
	
	
	/**
	 * @param commentInteractions
	 *           the commentInteractions to set
	 */
	public void setCommentInteractions(CommentInteractions commentInteractions) {
		this.commentInteractions = commentInteractions;
	}
	
	
	/**
	 * @param postId
	 *           the postId to set
	 */
	public void setPostId(Integer postId) {
		this.postId = postId;
	}
	
	
	/**
	 * @param postType
	 *           the postType to set
	 */
	public void setPostType(Integer postType) {
		this.postType = postType;
	}
	
}
