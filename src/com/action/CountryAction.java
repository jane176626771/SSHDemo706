package com.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import com.bean.Country;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.service.CountryService;

public class CountryAction implements ModelDriven<Country> {
	private CountryService service;
	private List<Country> counList;
	private Country country;
	public String list(){
		counList=service.queryAll();
		return "countryList";
	}
	public String del(){
		service.delete(country);
		
		return list();
	}
	public String preAdd(){
		return "add";
	}
	public String add(){
		
		service.add(country);
		return list();
	}
	public String preUpdate() throws IOException{
		Country c = service.queryById(country.getId());
		ActionContext.getContext().put("c", c);
		return "update";
	}
	public String update(){
		service.update(country);
		return list();
	}
	public String queryByNameOrLanguage(){
		counList=service.select(country);
		return "countryList";
	}
	public CountryService getService() {
		return service;
	}
	public void setService(CountryService service) {
		this.service = service;
	}
	public List<Country> getCounList() {
		return counList;
	}
	public void setCounList(List<Country> counList) {
		this.counList = counList;
	}
	@Override
	public Country getModel() {
		// TODO Auto-generated method stub
		if(country==null){
			country=new Country();
		}
		return country;
	}
	
}
