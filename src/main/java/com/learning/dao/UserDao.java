package com.learning.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.learning.pojo.User;

@Component
public class UserDao extends HibernateDaoSupport{
	
	public User getUserByUserNameAndPassword(String username, String password) {
		List<User> users = (List<User>)getHibernateTemplate().find("from User where username=? and password=?", username,password);
		if(users.size() > 0){
			return users.get(0);
		}
		return null;
	}
	
	@Autowired
    public void anyMethodName(SessionFactory sessionFactory)
    {
        setSessionFactory(sessionFactory);
    }

}
