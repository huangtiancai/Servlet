package com.htc.web;

import java.io.IOException;
import java.util.Enumeration;
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
		//第二种写法：先进入页面再跳转到指定的servlet
		//http://localhost:8080/Servlet-demo/index.html
		
		//需求：获取页面的值-使用request对象(根据name属性)
		//String getParameter(String name)  根据name 获取对应的值
		String username = request.getParameter("username");
		System.out.println("用户名："+username);
		
		System.out.println("-------2-------");
		//String[] getParameterValues(String name)  获取name相同的所有value,如复选框
		String[] values = request.getParameterValues("hobby");
		for(String value:values){
			System.out.println("value:"+value);
		}
		

		//Map getParameterMap-参数名作为key，参数值作为value，封装到map中(getParameterMap()没有参数)
		//注意：request.getParameterMap()获得的是map集合
		System.out.println("-------3-------");
		
		Map<String, String[]> map = request.getParameterMap();	
		//map.keySet获取键的集合
	    //for循环外层遍历出key,每遍历出一个key，再在内层for循环遍历出这个key下的所有value(key为name属性，value为对应的值)
	    //如遍历出处一个key=username(这里是输入的文本框内容，只有一个)，只能遍历出一个value，遍历key=hobby有多个value
		for(String key : map.keySet()){
			//打印出key
			System.out.println("key:"+key);
			for(String value : map.get(key)){
				//根据键（key）取map集合中的值=打印key下的value
				System.out.println("value:"+value);
			}
		}
		
		System.out.println("------4--------");
		Enumeration<String> names = request.getParameterNames();
		System.out.println("names:"+names);
		System.out.println(names.hasMoreElements());
		
		String name = names.nextElement();      //获取参数名
		String v = this.getInitParameter(name); //获取参数值
		System.out.println(name+" "+v);
		

		//发出响应
	    System.out.println("--------------发出响应---------------");
		//使用response对象用于向浏览器发出响应
		//response.getWriter()返回的是可将字符文本发送到客户端的 "PrintWriter"对象，这是一个打印输出流
		//response.getWriter().print(),不仅可以打印输出文本格式的（包括html标签），还可以将一个对象以默认的编码方式转换为二进制字节输出
		//response.getWriter().write(),只能打印输出文本格式的（包括html标签），不可以打印对象。 

		//使用的方法:void write(String s) -写入字符串
		
	    //设置中文乱码
	    response.setContentType("text/html;charset=UTF-8");
	    //往页面写内容(response.getWrite();写内容到页面)
	    response.getWriter().write("响应测试！");
		response.getWriter().write("this is responsive contents!");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		//
	}

}
