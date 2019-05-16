package com.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.bean.Country;
import com.dao.CountryDao;

public class CountryDaoImpl implements CountryDao {
	private SessionFactory sessionFactory;

	@Override
	public List<Country> queryAll() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		
		return session.createQuery("from Country").list();
	}


	@Override
	public void delete(Country c) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.delete(c);
	}

	@Override
	public int add(Country c) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		int result = (Integer)session.save(c);
		return result;
	}

	@Override
	public void update(Country c) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.update(c);
	}

	@Override
	public List<Country> select(Country c) {
		Session session=sessionFactory.getCurrentSession();
		StringBuffer sb = new StringBuffer();
		ArrayList valueList = new ArrayList();
		sb.append("from Country where 1=1 ");
		if(c.getName()!=null && !"".equals(c.getName())){
			sb.append("and name like ? ");
			valueList.add("%"+c.getName()+"%");
		}
		if(c.getLanguage()!=null && !"".equals(c.getLanguage())){
			sb.append("and language=? ");
			valueList.add(c.getLanguage());
		}
		Query q = session.createQuery(sb.toString());
		for (int i = 0; i < valueList.size(); i++) {
			q.setParameter(i, valueList.get(i));
		}
		return q.list();
	}

	@Override
	public Country queryById(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		
		return (Country) session.get(Country.class, id);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
