package com.assignment.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



/**
 * @author zhouxi
 *
 */
@Entity
public class Carpool {


	private int id;
	private String beginDate;
	private String beginArea;
	private String destination;
	private String tele;
	private String signed;
	private String User;


	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getSigning() {
		return signing;
	}

	public void setSigning(String signing) {
		this.signing = signing;
	}

	private String signing;    //  
	private String user;
	private Date publishDate;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getBeginArea() {
		return beginArea;
	}

	public void setBeginArea(String beginArea) {
		this.beginArea = beginArea;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getSigned() {
		return signed;
	}

	public void setSigned(String signed) {
		this.signed = signed;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public String getTele() {
		return tele;
	}

	public void setTele(String tele) {
		this.tele = tele;
	}

	@Override
	public String toString() {
		return "Carpool [id=" + id + ", beginDate=" + beginDate + ", beginArea=" + beginArea + ", destination=" + destination + ", tele=" + tele + ", signed=" + signed
				+ ", signing=" + signing + ", user=" + user + ", publishDate=" + publishDate + "]";
	}

}
