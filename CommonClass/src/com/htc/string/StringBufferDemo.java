/**
 * 
 */
package com.htc.string;

import org.junit.Test;

/**  
* @ClassName StringBufferDemo
* @Description:
* @author htc  
* @date 2019年9月18日下午2:40:38 
*/
public class StringBufferDemo {
	//追加 删除 插入 反转
	/**
	 * @describe 追加 删除 插入 反转
	 * append追加
	 * delete 删除
	 * insert 插入
	 * reverse 反转
	 * @param
	 */
	@Test
	public void testStringBuffer(){
		StringBuffer str = new StringBuffer("abc");
		System.out.println(str);//abc
		str.append("efg");
		//1.append:该方法的作用是追加内容到当前StringBuffer对象的末尾，类似于字符串的连接。调用该方法以后，StringBuffer对象的内容也发生改变
		System.out.println(str);//abcefg
		
		//使用该方法进行字符串的连接，将比String更加节约内容，例如应用于数据库SQL语句的连接
		StringBuffer sql = new StringBuffer();
		String username = "admin";
		String password = "123";
		sql.append("select * from user where username = ").append(username).append(" and password = ").append(password);
		System.out.println(sql);
		
		//2.delete：删除指定区间以内的所有字符，包含start，不包含end索引值的区间
		StringBuffer  str1 = new StringBuffer(str);
		str1.delete(1, 5);//左闭右开，不删除索引为5 的元素
		System.out.println(str1);//ag
		
		//3.deleteCharAt:删除指定位置的字符，然后将剩余的内容形成新的字符串
		StringBuffer str2 = new StringBuffer("hello");
		System.out.println(str2);//hello
		str2.deleteCharAt(1);
		System.out.println(str2);//hllo
		
		//4.insert:对象str3的索引值4的位置插入值，形成新的字符串，则执行以后对象str3的值是test方法insert
		StringBuffer str3 = new StringBuffer("testinsert");
		System.out.println(str3);//testinsert
		str3.insert(4, "方法");
		System.out.println(str3);//test方法insert
		
		//5.reverse:将StringBuffer对象中的内容反转，然后形成新的字符串
		StringBuffer str4 = new StringBuffer("test");
		str4.reverse();
		System.out.println(str4);//tset
	}
	
	/**
	 * @describe 长度 容量
	 * 和String内部是一个字符数组一样，StringBuffer也维护了一个字符数组。 但是，这个字符数组，留有冗余长度
	 * =>比如说new StringBuffer("the")，其内部的字符数组的长度，是19(3+16)，而不是3，这样调用插入和追加，在现成的数组的基础上就可以完成了。
	 * @param
	 */
	@Test
	public void testStringBuffer1(){
		String str = "the";
		System.out.println(str.length());//3
		
		StringBuffer sb = new StringBuffer(str);
		System.out.println(sb.length());//3
		System.out.println(sb.capacity());//9
	}
	
}
