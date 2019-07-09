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
 * Servlet implementation class CheckUserAction
 */
public class CheckUserAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("进入CheckUserAction!");
		//异步请求：响应方式：第一种：response.getWriter().write("");
		//第二种：跳转页面，跳转的页面是作为异步响应内容，一般是放在原页面的局部
		
		//获取用户名
		String username = request.getParameter("username");
		System.out.println("输入的用户名为："+username);
		
		UserService us = new UserServiceImpl();
		
		User user = us.queryUser(username);
		String result = "";
		if(user!=null){
			System.out.println("用户名已存在！");
			result = "用户名已存在！";
		}
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(result);
}

}
