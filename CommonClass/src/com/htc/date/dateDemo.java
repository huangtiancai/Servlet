/**
 * 
 */
package com.htc.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.junit.Test;

/**  
* @ClassName:dateDemo
* @Description:Date类
* @author:htc  
* @date:2019年9月8日 上午11:13:03
*/
public class dateDemo {
	
	/**
	 * function: testDate
	 * Description:java日期和毫秒值的相互转化
	 * return:void
	 */
	@Test
	public void testDate(){
		//获取当前日期对象
		Date d = new Date();
		System.out.println("当前日期："+d);
		
		//1.日期转毫秒
		long time = d.getTime();
		System.out.println("当前日期的毫秒数："+time);
		
		//2.毫秒转日期
		//2.1将指定时间(毫秒值)传给Date构造器，自动转换为日期，后面记得加上L
		Date d2 = new Date(1567912944032l);
		System.out.println("d2:"+d2);
		
		//2.2使用setTime方法
		Date d3 = new Date();	
		d3.setTime(1567912944032l);
		System.out.println("d3:"+d3);
		
		//d2 和 d3的对比
		System.out.println(d3==d2);
		System.out.println(d3.equals(d2));
		
	}
	
	
	
	
	
	/**
	 * 日期的格式化
		方法一：DateFormat - （常用的）需要将日期转为yyyy-MM-dd格式的
		方法二：使用simpleDateFormat
	 */
	
	//DateFormat例子:testDate1 - testDate10
	
	/**
	 * function: testDate1
	 * Description:1.日期的格式化,使用DateFormat的format方法:
	 * 			   	 String - format(Date date) - 将日期格式化成日期/时间字符串
	 * 			   2.static DateFormat - getDateInstance()
	 * return:void
	 */
	@Test
	public void testDate1(){
		// 获取当前日期对象
		Date d = new Date();
		
		System.out.println(d);//Mon Sep 09 22:00:11 CST 2019
		
		// 获取日期格式器:
		
		//getDateInstance() - 获取默认格式化样式为默认的 FORMAT语言环境的日期格式化 程序 -yyyy-MM-dd
		DateFormat dateformat = DateFormat.getDateInstance();
		
		//将日期格式化成日期字符串=>用字符串变量接收转换后的日期字符串
		String dStr = dateformat.format(d);
		
		System.out.println(dStr);//2019-9-9
		
	}
	
	/**
	 * function: testDate2
	 * Description:日期的格式化
	 * 			static DateFormat - getDateInstance(style)	
	 * return:void
	 */
	@Test
	public void testDate2(){
		// 获取当前日期对象
		Date d = new Date();
		
		System.out.println(d);//Mon Sep 09 22:00:11 CST 2019
		
		//getDateInstance(int style) - 获取默认的 FORMAT区域设置的给定格式化样式的日期格式化 程序
		//style为要格式话的样式：取值为0,1,2,3;对应的格式为FULL,LONG,MEDIUM,SHORT
		//style的2种写法，4个不同的值:
		//0 - DateFormat.FULL
		//1 - DateFormat.LONG
		//2 - DateFormat.MEDIUM
		//3 - DateFormat.SHORT
		
		DateFormat df1 = DateFormat.getDateInstance(0);
		System.out.println(df1.format(d));//2019年9月9日 星期一
		
		DateFormat df11 = DateFormat.getDateInstance(DateFormat.FULL);
		System.out.println(df11.format(d));//2019年9月9日 星期一
		
		
		DateFormat df2 = DateFormat.getDateInstance(1);
		System.out.println(df2.format(d));//2019年9月9日
		
		DateFormat df22 = DateFormat.getDateInstance(DateFormat.LONG);
		System.out.println(df22.format(d));//2019年9月9日
		
		
		DateFormat df3 = DateFormat.getDateInstance(2);
		System.out.println(df3.format(d));//2019-9-9
		
		DateFormat df33 = DateFormat.getDateInstance(DateFormat.MEDIUM);
		System.out.println(df33.format(d));//2019-9-9
		
		
		DateFormat df4 = DateFormat.getDateInstance(3);
		System.out.println(df4.format(d));//19-9-9
		
		DateFormat df44 = DateFormat.getDateInstance(DateFormat.SHORT);
		System.out.println(df44.format(d));//19-9-9

	}
	
