package com.assignment.servive;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import com.assignment.model.Carpool;
import com.assignment.model.Pager;
import com.assignment.tool.HibernateUtil;

public class CarpoolService {

	/**
	 * 
	 * @param carpool
	 *            save carpool obj
	 */
	public void saveCarpool(Carpool carpool) {

		Session session = new HibernateUtil().getSessionFactory().getCurrentSession();

		session.beginTransaction();
		session.save(carpool);
		session.getTransaction().commit();

	}

	/**
	 * 
	 * @param key
	 * @param SearchValue
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Pager<Carpool> getCarpools(String key,int currentPage, int pageSize) {
		Session session = new HibernateUtil().getSessionFactory().getCurrentSession();
		session.beginTransaction();
		StringBuffer HQL = new StringBuffer("from Carpool");
		int currentIndex = (currentPage - 1) * pageSize;
		Query query = null;
		Query qry = null;
		if (key != null && !"".equals(key)) {
			HQL.append(" where destination like :destination order by id desc");
			query = session.createQuery(HQL.toString());
			query.setParameter("destination", "%" + key + "%");

			qry = session.createQuery("select count(*)" + HQL.toString());
			qry.setParameter("destination", "%" + key + "%");
		} else {
			query = session.createQuery(HQL.toString() + " order by id desc");
			qry = session.createQuery("select count(*) from Carpool");
		}
		query.setFirstResult(currentIndex);
		query.setMaxResults(pageSize);

		List<Carpool> list = query.list();
		List<Carpool> list1 = qry.list();

		session.getTransaction().commit();
		int totalRecords = Integer.valueOf(String.valueOf(list1.get(0)));
		int totalPages = (int) Math.ceil((float) totalRecords / pageSize);
		return new Pager(currentPage, pageSize, totalRecords, totalPages, list);

	}

	/**
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Carpool> getAll() {
		Session session = new HibernateUtil().getSessionFactory().getCurrentSession();

		session.beginTransaction();
		List<Carpool> list = (List<Carpool>) session.createQuery("from Carpool").list();
		session.getTransaction().commit();

		return list;

	}

}
