package cn.zzc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.zzc.jdbc.JDBCUtils_V1;

public class Demo1 {
	public static Connection conn;
	public static PreparedStatement pstmt;
	public static ResultSet rs;
	public static void main(String[] args) {
		try {		
			//1.链接数据库
			conn = JDBCUtils_V1.getConnection();
			//2.编写SQL语句
			/*String sql = "SELECT * FROM `product` WHERE pid=?";*/
			String sql1 = "SELECT * FROM `product` WHERE pid=? or pid=?;";
			//3.执行SQL对象
			pstmt = conn.prepareStatement(sql1);
			//4.设置参数
			pstmt.setInt(1, 4);
			pstmt.setInt(2, 6);
			//5.执行查询
			rs = pstmt.executeQuery();
			//6.处理结果集
			while(rs.next()) {
				System.out.println(rs.getString("pid")+"\t"+rs.getString("pname")+"\t"+rs.getString("price")+"\t"+rs.getString("pdate"));
			}			
		} catch (SQLException e){
			e.printStackTrace();
		}finally {			
			JDBCUtils_V1.close(conn, pstmt, rs);
		}
	}
}
