package com.assignment.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.JSON;
import com.assignment.model.Express;
import com.assignment.model.Pager;
import com.assignment.model.User;
import com.assignment.servive.ExpressService;

public class ExpressAction extends SuperAction implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	private String num;
	private String description;
	private String tel;

	// search model
	private String searchKey;
	private String currentPage;
	private String pageSize;

	/**
	 * 
	 */
	public String execute() {
		User u = (User) session.getAttribute("login_user");

		if (u != null && name != null && description != null && num != null && tel != null) {
			ExpressService expressService = new ExpressService();
			Express es = new Express();
			es.setName(name);
			es.setDescription(description);
			es.setNum(num);
			es.setTel(tel);
			es.setPublishData(new Date());
			es.setUser(u.getUserName());
			expressService.saveExpress(es);
		}
		return "success";
	}

	/**
	 * 
	 * @throws IOException
	 */
	public void write() throws IOException {
		ExpressService expressService = new ExpressService();

		int pageNum = 0, ps = 0;
		if (currentPage == null || currentPage.length() == 0)
			pageNum = 1;
		else {
			currentPage = currentPage.trim();
			pageNum = Integer.valueOf(currentPage);
		}
		if (this.pageSize == null)
			ps = 10;
		Pager<Express> pager = expressService.getExpress(pageNum, ps);

		String jsonString = JSON.toJSONString(pager);

		response.setContentType("text/html;charset=utf-8");

		PrintWriter out = response.getWriter();

		out.println(jsonString);
		out.flush();
		out.close();

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

}
