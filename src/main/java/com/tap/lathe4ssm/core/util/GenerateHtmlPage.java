package com.tap.lathe4ssm.core.util;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 * 根据web请求生成html文件
 * 
 * @author York Wu
 */
public class GenerateHtmlPage {

	/**
	 * 生成静态html文件的方法
	 * 
	 * @param request
	 * @param response
	 * @param servletContext
	 * @param fileName
	 *            文件名称
	 * @param fileFullPath
	 *            文件完整路径
	 * @param jspPath
	 *            需要生成静态文件的JSP路径(相对)
	 * @throws IOException
	 * @throws ServletException
	 */
	public void createStaticHTMLPage(HttpServletRequest request, HttpServletResponse response,
			ServletContext servletContext, String fileName, String fileFullPath, String jspPath)
					throws ServletException, IOException {
		
		response.setContentType("text/html;charset=gb2312");
		
		// 获得JSP资源
		RequestDispatcher rd = servletContext.getRequestDispatcher(jspPath);
		
		// 从ServletOutputStream中接收资源
		final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		
		// 从HttpServletResponse中接收资源
		final ServletOutputStream servletOuputStream = new ServletOutputStream() {
			public void write(byte[] b, int off, int len) {
				byteArrayOutputStream.write(b, off, len);
			}

			public void write(int b) {
				byteArrayOutputStream.write(b);
			}
		};
		
		// 把转换字节流转换成字符流
		final PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(byteArrayOutputStream));
		
		// 从response获取结果流资源
		HttpServletResponse httpServletResponse = new HttpServletResponseWrapper(response) {
			public ServletOutputStream getOutputStream() {
				return servletOuputStream;
			}

			public PrintWriter getWriter() {
				return printWriter;
			}
		};
		
		// 发送结果流
		rd.include(request, httpServletResponse);
		
		// 刷新缓冲区，把缓冲区的数据输出
		printWriter.flush();
		
		FileOutputStream fileOutputStream = new FileOutputStream(fileFullPath);
		
		// 把byteArrayOuputStream中的资源全部写入到fileOuputStream中
		byteArrayOutputStream.writeTo(fileOutputStream);
		
		// 关闭输出流，释放相关资源
		fileOutputStream.close();
		
		// 发送指定文件流到客户端
		response.sendRedirect(fileName);
	}
}