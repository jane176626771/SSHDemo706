package com.action.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.bean.User;
import com.service.UserService;

public class LoginAppAction {
	private UserService service;
	private String name;
	private String password;
	public void login() throws IOException{
		User u=service.queryByName(name);
		String result = "µÇÂ¼Ê§°Ü";
		if(u!=null&&u.getPassword().equals(password)){
			result = "µÇÂ¼³É¹¦";
			String un=URLEncoder.encode(name, "utf-8");
			Cookie cookie=new Cookie("USERNAME",un);
			HttpServletResponse response=ServletActionContext.getResponse();
			cookie.setPath("/");
			response.addCookie(cookie);
		}
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		out.println(result);
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
