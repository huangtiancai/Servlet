package com.htc.math;

import java.util.Random;

import org.junit.Test;

/**
 * @ClassName MathAction
 * @Description:
 * @author htc
 * @date 2019年9月6日下午4:21:33
 */
public class MathAction {
	public static void main(String[] args) {
		double a = 10.12;
		double b = 10.88;
		double c = -10.12;
		double d = -10.88;	
		// 强制转换
		int m1 = (int) a;
		int m2 = (int) b;
		int m3 = (int) c;
		int m4 = (int) d;
		
		System.out.println(m1);// 10
		System.out.println(m2);// 10
		System.out.println(m3);// -10
		System.out.println(m4);// -10	

	}
	
	@Test
	public void testCeil(){
		double a = 11.12;
		double b = 11.88;
		double c = -11.12;
		double d = -11.88;	
		
		// ceil；向上取整，返回doouble类型的值
		double m1 = Math.ceil(a);
		double m2 = Math.ceil(b);
		double m3 = Math.ceil(c);
		double m4 = Math.ceil(d);
		
		System.out.println(m1);// 12.0
		System.out.println(m2);// 12.0
		System.out.println(m3);// -11.0
		System.out.println(m4);// -11.0
	}
	
	@Test
	public void testFloor(){
		double a = 11.12;
		double b = 11.88;
		double c = -11.12;
		double d = -11.88;	
		
		//floor:向下取整,返回doouble类型的值
		double m1 = Math.floor(a); 
		double m2 = Math.floor(b); 
		double m3 = Math.floor(c); 
		double m4 = Math.floor(d); 
		
		
		System.out.println(m1);// 11.0
		System.out.println(m2);// 11.0
		System.out.println(m3);// -12.0
		System.out.println(m4);// -12.0
	}
	
	@Test
	public void testRound(){
		double a = 11.12;
		double b = 11.88;
		double c = -11.12;
		double d = -11.88;	
		
		//round:四舍五入,返回整数
		double m1 = Math.round(a); 
		double m2 = Math.round(b); 
		double m3 = Math.round(c); 
		double m4 = Math.round(d); 
		
		System.out.println(m1);// 
		System.out.println(m2);// 
		System.out.println(m3);// 
		System.out.println(m4);// 
	}
	
	@Test
	public void testRandom(){
		//random() 返回一个 [0,1) 的随机小数 
		double x = Math.random();
		System.out.println(x);
		
		//应用
		//1.生成一个 0-100 的随机数
		int y = (int) (Math.random()*100);
		System.out.println(y);
		
		Random rand = new Random();
		rand.nextInt();
	}
	
	
	
}
