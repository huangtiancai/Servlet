/**
 * 
 */
package com.htc.random;

import java.util.Random;

import org.junit.Test;

/**  
* @ClassName randomDemo
* @Description:
* @author htc  
* @date 2019年9月11日下午3:31:40 
*/
public class randomDemo {
	@Test
	public void testRandom(){
		Random random = new Random();
		
		System.out.println(random);
		System.out.println(random.nextInt());
		System.out.println(random.nextLong());
		System.out.println(random.nextFloat());//随机生成[0, 1.0)区间的小数
		System.out.println(random.nextDouble()); //随机生成[0, 1.0)区间的小数
		
		///随机生成byte，并存放在定义的数组中，生成的个数等于定义的数组的个数
//		byte[] byteArr = new byte[3];
//		rd.nextBytes(byteArr);
//		for(int i = 0;i<byteArr.length;i++){
//			System.out.println(byteArr[i]);
//		}
		
		/**
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
		for(int i = 0;i<1000;i++){
			//System.out.println(random.nextInt(5));
			System.out.println(random.nextInt(5));
		}
		
	}
	
}
