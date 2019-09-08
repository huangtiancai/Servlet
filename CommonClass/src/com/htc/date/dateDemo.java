/**
 * 
 */
package com.htc.date;

import java.util.Date;

import org.junit.Test;

/**  
* @ClassName:dateDemo
* @Description:Date类
* @author:htc  
* @date:2019年9月8日 上午11:13:03
*/
public class dateDemo {
	/**
	 * 
	 * function: testDate
	 * Description:毫秒与日期间的相互转化
	 * return:void
	 */
	@Test
	public void testDate(){
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
		System.out.println(d3==d2);
		System.out.println(d3.equals(d2));
		
		
	}
	
	@Test
	public void testDate1(){
		Date d = new Date();
		long time = d.getTime();
		
		System.out.println(d);
		System.out.println(time);
		
		//将毫秒值转换为日期
		Date d2 = new Date(time);
		System.out.println(d==d2);
		System.out.println(d2);	
	}
}

