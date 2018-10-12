package cn.zzc.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.zzc.domain.User;
import cn.zzc.utils.DataSourceUtils;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		int count = 0;
		this.getServletContext().setAttribute("count", count);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取用户名和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//2.从数据库中验证该用户名和密码是否正确
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where username=? and password=?";
		User user = null;
		try {
			user = runner.query(sql, new BeanHandler<User>(User.class), username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//3.根据返回结果给用不同的显示信息
		if(user != null) {
			ServletContext context = this.getServletContext();
			Integer count = (Integer) context.getAttribute("count");
			count++;
			System.out.println("用户登录成功!");
			response.getWriter().write(user.toString()+"Success:"+count);
			context.setAttribute("count", count);
		}else {
			System.out.println("用户登录失败!");
			response.getWriter().write("Failure!");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
