package cn.zzc.web.servlet;

import org.junit.Test;

public class TestMyServlet {
	
	@Test
	public void testMyServlet() {
		MyServlet servlet = new MyServlet();
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
			
			MyServlet my = (MyServlet) clazz.newInstance();
			my.init();
			my.service();
			my.destory();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