	/**
	 * function: testDate3
	 * Description:日期的格式化+国际化
	 * 			static DateFormat - getDateInstance(int style, Locale aLocale) 	
	 * return:void
	 */
	@Test
	public void testDate3(){
		// 获取当前日期对象
		Date d = new Date();
		
		System.out.println(d);//Mon Sep 09 22:00:11 CST 2019
		
		//getDateInstance(int style, Locale aLocale) - 获取给定区域设置的给定格式化样式的日期格式化程序
		//注意：日期格式+国际化
		
		
		DateFormat df1 = DateFormat.getDateInstance(DateFormat.LONG, Locale.CHINESE);
		System.out.println(df1.format(d));//2019年9月9日
		
		//CN
		DateFormat df2 = DateFormat.getDateInstance(DateFormat.LONG, Locale.SIMPLIFIED_CHINESE);
		System.out.println(df2.format(d));//2019年9月9日
		
		//TW
		DateFormat df3 = DateFormat.getDateInstance(DateFormat.LONG, Locale.TRADITIONAL_CHINESE);
		System.out.println(df3.format(d));//2019年9月9日
		
		//CHINA = SIMPLIFIED_CHINESE
		DateFormat df4 = DateFormat.getDateInstance(DateFormat.LONG, Locale.CHINA);
		System.out.println(df4.format(d));//2019年9月9日
		
		//PRC = SIMPLIFIED_CHINESE
		DateFormat df5 = DateFormat.getDateInstance(DateFormat.LONG, Locale.PRC);
		System.out.println(df5.format(d));//2019年9月9日
		
		//TAIWAN = TRADITIONAL_CHINESE
		DateFormat df6 = DateFormat.getDateInstance(DateFormat.LONG, Locale.TAIWAN);
		System.out.println(df6.format(d));//2019年9月9日
		
		DateFormat df7 = DateFormat.getDateInstance(DateFormat.LONG, Locale.ENGLISH);
		System.out.println(df7.format(d));//September 9, 2019
		
		DateFormat df8 = DateFormat.getDateInstance(DateFormat.LONG, Locale.UK);
		System.out.println(df8.format(d));//09 September 2019
			
		DateFormat df9 = DateFormat.getDateInstance(DateFormat.LONG, Locale.US);
		System.out.println(df9.format(d));//September 9, 2019
		
	}
	
	/**
	 * function: testDate4
	 * Description:时间的格式化
	 * 			static DateFormat - getTimeInstance()  	
	 * return:void
	 */
	@Test
	public void testDate4(){
		// 获取当前日期对象
		Date d = new Date();
		System.out.println(d);//Mon Sep 09 23:43:07 CST 2019
		
		//getTimeInstance()  - 获取默认格式化样式为默认的 FORMAT语言环境的时间格式化 程序
		DateFormat df1 = DateFormat.getTimeInstance();
		System.out.println(df1.format(d));//23:43:07
		
	}
	
	
	/**
	 * function: testDate5
	 * Description:时间的格式化
	 * 			static DateFormat - getTimeInstance(int style)   	
	 * return:void
	 */
	@Test
	public void testDate5(){
		// 获取当前日期对象
		Date d = new Date();
		System.out.println(d);//Mon Sep 09 23:49:21 CST 2019
		
		//getTimeInstance(int style) - 获取默认的 FORMAT区域设置的给定格式化样式的时间格式化 程序 
		DateFormat df1 = DateFormat.getTimeInstance(DateFormat.FULL);
		System.out.println(df1.format(d));//下午11时49分21秒 CST
		
		DateFormat df2 = DateFormat.getTimeInstance(DateFormat.LONG);
		System.out.println(df2.format(d));//下午11时49分21秒
		
		
		DateFormat df3 = DateFormat.getTimeInstance(DateFormat.MEDIUM);
		System.out.println(df3.format(d));//23:49:21
	
		DateFormat df4 = DateFormat.getTimeInstance(DateFormat.SHORT);
		System.out.println(df4.format(d));//下午11:49
	}
	
	
	/**
	 * function: testDate6
	 * Description:时间的格式化+国际化
	 * 			static DateFormat - getTimeInstance(int style, Locale aLocale)   	
	 * return:void
	 */
	@Test
	public void testDate6(){
		// 获取当前日期对象
		Date d = new Date();
		System.out.println(d);//Mon Sep 09 23:49:21 CST 2019
		
		//getTimeInstance(int style, Locale aLocale) - 获取给定区域设置的给定格式化样式的时间格式化程序。
		DateFormat df1 = DateFormat.getTimeInstance(DateFormat.MEDIUM,Locale.CHINA);
		System.out.println(df1.format(d));//23:53:33
	
	}
	
