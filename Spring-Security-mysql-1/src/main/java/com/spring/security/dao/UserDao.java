package com.spring.security.dao;

import com.spring.security.pojo.AuthenticatedUser;

public interface UserDao {

	public AuthenticatedUser getByUserNamer(String username);

}
