/**
 * 
 */
package com.htc.array;

/**  
* @ClassName JDK
* @Description:
* @author htc  
* @date 2019年12月23日下午3:19:08 
*/
public class JDK {
	// 更换JDK，获取JDK相关信息
	public static void main(String[] args) {
	
		// 获取jdk的版本号
			
		// 获取jdk详细版本号，例如：1.8.0_231、1.8.0_65、1.7.0_79
		System.out.println(System.getProperty("java.version")); // 1.8.0_231
		// 获取jdk的标准版本，例如：1.8、1.7
		System.out.println(System.getProperty("java.specification.version"));
		
		// 获取jdk的位数
		
		// 64位JDK：amd64 ，32位JDK：x86
		System.out.println(System.getProperty("os.arch"));//amd64
		// 64位JDK：64 ，32位JDK：32
		System.out.println(System.getProperty("sun.arch.data.model"));//64
		
		
		// 1.8.0_231  amd64		64
		// 1.8.0_65   x86		32
		
	}
}
