package comment.service;

import comment.dao.CommentDAO;
import comment.vo.Comment;

public class CommentService {

	public int writeComment(Comment comment) {
		try {
			CommentDAO dao = new CommentDAO();
			int result = dao.insert(comment);
			return result;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	public int deleteComment(String cID) {
		try {
			CommentDAO dao = new CommentDAO();
			int result = dao.delete(cID);
			return result;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

}
