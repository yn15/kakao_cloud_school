package user.service;


import java.sql.SQLIntegrityConstraintViolationException;

import user.dao.UserDAO;
import user.vo.User;

public class UserService {
	
	public User signin(User user) {
		
		try {
			UserDAO dao = new UserDAO();
			user = dao.select(user);
			return user;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public int signup(User user) {
		try {
			UserDAO dao = new UserDAO();
			User check = new User();
			int result = dao.insert(user);
			return result;
		} catch(SQLIntegrityConstraintViolationException e) {
			return -1;
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return 0;
	}

}
