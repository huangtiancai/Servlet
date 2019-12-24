/**
 * 
 */
package com.htc.array;

import org.junit.Test;
import org.apache.commons.lang3.StringUtils;

/**  
* @ClassName ArrayProcess
* @Description:java数组和字符串的相互转换
* @author htc  
* @date 2019年12月24日上午10:11:32 
*/
public class ArrayString {
	// 字符串转换为数组
	
	// 1.Java String 类中的 toCharArray() 方法将字符串转换为字符数组
	@Test
	public void ArraytocharString(){
		String str = "123abc";
		char[] arr = str.toCharArray(); // 转为char数组
		// 遍历
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" "); // 1 2 3 a b c 
		}
	}
	
	// 2.split()
	@Test
	public void ArraytoString(){
		String str = "123abc";
		String[] arr = str.split("");// 转为String数组
		// 遍历
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" "); // 1 2 3 a b c 
		}
	}
	
	// 3.返回 byte 数组 - 直接使用 getBytes 方法
	@Test
	public void ArraytobyteString(){
		String str = "123abc";
		byte[] arr = str.getBytes();	// 转为byte数组
		// 遍历
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" "); // 49 50 51 97 98 99 
		}
	}
	
	// 4.使用 StringUtils 中的 join 函数，使用前需先引入 common-lang3 的 jar 包(apache官网)
	// 下面可以总结下common-lang3工具类的使用方法
	@Test
	public void StringUtils(){
		String[] str = {"1","2","a","c"};
		StringUtils.join(str);
//		StringUtils.join(str,",");
		// 遍历
		for(int i=0;i<str.length;i++){
			System.out.print(str[i]+" "); // 1 2 a c 
		}
	}	
	
}
