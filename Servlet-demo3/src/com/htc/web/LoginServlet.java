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
* @ClassName LoginServlet
* @Description:
*  servlet（处理请求和响应）  
*  service执行具体业务逻辑  
*  dao 执行数据库操作 
* @author htc  
* @date 2019年6月6日下午4:53:33
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决post乱码
		request.setCharacterEncoding("utf-8");
		
		System.out.println("进入LoginServlet");
		//前台login.html提交的参数会追加到
		//http://localhost:8080/Servlet-demo2/loginServlet?username=admin&password=123456(直接在url地址后加参数)
		
		//获取请求参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");		
		
		//封装数据到user对象
		//封装数据到User对象(先new一个空的User对象，再往里面封装数据)
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		//调用service方法，执行用户登陆
		//UserServiceImpl us = new UserServiceImpl();
		UserService us = new UserServiceImpl();
	
		User loginUser = us.login(user);
		
		//设置中文乱码
		response.setContentType("text/html;charset=UTF-8");
		if(loginUser==null){
			System.out.println("登录失败！");
			response.getWriter().write("登录失败！");			
		}else{
			System.out.println("登录成功！");
			response.getWriter().write("登录成功！");
			//登录成功后,服务器端跳转（页面转发）：/代表的是项目的根路径(跳转后地址不一定变)
			
		}	
		
		//获取请求的信息
		//获取请求的方式
		String method = request.getMethod();
		System.out.println("请求的方法："+method); //form表单后的method
		
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("--------");
		doPost(request, response);
	}

}
