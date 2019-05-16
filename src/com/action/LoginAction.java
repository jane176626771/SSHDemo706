package com.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.bean.User;
import com.service.UserService;

public class LoginAction extends LogAction{
	private UserService service;
	private String name;
	private String password;
	public String login() throws IOException{
		User u=service.queryByName(name);
		if(u!=null&&u.getPassword().equals(password)){
			logger.info("µÇÂ½³É¹¦");
			String un=URLEncoder.encode(name, "utf-8");
			Cookie cookie=new Cookie("USERNAME",un);
			HttpServletResponse response=ServletActionContext.getResponse();
			cookie.setPath("/");
			response.addCookie(cookie);
			
			return "success";
		}else{
			logger.info("µÇÂ½Ê§°Ü");
			return "login";
		}
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
