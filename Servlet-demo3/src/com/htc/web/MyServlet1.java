package com.htc.web;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
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
		//System.out.println("进入doGet方法！");
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("进入doPost方法！");
		
		//Servlet中常用的方法：
		//1.获取局部参数(web.xml中配置-<init-param>)
		//根据参数名获取
		String value1 =  this.getInitParameter("encode"); 
		String value2 = this.getInitParameter("color");
		//System.out.println("当前servlet中配置的初始化参数encode为："+value1);
		//System.out.println("当前servlet中配置的初始化参数color为："+value2);
		
		//获取所有参数名称：
		Enumeration<String> names = this.getInitParameterNames();
		System.out.println("names:"+names);
		while(names.hasMoreElements()){
			String name = names.nextElement();      //获取参数名
			String v = this.getInitParameter(name); //获取参数值
			System.out.println(name+":"+v);
		}
		
		/**
		 * 2.获取全局的参数(<context-param>)	   
		 */
		//2.1ServletContext:web环境上下文 /域-->只能获取全局参数（不能获取局部参数）
		ServletContext application = this.getServletContext();//application:域对象
		//System.out.println("全局参数:"+application);
		
		//2.2获取全局的参数
		String global = application.getInitParameter("encode");
		System.out.println("全局参数为:"+global);
		
		//2.3作为一个域对象存储数据
		//ServletContext:application的生命周期;只要项目启动生命周期便开始，只有项目卸载生命周期截止
		//获取ServletContext中的数据
		Object obj = application.getAttribute("count");//第一次obj为null;第二次obj!=null
		System.out.println("obj:"+obj);
		int count = 0;
		if(obj!=null){
			count = Integer.parseInt(obj.toString());
		}
		application.setAttribute("count", ++count);
		System.out.println("当前访问量:"+count);
		
		//2.4获取当前项目下某个文件/文件夹的绝对路径：部署的tomcat下面项目的路径
//		String realPath = application.getRealPath("pages");
//		System.out.println(realPath);
//		String param1 = application.getContextPath();
//		String param3 = application.getServletContextName();
//		System.out.println(param3);
//		System.out.println(param1);
//		String param2 = application.getServerInfo();
//		System.out.println(param2);
	}
	
	//销毁
	//当服务器关闭时，servlet会随着Web应用的销毁而销毁,当服务器关闭时，servlet会随着Web应用的销毁而销毁
	@Override
	public void destroy() {
		System.out.println("MyServlet1被销毁！");
	}

}
