package com.assignment.servive;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.assignment.model.Activity;
import com.assignment.tool.HibernateUtil;

public class ActivityService {

	public void savaActivity(Activity activity) {
		Session session = new HibernateUtil().getSessionFactory()
				.getCurrentSession();

		session.beginTransaction();
		session.save(activity);
		session.getTransaction().commit();

	}

	public List<Activity> getActivities() {

		Session session = new HibernateUtil().getSessionFactory()
				.getCurrentSession();

		session.beginTransaction();
		Query query = session.createQuery("from Activity");
		List<Activity> list = query.list();


		session.getTransaction().commit();

		return list;

	}

}
