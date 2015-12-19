package com.learning.dao;

import com.learning.pojo.User;

public interface UserDao {
	
	User getUserByUserNameAndPassword(String username,String password);

}
