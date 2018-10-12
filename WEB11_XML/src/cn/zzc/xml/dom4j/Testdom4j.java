package cn.zzc.xml.dom4j;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Testdom4j {
	public static void main(String[] args) {
		try {
			//1.获取解析器
			SAXReader saxReader = new SAXReader();
			//2.获取Document文档对象
			Document doc = saxReader.read("src/cn/zzc/xml/schema/web.xml");
			//Document doc = saxReader.read("src/cn/zzc/xml/dtd/web.xml");
			//3.获取根元素
			Element rootElement = doc.getRootElement();
			//System.out.println(rootElement.getName());//获取根元素名称
			//System.out.println(rootElement.attributeValue("version"));//获取根元素中属性值
			//4.获取根元素下的子元素
			@SuppressWarnings("unchecked")
			List<Element> childElements = rootElement.elements();
			//5.遍历子元素
			for (Element element : childElements) {
				if("servlet".equals(element.getName())) {
					Element servletName = element.element("servlet-name");
					Element servletClass = element.element("servlet-class");
					System.out.println(servletName.getText()+"\t"+servletClass.getText());
				}else if ("servlet-mapping".equals(element.getName())) {
					Element servletName = element.element("servlet-name");
					Element urlPattern = element.element("url-pattern");
					System.out.println(servletName.getText()+"\t"+urlPattern.getText());
				}
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
}
