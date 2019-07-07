package com.htc.test;

//导入InetAddress的jar
import java.net.InetAddress;


public class Main {
	//Java 实例 - 获取本机ip地址及主机名
	public static void main(String[] args) throws Exception {
		InetAddress addr = InetAddress.getLocalHost();
		System.out.println("addr:"+addr);//addr:ks01pc23/172.30.32.67
		String hostAddress = addr.getHostAddress();
		String hostName = addr.getHostName();
		System.out.println("主机名地址："+hostAddress);//主机名地址：172.30.32.67
		System.out.println("主机名："+hostName);//主机名：ks01pc23		
	}
}



