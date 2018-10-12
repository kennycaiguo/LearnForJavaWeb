package cn.zzc.jdbc.test;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import cn.zzc.domain.product;
import cn.zzc.jdbc.utils.DBCPUtils;

public class testDBUtils2 {
	public static void main(String[] args) {
		select2();
	}
	public static void select() {
		QueryRunner qr = new QueryRunner(DBCPUtils.getDataSource());
		String sql = "select * from product";
		try {			
			List<product> product = qr.query(sql, new BeanListHandler<product>(product.class));
			for (product pr : product) {
				System.out.println(pr.getPid()+"\t"+pr.getPname()+"\t"+pr.getPrice()+"\t"+pr.getPdate());
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void select2() {
		QueryRunner qr = new QueryRunner(DBCPUtils.getDataSource());
		String sql = "select * from product";
		try {			
			List<Map<String, Object>> product = qr.query(sql, new MapListHandler());
			for (Map<String, Object> map : product) {
				for (String key : map.keySet()) {
					//System.out.print(key+"\t"+map.get(key)+"\t");
					System.out.print(map.get(key)+"\t");
				}
				System.out.println();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
