/**
 * 
 */
package com.htc.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
	 * Description:Date类
	 * return:void
	 */
	@Test
	public void testDate(){
		/**
		 * 构造方法	
		 */
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		//调用无参数构造函数
		Date date = new Date();
		System.out.println(date);
		
		//获取时间原点：1970-01-01 08:00:00
		Date dzero = new Date(0);
		System.out.println(dzero);//Thu Jan 01 08:00:00 CST 1970
		System.out.println(sdf.format(dzero));
		
		//调用含有一个long类型参数的构造函数	
		//将指定时间(毫秒值)传给Date构造器，自动转换为日期
		Date date1 = new Date(60000);//long型数据加L或不加
		System.out.println(date1);
		
		Date date2 = new Date(1567912944032L);
		System.out.println(date2);
		
		System.out.println("--------------------------");

		//获取当前日期对象
		Date d = new Date();
		System.out.println("当前日期："+d);
		
		/**
		 * 常用方法
		 */
		//1.日期转毫秒:long getTime()
		long time = d.getTime();
		System.out.println("当前日期的毫秒数："+time);
		
		//2.毫秒转日期
		//2.1将指定时间(毫秒值)传给Date构造器，自动转换为日期，后面记得加上L
		Date d2 = new Date(1567912944032L);
		System.out.println("d2:"+d2);
		
		//2.2使用setTime方法:void setTime(long time) 
		Date d3 = new Date();	
		d3.setTime(1567912944032L);
		System.out.println("d3:"+d3);
		
		//d2 和 d3的对比
		System.out.println(d3==d2);
		System.out.println(d3.equals(d2));
		
		//3.将此 Date对象转换为 String的形式 - String toString()
		Date d4 = new Date();
		System.out.println(d4.toString());
		
		System.out.println(d2.before(d3));//false
		System.out.println(d2.after(d3));//false
		System.out.println(d2.equals(d3));//true
		
		//如果参数Date等于此Date，则值为0 ; 如果此日期在Date参数之前，该值小于0 ; 如果此参数在Date参数之后，则值大于0 。 
		System.out.println(d2.compareTo(d3));//0
		System.out.println(d2.compareTo(d4));//-1
		System.out.println(d4.compareTo(d2));
		
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
		System.out.println(d);//Wed Sep 11 13:42:44 CST 2019
		
		//getDateTimeInstance(int dateStyle, int timeStyle, Locale aLocale)  - 获取给定区域设置的给定格式样式的日期/时间格式化程序。 
		DateFormat df1 = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.MEDIUM,Locale.CHINA);
		System.out.println(df1.format(d));//2019年9月11日 13:42:44
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
//		String s = "19-9-10 上午12时21分29秒";
//		DateFormat df2 = DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.LONG,Locale.CHINA);
//		Date d1 = df2.parse(s);
//		System.out.println(d1);
		
		String s = "2019年9月11日 13:42:44";
		DateFormat df2 = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.MEDIUM,Locale.CHINA);
		Date d1 = df2.parse(s);
		System.out.println(d1);
	}
	
	
	/**
	 * SimpleDateFormat 类：
	 * 1.如果使用 DateFormat 类格式化日期/时间并不能满足要求,那么就需要使用 DateFormat 类的子类——SimpleDateFormat。
	 * 2.SimpleDateFormat 是一个以与语言环境有关的方式来格式化和解析日期的具体类，它允许进行格式化（日期→文本）、解析（文本→日期）和规范化。SimpleDateFormat 使得可以选择任何用户定义的日期/时间格式的模式。
	 * 
	 * 使用步骤：
	 * 1.使用SimpleDateFormat类的构造函数(构造方法)构造格式化日期的格式
	 * 2.通过format(Date date)方法将指定的日期对象格式化为指定格式的字符串
	 * 	
	 * SimpleDateFormat 类主要有如下 3 种构造方法：
		SimpleDateFormat()：用默认的格式和默认的语言环境构造 SimpleDateFormat。
		SimpleDateFormat(String pattern)：用指定的格式和默认的语言环境构造 SimpleDateFormat。
		SimpleDateFormat(String pattern,Locale locale)：用指定的格式和指定的语言环境构造 SimpleDateF ormat。
	 * 
	 */
	
	@Test
	public void SimpleDateFormatTest(){
		//创建Date对象，获取当前时间
		Date d = new Date();
		
		//设置时间格式
		SimpleDateFormat sd = new SimpleDateFormat("yyyy MM dd HH mm ss");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM dd HH mm ss");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf2 = new SimpleDateFormat("今天是"+"yyyy 年 MM 月 dd 日 E HH 点 mm 分 ss 秒");
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.CHINA);
		SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.US);
		
		//将当前时间袼式化为指定的格式
		System.out.println(sd.format(d));//2019 09 10 11 23 58
		System.out.println(sdf.format(d));//2019 09 10 11 23 58
		System.out.println(sdf1.format(d));//2019-09-10 11:23:58
		System.out.println(sdf2.format(d));//今天是2019 年 09 月 10 日 星期二 11 点 23 分 58 秒
		System.out.println(sdf3.format(d));
		System.out.println(sdf4.format(d));
		
	}
	
	/**
	 * Calendar 类:抽象类
	 * 1.创建 Calendar 对象不能使用 new 关键字，因为 Calendar 类是一个抽象类，
	 * 	 	但是它提供了一个 getInstance() 方法来获得 Calendar类的对象。
	 *   	getInstance() 方法返回一个 Calendar 对象
	 * 2.Calendar 对象可以调用的方法：
	 * 		set(..):将日历翻到任何一个时间，当参数 year 取负数时表示公元前
	 * 		get(...):获取有关年、月、日等时间信息，参数 field 的有效值由 Calendar 静态常量指定。
	 * 3.Calendar 类中定义的常量
	 */
	
	@Test
	public void CalendarTest(){
		//对象调用 get() 方法可以获取有关年、月、日等时间信息
		Date d = new Date();
		System.out.println(d);
		
		
		//采用单例模式获取日历对象
		Calendar c = Calendar.getInstance();

		//Date getTime() 通过日历对象得到日期对象
		Date date = c.getTime();
		System.out.println(date);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		String dStr = sdf.format(d);
		String cStr = sdf.format(date);
		
		System.out.println(dStr==cStr);//false
		System.out.println(dStr.equals(cStr));//true
		
		
		System.out.println("使用get方法+静态常量 获取日期/时间参数");
		System.out.println("现在时刻："+sdf.format(c.getTime()));
		
		int year = c.get(Calendar.YEAR);
		System.out.println("现在是"+year+"年");
		
		int month = c.get(Calendar.MONTH);
		System.out.println("现在是"+month+"月");
		
		int day = c.get(Calendar.DATE);
		int days = c.get(Calendar.DAY_OF_MONTH);
		System.out.println("日期："+day);
		System.out.println("日期："+days);
		
		int week = c.get(Calendar.DAY_OF_WEEK);
		System.out.println("星期"+week);
		
		int hour = c.get(Calendar.HOUR);
		int hours = c.get(Calendar.HOUR_OF_DAY);
		System.out.println(hour+"点");
		System.out.println(hours+"点");

		int minute = c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);
		int millisecond = c.get(Calendar.MILLISECOND);
		System.out.println(minute+"分");
		System.out.println(second+"秒");
		System.out.println(millisecond+"毫秒");
		
		System.out.println("---------------");
		
