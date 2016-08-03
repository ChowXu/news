package model.test;

import java.sql.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.assignment.model.Activity;
import com.assignment.model.Carpool;
import com.assignment.tool.HibernateUtil;

public class HibernateORMappingTest {

	private static SessionFactory sessionFactory;

	@BeforeClass
	public static void beforeClass() {

		sessionFactory = new AnnotationConfiguration().configure()
				.buildSessionFactory();

	}

	@AfterClass
	public static void afterClass() {
		sessionFactory.close();
	}

	@Test
	public void testSavaActivity() {
		Session session = sessionFactory.getCurrentSession();
		Activity activity = new Activity();
		activity.setName("hahah");
		activity.setDescription("this is a sample description");
		activity.setTele("*******");

		session.beginTransaction();
		session.save(activity);
		session.getTransaction().commit();

	}

	@Test
	public void testSaveCarpool() {
		Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();

		for (int i = 0; i < 10; i++) {
			Carpool carpool = new Carpool();

			Date date = new Date(System.currentTimeMillis() + i * 100000000);

			carpool.setBeginDate(date);

			session.save(carpool);
		}
		session.getTransaction().commit();

	}

	@SuppressWarnings("unchecked")
	@Test
	public void testLoadCarpool() {
		Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();

		for (int i = 0; i < 10; i++) {
			Carpool carpool = new Carpool();

			Date date = new Date(System.currentTimeMillis() + i * 100000000);

			carpool.setBeginDate(date);

			session.save(carpool);
		}
		session.getTransaction().commit();

		session = new HibernateUtil().getSessionFactory().getCurrentSession();

		session.beginTransaction();

		Query query = session.createQuery("from Carpool as car");
		List<Carpool> list = query.list();

		session.getTransaction().commit();

		for (int i = 0; i < list.size(); i++) {
			Carpool carpool = (Carpool) list.get(i);

			System.out.print(carpool.getBeginDate() + "\n");

		}

	}

	// @Test
	// public void testSchemaExport() {
	//
	// new SchemaExport(new AnnotationConfiguration().configure()).create(
	// false, true);
	// }

	// public static void main(String[] arg) {
	// beforeClass();
	// }



}
