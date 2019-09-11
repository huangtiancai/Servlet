/**
 * 
 */
package com.htc.system;

import java.util.Arrays;
import java.util.Properties;

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

		System.out.println("out-标准输出流。 ");
		//System.err.println("err-标准错误输出流。");
		
		//static long currentTimeMillis()  返回以毫秒为单位的当前时间
		long time = System.currentTimeMillis();
		System.out.println(time);//1568183039057-毫秒数-long型	
	}
	
	//验证for循环打印数字1-9999所需要使用的时间（毫秒）
	@Test
	public void testSystem1(){
		long start = System.currentTimeMillis();
		
		//循环打印
		for(int i = 0; i<10000;i++){
			System.err.println(i);
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println("打印共耗时"+(end-start)+"毫秒！");
	}
	
	
	//public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
	//将指定源数组中的数组从指定位置复制到目标数组的指定位置
//	参数序号	参数名称	参数类型	参数含义
//	1		src		Object	源数组
//	2		srcPos	int		源数组索引起始位置
//	3		dest	Object	目标数组
//	4		destPos	int		目标数组索引起始位置
//	5		length	int		复制元素个数
	
	
	//将src数组中前3个元素，复制到dest数组的前3个位置上复制元素前
	
	@Test
	public void systemArrayCopy(){
		int[] src = new int[]{1,2,3,4,5};
		int[] dest = new int[]{6,7,8,9,10};
		System.arraycopy(src, 0, dest, 0, 3);
		
		System.out.println(src);
		System.out.println(dest);
		
		for(int a:src){
			System.out.println(a);
		}
		
		//Arrays类中的toString方法
		System.out.println(Arrays.toString(src));//[1, 2, 3, 4, 5]
		System.out.println(Arrays.toString(dest));//[1, 2, 3, 9, 10]

	}
	
	//static Properties getProperties() -  确定当前的系统属性
	//static String getProperty(String key) - 获取指定键指示的系统属性
	@Test
	public void testSystem3(){

		Properties properties = System.getProperties();
		
		System.out.println("java的运行环境版本:"+properties.getProperty("java.version"));
		System.out.println("java的安装目录:"+properties.getProperty("java.home"));
		System.out.println("Java 虚拟机实现版本:"+properties.getProperty("java.vm.version"));
		System.out.println("java的类路径:"+properties.getProperty("java.class.path"));
		
		System.out.println("操作系统的名称:"+properties.getProperty("os.name"));
		System.out.println("操作系统的架构:"+properties.getProperty("os.arch"));
		System.out.println("操作系统的版本:"+properties.getProperty("os.version"));
		System.out.println("文件分隔符："+properties.getProperty("file.separator"));  //在 unix 系统中是"/"
		System.out.println("路径分隔符："+properties.getProperty("path.separator"));  //在 unix 系统中是":"
		System.out.println("行分隔符："+properties.getProperty("line.separator"));   //在 unix 系统中是"/n"
		System.out.println("用户的账户名："+properties.getProperty("user.name"));	
		System.out.println("用户的主目录："+properties.getProperty("user.home"));
	    System.out.println("用户的当前工作目录："+properties.getProperty("user.dir"));
		
		
//		for(Object obj:properties.keySet()){
//			System.out.println(obj);
////			System.out.println(properties.keySet());
////			System.out.println(properties.get(obj));
//		}
	}
	
	//static void exit(int status) - 终止当前运行的Java虚拟机 
	@Test
	public void testSystem4(){
		System.out.println("1");
		System.exit(1);
		System.out.println("2");;
	}
			
	
	
}
