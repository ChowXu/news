package com.assignment.servive;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import com.assignment.model.Activity;
import com.assignment.model.Pager;
import com.assignment.tool.HibernateUtil;

public class ActivityService {

	/**
	 * save Entity
	 * 
	 * @param activity
	 */
	public void savaActivity(Activity activity) {
		Session session = new HibernateUtil().getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(activity);
		session.getTransaction().commit();
	}

	/**
	 * 
	 * @param key
	 *            Search key
	 * @param currentPage
	 *            index of page to get
	 * @param pageSize
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Pager<Activity> getActivities(String key, int currentPage, int pageSize) {

		Session session = new HibernateUtil().getSessionFactory().getCurrentSession();
		session.beginTransaction();
		// Map<String,Object> paramMap = new HashMap<String,Object>();

		StringBuffer HQL = new StringBuffer("from Activity");
		int currentIndex = (currentPage - 1) * pageSize;
		Query query = null;
		Query qry = null;
		if (key != null && !"".equals(key)) {
			HQL.append(" where name like :name or description like :description ");
			query = session.createQuery(HQL.toString());
			query.setParameter("name", "%" + key + "%");
			query.setParameter("description", "%" + key + "%");

			qry = session.createQuery("select count(*)" + HQL.toString());
			qry.setParameter("name", "%" + key + "%");
			qry.setParameter("description", "%" + key + "%");
		} else {
			query = session.createQuery(HQL.toString());
			qry = session.createQuery("select count(*) from Activity");
		}
		query.setFirstResult(currentIndex);
		query.setMaxResults(pageSize);

		List<Activity> list = query.list();
		List<Activity> list1 = qry.list();

		session.getTransaction().commit();
		int totalRecords = Integer.valueOf(String.valueOf(list1.get(0)));
		int totalPages = (int) Math.ceil((float) totalRecords / pageSize);
		return new Pager(currentPage, pageSize, totalRecords, totalPages, list);

	}

}
