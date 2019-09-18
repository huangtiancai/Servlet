/**
 * 
 */
package com.htc.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	 * @describe String类的常用方法:操作字符串
	 * length
	 * indexOf
	 * lastindexOf
	 * charAt
	 * subString
	 * split
	 * concat
	 * trim
	 * toUpperCase、toLowerCase
	 * replaceAll、replaceFirst
	 * startWith、endWith
	 * 静态方法：valueOf
	 * @param 
	 */
	@Test
	public void testStringMethod(){
		//length:字符串长度
		//长度为0的字符串，即空字符串
		String unknowStr = "";
		System.out.println(unknowStr.length());//0
		
		//非空字符串
		String unnullStr = "非空字符串";
		System.out.println(unnullStr.length());//5
		
		//定位
		String sentence = "这是,8一段,非常好非常好";
		
		//indexOf 字符第一次出现的位置
		System.out.println(sentence.indexOf("8"));//3
		System.out.println(sentence.indexOf("是"));//1
		//字符串第一次出现的位置
		System.out.println(sentence.indexOf("非常好"));//7 => 定位到字符串的第一个字符 
		//从位置3开始，出现的第一次,的位置
		System.out.println(sentence.indexOf(",", 3));//6 => 从指定的索引位置3开始返回的是在整个字符串中的索引
		
		//lastIndexOf 字符串最后出现的位置
		System.out.println(sentence.lastIndexOf("非常好"));//10 "这是,8一段,非常好非常好"中最后一个"非常好"的位置
		System.out.println(sentence.lastIndexOf(",", 8));//6  "这是,8一段,非常"中最后一个","的位置
		System.out.println(sentence.lastIndexOf(",", 7));//6  "这是,8一段,非"中最后一个","的位置
		System.out.println(sentence.lastIndexOf(",", 3));//2  "这是,8"中最后一个","的位置
		System.out.println(sentence.lastIndexOf(",", 1));//-1 "这是"中最后一个","的位置
		
		System.out.println(sentence.contains("一"));//true
		System.out.println(sentence.contains("非常好"));//true
		System.out.println(sentence.contains("hello"));//false	
		
		//charAt(int index) 获取指定位置的字符
		char c = sentence.charAt(4);
		System.out.println(c);//一
		
		//toCharArray() 获取对应的字符数组
		char[] cs = sentence.toCharArray();
		System.out.println(cs);//这是,8一段,非常好非常好
		System.out.println(cs.toString());//[C@17ea54 => ?
		System.out.println(sentence.length() == cs.length);//true
		
		//subString 截取子字符串	
		//从指定位置截取到末尾
		String sub1 = sentence.substring(3);
		System.out.println(sub1);
		//截取[) => 左闭右开
		String sub2 = sentence.substring(3, 5);
		System.out.println(sub2);
		
		//分隔：split 根据分隔符进行分隔
		//根据,进行分割，得到3个子字符串=>字符串数组
		String[] spSen = sentence.split(",");
		for(String sub:spSen){
			System.out.println(sub+" ");
		}
		
		//将指定的字符串参数连接到字符串上:concat
		String s = "原本的字符串";
		s = s.concat("要连接的字符串");
		System.out.println(s);
		
		//trim:去掉首尾空格
		String s1 = "          这是一个字符串    字符串           ";
		System.out.println(s1);
		System.out.println(s1.trim());
		
		//toUpperCase:全部变成小写
		//toLowerCase:全部变成大写
		String s2 = "Tom";
		//全部变成小写
		System.out.println(s2.toLowerCase());//tom
		//全部变成大写
		System.out.println(s2.toUpperCase());//TOM
		
		//replaceAll: 替换所有的
		//replaceFirst:只替换第一个
		String s3 = "这是,8一段,非常好非常好";
		//替换所有的
		String temp = s3.replaceAll("非常", "very");//这是,8一段,very好very好
		System.out.println(temp);
		//只替换第一个
		String temp1 = s3.replaceFirst(",", ";");
		System.out.println(temp1);//这是;8一段,非常好非常好
		
		
		System.out.println("-------------");
		
		//startWith:用于检测字符串是否以指定的前缀开始
		//public boolean startsWith(String prefix, int toffset) 或
		//public boolean startsWith(String prefix)
		
		//prefix -- 前缀
		//toffset -- 字符串中开始查找的位置
		
		//endsWith():用于测试字符串是否以指定的后缀结束
		//public boolean endsWith(String suffix)
		//suffix -- 指定的后缀
		
		String s4 = "www.runoob.com";
		System.out.println(s4.startsWith("www"));//true
		System.out.println(s4.startsWith("runoob"));//false
		System.out.println(s4.startsWith("runoob", 4));//true
		System.out.println(s4.endsWith("runoob"));//false
		System.out.println(s4.endsWith("com"));//true
		
		
		//String.valueOf():基本数据型 => String 
		System.out.println(String.valueOf(true));//true
		
		char[] ch = new char[]{'字','符','数','组'};
		System.out.println(String.valueOf(ch));	//字符数组	                                        
		//System.out.println(String.valueOf(char[] data, int offset, int count));
		System.out.println(String.valueOf(ch, 1, 2));//符数
		
		Double d = 3.14;
		String dStr = String.valueOf(d);
		
		System.out.println(d instanceof Double);//true
		System.out.println(dStr instanceof String);//true
		
	}
	
	
	/**
	 * @describe String类的常用方法:比较字符串
	 * equalsIgnoreCase
	 * @param
	 */
	@Test
	public void testEqual(){
		//是否是同一个对象
		String str1 = "the light";
		String str2 = new String(str1);
		String strUP = str2.toUpperCase();
		//==用于判断是否是同一个字符串对象
		System.out.println(str1 == str2);//false
		//使用equals进行字符串内容的比较，必须大小写一致
		System.out.println(str1.equals(str2));//true
		System.out.println(str1.equals(strUP));//false
		//equalsIgnoreCase，忽略大小写判断内容是否一致
		System.out.println(str1.equalsIgnoreCase(strUP));//true
		
		//编译器每碰到一个字符串的字面值，就会创建一个新的对象
		String str3 = "the right";//创建了一个新的字符串"the right"
		String str4 = "the right";//编译器发现已经存在现成的"the right"，那么就直接拿来使用，而没有进行重复创建
		System.out.println(str3 == str4);//true
		
	}
	
	
	
	
	
	
	/**
	 * @describe length属性、length()方法和size()的方法的区别
	 * 1.length属性是针对Java中的数组来说的，要求数组的长度可以用其length属性；
	 * 2.length()方法是针对字符串来说的，要求一个字符串的长度就要用到它的length()方法；
	 * 3.java中的size()方法是针对泛型集合说的,如果想看这个泛型有多少个元素,就调用此方法来查看
	 * @param
	 */
	@Test
	public void testLengh(){
		String[] array = {"bo","ke","yuan"};
		String str = "bokeyuan";
		List list = new ArrayList();
		list.add(str);
		
		System.out.println(array.length);
		System.out.println(str.length());
		System.out.println(list.size());
	}
	
	
	
	
	
}
