/**
 * 
 */
package com.htc.statics;

import org.junit.Test;

/**  
* @ClassName Test
* @Description:
* @author htc  
* @date 2019年9月18日下午4:50:16 
*/
public class TestDemo {
	@Test
	public void testCar(){
		new Car("Hello","T6");
		new Car("TT", "V8");
		new Car("WW", "W8");
		// 对类变量（静态变量）和方法（静态方法）的访问可以直接使用 classname.variablename 和 classname.methodname 的方式访问
		System.out.println(Car.numberOfCars);
	}
	
	@Test
	public void testChinese(){
		Chinese cn = new Chinese();
		cn.country = "中国";
		cn.name = "tom";
		cn.age = 10;
		
		Chinese cn1 = new Chinese();
		cn1.country = "中国";
		cn1.name = "tony";
		cn1.age = 20;
		
		Chinese cn2 = new Chinese();
		cn2.country = "中国";
		cn2.name = "tony";
		cn2.age = 20;
		
		System.out.println(cn.country);
		System.out.println(cn1.country);
		System.out.println(cn2.country);
		
		// 有没有办法只写一次国籍，让所有对象都使用一个相同国籍 => static
		
	}
	
	@Test
	public void testChinese1(){
		Chinese.country = "中国";
		
		Chinese cn = new Chinese();
		cn.name = "tom";
		cn.age = 10;
		
		Chinese cn1 = new Chinese();
		cn1.name = "tony";
		cn1.age = 20;
		
		Chinese cn2 = new Chinese();
		cn2.name = "tony";
		cn2.age = 20;
		
		// static
		System.out.println(cn.country);
		System.out.println(cn1.country);
		System.out.println(cn2.country);
	}
	
	@Test
	public void testChinese2(){
		// 通过类名.属性 设置，访问的时候也是类名.属性去访问
		Chinese.country = "中国";
		
		Chinese cn = new Chinese();
		cn.name = "tom";
		cn.age = 10;
		
		Chinese cn1 = new Chinese();
		cn1.name = "tony";
		cn1.age = 20;
		
		Chinese cn2 = new Chinese();
		cn2.name = "tony";
		cn2.age = 20;
		
		// static 实际访问属性的时候也不会通过对象名.属性 => 通过类名.属性 直接访问
		System.out.println(Chinese.country);
		
	}
	
	@Test
	public void testChinese3(){
		// 类名.方法
		Chinese.test();
	}
	
	@Test
	public void testUtils(){
		String s = "hello";
		String s1 = "";
		String s2 = null;
		System.out.println(Utils.isEmpty(s)); // true 
		System.out.println(Utils.isEmpty(s1));// false
		System.out.println(Utils.isEmpty(s2));// false
	}
	
	// 需求：想知道new了多少个Chinse对象
	@Test
	public void testCount(){
		Chinese cn1 = new Chinese();
		System.out.println(Chinese.count); //1
		Chinese cn2 = new Chinese();
		System.out.println(Chinese.count); //2
		Chinese cn3 = new Chinese();
		System.out.println(Chinese.count); //3
		Chinese cn4 = new Chinese();
		System.out.println(Chinese.count); //4
		Chinese cn5 = new Chinese(); 
		System.out.println(Chinese.count); //5
		Chinese cn6 = new Chinese();
		System.out.println(Chinese.count); //6
		
		Chinese.showCount(); // 共new了6个对象！

		// 由此可以看出Chinese.count 这个类属性被所有实例化对象（cn1、cn2...）共享
		
	}
	
}
