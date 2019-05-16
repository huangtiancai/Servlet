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
		System.out.println("-------1-------");
		//需求：获取注册页面的值-使用request对象(根据name属性)
		//String getParameter(String name)  根据name 获取对应的值
		String username = request.getParameter("username");
		System.out.println("用户名："+username);
		
		System.out.println("-------2-------");
		//String[] getParameterValues(String name)  获取name相同的所有value,如复选框
		String[] values = request.getParameterValues("hobby");
		for(String value:values){
			System.out.println("value:"+value);
		}
		//Map getParameterMap 参数名作为key，参数值作为value，封装到map中
		System.out.println("-------3-------");
		Map<String, String[]> map = request.getParameterMap();	
		for(String key : map.keySet()){
			System.out.println("key:"+key);
			System.out.println("map:"+map);
			System.out.println("map.keySet():"+map.keySet());
			for(String value : map.get(key)){
				System.out.println("value:"+value);
			}
		}
		
		//使用response对象用于向浏览器发出响应
		//response.getWriter()返回的是可将字符文本发送到客户端的 "PrintWriter"对象，这是一个打印输出流
		//response.getWriter().print(),不仅可以打印输出文本格式的（包括html标签），还可以将一个对象以默认的编码方式转换为二进制字节输出
		//response.getWriter().writer(),只能打印输出文本格式的（包括html标签），不可以打印对象。 

		//使用的方法:void write(String s) -写入字符串
		
		System.out.println("发送响应");
		response.getWriter().write("test");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
