package fr.silvharm.commulade.consumer.impl.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import fr.silvharm.commulade.consumer.contract.dao.MessageDao;
import fr.silvharm.commulade.model.pojo.Message;


public class MessageDaoImpl extends AbstractDaoImpl implements MessageDao {
	
	public void create(Message message) {
		String vSQL = "INSERT INTO " + TABLE_NAME + " (" + RECEIVER_ID + "," + SENDER_ID + "," + PREVIOUS_MESSAGE_ID + ","
				+ DATE_TIME + "," + MESSAGE_READ + "," + SUBJECT + "," + CONTENT + ")"
				+ " VALUES ( :receiverId, :senderId, :previousMessageId, :dateTime, :messageRead, :subject, :content );";
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("receiverId", message.getReceiverId());
		vParams.addValue("senderId", message.getSenderId());
		vParams.addValue("previousMessageId", message.getPreviousMessageId());
		vParams.addValue("dateTime", message.getDateTime());
		vParams.addValue("messageRead", message.getMessageRead());
		vParams.addValue("subject", message.getSubject());
		vParams.addValue("content", message.getContent());
		
		jdbcTemplate.update(vSQL, vParams);
	}
	
	
	public void deleteById(int id) {
		String vSQL = "DELETE FROM " + TABLE_NAME + " WHERE " + ID + " = :id ;";
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("id", id);
		
		jdbcTemplate.update(vSQL, vParams);
	}
	
	
	public Message findById(int id) {
		String vSQL = "SELECT * FROM " + TABLE_NAME + " WHERE " + ID + " = :id ;";
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("id", id);
		
		return jdbcTemplate.queryForObject(vSQL, vParams, new BeanPropertyRowMapper<Message>(Message.class));
	}
	
	
	public void update(Message message) {
		String vSQL = "UPDATE " + TABLE_NAME + " SET " + RECEIVER_ID + " = :receiverId, " + SENDER_ID + " = :senderId, "
				+ PREVIOUS_MESSAGE_ID + " = :previousMessageId, " + DATE_TIME + " = :dateTime, " + MESSAGE_READ
				+ " = :messageRead, " + SUBJECT + " = :subject, " + CONTENT + " = :content WHERE " + ID + " = :id;";
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("receiverId", message.getReceiverId());
		vParams.addValue("senderId", message.getSenderId());
		vParams.addValue("previousMessageId", message.getPreviousMessageId());
		vParams.addValue("dateTime", message.getDateTime());
		vParams.addValue("messageRead", message.getMessageRead());
		vParams.addValue("subject", message.getSubject());
		vParams.addValue("content", message.getContent());
		vParams.addValue("id", message.getId());
		
		jdbcTemplate.update(vSQL, vParams);
	}
	
}
