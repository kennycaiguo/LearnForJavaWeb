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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		//验证码校验
		//获得页面输入的验证
		String checkCode_client = request.getParameter("checkCode");
		//获得生成图片的文字的验证码
		String checkCode_session = (String) request.getSession().getAttribute("checkcode_session");
		//比对页面的和生成图片的文字的验证码是否一致
		if(!checkCode_session.equals(checkCode_client)){
			request.setAttribute("loginInfo", "您的验证码不正确");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}else {
			//获得页面的用户名和密码进行数据库的校验
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
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}	
		}	
	}

	public User login(String username,String password) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where username=? and password=?";
		User user = runner.query(sql,new BeanHandler<User>(User.class),username,password);
		return user;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}