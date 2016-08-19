package com.assignment.action;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.assignment.model.Activity;
import com.assignment.model.Carpool;
import com.assignment.model.Express;
import com.assignment.servive.MyReleaseService;

public class ReleaseAction extends SuperAction {

	private MyReleaseService ms = new MyReleaseService();
	

	private String userName;
	private int id;

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	
	/**
	 * 
	 * @throws IOException  how to catch
	 */
	public void showActivity() throws IOException {

		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("text/html;charset=utf-8");
		List<Activity> list = ms.queryActivity(userName);
		String responseStr = JSON.toJSONString(list);
		Writer out = response.getWriter();
		out.write(responseStr);
		out.flush();
		out.close();
	}

	/**
	 *  Exception manage
	 */
	public void deleteActivity()  {
		int oid = id;

		ms.deleteActivity(oid);
	}
	public void deleteCarpool()  {
		int oid = id;

		ms.deleteCarpool(oid);
	}
	public void deleteExpress()  {
		int oid = id;

		ms.deleteExpress(oid);
	}

	public void showCarpool() throws IOException {
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("text/html;charset=utf-8");
		List<Carpool> list = ms.queryCarpool(userName);
		String responseStr = JSON.toJSONString(list);
		Writer out = response.getWriter();
		out.write(responseStr);
		out.flush();
		out.close();
		

	}

	public void showExpress() throws IOException {
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("text/html;charset=utf-8");
		List<Express> list = ms.queryExpress(userName);
		String responseStr = JSON.toJSONString(list);
		Writer out = response.getWriter();
		out.write(responseStr);
		out.flush();
		out.close();

	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
