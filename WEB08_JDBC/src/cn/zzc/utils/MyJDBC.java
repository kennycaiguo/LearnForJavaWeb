package cn.zzc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyJDBC {
	private MyJDBC() {};
	
	private static Connection conn;
	static {
		try {
			//1.注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			//2.获取连接
			String url = "jdbc:mysql://localhost:3306/mybase";
			String username = "root";
			String password = "root";
			conn = DriverManager.getConnection(url, username, password);		
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e+"数据库连接失败!");
		}
	}
	
	//定义静态方法,返回数据库的连接对象
	public static Connection getConnection() {
		return conn;	
	}
	
	//关闭资源
		public static void close(Statement stat,Connection conn){
			 
			 if(stat!=null){
				 try{
					 stat.close();
				 }catch(SQLException ex){}
			 }
			 
			 if(conn!=null){
				 try{
					 conn.close();
				 }catch(SQLException ex){}
			 }
			 
		}
		
	public static void close(ResultSet rs, Statement stat, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (stat != null) {
			try {
				stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
