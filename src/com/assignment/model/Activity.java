package com.assignment.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Activity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private String description;
	private String tele;
	private String user;
	private Date publicDate;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public Activity() {
		
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTele() {
		return tele;
	}

	public void setTele(String tele) {
		this.tele = tele;
	}

	public Date getPublicDate() {
		return publicDate;
	}

	public void setPublicDate(Date publicDate) {
		this.publicDate = publicDate;
	}

	@Override
	public String toString() {
		return "Activity [id=" + id + ", name=" + name + ", description=" + description + ", tele=" + tele + ", user=" + user + ", publicDate=" + publicDate + "]";
	}

}
