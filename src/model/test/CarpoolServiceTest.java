package model.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.assignment.model.Carpool;
import com.assignment.model.Pager;
import com.assignment.servive.CarpoolService;
import com.assignment.tool.HibernateUtil;

@SuppressWarnings("unused")
public class CarpoolServiceTest {

	private SessionFactory sessionFactory;

	@Before
	public void BeforeClass() {
		sessionFactory = new HibernateUtil().getSessionFactory();
	}


	/**
	 * 
	 */
	@Test
	public void testSaveCarpool(){
		
		CarpoolService cs = new CarpoolService();
		for(int i = 0; i < 20; i++){
			Carpool c = new Carpool();
			c.setTele(String.valueOf((int)(Math.random() * 100000000)));
			c.setBeginArea(Math.random() > 0.5 ? "南湖": "文昌");
			c.setPublishDate(new Date());
			c.setBeginDate(String.valueOf(new Date()));
			c.setSigned(String.valueOf(Math.random() * 10) );
			c.setDestination(Math.random() > 0.3 ? "火车站":"高铁站");
			cs.saveCarpool(c);
			
		}
		
		List<Carpool> list= cs.getAll();
		for(Carpool c : list){
			System.out.println(c.toString());
			
		}
		
	}

}
