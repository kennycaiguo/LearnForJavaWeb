package cn.zzc.service;

import java.sql.SQLException;
import java.util.List;

import cn.zzc.dao.ProductDao;
import cn.zzc.domain.ProductList;

public class ProductService {

	public List<ProductList> findAllProduct() throws SQLException {
		//传递到Dao层
		ProductDao dao = new ProductDao();
		List<ProductList> productList = 
				dao.findAllProduct();
		return productList;
	}

	public List<ProductList> findProduct(String pid) throws SQLException {
		// 传递到Dao层
		ProductDao dao = new ProductDao();
		List<ProductList> product = dao.findProduct(pid);
		return product;
	}

}
