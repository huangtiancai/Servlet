/**
 * 
 */
package com.htc.statics;

/**  
* @ClassName:Chinese
* @Description:
* @author:htc  
* @date:2019年11月20日 下午9:33:25
*/
public class Chinese {
	// 类变量-不用实例化，直接类名.属性名就可以使用，是类的一部分，被所有这个类的实例化对象所共享
	// 类变量也可以叫做静态变量
	static String country;
	
	public static int count; // 计数
	
	// 实例变量-只有实例化后才能访问，属于实例化对象的一部分，不能共用
	String name;
	int age;
	
	public static void test(){
		System.out.println("这是一个静态方法！");
	}
	
	// 无参构造
	public Chinese(){
//		System.out.println("this:"+this);
		Chinese.count += 1;
	}
	
	public static void showCount(){
		// static内部不能使用this
//		System.out.println("共new了"+ this.count + "个对象！");
		System.out.println("共new了"+ Chinese.count + "个对象！");
	}
	
	
}
