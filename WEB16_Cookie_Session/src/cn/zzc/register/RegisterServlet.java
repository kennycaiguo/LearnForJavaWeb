package cn.zzc.register;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;

import cn.zzc.utils.DataSourceUtils;

public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置request的编码
		request.setCharacterEncoding("UTF-8");
		//使用BeanUtils进行自动封装
		Map<String, String[]> properties = request.getParameterMap();
		//new一个User实体
		User user = new User();
		try {
			BeanUtils.populate(user, properties);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		//手动封装uid----uuid---随机不重复的字符串32位--java代码生成后是36位
		user.setUid(UUID.randomUUID().toString());
		//将参数传递给业务 操作
		try {
			regist(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//4.若注册成功则跳转到登录界面
		//获取web应用的名称
		String path = request.getContextPath();
		response.sendRedirect(path+"/login.jsp");
	}

	public void regist(User user) throws SQLException {
		//操作数据库
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into user values(?,?,?,?,?,?,?,?,?,?)";
		runner.update(sql, user.getUid(),user.getUsername(),user.getPassword(),user.getName(),user.getEmail(),null,
				user.getBirthday(),user.getSex(),null,null);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}