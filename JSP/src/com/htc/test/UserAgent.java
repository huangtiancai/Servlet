package com.htc.test;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import cz.mallat.uasparser.OnlineUpdater;
import cz.mallat.uasparser.UASparser;
import cz.mallat.uasparser.UserAgentInfo;

public class UserAgent {
	//Java解析User-Agent信息
	//第一种方法：通过第三方包来实现(uasparser-0.6.1.jar/jregex-1.2_01.jar)
	//1.依赖包引入（uasparser-0.6.1.jar/jregex-1.2_01.jar）-直接添加到lib下
	
	//2.代码实现
	static UASparser  uasparser = null;
	static {
		try {
			uasparser = new UASparser(OnlineUpdater.getVendoredInputStream());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		//对已知的ua进行解析
		String ua = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.103 Safari/537.36";
		try {
			UserAgentInfo userAgentInfo = UserAgent.uasparser.parse(ua);
			System.out.println("操作系统："+userAgentInfo.getOsFamily());
			System.out.println("操作系统详细名称："+userAgentInfo.getOsName());
			System.out.println("客户端类型："+userAgentInfo.getType());
			System.out.println("浏览器名称和版本："+userAgentInfo.getUaName());
			System.out.println("浏览器名称："+userAgentInfo.getUaFamily());
			System.out.println("浏览器版本："+userAgentInfo.getBrowserVersionInfo());
			System.out.println("设备类型："+userAgentInfo.getDeviceType());
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
	
}
