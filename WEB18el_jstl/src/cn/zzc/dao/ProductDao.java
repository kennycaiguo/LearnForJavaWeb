package cn.zzc.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.zzc.domain.ProductList;
import cn.zzc.utils.DataSourceUtils;

public class ProductDao {

	public List<ProductList> findAllProduct() throws SQLException {
		//操作数据库
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product";
		List<ProductList> productList = 
				runner.query(sql, new BeanListHandler<ProductList>(ProductList.class));
		return productList;
	}

	public List<ProductList> findProduct(String pid) throws SQLException {
		// 操作数据库
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product where pid=?";
		List<ProductList> product = runner.query(sql, new BeanListHandler<ProductList>(ProductList.class),pid);
		return product;
	}
	
}
