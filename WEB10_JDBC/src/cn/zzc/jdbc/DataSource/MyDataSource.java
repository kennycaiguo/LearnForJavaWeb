package cn.zzc.jdbc.DataSource;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;

import javax.sql.DataSource;

import cn.zzc.jdbc.utils.JDBCUtils_V3;

public class MyDataSource implements DataSource {
	//1.创建一个容器用于存储Connection对象
	private static LinkedList<Connection> pool = new LinkedList<Connection>();
	//2.创建5个连接放入容器中
	static {
		for (int i = 0; i < 5; i++) {
			Connection conn = JDBCUtils_V3.getConnection();
			pool.add(conn);
		}
	}
	
	/**
	 * 重写获取连接
	 */
	@Override
	public Connection getConnection() throws SQLException {
		Connection conn = null;
		//3.使用前判断
		if(pool.size() == 0) {
			//4.池子中没有，我们再创建一些
			for (int i = 0; i < 5; i++) {
				conn = JDBCUtils_V3.getConnection();
				pool.add(conn);
			}
		}	
		//5.从池子中取出连接
		conn = pool.remove(0);
		return conn;
	}
	/**
	 * 归还连接对象到连接池中去
	 */
	public void backConnection(Connection conn){
		pool.add(conn);
	}
	
	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoginTimeout(int arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isWrapperFor(Class<?> arg0) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> arg0) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
