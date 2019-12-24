/**
 * 
 */
package com.htc.commonlang3;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**  
* @ClassName StringUtilsTest
* @Description:apache-common-lang3 工具类 - StringUtils
* @author htc  
* @date 2019年12月24日下午3:00:48 
*/
public class StringUtilsTest {
	@Test
	public void testJoin(){
		// StringUtils.join()方法 - common-lang3
		List<String> list = new ArrayList<>();
		
		list.add("first");
		list.add("StringUtils");
		list.add("join");
		
		// 将String类型的list
		String join = StringUtils.join(list, "-");
		System.out.println(join); // first-StringUtils-join
		
		String[] str = {"join","Array"};
		String join2 = StringUtils.join(str,"-");
		System.out.println(join2); // join-Array	
	}
	
	@Test
	public void testJoin2(){
		// String.join()方法:String.join()是JDK8新增方法(无需引包）
		// 参数顺序不一样,String.join()尽可以传入实现charSequence接口类型的集合或数组
		List<String> list = new ArrayList<>();
		
		list.add("first");
		list.add("StringUtils");
		list.add("join");
		
		// 将String类型的list
		String join = String.join("-", list);
		System.out.println(join); // first-StringUtils-join
		
		String[] str = {"join","Array"};
		String join2 = String.join("-", str);
		System.out.println(join2); // join-Array	
	}
	
	
}
