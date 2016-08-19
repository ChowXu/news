package com.assignment.action;

import java.io.IOException;
import java.io.Writer;

import com.alibaba.fastjson.JSON;
import com.assignment.model.User;

public class SessionAction extends SuperAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private User user;
	
	public void getSession() throws IOException{
		user = (User) session.getAttribute("login_user");
		String str = JSON.toJSONString(user);
		response.setContentType("text/html;charset=utf-8");
		Writer out = response.getWriter();
		out.write(str);
		out.flush();
		out.close();
		
	}
	
	

}
