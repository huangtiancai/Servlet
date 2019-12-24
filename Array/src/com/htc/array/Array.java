/**
 * 
 */
package com.htc.array;

import org.junit.Test;

/**  
* @ClassName Array1
* @Description:
* @author htc  
* @date 2019年12月23日上午11:46:12 
*/
public class Array {
	// 创建数组
	@Test
	public void buildArray(){
		//一维数组声明方式： type var[] 或 type[] var;
		// int a[];
		// int[] a1;
		// double[] b;
		// mydate[] c;对象数组
		
		// 声明一个数组
		int[] t;
		
		// 声明一个能放4个int类型数据的数组
		int[] a = new int[4]; // 变量a代表一个数组=>引用，让a这个引用指向数组
		
		// 声明一个存放了1,3,2三个数的数组
		int[] b = new int[]{1,3,2};
		
		
		// 访问数组
		int[] d = new int[5];
		d[0] = 1;
		d[1] = 2;
		d[2] = 3;
		d[3] = 4;
		d[4] = 5;
		System.out.println(d+"-"+d.length);
		
		// 数组长度：length 用于访问数组的长度，数组访问下标的范围是 0~length-1,超出范围就会产生数组下表越界异常
		int[] e = new int[3];
//		e[-1] = 1; // java.lang.ArrayIndexOutOfBoundsException: -1
		e[0] = 1;
		e[2] = 1;
//		e[3] = 1; // java.lang.ArrayIndexOutOfBoundsException: 3
	
		String[] strs = new String[]{"a","b","c","d"};
		System.out.println(strs.length);
		
		System.out.println("----------------------");
		
		// 遍历数组
		int[] f = new int[5];
		f[0] = (int) (Math.random()*100);
		f[1] = (int) (Math.random()*100);
		f[2] = (int) (Math.random()*100);
		f[3] = (int) (Math.random()*100);
		f[4] = (int) (Math.random()*100);
		
		// 初始化一个默认的最小值
		int min = f[0];
		
		for(int i=0;i<f.length;i++){
			
			System.out.println(f[i]);
			if(min>f[i]){
				min= f[i];
			}
			
		}
		
		System.out.println("数组中最小的值为："+min);	
	}
	
	// 初始化数组 - 分配空间与赋值分步进行
	@Test
	public void initialArray(){
		int[] a = new int[3];
		System.out.println(a[0]); // 0 - 没有赋值，使用默认值,int类型的数组默认值是0
		
		// 进行赋值
		a[0] = 100;
		a[1] = 200;
		a[2] = 300;
		
		System.out.println(a[1]); // 200
		
	}
	
	// 初始化数组 - 分配空间，同时赋值
	@Test
	public void initialArray1(){
		// 写法一：分配空间同时赋值
		int[] a = new int[]{100,200,300,400};
		// 省略new int[]
		int[] b = {100,200,300,400};
		// 指定课数组长度就不能同时设置数组的长度 
//		int[] c = new int[4]{100,200,300,400};
	}
	
}
