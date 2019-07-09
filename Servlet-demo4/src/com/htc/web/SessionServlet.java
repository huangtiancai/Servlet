package com.htc.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取session对象（容器）
		HttpSession session = request.getSession();
		System.out.println(session);
		
		session.setAttribute("addr", "北京");
		String addr = (String) session.getAttribute("addr"); //简写为：request.getSession().getAttribute("addr");
		System.out.println(addr);
		
		//手动销毁session容器, 使用 session.invalidate()
		//session.invalidate();//手动销毁session容器,两次调用同一个servlet测试，有销毁方法，获取到不同的session对象
		
//		session.removeAttribute("addr");
//		String addr1 = (String) session.getAttribute("addr");
//		System.out.println(addr1);
		
		//ApplicationSessionCookieConfig
		//创建记录sessionid的cookie由tomcat中的ApplicationSessionCookieConfig类创建

		//结论：关闭浏览器之后，重新访问项目，被分配一个新的session对象，
		//原因——用来寻找session对象的cookie已经不存在了，随着浏览器关闭消失了。
		
		//需求：关闭浏览器之后，还要之前的session，如何实现呢？
		//解决方案：自己创建一个cookie，要求被浏览器持久化保存起来（setMaxAge(10000)）放便后期使用
		
		//获取session的id
		Cookie cookie = new Cookie("JSESSIONID", session.getId());
		
		//活的久一点
		cookie.setMaxAge(100000);
		cookie.setPath("/");
		response.addCookie(cookie);
		
		//效果：
		//JSESSIONID：
//		68A3F7A431906ABB711E914365CC0467
//		68A3F7A431906ABB711E914365CC0467
//		session：
//		org.apache.catalina.session.StandardSessionFacade@2178e7
//		北京
//		org.apache.catalina.session.StandardSessionFacade@2178e7
//		北京

		//总结：
		//session容器的获取全部依赖于cookie，服务器自动解析cookie，根据cookie中jsessionid，获取指定的容器对象
		

//		Cookie cookie = new Cookie("JSESSIONID", "");
//		Cookie cookie1 = new Cookie("JESSIONID", "");
//		cookie.setMaxAge(0);
//		cookie1.setMaxAge(0);
//		response.addCookie(cookie);
//		response.addCookie(cookie1);
	}

}
