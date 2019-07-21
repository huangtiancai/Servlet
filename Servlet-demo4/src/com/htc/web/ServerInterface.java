package com.htc.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.htc.bean.User;
import com.htc.service.UserService;
import com.htc.service.impl.UserServiceImpl;

/**
 * Servlet implementation class ServerInterface
 */
public class ServerInterface extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("进入ServerInterface!");
		//获取参数
		String username = request.getParameter("username");
		System.out.println("用户名："+username);
		String city = request.getParameter("city");
		System.out.println("城市："+city);
		
		UserService us = new UserServiceImpl();
		
		User user = us.queryUser(username);
		String result = "";
		if(user!=null){
			System.out.println("用户名已存在");
			result = "用户名已存在";
		}
		
		//1.js-ajax:前端使用 setRequestHeader() 来添加的 HTTP 头
		//xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		
		//2.若是jquery-ajax:前端不需要设置使用 setRequestHeader() 来添加 HTTP 头
		
		//后台获得请求体
		String requestType = request.getContentType();
		System.out.println("获得请求体:"+requestType);//application/x-www-form-urlencoded
		
		
		//通过response设置响应头(设置允许跨域-允许所有域名都可以访问，不够安全)
		response.setHeader("Access-Control-Allow-Origin", "*");
		//通过response设置响应体
		//设置响应的编码方式
		response.setContentType("text/html;charset=UTF-8");
		
		response.getWriter().write(result);
//		response.getWriter().write(result);
//		response.getWriter().write(result);
	}

}
