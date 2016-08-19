package model.test;


import java.util.Date;

import org.junit.Test;

import com.assignment.model.Express;
import com.assignment.model.Pager;
import com.assignment.servive.ExpressService;


public class ExpressServiceTest {


	@Test
	public void test() {
		
		ExpressService cs = new ExpressService();
		for(int i = 0; i < 20; i++){
			Express c = new Express();
			c.setTel(String.valueOf((int)(Math.random() * 100000000)));
			c.setDescription((Math.random() > 0.5 ? "南湖": "文昌"));
			c.setPublishData(new Date());
			c.setNum(String.valueOf(Math.random() * 10) );
			cs.saveExpress(c);
			
		}
		
		Pager<Express> pager = cs.getExpress(1, 10);
		for(Express c : pager.getDatalist()){
		
			System.out.println(c.toString());
			
		}
		
		
		
	
	}

}
