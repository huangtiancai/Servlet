/**
 * 
 */
package com.htc.finals;

/**  
* @ClassName FinalA
* @Description:
* @author htc  
* @date 2019年11月21日上午11:20:46 
*/
public class FinalA extends FinalB{
	public final int i = 0;
	public final int count = 0;

	public String getHello(){
		return "hello";
	}
	
	public static void main(String[] args) {
		System.out.println("main方法");
		// 静态变量  普通变量
		String a = "hello world";	  // a
		
		final String b = "hello"; // b+"world"=d == a true
		String c = "hello";		  // c+"world"=e == a false
		
		// 由于变量b被final修饰，因此会被当做编译器常量，所以在使用到b的地方会直接将变量b 替换为它的值。
		// 而对于变量c的访问却需要在运行时通过链接来进行=>String字符串常量池
		
		String d = b + " world";
		String e = c + " world";
		
		System.out.println(a); // hello world
		
		System.out.println(b); // hello
		System.out.println(c); // hello
		
		System.out.println(d); // hello world
		System.out.println(e); // hello world
		
		System.out.println(a==d); // true   fianl所修饰的字符串b在编译器就确定了值
		System.out.println(a==e); // false
		System.out.println(d==e); // false
		
		String f = new FinalA().getHello() + " world";
		System.out.println(f); 	  // hello world
		System.out.println(a==f); //false,因为方法在运行期才能确定返回值
		
	}
	
	
	// 属于子类本身的方法，编译正常
	public void getName(){
		System.out.println("这是子类的方法！");
	}
	
	// 重写了父类的final方法,编译出错
//	public void getAge(){
//		System.out.println("这是父类的方法！");
//	}
	
	
}
