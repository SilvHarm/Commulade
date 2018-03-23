package fr.silvharm.commulade.webapp.action;

import java.util.List;

import fr.silvharm.commulade.business.contract.CommentInteractions;
import fr.silvharm.commulade.business.contract.UserInteractions;
import fr.silvharm.commulade.model.bean.CommentBean;
import fr.silvharm.commulade.model.bean.CommentFormBean;
import fr.silvharm.commulade.webapp.helper.SessionHelper;

public class CommentAction extends SessionHelper {
	
	private CommentFormBean commentForm;
	private CommentInteractions commentInteractions;
	private Integer postId, postType;
	private List<CommentBean> beanList;
	private UserInteractions userInteractions;
	
	
	public String execute() {
		if (postId != null && postType != null) {
			beanList = commentInteractions.getListCommentOfPost(postId, postType);
			
			return SUCCESS;
		}
		
		return ERROR;
	}
	
	
	public String addComment() {
		if (commentForm != null) {
			setUserId();
			
			if (userInteractions.verifyUser(userId, getUsername())) {
				commentForm.setUserId(userId);
			}
			
			if (commentInteractions.createComment(commentForm)) {
				return SUCCESS;
			}
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
	 * @return the commentForm
	 */
	public CommentFormBean getCommentForm() {
		return commentForm;
	}
	
	
	/**
	 * @param commentForm
	 *           the commentForm to set
	 */
	public void setCommentForm(CommentFormBean commentForm) {
		this.commentForm = commentForm;
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
	
	
	/**
	 * @param userInteractions
	 *           the userInteractions to set
	 */
	public void setUserInteractions(UserInteractions userInteractions) {
		this.userInteractions = userInteractions;
	}
	
}
