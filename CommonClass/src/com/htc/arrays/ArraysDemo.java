/**
 * 
 */
package com.htc.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**  
* @ClassName ArraysDemo
* @Description:java.util.Arrays类是 JDK 提供的一个工具类，用来处理数组的各种方法，而且每个方法基本上都是静态方法，能直接通过类名Arrays调用
* @author htc  
* @date 2019年9月12日下午3:09:57 
*/
public class ArraysDemo {
	/**
	 * @describe 数组转集合:Arrays.asList
	 * @param 
	 * @return void
	 */
	@Test
	public void testArray(){
		int n = 5;
		String[] name = new String[n];
		
		//为数组赋值
		for(int i = 0;i<name.length;i++){
			//将 int 变量 i 转换成字符串 => 赋值给数组的每个元素
			name[i] = String.valueOf(i);
		}
		System.out.println(name);//[Ljava.lang.String;@198a09e
		
		List<String> list = Arrays.asList(name);
		System.out.println(list);//[0, 1, 2, 3, 4]
		
		for(String li:list){
			System.out.print(li + " ");//0 1 2 3 4 
		}	
	}
	
	/**
	 * @describe 集合转数组
	 * @param 
	 * @return void
	 */
	@Test
	public void testArray1(){
		List<String> list = new ArrayList<String>();	
		list.add("H");
		list.add("e");
		list.add("l");
		list.add("l");
		list.add("o");
		System.out.println(list);//[H, e, l, l, o]
		
		String[] str = list.toArray(new String[0]);
		System.out.println(str);//[Ljava.lang.String;@198a09e
		
		//数组遍历
		for(int i = 0;i<str.length;i++){
			System.out.print(str[i] + " ");//H e l l o 
		}
	}
	
	
	/**
	 * @describe 数组转换为字符串:用来返回指定数组元素内容的字符串形式
	 * 需要注意的是，该方法并不是对 Object 类 toString() 方法的重写，只是用于返回指定数组的字符串形式。
	 * @param 
	 * @return void
	 */
	@Test
	public void testArray2(){
		int[] arr = {1,4,3,2,5};
		System.out.println(arr);//[I@158ef1f
		
		String str = Arrays.toString(arr);
		System.out.println(str);//[1, 4, 3, 2, 5]
	}
	
	//写一个打印数组的方法
	public void printArray(int[] arr){
		System.out.println(Arrays.toString(arr));
	}
	
	/**
	 * @describe 排序:sort
	 * @param 
	 * @return void
	 */
	@Test
	public void testSortArray(){
		int[] arr = {1,4,3,2,5};
		
		//打印数组
		printArray(arr);
		
		//排序
		Arrays.sort(arr);
		
		//再次打印数组
		printArray(arr);	
	}
	
	/**
	 * @describe 查找元素:binarySearch
	 * 注意：
	 * 	1.调用binarySearch()方法前要先调用sort方法对数组进行排序，否则得出的返回值不定，这时二分搜索算法决定的。
	 *  2.binarySearch()方法的返回值为：
	 *  	1)如果找到关键字，则返回值为关键字在数组中的位置索引，且索引从0开始
	 *  	2)如果没有找到关键字，返回值为负的插入点值，所谓插入点值就是第一个比关键字大的元素在数组中的位置索引，而且这个位置索引从1开始。
	 * @param 
	 * @return void
	 */
	@Test
	public void testfindArray(){
		int[] arr = {4,25,10,95,06,21};
		
		//打印数组
		printArray(arr);
		
		//排序
		Arrays.sort(arr);
		
		//再次打印数组
		printArray(arr);//[4, 6, 10, 21, 25, 95]
		
		//查找元素的索引位置
		int index = Arrays.binarySearch(arr, 2);
		System.out.println("关键字2的返回值为："+index);
		
		index = Arrays.binarySearch(arr, 20);
		System.out.println("关键字2的返回值为："+index);
		
		index = Arrays.binarySearch(arr, 30);
		System.out.println("关键字2的返回值为："+index);
		
		index = Arrays.binarySearch(arr, 100);
		System.out.println("关键字2的返回值为："+index);
		
		index = Arrays.binarySearch(arr, 10);
		System.out.println("关键字2的返回值为："+index);
		
		
		//关键字2并没有在数组中，而且2比数组中的任何一个元素都小，所以其插入点的值应为元素4的位置也就是1(没有找到关键字从1开始）
		//关键字20也不在数组中，数组中第一个比20大的数是21，所以20的插入点值为4（没用找到关键字从索引从1开始）
		//关键字100也不在数组中，而且100比数组中所有的元素都大，此时插入点值为length+1 为7（没有找到关键字索引从1开始）
		//关键字10在数组中，所以返回其在数组中的索引为2（找到关键字索引从0开始）
		
		//之所以计算插入点值时索引要从1开始算，是因为-0=0，如果从0开始算，那么上面例子中关键字2和关键字4的返回值就一样了
	}
	
