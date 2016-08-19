package com.assignment.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String username;
	private String password;
	private String email;

	@Id
	public String getUserName() {
		return username;
	}

	public void setUserName(String name) {
		this.username = name;
	}

	public User() {
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

	@Override
	public String toString() {
		return "User [name=" + username + ", password=" + password + ", email=" + email + "]";
	}

	public User(String name, String password, String email) {
		super();
		this.username = name;
		this.password = password;
		this.email = email;
	}

}
