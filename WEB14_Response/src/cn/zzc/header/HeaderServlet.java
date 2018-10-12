package cn.zzc.header;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HeaderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置响应头(add表示添加,set表示设置)
		//最新的addHeader直接添加到原乡同名的响应头后或者添加一个同名的响应头
		response.addHeader("name", "zzc");
		response.addHeader("name", "zsf");
		//最新的setHeader会覆盖原先同名的响应头
		response.setHeader("age", "18");
		response.setHeader("age", "29");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}