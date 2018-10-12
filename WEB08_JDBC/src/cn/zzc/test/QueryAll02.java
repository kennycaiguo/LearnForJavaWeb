package cn.zzc.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cn.zzc.utils.MyJDBC;

public class QueryAll02 {
	private static Connection conn;
	private static Statement stat; 
	private static ResultSet rs;
	public static void main(String[] args) {
		try {
			//1,2.连接数据库
			conn = MyJDBC.getConnection();
			//3.获取执行sql语句对象
			stat = conn.createStatement();
			//4.编写sql语句
			String sql = "SELECT * FROM `product`";
			//5.执行sql语句 
			rs = stat.executeQuery(sql);
		
			//处理结果集
			while(rs.next()) {
				System.out.println("用户名:"+rs.getString("pname")+"\t"+"价格:"+rs.getString("price"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//6.关闭资源
			MyJDBC.close(rs, stat, conn);
		}
	}
}
