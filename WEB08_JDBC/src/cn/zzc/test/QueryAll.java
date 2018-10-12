package cn.zzc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryAll {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			//1.注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			//2.获取连接
			String url = "jdbc:mysql://localhost:3306/mybase";
			String username = "root";
			String password = "root";
			conn = DriverManager.getConnection(url, username, password);
			//3.获取执行sql语句的对象
			stat = conn.createStatement();
			//4.编写sql语句
			String sql = "SELECT * FROM `product`";
			//5.执行sql语句 
			rs = stat.executeQuery(sql);
			
			//处理结果集
			while(rs.next()) {
				System.out.println("用户名:"+rs.getString("pname")+"\t"+"价格:"+rs.getString("price"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//6.关闭资源
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(stat != null) {
				try {
					stat.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
