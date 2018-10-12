package cn.zzc.web.servlet1;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Before;
import org.junit.Test;

public class Demo2 {
	private HashMap<String, String> data = new HashMap<String,String>();
	
	@Before
	public void testReadWEBXml() {
		try {
			//1.创建解析器对象
			SAXReader saxReader = new SAXReader();
			//2.使用解析器加载web.xml文件得到document对象
			Document document = saxReader.read("src/cn/zzc/xml/web.xml");
			
			//3.获取根元素节点
			Element rootElement = document.getRootElement();
			//4.获取子节点(servlet和servlet-mapping)
			@SuppressWarnings("unchecked")
			List<Element> childElement = rootElement.elements();
			//5.遍历
			for (Element element : childElement) {
				//6.判断元素的名称为servlet的元素节点
				if("servlet".equals(element.getName())) {
					//7.分别获取servlet元素节点的servlet-name和servlet-class的值
					String servletName = element.element("servlet-name").getText();
					String servletClass = element.element("servlet-class").getText();
					data.put(servletName, servletClass);
				}
				//9.判断元素的名称为servlet-mapping的元素节点
				if("servlet-mapping".equals(element.getName())) {
					//10.分别获取servlet元素节点的servlet-name和url-pattern的值
					String servletName = element.elementText("servlet-name");
					String urlPattern = element.elementText("url-pattern");
					//11.将servletName作为key来获取servletClass的值
					String servletClass = data.get(servletName);
					//12.将url-pattern作为key,servletClass作为value存到map中去
					data.put(urlPattern, servletClass);
					//13.移除servletName
					data.remove(servletName);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testMyServlet() {
		try {
			//1.模拟在浏览器输入一个url
			String url1 = "/myServlet1";
			//2.将urlPattern作为key来获取servletClass
			String className = data.get(url1);
			//3.通过servletClass获取字节码文件
			Class clazz = Class.forName(className);
			//获取所有方法
			/*Object obj = clazz.newInstance();
			Method[] methods = clazz.getMethods();
			for (Method method : methods) {
				method.invoke(obj, null);
			}*/
			//获取特定方法
			//4.通过字节码文件创建实例对象
			Object obj = clazz.newInstance();
			//5.通过字节码文件获取方法(两个参数：第一个是方法名称；第二个参数是方法的参数)
			Method method = clazz.getMethod("init", null);
			//6.调用invoke方法执行实例对象里面的方法(前面写的方法init)【两个参数：第一个是调用方法的实例对象，第二个是方法的实参】
			method.invoke(obj, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
