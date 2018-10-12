package cn.zzc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.zzc.jdbc.JDBCUtils_V2;

public class Demo2 {

	public static Connection conn;
	public static PreparedStatement pstmt;
	public static void main(String[] args) {
		try {
			conn = JDBCUtils_V2.getConnection();
			String sql = "INSERT INTO `product` VALUES(NULL,?,?,NULL)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "李四");
			pstmt.setDouble(2, 900.05);
			int row = pstmt.executeUpdate();
			if(row > 0) {
				System.out.println("插入成功!");
			}else {
				System.out.println("插入失败!");				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			JDBCUtils_V2.close(conn, pstmt, null);
		}	
	}
}	
