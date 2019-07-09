package com.htc.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CookieServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("进入CookieServlet2");
		
		//浏览器自动发送cookie给服务器，服务器如通过request对象获取这个cookie
		//获取Cookie数组(response发送cookie时可以发送多个)
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie:cookies){
			if(cookie.getName().equals("username1")){
				//取出cookie的值
				String value = cookie.getValue();
				System.out.println(cookie);
				System.out.println(value);
			}
		}
		
	}

}
