/**
 * 
 */
package com.htc.string;

/**  
* @ClassName StringUtils
* @Description:字符串工具类 => 根据需要总结一些必须的方法
* 	注意：该工具类是用于操作Java.lang.String类的；
* @author htc  
* @date 2019年9月18日下午2:45:11 
*/
public class StringUtils {
	/**
	 * @describe 判断字符串是否为空
	 * @param str 字符串
	 * @return 是否为空
	 */
	public static boolean isEmpty(String str){
		return str == null || "".equals(str);
	}
	/**
	 * @describe 删除空格
	 * @param str 字符串
	 * @return String
	 */
	public static String trim(String str){
		return str == null ? null:str.trim();
	}
	
}
