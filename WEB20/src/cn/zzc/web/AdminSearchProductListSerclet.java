package cn.zzc.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.zzc.domain.Product;
import cn.zzc.service.AdminProductService;
import cn.zzc.vo.Condition;

public class AdminSearchProductListSerclet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		//获取数据
		Map<String, String[]> properies = request.getParameterMap();
		//封装数据到实体
		Condition condition = new Condition();
		try {
			BeanUtils.populate(condition, properies);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		} 
		//将实体传递给service
		AdminProductService service = new AdminProductService();
		List<Product> productList =  service.findProductListByCondition(condition);
		
		//转发页面
		request.setAttribute("productList", productList);
		request.getRequestDispatcher("/admin/product/list.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}