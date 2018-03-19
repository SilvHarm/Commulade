package fr.silvharm.commulade.business.contract;

import java.util.List;

import fr.silvharm.commulade.model.bean.CommentBean;

public interface CommentInteractions {
	
	/**
	 * Verify the CommentBean, convert it into a Comment and add it to the database
	 * 
	 * @param commentBean
	 * @return true if the Comment was created or false
	 */
	public Boolean createComment(CommentBean commentFormBean);
	
	
	/**
	 * Call the consumer module to get all the Comment associated to the postId and
	 * postType provided and convert them into CommentBean
	 * 
	 * @param postId
	 * @param postType
	 * @return a List containing all the CommentBean, sorted from newest to older,
	 *         of the post whom the information were provided or null
	 */
	public List<CommentBean> getListCommentOfPost(int postId, int postType);
}
