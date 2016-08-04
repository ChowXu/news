package com.assignment.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.assignment.model.Activity;
import com.assignment.servive.ActivityService;

@SuppressWarnings("serial")
public class ActivityAction extends SuperAction {

	// domain model
	private String name;
	private String description;
	private String tele;

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

	public String execute() {
		Activity activity = new Activity();
		activity.setName(name);
		activity.setDescription(description);
		activity.setTele(tele);
		activityService.savaActivity(activity);
		return "success";

	}

	// query Activity
	public String query() {
		List<Activity> list = activityService.getActivities();
		if (list != null && list.size() > 0) {
			session.setAttribute("activity_list", list);
		} else {
			session.setAttribute("activity_list", null);
		}
		return "query_success";

	}
	
	

	public void write() throws IOException {

		HttpServletResponse response = ServletActionContext.getResponse();
		/*
		 * 在调用getWriter之前未设置编码(既调用setContentType或者setCharacterEncoding方法设置编码),
		 * HttpServletResponse则会返回一个用默认的编码(既ISO-8859-1)编码的PrintWriter实例。这样就会
		 * 造成中文乱码。而且设置编码时必须在调用getWriter之前设置,不然是无效的。
		 */
		response.setContentType("text/html;charset=utf-8");
		// response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		// JSON在传递过程中是普通字符串形式传递的，这里简单拼接一个做测试
		String jsonString = "{\"user\":{\"id\":\"123\",\"name\":\"张三\",\"say\":\"Hello , i am a action to print a json!\",\"password\":\"JSON\"},\"success\":true}";
		out.println(jsonString);
		out.flush();
		out.close();

	}

}
