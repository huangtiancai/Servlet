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
}
