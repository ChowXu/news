package model.test;

import java.security.NoSuchAlgorithmException;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.assignment.model.User;
import com.assignment.servive.UserService;
import com.assignment.tool.HibernateUtil;
import com.sun.crypto.provider.SunJCE;

public class UserServiceTest {
	private UserService us ;
	private SessionFactory sf ;
	private KeyGenerator keygen;
	private SecretKey deskey;
	private Cipher c;
	private byte[] cipherByte;
	
	@Before
	public void before(){
		us = new UserService();
	}

	@After
	public void after(){
		us = null;
	}
	
	@Test
	public void testDES() throws NoSuchAlgorithmException{
		Security.addProvider(new com.sun.crypto.provider.SunJCE());
		keygen = KeyGenerator.getInstance("DES");
		
	}
	
	
	@Test
	public void testSave() {
		String result = "true";
		
		sf = new HibernateUtil().getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		try {
			User u = new User();
			u.setUserName("asdfasf");
			session.save(u);
			session.getTransaction().commit();
		} catch (Exception e) {
			result = "false";

		}
	

		finally{
			System.out.println(result);
		}
	}
	
	@Test
	public void testDelete(){

		User u = new User();
		u.setUserName("Tom");
		u.setPassword("12345");
		u.setEmail("");
		
		System.out.println(us.isUser(u));
		
	}
	
	
	
		
	


}