	/**
	 * @describe 拷贝元素:
	 * 			1.arraycopy
	 * 			2.copyOf
	 *			3.copyOfRange
	 *  
	 *  拷贝数组元素。底层采用 System.arraycopy() 实现，这是一个native方法。
	 * @param 
	 * @return void
	 */
	@Test
	public void testCopyArray(){
		
//		1.arraycopy()方法
//		函数原型：arraycopy（Object src, int srcPos, Object dest, int destPos, int length）
//		src: 原数组                                               
//		srcPos:原数组起始的位置
//		dest:目的数组                                         
//		destPos:目的数组的起始位置
		
//		注意：src 和 dest都必须是同类型或者可以进行转换类型的数组 => 要重新声明一个同类型且长度足够的数组，否则会出现异常
		
		int[] a = {1,4,3,2,5};
		//打印数组
		printArray(a);//[1, 4, 3, 2, 5]
		
		int[] b = new int[5];//注意数组的长度
		
		System.arraycopy(a, 0, b, 0, 5);
		//System.arraycopy(a ,0 ,b ,0 ,5)这句话可以翻译为：把数组a从下标为0的位置依次开始复制到数组b下标为0的位置，复制长度为5
		
		System.out.println(Arrays.toString(b));//[1, 4, 3, 2, 5]
		
		//2.copyOf
		//函数原型：copyOf(oringinal, int newlength)
		//oringinal:原数组      newlength:复制数组的长度
		//这个方法是从原数组的起始位置开始复制，复制的长度是newlength。相比较于前一种，这种相当于特殊的情况，只能从原数组的起始位置开始复制
		int[] a1 = {1,4,3,2,5};
		int[] b1 = new int[5];
		b1 = Arrays.copyOf(a1, 5);
		System.out.println(Arrays.toString(b1));
		
		
		//3.copyOfRange()方法
		//函数原型：copyOfRange(oringinal,int from, int to)
		//该方法是从original数组的下标from开始复制，到下标to结束
//		参数 original 表示被复制的数组
//		参数 from 表示被复制元素的初始索引（包括）
//		参数 to 表示被复制元素的最后索引（不包括）
		
		//拷贝
		int[] copied = Arrays.copyOfRange(a, 1, 3);
		printArray(copied);
	}
	
	
	/**
	 * @describe 填充元素:fill => 该系列方法用于给数组赋值，并能指定某个范围赋值
	 * 经常需要用一个值替换数组中的所有元素，使用 Array 的 fill(Object[] a, Object val) 方法，
	 * 该方法可以将指定的值赋给数组中的每一个元素。
	 * @param 
	 * @return void
	 */
	@Test
	public void testfillArray(){
		int[] arr = {1,4,3,2,5};
		
		//打印数组
		printArray(arr);
		
		//填充
		Arrays.fill(arr, 6);
		
		//再次打印数组
		printArray(arr);	
	}
	
	/**
	 * @describe 
	 * 			equals 用来比较两个数组中对应位置的每个元素是否相等
	 * 			deepEquals 能够进行比较多维数组，而且是任意层次的嵌套数组
	 * @param 
	 * @return void
	 */
	@Test
	public void testequalsArray(){
		int[] arr1 = {1,4,3,2,5};
		int[] arr2 = {1,4,3,2,5};
		int[] arr3 = {1,4,3,1,5};
		
		int[][] ar1 = {{1,2,3},{2,34,5},{5,3,7}};
		int[][] ar2 = {{1,2,3},{2,34,5},{5,3,7}};
		int[][] ar3 = {{1,4,3},{2,34,5},{5,3,7}};
		
		System.out.println(Arrays.equals(arr1, arr2));//true
		System.out.println(Arrays.equals(arr1, arr3));//false
		
		System.out.println(Arrays.deepEquals(ar1, ar2));//true
		System.out.println(Arrays.deepEquals(ar1, ar3));//false
	}
	
	
}
