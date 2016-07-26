package com.assignment.action;

import java.util.Date;

import com.assignment.model.Carpool;
import com.assignment.servive.CarpoolService;
import com.opensymphony.xwork2.ActionSupport;

public class CarpoolAction extends ActionSupport {
	private int id;
	private Date beginDate;
	private String beginArea;
	private String destination;
	private int signed;
	private int signing;
	private String user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
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

	public int getSigned() {
		return signed;
	}

	public void setSigned(int signed) {
		this.signed = signed;
	}

	public int getSigning() {
		return signing;
	}

	public void setSigning(int signing) {
		this.signing = signing;
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

	private Date publishDate;

	public String execute() {
		Carpool carpool = new Carpool();
		carpool.setBeginArea(beginArea);
		// carpool.setBeginDate(new Date(beginDate));

		carpool.setDestination(destination);
		carpool.setSigned(signed);

		// ActivityService activityService = new ActivityService();
		CarpoolService carpoolService = new CarpoolService();
		carpoolService.savaCarpool(carpool);

		return "success";

	}

	public String loadString() {

		return null;
	}

}
