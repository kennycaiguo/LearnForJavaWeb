package cn.zzc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 提供获取链接和释放资源的方法
 * @author GG
 *
 */
public class JDBCUtils_V1 {
	private static Connection conn;
	
	//链接方法
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/mybase";
			String username = "root";
			String password = "root";
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return conn;
	}
	
	//释放方法
	public static void close(Connection conn,PreparedStatement pstmt,ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
 			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(pstmt != null) {
			try {
				pstmt.close();
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
