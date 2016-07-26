package model.test;

import java.util.List;

import net.sf.json.JSONObject;

import org.hibernate.SessionFactory;
import org.junit.Test;

import com.assignment.model.Carpool;
import com.assignment.servive.CarpoolService;

public class ActivityServiceTest {

	private static SessionFactory sessionFactory;

	@Test
	public void test() {

		CarpoolService carpoolService = new CarpoolService();

		List<Carpool> list = carpoolService.loadCarpool();

		TotaJson totaJson = new TotaJson();

		totaJson.setList(list);
		totaJson.setResults(list.size());

		JSONObject jsonObject = JSONObject.fromObject(totaJson);

		System.out.println(jsonObject.toString());

		for (Carpool carpool : list) {
			System.out.println(carpool.getId());
			System.out.println(carpool.getBeginArea());
			System.out.println(carpool.getDestination());
			System.out.println(carpool.getSigned());

		}

	}

}
