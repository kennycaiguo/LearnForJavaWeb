package cn.zzc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.zzc.jdbc.JDBCUtils_V3;

public class Demo3 {
	public static Connection conn;
	public static PreparedStatement pstmt;
	public static ResultSet rs;
	public static void main(String[] args) {
		try {
			//1.连接数据库
			conn = JDBCUtils_V3.getConnection();
			//2.编写SQL语句
			String sql = "UPDATE product SET price=? WHERE pid=?";
			//3.获取执行sql语句对象
			pstmt = conn.prepareStatement(sql);
			//4.设置参数
			pstmt.setDouble(1, 998);
			pstmt.setInt(2, 3);
			//5.执行更新操作
			int row = pstmt.executeUpdate();
			if(row > 0) {
				System.out.println("更新成功！");
			}else {
				System.out.println("更新失败！");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			//6.释放资源
			JDBCUtils_V3.close(conn, pstmt, rs);
		}
		
	}
}
