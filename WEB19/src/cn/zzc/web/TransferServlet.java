package cn.zzc.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zzc.service.TransferService;

public class TransferServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接收转账的参数
		String out = request.getParameter("out");
		String in = request.getParameter("in");
		String moneyStr = request.getParameter("money");
		//将字符串的money转为doubule
		double money = Double.parseDouble(moneyStr);
		
		//调用业务层转账方法
		TransferService service = new TransferService();
		boolean isTransferSuccess = service.transfer(out,in,money);
		response.setContentType("text/html;charset=UTF-8");
		if(isTransferSuccess) {
			//response.getWriter().write("转账成功!");
			
			//转发页面
			request.getRequestDispatcher("success.jsp").forward(request, response);
		}else {
			response.getWriter().write("转账失败!");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}