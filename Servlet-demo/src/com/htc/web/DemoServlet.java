package com.htc.web;

import java.io.IOException;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemoServlet extends HttpServlet{
	
	@Override
	public void init() throws ServletException {
		System.out.println("init");
		super.init();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet...");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost...");
	}	
	

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service");
		super.service(req, resp);
	}
	
	
	@Override
	public void destroy() {
		System.out.println("destory");
		super.destroy();
	}
	
	//在整个servlet的生命周期内，init方法只被调用了一次,后续访问demoServlet只会执行doGet方法
//	init
//	doGet...
//	doGet...
//	doGet...
//	...
//	六月 09, 2019 4:23:58 下午 org.apache.catalina.core.ApplicationContext log
//	信息: ContextListener: contextDestroyed()
//	destory
//	六月 09, 2019 4:23:59 下午 org.apache.coyote.AbstractProtocol stop
//	...
}