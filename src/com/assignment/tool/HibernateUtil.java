package com.assignment.tool;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	public HibernateUtil() {
		sessionFactory = new AnnotationConfiguration().configure()
				.buildSessionFactory();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
