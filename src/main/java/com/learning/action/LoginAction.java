package com.learning.action;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.learning.dao.UserDao;
import com.learning.pojo.User;
import com.opensymphony.xwork2.ActionSupport;

@Component
public class LoginAction extends ActionSupport {

	public String username;
	public String password;
	public String message;
	public List<User> users;
	
	@Autowired
	UserDao userDao;
	Logger log = Logger.getLogger(getClass());

	public String execute() {
		
		log.info(username + " - " +password);
		
		User user = userDao.getUserByUserNameAndPassword(username, password);
		
		if (user != null) {
			
			log.error("logon success");
			
			users = userDao.findAllUsers();
			
			message = "welcome, " + username;
			
			return SUCCESS;
		}

		return ERROR;
	}

}
