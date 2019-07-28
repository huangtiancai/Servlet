package com.htc.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserAction implements IModel {
	public String login(HttpServletRequest request,HttpServletResponse response)
	{
		//实现登陆
		String username = request.getParameter("username");
		System.out.println("进入login,用户名：" + username);
		
		if("admin".equals(username))
		{
			//通过客户端跳转到主页
			return "redirect:pages/main.jsp";
		}
		
		return "forward:pages/regist.jsp";
	}
	public String regist(HttpServletRequest request,HttpServletResponse response)
	{
		//实现登陆
		//request.getParamter("username");
		System.out.println("进入regist");
		return "/pages/login.jsp";
	}
	
	
	
	
}
