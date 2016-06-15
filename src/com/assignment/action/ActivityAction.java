package com.assignment.action;

import com.assignment.model.Activity;
import com.assignment.servive.ActivityService;
import com.opensymphony.xwork2.ActionSupport;

public class ActivityAction extends ActionSupport {

	private String name;
	private String description;
	private String tele;

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
		ActivityService activityService = new ActivityService();
		activityService.savaActivity(activity);

		return "success";

	}

}
