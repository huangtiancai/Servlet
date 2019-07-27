package com.htc.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CoreController
 */
public class CoreController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("进入核心控制器！");
		
		//获取用户请求的方法
		String methodName = request.getParameter("method");
		System.out.println("method:"+methodName);

		String uri = request.getRequestURI();
		System.out.println("uri:"+uri);//uri:/MVC/user.action
		
		StringBuffer requestURL = request.getRequestURL();	
		System.out.println("请求的url:"+requestURL);
		
		
		
		//需要知道用户请求的模型地址 如：通过user.action-->UserAction
		String[] arrURI = uri.split("/");
		String action = arrURI[arrURI.length-1];
		System.out.println(action);//user.action
		
		//根据请求字符串，获取模型对象
		
		

		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
