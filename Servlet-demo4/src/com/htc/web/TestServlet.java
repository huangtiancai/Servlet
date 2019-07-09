package com.htc.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("进入TestServlet");
		//通过<a href="../..?..">发送请求
		//设置中文乱码
		response.setContentType("text/html;charset=UTF-8");//解决响应中的中文乱码问题
		
		String param = request.getParameter("param");
		System.out.println(param);
		
		PrintWriter writer = response.getWriter();
		//根据用户请求(参数)动态生成网页源代码--->index.html
		if("1".equals(param)){
			writer.write("<h1><font color=\"red\">参数1</font></h1>");
		}else if("2".equals(param)){
			writer.write("<h1><font color=\"red\">参数2</font></h1>");
		}else if("3".equals(param)){
			writer.write("参数3");
		}else{
			writer.write("参数不合法！");
		}
		
//		使用的是response对象，获取输出流输出网页源代码
//		这种方式有几个问题：
//		1）有大量的字符串拼接操作，操作复杂。
//		2）前端工程师修改页面代码困难
		
		//在jsp中使用java代码动态生成网页---->index.jsp
//		为了解决以上问题sun公司给出了：Java Server Page——简称jsp技术
//		Jsp是为了同时满足动态生成网页和简化页面书写的需求诞生的。
		
//		jsp技术最终还是用java类，执行网页内容，jsp说到底还是一个Servlet.
//		既然是servlet，那么必然可以书写java代码;
//		因此，JSP中提供了书写java代码的三种定义格式：（为了区别页面上的html代码）
		
		Date date = new Date();
		SimpleDateFormat fomat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		
	}

}
