package fr.silvharm.commulade.consumer.contract.dao;

import fr.silvharm.commulade.model.pojo.Comment;

public interface CommentDao {
	
	public void create(Comment comment);
	
	
	public void delete(int id);
	
	
	public Comment find(int id);
	
	
	public void update(Comment comment);
	
}
