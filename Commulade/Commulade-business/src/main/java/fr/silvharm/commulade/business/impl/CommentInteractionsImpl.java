package fr.silvharm.commulade.business.impl;

import java.util.ArrayList;
import java.util.List;

import fr.silvharm.commulade.business.contract.CommentInteractions;
import fr.silvharm.commulade.business.contract.UserInteractions;
import fr.silvharm.commulade.business.helper.FormConverterHelper;
import fr.silvharm.commulade.business.helper.FormVerificationHelper;
import fr.silvharm.commulade.business.helper.PojoConverterHelper;
import fr.silvharm.commulade.consumer.contract.dao.CommentDao;
import fr.silvharm.commulade.model.bean.CommentBean;
import fr.silvharm.commulade.model.bean.CommentFormBean;
import fr.silvharm.commulade.model.pojo.Comment;


public class CommentInteractionsImpl implements CommentInteractions {
	
	private CommentDao commentDao;
	private UserInteractions userInteractions;
	
	
	public Boolean createComment(CommentFormBean commentForm) {
		if (FormVerificationHelper.commentForm(commentForm)) {
			commentDao.create(FormConverterHelper.commentFormToComment(commentForm));
			
			return true;
		}
		
		return false;
	}
	
	
	public List<CommentBean> getListCommentOfPost(int postId, int postType) {
		List<Comment> list = commentDao.findByPostTypeId(postId, postType);
		
		if (!list.isEmpty()) {
			List<Integer> userIdList = new ArrayList<Integer>();
			for (Comment comment : list) {
				if (!userIdList.contains(comment.getUserId())) {
					userIdList.add(comment.getUserId());
				}
			}
			
			return PojoConverterHelper.commentToCommentBean(list, userInteractions.getUsernameMapByIdList(userIdList));
		}
		
		return null;
	}
	
	
	/********************************
	 * Getters & Setters
	 *******************************/
	
	/**
	 * @param commentDao
	 *           the commentDao to set
	 */
	public void setCommentDao(CommentDao commentDao) {
		this.commentDao = commentDao;
	}
	
	
	/**
	 * @param userInteractions
	 *           the userInteractions to set
	 */
	public void setUserInteractions(UserInteractions userInteractions) {
		this.userInteractions = userInteractions;
	}
	
}
