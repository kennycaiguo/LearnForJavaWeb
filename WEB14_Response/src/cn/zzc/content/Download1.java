package cn.zzc.content;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Download1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取要下载的文件名
		String filename = request.getParameter("filename");
		
		//获取要下载文件的类型
		response.setContentType(this.getServletContext().getMimeType(filename));
		//告诉客户端不需要解析，这是下载文件
		response.setHeader("Content-Disposition", "attachment;filename="+filename);
		
		//获取文件绝对路径
		String realPath = this.getServletContext().getRealPath("download/"+filename);
		//获取文件输入流
		InputStream in = new FileInputStream(realPath);
		//文件输出流，逐个读取
		ServletOutputStream out = response.getOutputStream();
		int len = 0;
		byte[] buffer = new byte[1024];
		while((len=in.read(buffer))>0) {
			out.write(buffer, 0, len);
		}
		in.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}