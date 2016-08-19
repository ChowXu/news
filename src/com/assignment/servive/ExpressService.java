package com.assignment.servive;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.assignment.model.Express;
import com.assignment.model.Pager;
import com.assignment.tool.HibernateUtil;

public class ExpressService {

	public void saveExpress(Express express) {
		Session session = new HibernateUtil().getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(express);
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
	public Pager<Express> getExpress(int currentPage, int pageSize) {

		Session session = new HibernateUtil().getSessionFactory().getCurrentSession();
		session.beginTransaction();
		StringBuffer HQL = new StringBuffer("from Express order by id desc");
		int currentIndex = (currentPage - 1) * pageSize;
		Query query = null;
		Query qry = null;
		// if (key != null && !"".equals(key)) {
		// HQL.append(" where name like :name or description like :description ");
		// query = session.createQuery(HQL.toString());
		// query.setParameter("name", "%" + key + "%");
		// query.setParameter("description", "%" + key + "%");
		//
		// qry = session.createQuery("select count(*)" + HQL.toString());
		// qry.setParameter("name", "%" + key + "%");
		// qry.setParameter("description", "%" + key + "%");
		// }
		query = session.createQuery(HQL.toString());
		qry = session.createQuery("select count(*) from Express");
		query.setFirstResult(currentIndex);
		query.setMaxResults(pageSize);
		List<Express> list = query.list();
		List<Express> list1 = qry.list();
		session.getTransaction().commit();
		int totalRecords = Integer.valueOf(String.valueOf(list1.get(0)));
		int totalPages = (int) Math.ceil((float) totalRecords / pageSize);
		return new Pager(currentPage, pageSize, totalRecords, totalPages, list);

	}

}
