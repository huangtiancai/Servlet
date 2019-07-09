package com.htc.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionServlet2
 */
public class SessionServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		System.out.println(session);
		//为了后期，还能使用同一个session，设置一个链接，在链接中，拼接请求参数（jsessionid=XXXX）
		response.setContentType("tetx/html;charset=utf-8");
		//拼接参数，使用的是分号，不是问号
		String encodeURL = response.encodeURL("/Servlet-demo3/SessionServlet2");
		String encodeRedirectURL = response.encodeRedirectURL("/Servlet-demo3/SessionServlet2");
		
		System.out.println("encodeURL:"+encodeURL);
		System.out.println("encodeRedirectURL:"+encodeRedirectURL);
		
		String a = "<a href='"+encodeURL+"'>点击</a>";
		
		response.getWriter().write(a);
		
	}

}
