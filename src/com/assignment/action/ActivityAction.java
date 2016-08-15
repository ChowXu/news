package com.assignment.action;

import java.io.IOException;
import java.io.PrintWriter;

import com.alibaba.fastjson.JSON;
import com.assignment.model.Activity;
import com.assignment.model.Pager;
import com.assignment.servive.ActivityService;

@SuppressWarnings("serial")
public class ActivityAction extends SuperAction {

	// domain model
	private String name;
	private String description;
	private String tele;

	// search model
	private String searchKey;
	private String currentPage;
	private String pageSize;

	/*
	 * 
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */

	public String execute() {
		Activity activity = new Activity();
		activity.setName(name);
		activity.setDescription(description);
		activity.setTele(tele);
		activityService.savaActivity(activity);
		return "success";

	}

	/**
	 * 
	 * @return query_
	 * @throws IOException
	 */
	public String query() throws IOException {
		int pageNum = 0, ps = 0;
		if (currentPage == null || currentPage.length() == 0)
			pageNum = 1;
		else {
			currentPage = currentPage.trim();
			pageNum = Integer.valueOf(currentPage);
		}
		if (this.pageSize == null)
			ps = 10;
		Pager<Activity> pager = activityService.getActivities(this.searchKey, pageNum, ps);
		if (pager.getDatalist() != null && pager.getDatalist().size() > 0) {
			session.setAttribute("activity_list", pager);
		} else {
			session.setAttribute("activity_list", null);
		}
		return "query_success";

	}

	public void write() throws IOException {

		/*
		 * �ڵ���getWriter֮ǰδ���ñ���(�ȵ���setContentType����setCharacterEncoding�������ñ���),
		 * HttpServletResponse��᷵��һ����Ĭ�ϵı���(��ISO-8859-1)�����PrintWriterʵ���������ͻ�
		 * ����������롣�������ñ���ʱ�����ڵ���getWriter֮ǰ����,��Ȼ����Ч�ġ�
		 */
		int pageNum = 0, ps = 0;
		if (currentPage == null || currentPage.length() == 0)
			pageNum = 1;
		else {
			currentPage = currentPage.trim();
			pageNum = Integer.valueOf(currentPage);
		}
		if (this.pageSize == null)
			ps = 10;
		Pager<Activity> pager = activityService.getActivities(this.searchKey, pageNum, ps);

		String jsonString = JSON.toJSONString(pager);

		response.setContentType("text/html;charset=utf-8");

		PrintWriter out = response.getWriter();

		out.println(jsonString);
		out.flush();
		out.close();

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

	//
	private ActivityService activityService = new ActivityService();

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

}
