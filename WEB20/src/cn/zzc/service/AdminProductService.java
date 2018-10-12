package cn.zzc.service;

import java.sql.SQLException;
import java.util.List;

import cn.zzc.dao.AdminProductDao;
import cn.zzc.domain.Category;
import cn.zzc.domain.Product;
import cn.zzc.vo.Condition;

public class AdminProductService {

	//查找所有商品
	public List<Product> findAllProduct() {
		AdminProductDao dao = new AdminProductDao();
		List<Product> productList = null;
		try {
			productList = dao.findAllProduct();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productList;
	}

	//查找所有商品类别
	public List<Category> findAllCategory() {
		AdminProductDao dao = new AdminProductDao();
		List<Category> categories = null;
		try {
			categories = dao.findAllCategory();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categories;
	}

	//添加商品类别
	public void AddProduct(Product product) {
		AdminProductDao dao = new AdminProductDao();
		try {
			dao.AddProduct(product);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	//删除对应商品类别
	public void delProductByPid(String productPid) {
		AdminProductDao dao = new AdminProductDao();
		try {
			dao.delProductByPid(productPid);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	//查询对应商品
	public Product findProductByPid(String pid) {
		AdminProductDao dao = new AdminProductDao();
		Product product = null;
		try {
			product = dao.findProductByPid(pid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}

	//更改对应商品的信息
	public void updateProduct(Product product) {
		AdminProductDao dao = new AdminProductDao();
		try {
			dao.updateProduct(product);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//根据条件查询商品
	public List<Product> findProductListByCondition(Condition condition) {
		AdminProductDao dao = new AdminProductDao();
		List<Product> productList = null;
		try {
			productList = dao.findProductListByCondition(condition);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productList;
	}
	
}
