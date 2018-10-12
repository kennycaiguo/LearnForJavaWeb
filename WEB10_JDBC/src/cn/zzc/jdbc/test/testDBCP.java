package cn.zzc.jdbc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;

import cn.zzc.jdbc.utils.DBCPUtils;

public class testDBCP {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBCPUtils.getConnection();
			String sql = "UPDATE `product` SET price=? WHERE pid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setDouble(1, 200);
			pstmt.setInt(2, 1);
			int rows = pstmt.executeUpdate();
			if (rows > 0) {
				System.out.println("更新成功！");
			} else {
				System.out.println("更新失败！");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
