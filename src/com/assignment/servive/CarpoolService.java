package com.assignment.servive;

import org.hibernate.Query;
import org.hibernate.Session;

import com.assignment.model.Carpool;
import com.assignment.tool.HibernateUtil;

public class CarpoolService {

	public void savaCarpool(Carpool carpool) {

		Session session = new HibernateUtil().getSessionFactory()
				.getCurrentSession();

		session.beginTransaction();
		session.save(carpool);
		session.getTransaction().commit();

	}

	public java.util.List<Carpool> loadCarpool() {

		Session session = new HibernateUtil().getSessionFactory()
				.getCurrentSession();

		session.beginTransaction();
		Query query = session.createQuery("from Carpool as car");
		java.util.List list = query.list();
		session.getTransaction().commit();

		return list;

	}

}
