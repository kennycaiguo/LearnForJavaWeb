package cn.zzc.jdbc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*import org.junit.Test;*/

import cn.zzc.jdbc.DataSource.MyDataSource1;
import cn.zzc.jdbc.utils.JDBCUtils_V3;

public class testMyDataSource1 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		//1.自定义连接池对象
		MyDataSource1 dataSource = new MyDataSource1();
		try {
			//2.从连接池获取连接
			conn = dataSource.getConnection();
			String sql = "SELECT * FROM `product` WHERE pid=?";
			//3.执行SQL对象
			pstmt = conn.prepareStatement(sql);
			//4.设置参数
			pstmt.setInt(1, 5);
			//5.执行查询
			rs = pstmt.executeQuery();
			//6.处理结果集
			while(rs.next()) {
				System.out.println(rs.getString("pid")+"\t"+rs.getString("pname")+"\t"+rs.getString("price")+"\t"+rs.getString("pdate"));
			}			
		} catch (SQLException e){
			e.printStackTrace();
		}finally {	
			JDBCUtils_V3.close(conn, pstmt, rs);
		}
	}
}
