package com.htc.math;

import java.util.Random;
import java.util.Scanner;

import org.junit.Test;

/**
 * @ClassName MathAction
 * @Description: Math 类封装了常用的数学运算，提供了基本的数学操作，如指数、对数、平方根和三角函数等。Math 类位于 java.lang 包
 * @author htc
 * @date 2019年9月6日下午4:21:33
 */
public class MathAction {
	
	@Test
	public void convert(){
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
	
	/**
	 * @describe 静态常量
	 * 	Math 类中包含 E 和 PI 两个静态常量，其中 E 用于记录 e 的常量，而 PI 用于记录圆周率的值
	 * @param 
	 * @return void
	 */
	@Test
	public void statiConst(){
		//调用 Math 类的 E 和 PI 两个常量，并将结果输出
		System.out.println(Math.PI);//3.141592653589793
		System.out.println(Math.E);//2.718281828459045
	}
	
	/**
	 * @describe 求最大值、最小值和绝对值
	 * @param 
	 * @return void
	 */
	@Test
	public void minmaxabs(){
		//min
		double min1 = Math.min(10.12, 20.24);
		float min2 = Math.min(20.11f, 15.44f);
		int min3 = Math.min(33, 44);
		long min4 = Math.min(1200L, 300L);
		
		System.out.println(min1);
		System.out.println(min2);
		System.out.println(min3);
		System.out.println(min4);
		
		//max
		double max1 = Math.max(10.12, 20.24);
		float max2 = Math.max(20.11f, 15.44f);
		int max3 = Math.max(33, 44);
		long max4 = Math.max(1200L, 300L);
		
		System.out.println(max1);
		System.out.println(max2);
		System.out.println(max3);
		System.out.println(max4);
		
		//绝对值abs
		int abs = Math.abs(-23);
		System.out.println("绝对值为："+abs);
		
	}
	
	/**
	 * @describe 求整运算:ceil、floor、round、 rint
	 */
	
	/**
	 * @describe static double ceil(double a) 返回大于或等于 a 的最小整数
	 * @param 
	 * @return void
	 */
	@Test
	public void testCeil(){
		double a = 11.12;
		double b = 11.88;
		double c = -11.12;
		double d = -11.88;	
		
		// ceil:向上取整，返回doouble类型的值
		double m1 = Math.ceil(a);
		double m2 = Math.ceil(b);
		double m3 = Math.ceil(c);
		double m4 = Math.ceil(d);
		
		System.out.println(m1);// 12.0
		System.out.println(m2);// 12.0
		System.out.println(m3);// -11.0
		System.out.println(m4);// -11.0
	}
	
	/**
	 * @describe static double floor(double a)	返回小于或等于 a 的最大整数
	 * @param 
	 * @return void
	 */
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
		
		System.out.println(m1); 
		System.out.println(m2); 
		System.out.println(m3);
		System.out.println(m4);
	}
	
	/**
	 * @describe static double rint(double a)
	 * 			返回最接近 a 的整数值，如果有两个同样接近的整数，则结果取偶数
	 * @param 
	 * @return void
	 */
	@Test
	public void testRint(){
		Scanner input = new Scanner(System.in);
		System.out.println("请输入一个数字：");
		Double num = input.nextDouble();
		System.out.println("最接近"+num+"的整数为："+Math.rint(num));
		
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
