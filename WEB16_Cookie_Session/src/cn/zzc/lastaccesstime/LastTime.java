package cn.zzc.lastaccesstime;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LastTime extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获得当前时间
		Date date = new Date();
		//格式化时间
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String currentTime = format.format(date);

		//1、创建Cookie 记录当前的最新的访问时间
		Cookie cookie = new Cookie("lastTime", currentTime);
		cookie.setMaxAge(60*10*300);
		response.addCookie(cookie);
		
		//2、获得客户端携带cookie ---- lastTime
		String lastTime = null;
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for (Cookie coo : cookies) {
				if("lastTime".equals(coo.getName())) {
					lastTime = coo.getValue();
				}
			}
		}
		
		response.setContentType("text/html;charset=utf-8");
		if(lastTime == null) {
			response.getWriter().write("您是第一次访问!");
		}else {
			response.getWriter().write("您是上次访问的时间是："+lastTime);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}