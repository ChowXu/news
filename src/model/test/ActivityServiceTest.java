package model.test;

import java.io.IOException;
import java.util.List;

import net.sf.json.JSONObject;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;

import com.assignment.model.Activity;
import com.assignment.model.Carpool;
import com.assignment.model.Pager;
import com.assignment.servive.ActivityService;
import com.assignment.servive.CarpoolService;

public class ActivityServiceTest {

	private static SessionFactory sessionFactory;

	@Before
	public void boforeClass() {
		sessionFactory = new AnnotationConfiguration().configure()
				.buildSessionFactory();

		// sessionFactory = new AnnotationConfiguration().configure()
		// .buildSessionFactory();
	}

	
	
	@Test
	public void test() throws IOException {


		ActivityService  activityService = new ActivityService();
		Pager<Activity> activitylist = activityService.getActivities("课",1,10);
		
		System.out.println(activitylist.toString());

		

//		for (Carpool carpool : list) {
//			System.out.println(carpool.getId());
//			System.out.println(carpool.getBeginArea());
//			System.out.println(carpool.getDestination());
//			System.out.println(carpool.getSigned());
//
//		}

	}

}
