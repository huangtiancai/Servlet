//直接键入"servlet"字样，代码自动提示会出现如下结果，按一下Enter键就得到自己所要的代码
package com.htc.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemoServlet1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//第一种写法：url直接进入Servlet
		//http://localhost:8080/Servlet-demo/demoServlet1(不带参数)
		System.out.println("进入DemoServlet1");
		System.out.println("进入doGet...");
		
		//直接输入带有参数的url
		//http://localhost:8080/Servlet-demo/demoServlet1?name=zhangsang&age=18&hobby=ball1&hobby=ball2
		//获取单个参数值
		System.out.println("参数name:"+request.getParameter("name"));
		System.out.println("参数age:"+request.getParameter("age"));
		//获取同名参数的多个值
		String hobbys[] = request.getParameterValues("hobby");
		for(String str : hobbys){
			System.out.println("hobby:"+str);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
