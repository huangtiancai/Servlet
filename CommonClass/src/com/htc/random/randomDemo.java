/**
 * 
 */
package com.htc.random;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Test;

/**  
* @ClassName randomDemo
* @Description:Randon - java.util.Random
* 	1.在 java 中要生成一个指定范围之内的随机数字有两种方法：一种是调用 Math 类的 random() 方法，一种是使用 Random 类
* 	      这里详细讲解Random 类的使用
*   2.Random 类提供了丰富的随机数生成方法，可以产生 boolean、int、long、float, byte 数组以及 double 类型的随机数，
*     这是它与 random() 方法最大的不同之处。random() 方法只能产生 double 类型的 0~1 的随机数。
*   3.特点：
*   Random 类提供的所有方法生成的随机数字都是均匀分布的，也就是说区间内部的数字生成的概率是均等的
*    
*   使用：
*   Random 类位于 java.util 包中，该类常用的有如下两个构造方法：
	Random()：该构造方法使用一个和当前系统时间的毫秒数对应的数字作为种子数，然后使用这个种子数构造 Random 对象。
	Random(long seed)：使用单个 long 类型的参数创建一个新的随机数生成器。
*   
* @author htc  
* @date 2019年9月11日下午3:31:40 
*/
public class randomDemo {
	@Test
	public void testRandom(){
		//无参构造
		Random random = new Random();
		
		double d1 = random.nextDouble(); 	//随机生成[0, 1.0)区间的小数
		double d2 = random.nextDouble()*5;	//随机生成[0,0.5)区间的小数
		double d3 = random.nextDouble()*1.5+1;	//随机生成[1,2.5)区间的小数
		
		int i1 = random.nextInt();			//生成一个随机的 int 值，该值介于 int 的区间，也就是 -2的31次方~2的31次方-1
		int i2 = random.nextInt(10);		//生成[0,10)区间的整数
		int i3 = Math.abs(random.nextInt()%10);//生成[0,10)区间的整数
		int i4 = random.nextInt(10)-3;		//生成[-3,7)区间的整数
		
		
		long l1 = random.nextLong();		//生成一个随机长整型值
		boolean b1 = random.nextBoolean();	//生成一个随机的 boolean 值，生成 true 和 false 的值概率相等
		Float f1 = random.nextFloat();		//返回一个随机浮点型数字
		
		System.out.println(random);
		System.out.println(d1);
		System.out.println(d2);
		System.out.println(d3);
		System.out.println(i1);
		System.out.println(i2);
		System.out.println(i3);
		System.out.println(i4);
		
		System.out.println("--------------");
		
		System.out.println(l1);
		System.out.println(b1);
		System.out.println(f1);

		
		///随机生成byte，并存放在定义的数组中，生成的个数等于定义的数组的个数
//		byte[] byteArr = new byte[3];
//		rd.nextBytes(byteArr);
//		for(int i = 0;i<byteArr.length;i++){
//			System.out.println(byteArr[i]);
//		}
		
		/**
		 * 详解nextInt方法：
		 * random.nextInt(n) - 随机生成一个正整数，整数范围[0,n)
		 * random.nextInt(n-m+1) + m - 生成范围在[m,n]的整数, n > m
		 * 			     [0,n-m+1) => [m,n+1) => [m,n]
		 * random.nextInt(x) + y
		 * 				 [0,x)     => [m,x+m) => (m-1,x+m) => (m,x+m+1)=(m,n) 故	x+m+1=n
		 * 				 		   => x = n-m-1
		 * 
		 * random.nextInt(n-m+1) + 
		 * 				 [0,n-m-1) => [m+1,n) => (m,n)
		 */
//		for(int i = 0;i<100;i++){
//			System.out.println(Math.abs(random.nextInt()%10));
//		}
	}

	
	@Test
	public void testRandomLongSeed(){
		
		// 对于种子相同的Random对象，生成的随机数序列是一样的
		Random ran1 = new Random(10);
		
		System.out.println("使用种子为10的Random对象生成[0,10)内随机整数序列: ");
		
		for(int i = 0; i<10;i++){
			//生成的随机数由种子数决定
			System.out.print(ran1.nextInt(10)+" ");//3 0 3 0 6 6 7 8 1 4 
		}
		
		System.out.println();
		
		Random ran2 = new Random(10);
		
		System.out.println("使用另一个种子为10的Random对象生成[0,10)内随机整数序列: ");
		
		for(int i = 0; i<10;i++){
			//生成的随机数由种子数决定
			System.out.print(ran2.nextInt(10)+" ");//3 0 3 0 6 6 7 8 1 4 
		}
		
		System.out.println();
		
		Random ran3 = new Random();
		
		System.out.println("使用无参构造函数生成的的Random对象生成[0,10)内随机整数序列: ");
		
		for(int i = 0; i<10;i++){
			System.out.print(ran3.nextInt(10)+" ");//4 9 9 2 8 5 9 2 0 5 
		}
	
		//注意：直接使用Random无法避免生成重复的数字，如果需要生成不重复的随机数序列，需要借助数组和集合类
		//ArrayList list  = new randomDemo().get
	}
	
		

	
	
	
}
