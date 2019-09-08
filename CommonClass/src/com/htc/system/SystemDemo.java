/**
 * 
 */
package com.htc.system;

import org.junit.Test;

/**  
* @ClassName:System
* @Description:System类
* @author:htc  
* @date:2019年9月8日 上午10:48:34
*/
public class SystemDemo {
	
	@Test
	public void testSystem(){
		//返回以毫秒为单位的当前时间
		long time = System.currentTimeMillis();
		System.out.println(time);
	}
	
}
