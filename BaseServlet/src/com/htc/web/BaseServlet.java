package com.htc.web;


import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet {

	//通用的servlet方法
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//对于以后的所有方法同一的做请求响应乱码处理
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//获取用户请求的方法
		String methodName=request.getParameter("method");
		System.out.println("methodName:"+methodName);
		
		//判断方法名是否为空 ""    null
		if(methodName.trim().isEmpty()||methodName==null){  
			throw new RuntimeException("你没有传递method参数!无法确定你要调用的方法!");
		}
		
		//1.获取当前类的class对象
		Class c=this.getClass();
		
		//2.通过当前类的class对象的getMethod()方法查找是否存在对应方法
		Method method=null;
		try {
			method=c.getMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
			System.out.println("method:"+method);
		} catch (Exception e) {
			throw new RuntimeException("你要调用的方法!"+methodName+"不存在!");
		}
		
		
		//3. 通过反射动态的调用对应的方法
		try {
			//获取方法的返回值
			String result=(String)method.invoke(this, request,response);
			System.out.println("result:"+result);
			
			//判断是否有返回值   没有就什么都不做
			if(result==null||result.trim().isEmpty()){
				return ;
			}
			
			//查看返回值是否包含冒号,如果没有给用户抛异常
			//如果有,使用冒号进行分割  前半[转发或重定向的标识]与后半[跳转的地址]
			//做转发和重定向了
			if(result.contains(":")){
				//拆分
				
				//获取冒号的位置
				int index=result.indexOf(":");
				//获取冒号之前的
				String s=result.substring(0, index);
				System.out.println(s);
				//获取冒号之后的
				String path=result.substring(index+1);
				System.out.println(path);
				
				if(s.equalsIgnoreCase("c")){
					//重定向
					response.sendRedirect(request.getContextPath()+path);
				}else if(s.equalsIgnoreCase("z")){
					//转发
					request.getRequestDispatcher(path).forward(request, response);
				}else{
					throw new RuntimeException("你指定的操作"+s+"当前版本不支持!");
				}
				
			}else{
				//没有冒号
				throw new RuntimeException("你指定跳转的URL存在问题!");
				
			}
		} catch (Exception e) {
			throw new RuntimeException("你要调用的方法!"+methodName+"内部存在问题!");
		}
	}


	
}

