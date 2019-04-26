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
		//Java����User-Agent��Ϣ
		//��һ�ַ�����ͨ������������ʵ��(uasparser-0.6.1.jar/jregex-1.2_01.jar)
		//1.���������루uasparser-0.6.1.jar/jregex-1.2_01.jar��-ֱ����ӵ�lib��
		
		//2.����ʵ�֣��������ϵͳ��ȡ
		//��ȡ�������Ϣ
		String ua = request.getHeader("User-Agent");
		UserAgentInfo userAgentInfo = UserAgent.uasparser.parse(ua);
		
		System.out.println("����ϵͳ��"+userAgentInfo.getOsFamily());
		System.out.println("����ϵͳ��ϸ���ƣ�"+userAgentInfo.getOsName());
		System.out.println("���ͣ�"+userAgentInfo.getType());
		System.out.println("��������ƺͰ汾��"+userAgentInfo.getUaName());
		System.out.println("��������ƣ�"+userAgentInfo.getUaFamily());
		System.out.println("������汾��"+userAgentInfo.getBrowserVersionInfo());
		System.out.println("�豸���ͣ�"+userAgentInfo.getDeviceType());
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
