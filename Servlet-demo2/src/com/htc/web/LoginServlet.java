package com.htc.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.htc.bean.User;
import com.htc.service.UserService;

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
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取请求参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");		
		
		//封装数据到user对象
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		//调用service方法，执行用户登陆
		UserService userService = new UserService();
		
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