	/**
	 * function: testDate7
	 * Description:日期+时间的格式化
	 * 			static DateFormat - getDateTimeInstance()    	
	 * return:void
	 */
	@Test
	public void testDat7(){
		// 获取当前日期对象
		Date d = new Date();
		System.out.println(d);//Tue Sep 10 00:01:20 CST 2019
		
		//getDateTimeInstance()  - 获取默认格式化样式的日期/时间格式化程序默认的 FORMAT区域设置。
		DateFormat df1 = DateFormat.getDateTimeInstance();
		System.out.println(df1.format(d));//2019-9-10 0:01:20
	}
	
	/**
	 * function: testDate8
	 * Description:日期+时间的格式化
	 * 			static DateFormat - getDateTimeInstance(int dateStyle, int timeStyle)    	
	 * return:void
	 */
	@Test
	public void testDa8(){
		// 获取当前日期对象
		Date d = new Date();
		System.out.println(d);//Tue Sep 10 00:08:03 CST 2019
		
		//getDateTimeInstance(int dateStyle, int timeStyle) - 获取默认的 FORMAT区域设置的给定日期和时间格式化样式的日期/时间格式化 程序
		DateFormat df1 = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.MEDIUM);
		System.out.println(df1.format(d));//2019年9月10日 0:08:03
	}
	
	/**
	 * function: testDate9
	 * Description:日期+时间的格式化、国际化
	 * 			static DateFormat - getDateTimeInstance(int dateStyle, int timeStyle, Locale aLocale)     	
	 * return:void
	 */
	@Test
	public void testDa9(){
		// 获取当前日期对象
		Date d = new Date();
		System.out.println(d);//Tue Sep 10 00:10:12 CST 2019
		
		//getDateTimeInstance(int dateStyle, int timeStyle, Locale aLocale)  - 获取给定区域设置的给定格式样式的日期/时间格式化程序。 
		DateFormat df1 = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.MEDIUM,Locale.CHINA);
		System.out.println(df1.format(d));//2019年9月10日 0:10:12
	}
	
	/**
	 * function: testDate10
	 * Description:
	 * 	1.输出日期和时间+国际化
	 *  2.把字符串反向解析成一个date对象   	
	 * return:void
	 * @throws ParseException 
	 */
	@Test
	public void testDa10() throws ParseException{
		// 获取当前日期对象
		Date d = new Date();
		System.out.println(d);//Tue Sep 10 00:21:29 CST 2019
		
		//1.输出日期和时间+国际化
		DateFormat df1 = DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.LONG,Locale.CHINA);
		System.out.println(df1.format(d));//19-9-10 上午12时21分29秒
		
		//2.把字符串反向解析成一个date对象 
		String s = "19-9-10 上午12时21分29秒";
		DateFormat df2 = DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.LONG,Locale.CHINA);
		Date d1 = df2.parse(s);
		System.out.println(d1);
	}
	
	
	
	//使用simpleDateFormat
	SimpleDateFormat sdf = new 
	
	
	
}