//		setTime(Date date) - 使用给定的 Date设置此日历的时间
//		设置日期 : 1970-01-01 08:00:00
		Calendar c1 = Calendar.getInstance();
		Date d2 = new Date(0);//Thu Jan 01 08:00:00 CST 1970
		System.out.println(d2);
		c1.setTime(d2); 
		System.out.println(c1);
		
	}
	
	/**
	 * @describe 翻日历
				add方法，在原日期上增加年/月/日
				set方法，直接设置年/月/日
	 * @author ks0pc23-PC 
	 * @date 2019年9月10日 下午4:27:57
	 * @return void
	 * @throws Exception
	 */
	@Test
	public void CalendarTest1(){
		Calendar c = Calendar.getInstance();
		Date now = new Date();

		//设置时间格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		//当前日期	
		System.out.println("当前日期:"+sdf.format(c.getTime()));
		
		//void add(int field, int amount)
		//根据日历的规则，为给定的日历字段 field 添加或减去指定的时间量 amount
		
		//下个月的今天
		c.setTime(now);
		c.add(Calendar.MONTH, 1);
		System.out.println("下个月的今天:"+sdf.format(c.getTime()));
			
		//上个月的今天
		c.setTime(now);
		c.add(Calendar.MONTH, -1);
		System.out.println("上个月的今天:"+sdf.format(c.getTime()));
		
		//去年的今天
		c.setTime(now);
		c.add(Calendar.YEAR, -1);
		System.out.println("去年年的今天:"+sdf.format(c.getTime()));
		
		//明年的今天
		c.setTime(now);
		c.add(Calendar.YEAR, 1);
		System.out.println("明年的今天:"+sdf.format(c.getTime()));
		
		//上个月的第三天
		c.setTime(now);
		c.add(Calendar.MONTH, -1);
		c.set(Calendar.DATE, 3);
		System.out.println("上个月的第三天:"+sdf.format(c.getTime()));
		
//		c.set(field, value);
//		c.set(year, month, date);
//		c.set(year, month, date, hourOfDay, minute);
//		c.set(year, month, date, hourOfDay, minute, second);

		
		//为指定的日历字段设置给定值
		c.setTime(now);
		c.set(Calendar.YEAR, 2022);
		System.out.println(sdf.format(c.getTime()));
		
		//任意设置一个日期
		c.setTime(now);
		c.set(2019, 9, 15, 16, 40, 30);
		System.out.println(sdf.format(c.getTime()));
		

		
		
		
		
	}
	
	/**
	 * @describe 翻日历:修改
	 * @author ks0pc23-PC 
	 * @date 2019年9月10日 下午4:27:57
	 * @return void
	 * @throws Exception
	 */
	//设置时间格式
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	private static String formatDate(Date time){
		return sdf.format(time);
	} 
	
	@Test
	public void CalendarTest2(){
		Calendar c = Calendar.getInstance();
		Date now = new Date();
		//当前日期
		System.out.println("当前日期:"+formatDate(c.getTime()));
		
		//void add(int field, int amount)
		//根据日历的规则，为给定的日历字段 field 添加或减去指定的时间量 amount
		
		//下个月的今天
		c.setTime(now);
		c.add(Calendar.MONTH, 1);
		System.out.println("下个月的今天:"+formatDate(c.getTime()));
			
		//上个月的今天
		c.setTime(now);
		c.add(Calendar.MONTH, -1);
		System.out.println("上个月的今天:"+formatDate(c.getTime()));
		
		//去年的今天
		c.setTime(now);
		c.add(Calendar.YEAR, -1);
		System.out.println("去年的今天:"+formatDate(c.getTime()));
		
		//明年的今天
		c.setTime(now);
		c.add(Calendar.YEAR, 1);
		System.out.println("明年的今天:"+formatDate(c.getTime()));
		
		//上个月的第三天
		c.setTime(now);
		c.add(Calendar.MONTH, -1);
		c.set(Calendar.DATE, 3);
		System.out.println("上个月的第三天:"+formatDate(c.getTime()));
		
		//任意设置一个日期
		c.setTime(now);
		c.set(2019, 9, 15, 16, 40, 30);
		System.out.println(formatDate(c.getTime()));
	}
	
	
	//找出下个月的倒数第3天是哪天
	@Test
	public void CalendarTest3(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Calendar c = Calendar.getInstance();
		System.out.println("今天是："+sdf.format(c.getTime()));
		
		c.add(Calendar.MONTH, +2);
		c.set(Calendar.DATE, -3);
		System.out.println("下个月的倒数第3天是:"+sdf.format(c.getTime()));
		
	}
	
	
}

