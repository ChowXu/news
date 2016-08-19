package model.test;

import java.io.IOException;
import org.junit.Test;
import com.assignment.model.Activity;
import com.assignment.model.Pager;
import com.assignment.servive.ActivityService;

public class ActivityServiceTest {



	@Test
	public void testSavaActivity() throws IOException {
		ActivityService service = new ActivityService();
		for (int i = 0; i < 20; i++) {
			Activity activity = new Activity();
			activity.setName("张三");
			activity.setTele("15" + String.valueOf((long) (Math.random() * 1000000000)));
			activity.setDescription("上课" + String.valueOf(Math.random() * 10));
			activity.setUser("wang");
			service.saveActivity(activity);

		}
		Pager<Activity> pager = service.getActivities(null, 1, 15);
		for(Activity a : pager.getDatalist())
			System.out.println(a.toString());

	

	}

	

}
