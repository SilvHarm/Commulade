package fr.silvharm.commulade.business.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import fr.silvharm.commulade.model.bean.CommentBean;
import fr.silvharm.commulade.model.pojo.Comment;

public class PojoConverterHelper {
	
	public static List<CommentBean> commentToCommentBean(List<Comment> list, Map<Integer, String> usernameMap) {
		List<CommentBean> beanList = new ArrayList<CommentBean>();
		CommentBean tempo = new CommentBean();
		
		for (Comment comment : list) {
			tempo.setUsername(usernameMap.get(comment.getUserId()));
			tempo.setDate(comment.getDateTime().toLocalDate().toString());
			tempo.setTime(comment.getDateTime().toLocalTime().toString());
			tempo.setComment(comment.getComment());
			
			beanList.add(tempo);
		}
		
		return beanList;
	}
}
