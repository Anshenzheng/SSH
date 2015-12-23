package com.learning.action;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.learning.dao.UserDao;
import com.learning.pojo.User;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

@Namespace("/user")
@Results({
	   @Result(name="success", location="/index.jsp"),
	   @Result(name="input", location="/index.jsp")
	})
@Component
public class UserAction extends ActionSupport {
	public List<User> users;
	public User user;
	public int id;
	
	@Autowired
	UserDao userDao;
	Logger log = Logger.getLogger(getClass());

	@Action(value="/add")
	public String addUser(){
		userDao.addOrUpdateUser(user);
		users = userDao.findAllUsers();
		return SUCCESS;
	}
	@Action(value="/update")
	public String updateUser(){
		user.setId(id);
		userDao.updateUser(user);
		users = userDao.findAllUsers();
		return SUCCESS;
	}
	@Action(value="/delete")
	public String deleteUser(){
		user.setId(id);
		userDao.deleteUser(user);
		users = userDao.findAllUsers();
		return SUCCESS;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	

}
