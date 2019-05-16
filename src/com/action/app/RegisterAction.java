package com.action.app;

import java.io.IOException;
import java.io.PrintWriter;

import org.apache.struts2.ServletActionContext;

import com.bean.User;
import com.service.UserService;

public class RegisterAction {
	private UserService service;
	private String name;
	private String password;
	public void register() throws IOException{
		String result ="注册失败";
		User user = new User();
		user.setName(name);
		user.setPassword(password);
		int r = service.add(user);
		if(r>0){
			result = "注册成功";
		}
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		out.println(result);//将result中的值传递给app程序
	}
	public UserService getService() {
		return service;
	}
	public void setService(UserService service) {
		this.service = service;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
