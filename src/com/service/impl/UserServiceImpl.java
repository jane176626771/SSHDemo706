package com.service.impl;


import com.bean.Country;
import com.bean.User;
import com.dao.UserDao;
import com.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao dao;
	@Override
	public User queryByName(String name) {
		return dao.queryByName(name);
	}
	@Override
	public int add(User user) {
		return dao.add(user);
	}
	public UserDao getDao() {
		return dao;
	}
	public void setDao(UserDao dao) {
		this.dao = dao;
	}
	
}
