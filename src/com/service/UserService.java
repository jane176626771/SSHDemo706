package com.service;


import com.bean.User;

public interface UserService {
	public User queryByName(String name);
	public int add(User user);
}
