/**
 * 
 */
package com.htc.string;

import org.junit.Test;

/**  
* @ClassName StringDemo
* @Description:
* @author htc  
* @date 2019年9月17日上午9:08:07 
*/
public class StringDemo {
	/**
	 * @describe 常见创建字符串(字符串对象)手段
	 * @param 
	 */
	@Test
	public void testString(){
		//使用String类创建字符串对象的几种方法
		
		//1.字面值,虚拟机碰到字面值就会创建一个字符串对象
	    String str = "字面量";
	    System.out.println("str:"+str);
		
		//2.String() 创建一个空的字符串对象
		String str1 = new String();
		System.out.println("str1:"+str1);
		
		//3.String(String original) 根据字符串来创建一个字符串对象
		String str2 = new String("字符串来创建一个字符串对象");//创建了两个字符串对象
		System.out.println("str2:"+str2);
		
		//4.String(char value[]) 通过字符数组来创建字符串对象
		char[] chs = new char[]{'字','符','数','组'};
		String str3 = new String(chs);
		System.out.println("str3:"+str3);
		
		//5.String(byte[] bytes) 通过字节数组来构造新的字符串对象
		byte[] bytes = {97,98,99,100,101};//a,b,c,d,e
		String str4 = new String(bytes);
		System.out.println("str4:"+str4);
		
		//6.String(byte[] bytes, int offset, int length) 通过字节数组一部分来构造新的字符串对象
		String str5 = new String(bytes, 1, 2);
		System.out.println("str5:"+str5);
	}
	
	/**
	 * @describe 上述通过通过字节数组构造新的字符串对象 => new String(各种形式);
	 * @param 
	 */
	@Test
	public void testStringByte(){
		
	}
	
	/**
	 * @describe final => String 被修饰为final(public final class String),所以是不能被继承的
	 * @param 
	 */
	@Test
	public void testString1(){
		//String不能被继承,否则会报错
	}
	

	/**
	 * @describe immutable => immutable 是指不可改变的
		比如创建了一个字符串对象:String garen ="盖伦";
		不可改变的具体含义是指：
		不能增加长度
		不能减少长度
		不能插入字符
		不能删除字符
		不能修改字符
		一旦创建好这个字符串，里面的内容 永远 不能改变,String 的表现就像是一个常量
		=> 如果需要对字符串做很多修改，那么应该选择使用 StringBuffer & StringBuilder 类。
	 * @param
	 */
	@Test
	public void testString2(){
		String garen ="盖伦";
	}
	
	/**
	 * @describe 
	 * 			字符串拼接
	 * 			字符串格式化
	 * @param 
	 */
	@Test
	public void testString3(){
		String name = "Tom";
		int age = 18;
		String likeStr = "喜欢";
		
		//直接使用+进行字符串连接 => 编码会比较繁琐，并且维护性差,易读性差
		String sentence  = name + "今年" + age + "岁了，他很" + likeStr + "编程";
		System.out.println(sentence);
		
		//字符串拼接的小技巧:在字符串的双引号中 回车，可实现字符串拼接的换行
		String str = name + "今"
				+ "年" + age + "岁了，"
				+ "他很" + likeStr + "编程";
		System.out.println(str);
		
		//格式化字符串
		//%s表示字符串，%d表示数字,%n表示换行
		String sentenceFormat  = "%s 今年  %d 岁了，他很  %s 编程";
		String sentence2 = String.format(sentenceFormat, name,age,likeStr);
		System.out.println(sentence2);	
	}
	
	/**
	 * @describe String类的常用方法
	 * length
	 * indexOf
	 * lastindexOf
	 * charAt
	 * subString
	 * concat
	 * trim
	 * equalsIgnoreCase
	 * start
	 * @param 
	 */
	@Test
	public void testStringMethod(){
		String unknowStr = "";
		System.out.println(unknowStr.length());
	}
	
	
	
	
}
