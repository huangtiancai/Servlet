package com.htc.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;  //class HttpServlet extends GenericServlet , GenericServlet implements interface Servlet
import javax.servlet.http.HttpServletRequest; 	//interface HttpServletRequest extends interface ServletRequest
import javax.servlet.http.HttpServletResponse;	//interface HttpServletResponse extends interface ServletResponse

/**
 * Servlet implementation class MyServlet1
 */
public class MyServlet1 extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	//初始化
	//重写快捷键键（写init,然后Alt+/+Enter）
	
//	初始化
//	当客户端向tomcat发送http请求访问servelt程序，tomcat首先会解析请求，检查内存中是否已经有了该servlet对象：
//	如果有直接使用对应的servlet对象;
//	如果没有就创建servlet实例对象，然后通过调用init() 方法实现Servlet的初始化工作。

	@Override
	//init方法只被调用了一次
	public void init() throws ServletException {
		System.out.println("MyServlet1被初始化！");
	}
	

	//运行阶段
	//HttpServlet-service()
	
//	@Override
//	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
//		System.out.println("进入service方法！");
//	}
	
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("进入doGet方法！");
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("进入doPost方法！");
		
		
	}
	
	//销毁
	//当服务器关闭时，servlet会随着Web应用的销毁而销毁,当服务器关闭时，servlet会随着Web应用的销毁而销毁
	@Override
	public void destroy() {
		System.out.println("MyServlet1被销毁！");
	}

}
