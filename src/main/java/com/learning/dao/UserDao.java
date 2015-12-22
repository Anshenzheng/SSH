package com.learning.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

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
	
	public boolean deleteUser(User user){
		try {
			getHibernateTemplate().delete(user) ;
		} catch (DataAccessException e) {
			return false;
		}
		return true;
	}
	
	public boolean addUser(User user){
		try {
			getHibernateTemplate().save(user) ;
		} catch (DataAccessException e) {
			return false;
		}
		return true;
	}
	
	public boolean addOrUpdateUser(User user){
		try {
			getHibernateTemplate().saveOrUpdate(user) ;
		} catch (DataAccessException e) {
			return false;
		}
		return true;
	}
	
	
	public boolean updateUser(User user){
		try {
			getHibernateTemplate().update(user) ;
		} catch (DataAccessException e) {
			return false;
		}
		return true;
	}
	
	public List<User> findAllUsers(){
		return (List<User>)getHibernateTemplate().find("from User");
	}
	
	@Autowired
    public void anyMethodName(SessionFactory sessionFactory)
    {
        setSessionFactory(sessionFactory);
        
    }

}
