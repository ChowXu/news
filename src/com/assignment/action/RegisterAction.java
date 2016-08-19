package com.assignment.action;

import java.io.Serializable;

import com.assignment.model.User;
import com.assignment.servive.UserService;

public class RegisterAction extends SuperAction implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	private String username;
	private String password;
	private String email;
	
	private UserService us = new UserService();

	
	
	public String register(){
		User u = new User(username,password,email);
		if(us.saveUser(u).equals("true"))
			return "success";
		else
			return "failure";
	}
	
	
	
	public String login(){
		User u = new User(username,password,email);
		if(us.isUser(u)){
			session.setAttribute("login_user", u);
			return "success";
		}
		else
			return "failure";
		
	}
	
	
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
