package model.test;

import java.util.List;

import net.sf.json.JSONObject;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;

import com.assignment.model.Activity;
import com.assignment.model.Carpool;
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
	public void test() {

		CarpoolService carpoolService = new CarpoolService();

		List<Carpool> list = carpoolService.loadCarpool();
		ActivityService  activityService = new ActivityService();
		List<Activity> acitvitylist = activityService.getActivities();
		
		for( Activity activity : acitvitylist){
			System.out.print(activity.getName());
			System.out.print(activity.getDescription());
			System.out.print(activity.getTele());
			System.out.print(activity.getId());
			
		}

		

//		for (Carpool carpool : list) {
//			System.out.println(carpool.getId());
//			System.out.println(carpool.getBeginArea());
//			System.out.println(carpool.getDestination());
//			System.out.println(carpool.getSigned());
//
//		}

	}

}
