package cn.zzc.jdbc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.zzc.jdbc.utils.C3P0Utils;
import cn.zzc.jdbc.utils.JDBCUtils_V3;

public class testC3P0 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = C3P0Utils.getConnection();
			String sql = "SELECT * FROM `product` WHERE pid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 4);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString("pid")+"\t"+rs.getString("pname")+"\t"+rs.getString("price")+"\t"+rs.getString("pdate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtils_V3.close(conn, pstmt, rs);
		}
		
	}
}
