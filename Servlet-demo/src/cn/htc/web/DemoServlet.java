package cn.htc.web;

import java.io.IOException;

import javax.servlet.ServletException;
//Interface Servlet
//实现Servlet接口，编写一个扩展javax.servlet.http.HttpServlet 的 HTTP servlet
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author htc
 *	Servlet开发的步骤
 *	创建一个类 继承 HttpServlet 类
 */
public class DemoServlet extends HttpServlet{
	/**
	 *重写doGet和doPost方法
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet...");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost...");
	}
	
}
