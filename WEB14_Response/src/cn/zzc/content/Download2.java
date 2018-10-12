package cn.zzc.content;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.misc.BASE64Encoder;

public class Download2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取要下载的文件名
		String filename = request.getParameter("filename");
		// 解决获得中文参数的乱码
		filename = new String(filename.getBytes("ISO8859-1"), "UTF-8");// 美女.jpg

		// 获得请求头中的User-Agent
		String agent = request.getHeader("User-Agent");
		// 根据不同浏览器进行不同的编码
		String filenameEncoder = "";
		if (agent.contains("MSIE")) {
			// IE浏览器
			filenameEncoder = URLEncoder.encode(filename, "utf-8");
			filenameEncoder = filenameEncoder.replace("+", " ");
		} else if (agent.contains("Firefox")) {
			// 火狐浏览器
			BASE64Encoder base64Encoder = new BASE64Encoder();
			filenameEncoder = "=?utf-8?B?" + base64Encoder.encode(filename.getBytes("utf-8")) + "?=";
		} else {
			// 其它浏览器
			filenameEncoder = URLEncoder.encode(filename, "utf-8");
		}

		// 获取要下载文件的类型
		response.setContentType(this.getServletContext().getMimeType(filename));
		// 告诉客户端不需要解析，这是下载文件
		response.setHeader("Content-Disposition", "attachment;filename=" + filenameEncoder);

		// 获取文件绝对路径
		String realPath = this.getServletContext().getRealPath("download/" + filename);
		// 获取文件输入流
		InputStream in = new FileInputStream(realPath);
		// 文件输出流，逐个读取
		ServletOutputStream out = response.getOutputStream();
		int len = 0;
		byte[] buffer = new byte[1024];
		while ((len = in.read(buffer)) > 0) {
			out.write(buffer, 0, len);
		}
		in.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}