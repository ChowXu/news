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
		 * �ڵ���getWriter֮ǰδ���ñ���(�ȵ���setContentType����setCharacterEncoding�������ñ���),
		 * HttpServletResponse��᷵��һ����Ĭ�ϵı���(��ISO-8859-1)�����PrintWriterʵ���������ͻ�
		 * ����������롣�������ñ���ʱ�����ڵ���getWriter֮ǰ����,��Ȼ����Ч�ġ�
		 */
		response.setContentType("text/html;charset=utf-8");
		// response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		// JSON�ڴ��ݹ���������ͨ�ַ�����ʽ���ݵģ������ƴ��һ��������
		String jsonString = "{\"user\":{\"id\":\"123\",\"name\":\"����\",\"say\":\"Hello , i am a action to print a json!\",\"password\":\"JSON\"},\"success\":true}";
		out.println(jsonString);
		out.flush();
		out.close();

	}

}
