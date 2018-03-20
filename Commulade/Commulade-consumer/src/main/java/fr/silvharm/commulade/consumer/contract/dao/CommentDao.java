package fr.silvharm.commulade.consumer.contract.dao;

import java.util.List;

import fr.silvharm.commulade.model.pojo.Comment;

public interface CommentDao {
	
	final String TABLE_NAME = "comment";
	
	final String ID = "id", USER_ID = "user_id", POST_TYPE = "post_type", POST_ID = "post_id", DATE_TIME = "date_time",
			COMMENT = "comment";
	
	
	/**
	 * Insert the provided Comment in the database
	 * 
	 * @param comment
	 */
	public void create(Comment comment);
	
	
	/**
	 * Delete from the database the Comment associated to the id provided
	 * 
	 * @param id
	 */
	public void deleteById(int id);
	
	
	/**
	 * Get from the database the Comment whom the id is equal to the one provided
	 * 
	 * @param id
	 * @return the Comment associated to the id provided
	 */
	public Comment findById(int id);
	
	
	/**
	 * Get from the database all Comment who are associated to the postId and
	 * postType provided
	 * 
	 * @param postId
	 * @param postType
	 * @return a List of the Comment associated to the id and the type that were
	 *         provided
	 */
	public List<Comment> findByPostTypeId(int postId, int postType);
	
	
	/**
	 * Update the properties of the Comment from the database, whom the id is equal
	 * to the id of the Comment provided, by the ones of the Comment provided
	 * 
	 * @param comment
	 */
	public void update(Comment comment);
	
}
