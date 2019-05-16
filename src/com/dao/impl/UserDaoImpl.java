package com.dao.impl;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.bean.User;
import com.dao.UserDao;

public class UserDaoImpl implements UserDao {
	private SessionFactory sessionFactory;
	@Override
	public User queryByName(String name) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Query q = session.createQuery("from User where name=?");
		q.setString(0, name);
		return (User) q.list().get(0);
	}
	@Override
	public int add(User user) {
		Session session = sessionFactory.getCurrentSession();
		Integer r = (Integer) session.save(user);
		return r;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
