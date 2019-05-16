package com.action.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.bean.Country;
import com.service.CountryService;

public class CountryAppAction {
	private CountryService service;
	private List<Country> counList;
	private Country country;
	
	public void queryApp() throws IOException{
		counList = service.select(country);
		
//		只加入json-lib-x.x.jar包不行，对应的几个jar一起引入
		JSONObject json = new JSONObject();
		json.put("countrys", counList);//将ArrayList对象封装成JSONObject对象
		
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		out.println(json);
		out.flush();
		out.close();
	}
	public void addCountry() throws IOException{
		int result = service.add(country);
		JSONObject json = new JSONObject();
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		if(result > 0){
			country.setId(result);
			ArrayList<Country> countryList = new ArrayList<Country>();
			countryList.add(country);
			json.put("country", countryList);
			out.println(json);
		}else{
			out.println("增加失败");
		}
		out.flush();
		out.close();
	}
	
	public void deleteCountry() throws IOException{
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		try{
			service.delete(country);
			out.println("删除成功");
		}catch(Exception e){
			out.println("删除失败");
		}
		out.flush();
		out.close();
	}
	public void updateCountry() throws IOException{
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		try{
			service.update(country);
			out.println("修改成功");
		}catch (Exception e) {
			out.println("修改失败");
		}
		out.flush();
		out.close();
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
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	
}
