package fr.silvharm.commulade.consumer.impl.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import fr.silvharm.commulade.consumer.contract.dao.CommentDao;
import fr.silvharm.commulade.model.pojo.Comment;


public class CommentDaoImpl extends AbstractDaoImpl implements CommentDao {
	
	public void create(Comment comment) {
		String vSQL = "INSERT INTO " + TABLE_NAME + " (" + USER_ID + "," + POST_TYPE + "," + POST_ID + "," + DATE_TIME
				+ "," + COMMENT + ")" + " VALUES ( :user, :postType, :postId, :dateTime, :comment );";
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("user", comment.getUserId());
		vParams.addValue("postType", comment.getPostType());
		vParams.addValue("postId", comment.getPostId());
		vParams.addValue("dateTime", comment.getDateTime());
		vParams.addValue("comment", comment.getComment());
		
		namedJdbcTemplate.update(vSQL, vParams);
	}
	
	
	public void deleteById(int id) {
		String vSQL = "DELETE FROM " + TABLE_NAME + " WHERE " + ID + " = :id ;";
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("id", id);
		
		namedJdbcTemplate.update(vSQL, vParams);
	}
	
	
	public Comment findById(int id) {
		String vSQL = "SELECT * FROM " + TABLE_NAME + " WHERE " + ID + " = :id ;";
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("id", id);
		
		return namedJdbcTemplate.queryForObject(vSQL, vParams, new BeanPropertyRowMapper<Comment>(Comment.class));
	}
	
	
	public void update(Comment comment) {
		String vSQL = "UPDATE " + TABLE_NAME + " SET " + USER_ID + " = :user, " + POST_TYPE + " = :postType, "
				+ POST_ID + " = :postId, " + DATE_TIME + " = :dateTime, " + COMMENT + " = :comment WHERE " + ID + " = :id;";
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("user", comment.getUserId());
		vParams.addValue("postType", comment.getPostType());
		vParams.addValue("postId", comment.getPostId());
		vParams.addValue("dateTime", comment.getDateTime());
		vParams.addValue("comment", comment.getComment());
		vParams.addValue("id", comment.getId());
		
		namedJdbcTemplate.update(vSQL, vParams);
	}
	
}
