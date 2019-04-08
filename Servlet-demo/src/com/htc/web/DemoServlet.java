package com.htc.web;

import java.io.IOException;

import javax.servlet.ServletException;
//Interface Servlet
//ʵ��Servlet�ӿڣ���дһ����չjavax.servlet.http.HttpServlet �� HTTP servlet
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author htc
 *	Servlet�����Ĳ���
 *	����һ���� �̳� HttpServlet ��
 */
public class DemoServlet extends HttpServlet{
	//��дdoGet��doPost����
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet...");
		System.out.println("����pull�Ĺ���");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost...");
	}	
}