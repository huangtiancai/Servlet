package com.htc.test;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import cz.mallat.uasparser.OnlineUpdater;
import cz.mallat.uasparser.UASparser;
import cz.mallat.uasparser.UserAgentInfo;

public class UserAgent {
	//Java����User-Agent��Ϣ
	//��һ�ַ�����ͨ������������ʵ��(uasparser-0.6.1.jar/jregex-1.2_01.jar)
	//1.���������루uasparser-0.6.1.jar/jregex-1.2_01.jar��-ֱ����ӵ�lib��
	
	//2.����ʵ��
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
		//����֪��ua���н���
		String ua = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.103 Safari/537.36";
		try {
			UserAgentInfo userAgentInfo = UserAgent.uasparser.parse(ua);
			System.out.println("����ϵͳ��"+userAgentInfo.getOsFamily());
			System.out.println("����ϵͳ��ϸ���ƣ�"+userAgentInfo.getOsName());
			System.out.println("�ͻ������ͣ�"+userAgentInfo.getType());
			System.out.println("��������ƺͰ汾��"+userAgentInfo.getUaName());
			System.out.println("��������ƣ�"+userAgentInfo.getUaFamily());
			System.out.println("������汾��"+userAgentInfo.getBrowserVersionInfo());
			System.out.println("�豸���ͣ�"+userAgentInfo.getDeviceType());
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
	
}
