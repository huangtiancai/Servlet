/**
 * 
 */
package com.htc.statics;

import org.junit.Test;

/**  
* @ClassName Car
* @Description:
* @author htc  
* @date 2019年9月18日下午4:38:55 
*/
public class Car {
	private String name;
	private String engine;
	
	public static int numberOfCars;
	
	public Car(String name,String engine){
		this.name = name;
		this.engine = engine;
		numberOfCars++;
	}
	

}
