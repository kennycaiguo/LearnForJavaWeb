package cn.zzc.web.servlet1;

import org.junit.Test;

public class TestMyServlet {
	
	@Test
	public void testMyServlet() {
		MyServlet1 servlet = new MyServlet1();
		servlet.init();
		servlet.service();
		servlet.destory();
	}
	
	@Test
	public void testMyServlet1() {
		try {
			//1.
			String className = "cn.zzc.web.servlet.MyServlet";
			Class clazz = Class.forName(className);
			
			MyServlet1 my = (MyServlet1) clazz.newInstance();
			my.init();
			my.service();
			my.destory();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
