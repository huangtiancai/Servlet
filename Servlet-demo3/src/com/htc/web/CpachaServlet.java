package com.htc.web;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.htc.utils.CpachaUtil;

/**
 * Servlet implementation class CpachaServlet
 */
public class CpachaServlet extends HttpServlet {
	private static final long serialVersionUID = 4919529414762301338L;
	
	//doGet and doPost
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("进入doPost");
	
		//根据方法参数获取方法
		String method = request.getParameter("method");
		System.out.println("请求的方法："+method);
		if("loginCapcha".equals(method)){
			generateLoginCpacha(request, response);
			return;
		}
		//如果传入的方法method不为loginCapcha,向前台发送错误提示弹框
		response.getWriter().write("error method");
		
	}
	
	//生成验证码的方法	
	private void generateLoginCpacha(HttpServletRequest request,HttpServletResponse response) throws IOException{
		System.out.println("进入生成验证码的方法");
		CpachaUtil cachaUtil = new CpachaUtil();
		String generatorVCode = cachaUtil.generatorVCode();
		System.out.println("generatorVCode:"+generatorVCode);
		//获取session对象并将generatorVCode存入session的属性loginCapcha中
		request.getSession().setAttribute("loginCapcha", generatorVCode);
		
		BufferedImage  buf = cachaUtil.generatorRotateVCodeImage(generatorVCode, true);
		ImageIO.write(buf, "gif", response.getOutputStream());
	}

}
