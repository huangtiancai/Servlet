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
		new Car("TT", "V8");
		new Car("WW", "W8");
		System.out.println(Car.numberOfCars);
	}
}
