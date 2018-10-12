package cn.zzc.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zzc.domain.Category;
import cn.zzc.domain.Product;
import cn.zzc.service.AdminProductService;

public class AdminUpdateProductUIServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取对应的pid
		String pid = request.getParameter("pid");
		AdminProductService service = new AdminProductService();
		Product product = service.findProductByPid(pid);
		
		
		//获得所有的商品的类别数据
		List<Category> categories = service.findAllCategory();
				
		request.setAttribute("categories", categories);
		request.setAttribute("product", product);

		request.getRequestDispatcher("/admin/product/edit.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}