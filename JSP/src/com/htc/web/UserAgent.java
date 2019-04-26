package com.htc.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cz.mallat.uasparser.OnlineUpdater;
import cz.mallat.uasparser.UASparser;
import cz.mallat.uasparser.UserAgentInfo;


public class UserAgent extends HttpServlet {
	static UASparser  uasparser = null;
	static {
		try {
			uasparser = new UASparser(OnlineUpdater.getVendoredInputStream());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Java解析User-Agent信息
		//第一种方法：通过第三方包来实现(uasparser-0.6.1.jar/jregex-1.2_01.jar)
		//1.依赖包引入（uasparser-0.6.1.jar/jregex-1.2_01.jar）-直接添加到lib下
		
		//2.代码实现，浏览器、系统获取
		//获取浏览器信息
		String ua = request.getHeader("User-Agent");
		UserAgentInfo userAgentInfo = UserAgent.uasparser.parse(ua);
		
		System.out.println("操作系统："+userAgentInfo.getOsFamily());
		System.out.println("操作系统详细名称："+userAgentInfo.getOsName());
		System.out.println("类型："+userAgentInfo.getType());
		System.out.println("浏览器名称和版本："+userAgentInfo.getUaName());
		System.out.println("浏览器名称："+userAgentInfo.getUaFamily());
		System.out.println("浏览器版本："+userAgentInfo.getBrowserVersionInfo());
		System.out.println("设备类型："+userAgentInfo.getDeviceType());
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
