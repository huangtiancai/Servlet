/**
 * 
 */
package com.htc.finals;

/**  
* @ClassName FinalA
* @Description:
* @author htc  
* @date 2019年11月21日上午11:20:46 
*/
public class FinalB {
	// 因为private修饰，子类中不能继承到此方法，因此，子类中的getName方法是重新定义的
	private final void getName(){
		System.out.println("这是父类的方法！");
	}
	
	//  因为pblic修饰，子类可以继承到此方法，导致重写了父类的final方法,编译出错
	public final void getAge(){
		System.out.println("这是父类的方法！");
	}
}
