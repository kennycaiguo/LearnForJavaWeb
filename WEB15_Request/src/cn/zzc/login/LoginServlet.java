package cn.zzc.login;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.zzc.register.User;
import cn.zzc.utils.DataSourceUtils;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置request的编码
		request.setCharacterEncoding("UTF-8");
		//获得用户名和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//调用一个业务方法进行用户查询
		User login = null;
		try {
			login = login(username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (login != null) {
			//登录成功，跳转到网站首页
			String path = request.getContextPath();
			response.sendRedirect(path);
		} else {
			//登录失败，转发到login.jsp,向request域中存储错误信息
			request.setAttribute("loginInfo", "用户名或密码错误");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
	public User login(String username,String password) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where username=? and password=?";
		User user = runner.query(sql,new BeanHandler<User>(User.class),username,password);
		return user;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}