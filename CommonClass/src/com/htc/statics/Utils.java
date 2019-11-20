package com.htc.statics;

/**  
* @ClassName:Utils
* @Description:判断字符串是否是一个空字符串
*/
public class Utils {
	public static boolean isEmpty(String s){
		boolean flag = false;
		if(s!=null && !s.equals("")){
			flag = true;
		}
		return flag;
	}
}
