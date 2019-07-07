package com.htc.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieServlet
 */
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("进入CookieServlet");
		
		//调用构造函数，创建Cookie对象(记住用户名的动作发生在服务器端，所以在服务器创建Cookie)
		Cookie cookie = new Cookie("username", "haha");
		Cookie cookie1 = new Cookie("username1", "heihei");
		
		//在cookie创建的时候设置cookie的生存时间，时间一到自动去死
		//如果不设置过期时间，默认是多少-浏览会话结束时——浏览器关闭的时候
		
		//设置生存时间,单位秒
//		cookie.setMaxAge(30);
//		cookie1.setMaxAge(60);
		System.out.println(cookie);
		System.out.println(cookie1);
		
		//删除cookie
		//删除cookie其实是发送一个新的cookie，设置生成时间为0，而且设置数据为空字符或则null，通过response对象发送之后，会，覆盖之前的cookie
		//将cookie的name（key）保持一致，value 设置为 "";
		cookie = new Cookie("username", "");
		//设置存活时间为0
		cookie.setMaxAge(0);
		//路径要发送cookie时保持一致，没有路径不需要设置
		cookie.setPath("/");
		
		
		//如何将cookie发送给浏览器？给浏览器发出响应的是response对象，将cookie交给response发送
		//通过响应对象将指定cookie添加到响应，可多次调用此方法设置一个以上的	cookie--->浏览器
		response.addCookie(cookie);
		response.addCookie(cookie1);
		
		
			
		
		

	}

}
