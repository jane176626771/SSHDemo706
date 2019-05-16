package com.dao;

import java.util.List;

import com.bean.Country;

public interface CountryDao {
	public List<Country> queryAll();
	public void delete(Country c);
	public int add(Country c);
	public void update(Country c);
	public List<Country> select(Country c);
	public Country queryById(int id);
}
