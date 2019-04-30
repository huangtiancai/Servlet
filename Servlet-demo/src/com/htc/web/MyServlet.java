package com.htc.web;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MyServlet.....doGet..........");
		//需求：获取注册页面的值-使用request对象(根据name属性)
		String username = request.getParameter("username");
		System.out.println("用户名："+username);
		
		System.out.println("-------1-------");
		String[] values = request.getParameterValues("hobby");
		for(String value:values){
			System.out.println("value:"+value);
		}
		
		System.out.println("-------2-------");
		Map<String, String[]> map = request.getParameterMap();
		System.out.println("map:"+map);
		for(String key : map.keySet()){
			for(String value : map.get(key)){
				System.out.println("value:"+value);
			}
		}
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
