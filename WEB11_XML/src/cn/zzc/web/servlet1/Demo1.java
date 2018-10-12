package cn.zzc.web.servlet1;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class Demo1 {
	@Test
	public void demo1() {
		try {
			SAXReader saxReader = new SAXReader();
			Document document = saxReader.read("src/cn/zzc/xml/web.xml");
			
			//获取根元素
			Element rootElement = document.getRootElement();
			//获取第一个servlet
			Element servletElement1 = rootElement.element("servlet");
			//获取字符串实现类(servlet-class)的值
			String servletClass = servletElement1.element("servlet-class").getText();
			//获取字符串实现类实例
			Class<?> clazz = Class.forName(servletClass);
			MyServlet1 myServlet = (MyServlet1) clazz.newInstance();
			//执行对象方法 
			myServlet.init();
			myServlet.service();
			myServlet.destory();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
