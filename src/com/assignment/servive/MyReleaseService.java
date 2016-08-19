package com.assignment.servive;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.assignment.model.Activity;
import com.assignment.model.Carpool;
import com.assignment.model.Express;
import com.assignment.tool.HibernateUtil;

public class MyReleaseService {
	SessionFactory sf = new HibernateUtil().getSessionFactory();
	
	@SuppressWarnings("unchecked")
	public List<Activity> queryActivity(String name){
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		Query q  = s.createQuery("from Activity where user = :user" );
		q.setParameter("user", name);
		List<Activity> list = q.list();
		s.getTransaction().commit();
		return list;
		
	}
	
	public void deleteActivity(int id){
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		Activity a = new Activity();
		a.setId(id);
		s.delete(a);
		s.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	public List<Carpool> queryCarpool(String name){
		
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		Query q  = s.createQuery("from Carpool where user = :user" );
		q.setParameter("user", name);
		List<Carpool> list = q.list();
		s.getTransaction().commit();
		return list;
		
	}
	public void deleteCarpool(int id){
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		Carpool a = new Carpool();
		a.setId(id);
		s.delete(a);
		s.getTransaction().commit();
		
	}
	

	@SuppressWarnings("unchecked")
	public List<Express> queryExpress(String name){
		
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		Query q  = s.createQuery("from Express where user = :user" );
		q.setParameter("user", name);
		List<Express> list = q.list();
		s.getTransaction().commit();
		return list;
		
	}
	public void deleteExpress(int id){
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		Express a = new Express();
		a.setId(id);
		s.delete(a);
		s.getTransaction().commit();
		
	}
	

}
