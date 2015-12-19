package com.learning.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import com.learning.dao.UserDao;
import com.learning.pojo.User;

@Component
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	@Override
	public User getUserByUserNameAndPassword(String username, String password) {
		List<User> users = (List<User>)getHibernateTemplate().find("from User where username=? and password=?", username,password);
		if(users.size() > 0){
			return users.get(0);
		}
		return null;
	}



}
