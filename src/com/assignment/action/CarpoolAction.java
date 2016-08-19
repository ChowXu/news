package com.assignment.action;

import java.io.IOException;
import java.io.Serializable;
import java.io.Writer;
import java.util.Date;

import com.alibaba.fastjson.JSON;
import com.assignment.model.Carpool;
import com.assignment.model.Pager;
import com.assignment.model.User;
import com.assignment.servive.CarpoolService;

public class CarpoolAction extends SuperAction implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String beginDate;
	private String beginArea;
	private String destination;
	private String signed;

	private String user;
	private String tele;

	// search model
	private String searchKey;
	private String currentPage;
	private String pageSize;
	private String searchName;

	/**
	 * 
	 */
	public String execute() {
		User u = (User) session.getAttribute("login_user");

		if (u != null && beginArea != null && destination != null && signed != null && beginDate != null && tele != null) {

			Carpool carpool = new Carpool();
			carpool.setBeginArea(beginArea);
			carpool.setDestination(destination);
			carpool.setSigned(signed);
			carpool.setBeginDate(beginDate);
			carpool.setPublishDate(new Date());
			carpool.setTele(tele);
			carpool.setUser(u.getUserName());
			CarpoolService carpoolService = new CarpoolService(); // can also be in spring
																	
			carpoolService.saveCarpool(carpool);
		}

		return "success";

	}

	public void write() throws IOException {

		int pageNum = 0, ps = 0;
		if (currentPage == null || currentPage.length() == 0)
			pageNum = 1;
		else {
			currentPage = currentPage.trim();
			pageNum = Integer.valueOf(currentPage);
		}
		if (this.pageSize == null)
			ps = 10;

		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("text/html;charset=utf-8");

		CarpoolService cs = new CarpoolService();
		Pager<Carpool> result = cs.getCarpools(searchKey, pageNum, ps);
		String responseStr = JSON.toJSONString(result);
		Writer pw = response.getWriter();
		pw.write(responseStr);
		pw.flush();
		pw.close();
	}

	public String loadString() {

		return null;
	}

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
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

	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	public String getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}

	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public String getTele() {
		return tele;
	}

	public void setTele(String tele) {
		this.tele = tele;
	}

}
