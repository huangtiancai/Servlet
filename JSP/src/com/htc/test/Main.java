package com.htc.test;

//����InetAddress��jar
import java.net.InetAddress;


public class Main {
	//Java ʵ�� - ��ȡ����ip��ַ��������
	public static void main(String[] args) throws Exception {
		InetAddress addr = InetAddress.getLocalHost();
		System.out.println("addr:"+addr);//addr:ks01pc23/172.30.32.67
		String hostAddress = addr.getHostAddress();
		String hostName = addr.getHostName();
		System.out.println("��������ַ��"+hostAddress);//��������ַ��172.30.32.67
		System.out.println("��������"+hostName);//��������ks01pc23		
	}
}
