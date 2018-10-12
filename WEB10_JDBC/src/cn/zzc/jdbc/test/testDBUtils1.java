package cn.zzc.jdbc.test;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import cn.zzc.jdbc.utils.DBCPUtils;

public class testDBUtils1 {
	public static void main(String[] args) {
		insert();
	}
	public static void insert() {
		QueryRunner qr = new QueryRunner(DBCPUtils.getDataSource());
		String sql = "INSERT INTO product VALUES(NULL,?,?,NULL)";
		Object[] params = {"老鹰",890};
		try {			
			int rows = qr.update(sql,params);
			if (rows > 0) {
				System.out.println("添加成功!");
			} else {
				System.out.println("添加失败!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
