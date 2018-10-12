package cn.zzc.content;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ByteServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取字节输出流
		ServletOutputStream out = response.getOutputStream();
		
		//获取服务器上的图片
		String realPath = this.getServletContext().getRealPath("a.jpg");
		InputStream in = new FileInputStream(realPath);
		
		//循环读取字节
		int len = 0;
		byte[] buffer = new byte[1024];
		while((len = in.read(buffer))>0) {
			out.write(buffer, 0, len);
		}
		
		//关闭资源
		in.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}