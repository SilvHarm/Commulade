package fr.silvharm.commulade.webapp.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import fr.silvharm.commulade.business.contract.CommentInteractions;
import fr.silvharm.commulade.business.contract.UserInteractions;
import fr.silvharm.commulade.model.bean.CommentBean;
import fr.silvharm.commulade.model.bean.CommentFormBean;

public class CommentAction extends ActionSupport implements SessionAware {
	
	private CommentFormBean commentForm;
	private CommentInteractions commentInteractions;
	private Integer postId, postType;
	private List<CommentBean> beanList;
	private Map<String, Object> session;
	private UserInteractions userInteractions;
	
	
	public String execute() {
		if (postId != null && postType != null) {
			beanList = commentInteractions.getListCommentOfPost(postId, postType);
			
			return SUCCESS;
		}
		
		return ERROR;
	}
	
	
	public String addComment() {
		Integer userId = (Integer) session.get("userId");
		String username = (String) session.get("username");
		
		if (commentForm != null) {
			if (username != null && userId != null && userInteractions.verifyUser(userId, username)) {
				commentForm.setUserId(userId);
			}
			
			if (commentInteractions.createComment(commentForm)) {
				return NONE;
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
	
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	
	/**
	 * @param userInteractions
	 *           the userInteractions to set
	 */
	public void setUserInteractions(UserInteractions userInteractions) {
		this.userInteractions = userInteractions;
	}
	
}
