package com.htc.web;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.htc.bean.User;
import com.htc.service.UserService;
import com.htc.service.impl.UserServiceImpl;

/**
* @ClassName LoginServlet
* @Description:
*  servlet（处理请求和响应）  
*  service执行具体业务逻辑  
*  dao 执行数据库操作 
* @author htc  
* @date 2019年6月6日下午4:53:33
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决post乱码
		request.setCharacterEncoding("utf-8");
		
		System.out.println("进入LoginServlet");
		//前台login.html提交的参数会追加到
		//http://localhost:8080/Servlet-demo2/loginServlet?username=admin&password=123456(直接在url地址后加参数)
		
		//获取请求参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");		
		
		//封装数据到user对象
		//封装数据到User对象(先new一个空的User对象，再往里面封装数据)
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		//调用service方法，执行用户登陆
		//UserServiceImpl us = new UserServiceImpl();
		UserService us = new UserServiceImpl();
	
		User loginUser = us.login(user);
		
		//设置中文乱码
		response.setContentType("text/html;charset=UTF-8");//解决响应中的中文乱码问题
		
		if(loginUser==null){
			System.out.println("登录失败！");
			response.getWriter().write("登录失败！");			
		}else{
			System.out.println("登录成功！");
			response.getWriter().write("登录成功！");
			//注意：这里的转发和重定向都是以访问的servlet为基础
			//登录成功后,服务器端跳转（页面转发）：/代表的是项目的根路径(跳转后地址不一定变)
			//request.getRequestDispatcher("/index.html").forward(request, response);
			//地址栏:http://localhost:8080/Servlet-demo3/loginServlet
			
			//在sendRedict中url前必须加上当前web程序的路径名
			//request.getContextPath()+"/index.html") 或者index.html
			response.sendRedirect(request.getContextPath()+"/index.html");
			//地址栏:http://localhost:8080/Servlet-demo3/index.html
		}	
		
		
		/**
		 * HttpServletRequest 接口 的对象 ->父接口：ServletRequest
		 */	
		
		//获取请求的信息:request代表请求，所以我们可以通过该对象分别获得Http请求的请求行，请求头和请求体
		
		//1.请求行
		//获取请求的方式
		String method = request.getMethod();	
		System.out.println("请求的方法："+method); //form表单后的method
		
		//获取项目的根路径（web项目的根路径）（rootPath和contextPath均为项目根路径）
		String rootPath = request.getContextPath();
		System.out.println("项目根路径:"+rootPath);
		String contextPath = request.getServletContext().getContextPath();
		System.out.println("项目根路径:"+contextPath);
		
		//返回当前servlet的路径(get提交url地址后的参数字符串)
		String servletPath = request.getServletPath();
		System.out.println("当前servlet的路径为："+servletPath);
		
		String requestURI = request.getRequestURI();	
		System.out.println("请求的uri:"+requestURI);
		
		StringBuffer requestURL = request.getRequestURL();	
		System.out.println("请求的url:"+requestURL);
		
		String remoteAddr = request.getRemoteAddr();
		System.out.println();
		
		//获取请求地址+参数（get请求可以获取参数，post请求query为null）
		String query = request.getQueryString();
		System.out.println("url地址后的参数字符串:"+query);
		//拼接(相对路径)
		System.out.println("拼接后的相对路径为："+requestURL+"?"+query);
		
		//2.请求头
		
		//请求头的格式：key:value
		//String header = request.getHeader("key");
		System.out.println("根据key取出相应的头信息内容：");
		String accept = request.getHeader("Accept");
		System.out.println(accept);
		String contentLength = request.getHeader("Content-Length");
		System.out.println(contentLength);
		String contentType = request.getHeader("Content-Type");
		System.out.println(contentType);
		String host = request.getHeader("Host");
		System.out.println(host);
		String referer = request.getHeader("Referer");
		System.out.println(referer);
		String userAgent = request.getHeader("User-Agent");
		System.out.println(userAgent);
		
		System.out.println("通过Enumeration取出所有头信息内容：");
		Enumeration<String> enu = request.getHeaderNames();
		System.out.println(enu);
		while(enu.hasMoreElements()){
			String headerNames = enu.nextElement();
			String headerValues = request.getHeader(headerNames);//取出所有头信息内容
			System.out.println(headerValues);
		}
		
		//通过具体方法取出头信息内容：
		//获取请求体的字节数  get请求没有请求体  没有请求体返回-1
		//请求体类型
		String requestType = request.getContentType();
		System.out.println("请求体类型为："+requestType);
		//请求体字节数
		int requestLen = request.getContentLength();
		System.out.println("请求体字节数为："+requestLen);
				
				
		//返回当前客户端浏览器的Local  这个东西在后面的国际化会用到
		Locale local = request.getLocale();
		System.out.println("当前客户端浏览器的Local为："+local);
		
		//获取请求编码
		String encode = request.getCharacterEncoding();
		System.out.println("请求编码为："+encode);
		
		//设置编码格式 ： 解决POST方式乱码问题（post才有请求体）
		request.setCharacterEncoding("utf-8");
		
		//3.请求体
		//请求体中的内容是通过post提交的请求参数，格式是：
		//获取单个参数值
		//String value = request.getParameter(name); //上述已经使用过
		
		//获取同名参数的多个值（如：例如复选框或者url地址栏中有多个参数相同）  
		//String[] values = request.getParameterValues("favs");
		
		System.out.println("request.getParameterNames()方法是将发送请求页面中form表单里所有具有name属性的表单对象获取(包括button).返回一个Enumeration类型的枚举.");
		//获取页面所有的参数的name属性-->这里没有页面，所以在LoginServlet中使用
		Enumeration<String> names = request.getParameterNames();
		while(names.hasMoreElements()){
			String name = names.nextElement();      //获取参数名
			String[] values = request.getParameterValues(name); //获取参数值
			for(String value:values){
				System.out.println(value);
			}
		}
		
		//Map<String, String[]> map = request.getParameterMap();
		
		//获取客户端的ip地址/主机地址、端口
		String ip = request.getLocalAddr();
		int port = request.getLocalPort();
		System.out.println("访问的客户端IP地址为:"+ip);
		System.out.println("访问的客户端端口为:"+port);
		
		/**
		 * request可以作为一个域对象存储数据
		 * request生命周期：当发送请求开始，则request对象产生
		 * 如果遇到服务器端跳转则生命周期尚未结束; ---服务器端跳转（页面的转发）:request.getRequestDispatcher("/pages/main.html").forward(request, response);
		 * 如果遇到客户端跳转则生命周期截止        ---客户端跳转（页面的重定向）:response.sendRedirect("地址");
		 * 
		 */
		
		//向request域中设置属性
		//request.setAttribute("key",Object);
		//获取属性值
		//Object value = request.getAttribute("key");
		//移除属性
		//request.removeAttribute("key");
		//一定要注意：getAttribute只能获取通过setAttribute设置的属性值，而无法获取表单或者页面传递的参数。
		
		/**
		 * 服务器端页面跳转/页面的转发:
		 * request.getRequestDispatcher("/pages/main.html").forward(request, response);
		       特点：1）服务器端跳转，request对象是同一个
			   2）地址栏不发生变化。或者：当前显示的页面和地址栏显示的地址不一致
			   3）无法跳转到外部网站
		       客户端跳转：response.sendRedirect("地址");
		       特点：1）重定向，request对象不是同一个
		       2）地址栏发生变化。或者当前显示的页面和地址栏显示的地址是一致的
			   3）可以跳转到外部网站
		 */
		
		
		/**
		 * 乱码解决的问题:
		 * POST：request.setCharacterEncoding("UTF-8");
		   GET:二次编码  String name = new String(username.getBytes("ISO-8859-1"), "UTF-8");
		   
			   解决响应中的中文乱码问题
			 setContentType("text/html;charset=UTF-8");
		 */
		
		
		
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("--------");
		doPost(request, response);
	}

}
