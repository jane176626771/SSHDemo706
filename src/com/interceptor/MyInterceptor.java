package com.interceptor;

import java.net.URLDecoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class MyInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		String result="login";
		HttpServletRequest request=ServletActionContext.getRequest();
		Cookie[] cArr=request.getCookies();
		if(cArr!=null){
			for (Cookie cookie : cArr) {
				String username=URLDecoder.decode(cookie.getName(), "utf-8");
				if("USERNAME".equals(username)){
					result=arg0.invoke();
				}
			}
		}
		
		return result;
	}

}
