package model.test;


import org.junit.Test;

import com.assignment.model.Activity;
import com.assignment.servive.MyReleaseService;

public class MyReleaseServiceTest {

	@Test
	public void test() {
		MyReleaseService rs = new MyReleaseService();
		
		rs.deleteActivity(19);
	}

}
