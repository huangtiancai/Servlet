/**
 * 
 */
package com.htc.finals;

import org.junit.Test;

/**  
* @ClassName Test
* @Description:
* @author htc  
* @date 2019年11月21日上午11:31:33 
*/
//junit包导入不了的原因：测试类命名为了Test了，写测试类的时候不能命名为Test
public class TestDemo {
	@Test
	public void test1(){
		FinalA f = new FinalA();
		f.getName();
	}
	
	// final修饰的是一个基本类型变量
	// final修饰的是一个引用类型
	@Test
	public void testFinal(){		
//		final修饰引用类型变量，该引用类型变量不能再指向其它对象,即所指向的地址值不能发生变化.但,该对象所包含的内容可以发生改变.
		final Person person = new Person(); // Syntax error on token ";", , expected
//		p = new Person(); // 编译错误,因为final修饰的引用类型变量,引用对象地址不可改变
//		可以更改属性的内容
		person.name = "this is Person's 属性值";
		System.out.println(person.name);
		
//		final修饰的是一个基本类型变量,，该基本类型变量不能再次被赋值.
//		person.count = 20; // The final field Person.count cannot be assigned(无法分配)
		System.out.println(person.count);
		
	}
	
	@Test
	public void testFinal1(){
		final StringBuffer s = new StringBuffer("hello");
		
//		s = new StringBuffer("");
//		The final local variable s cannot be assigned. It must be blank and not using a compound assignment
//		编译错误,因为final修饰的引用类型变量,引用对象地址不可改变
		
//		编译通过,final修饰的引用类型变量,所引用的对象的值可以改变
		s.append(" Final");
		// 调用updateFinal修改引用的对象的值
		updateFinal(s);
		System.out.println(s); // hello Final
		
		TestDemo td = new TestDemo();
		int i= 0;
		td.changeValue(i);
		System.out.println(i); // 0
		
	}
	
	 // 如果在定义方法参数时希望方法内部不能修改此参数的值,这样做是无效的,理由同上
	public static void updateFinal(final StringBuffer param) {
		param.append(" Test！"); // hello Final Test！
	}	
	
	// changeValue方法中的参数i用final修饰之后，就不能在方法中更改变量i的值了
	public void changeValue(final int i){
//		final参数不可改变
//		i ++;
	}
}
