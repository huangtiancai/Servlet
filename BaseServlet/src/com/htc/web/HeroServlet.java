package com.htc.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HeroServlet extends BaseServlet {

	//增加  注意：和index.jsp页面请求的方法一致：method=saveHero
	public String saveHero(HttpServletRequest request, HttpServletResponse response){
		
		System.out.println("增加了");
		//获取用户增加的 请求参数
		
		
	   return "z:/index.jsp";
		
	}
	
	//修改]
	public String updateHero(HttpServletRequest request, HttpServletResponse response){
		System.out.println("修改了");
	
		return "c:/index.jsp";
	}
	

	

}
