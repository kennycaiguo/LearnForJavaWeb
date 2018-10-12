package cn.zzc.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zzc.domain.ProductList;
import cn.zzc.service.ProductService;

public class ProductInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 从页面中获取对应的pid
		String pid = request.getParameter("pid");
		// 1.传递请求到service层,按照pid对应查找
		ProductService service = new ProductService();
		List<ProductList> product = null;
		try {
			product = service.findProduct(pid);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 2.转发到jsp
		request.setAttribute("product", product);
		request.getRequestDispatcher("/product_info.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}