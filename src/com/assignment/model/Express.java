package com.assignment.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Express {

	private int id ;

	private String name;
	private String num;
	private String description;
	private String tel;
	private String user;
	private Date publishData;
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public Date getPublishData() {
		return publishData;
	}
	public void setPublishData(Date date) {
		this.publishData = date;
	}
	@Override
	public String toString() {
		return "Express [id=" + id + ", name=" + name + ", num=" + num + ", description=" + description + ", tel=" + tel + ", user=" + user + ", publishData=" + publishData + "]";
	}
	
	
}
