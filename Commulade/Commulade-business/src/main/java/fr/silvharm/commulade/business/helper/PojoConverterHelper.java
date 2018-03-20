package fr.silvharm.commulade.business.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import fr.silvharm.commulade.model.bean.CommentBean;
import fr.silvharm.commulade.model.pojo.Comment;

public class PojoConverterHelper {
	
	public static List<CommentBean> commentToCommentBean(List<Comment> list, Map<Integer, String> usernameMap) {
		List<CommentBean> beanList = new ArrayList<CommentBean>();
		String commentStr, date, time, username;
		
		for (Comment comment : list) {
			username = usernameMap.get(comment.getUserId());
			date = comment.getDateTime().toLocalDate().toString();
			time = comment.getDateTime().toLocalTime().toString();
			commentStr = comment.getComment();
			
			beanList.add(new CommentBean(username, date, time, commentStr));
		}
		
		return beanList;
	}
}
