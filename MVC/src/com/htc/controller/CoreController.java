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
		
		//判断方法名是否为空 ""/null
		if(methodName.trim().isEmpty() || methodName==null){
			throw new RuntimeException("你没有传递method参数!无法确定你要调用的方法!");
		}
		
		//1.获取当前类的class对象
		Class c = this.getClass();
		
		//2.通过当前类的class对象的getMethod()方法查找是否存在对应方法
		Method method = null;
		try {
			method = c.getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
		} catch (Exception e) {
			throw new RuntimeException("你要调用的方法!"+methodName+"不存在!");
		}
		
		//3. 通过反射动态的调用对应的方法
		try {
			String result=(String)method.invoke(this, request,response);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
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
