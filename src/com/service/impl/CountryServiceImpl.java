package com.service.impl;

import java.util.List;

import com.bean.Country;
import com.dao.CountryDao;
import com.service.CountryService;

public class CountryServiceImpl implements CountryService {
	
	private CountryDao dao;
	@Override
	public List<Country> queryAll() {
		// TODO Auto-generated method stub
		return dao.queryAll();
	}
	
	@Override
	public void delete(Country c) {
		// TODO Auto-generated method stub
		dao.delete(c);
	}
	@Override
	public int add(Country c) {
		return dao.add(c);
	}
	@Override
	public void update(Country c) {
		// TODO Auto-generated method stub
		dao.update(c);
	}
	@Override
	public List<Country> select(Country c) {
		return dao.select(c);
	}
	@Override
	public Country queryById(int id) {
		// TODO Auto-generated method stub
		return dao.queryById(id);
	}
	
	public CountryDao getDao() {
		return dao;
	}
	public void setDao(CountryDao dao) {
		this.dao = dao;
	}
}
