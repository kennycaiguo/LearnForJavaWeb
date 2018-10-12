package cn.zzc.service;

import java.sql.SQLException;

import cn.zzc.dao.TransferDao;
import cn.zzc.utils.DataSourceUtils;

public class TransferService {

	public boolean transfer(String out, String in, double money) {

		boolean isTransferSuccess = true;
		TransferDao dao = new TransferDao();
		try {
			//开启事务
			DataSourceUtils.startTransaction();
			
			//调用dao层的转出方法
			dao.out(out,money);
			
			//调用dao层的转入方法
			dao.in(in,money);
		} catch (SQLException e) {
			isTransferSuccess = false;
			//回滚事务
			try {
				DataSourceUtils.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				DataSourceUtils.commitAndRelease();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return isTransferSuccess;
	}

	

}
