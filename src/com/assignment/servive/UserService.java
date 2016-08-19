package com.assignment.servive;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.assignment.model.Activity;
import com.assignment.model.Carpool;
import com.assignment.model.Express;
import com.assignment.model.User;
import com.assignment.tool.HibernateUtil;

public class UserService {

	private SessionFactory sf;

	/**
	 * 
	 * @param u
	 */
	public String saveUser(User u) {
		String result ="true";
		sf = new HibernateUtil().getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		try {
			session.save(u);
			session.getTransaction().commit();
		} catch (Exception e) {
			result = "false";

		}
		return result;
	}

	/**
	 * 
	 * @param u
	 * @return
	 */
	public boolean isUser(User u) {
		boolean flag = false;
		sf = new HibernateUtil().getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		try{
		User u1 = (User) session.get(User.class, u.getUserName());
		session.getTransaction().commit();
		if(u1 != null && u1.getUserName().equals(u.getUserName()) && u.getPassword().equals(u1.getPassword()))
			flag = true;
		}
		catch(Exception e){
			
		}
		return flag;

	}

	public void deleteActivity(Activity a) {

	}

	public void deleteCarpool(Carpool c) {

	}

	public void deleteExpress(Express e) {

	}

	public void modifyActivity(Activity a) {

	}

	public void modifyCarpool(Carpool c) {

	}

	public void modifyExpress(Express e) {

	}

}
