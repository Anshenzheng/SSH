package com.learning.action;

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
	@Autowired
	UserDao userDao;
	Logger log = Logger.getLogger(getClass());

	public String execute() {
		log.info(username + " - " +password);
		User user = userDao.getUserByUserNameAndPassword(username, password);
		if (user != null) {
			log.error("logon success");
			message = "welcome, " + username;
			return SUCCESS;
		}

		return ERROR;

	}


}
