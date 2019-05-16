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
		String result ="ע��ʧ��";
		User user = new User();
		user.setName(name);
		user.setPassword(password);
		int r = service.add(user);
		if(r>0){
			result = "ע��ɹ�";
		}
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		out.println(result);//��result�е�ֵ���ݸ�app����
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
