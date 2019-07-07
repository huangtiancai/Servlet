package com.htc.web;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
* @ClassName:TimeServlet
* @Description:显示用户上次访问的时间
* @author:htc  
* @date:2019年7月7日 下午9:11:44
 */
public class TimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//两次请求
		//第一次将访问，保存到cookie
		Cookie cookie = new Cookie("time", new Date().toLocaleString());
		cookie.setMaxAge(60*60*24*7);
		cookie.setPath("/");
		response.addCookie(cookie);
		
		//第二次将访问
		//获取上一次访问的的cookie
		Cookie[] cookies = request.getCookies();
		if(cookies!=null){
			for(Cookie cooki:cookies){
				if(cooki.getName().equals("time")){
					//将数据展示到页面
					response.getWriter().write(cooki.getValue());
				}
			}
		}
	}

}
