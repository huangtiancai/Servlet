package com.htc.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.htc.model.IModel;
import com.htc.utils.MapUtils;


/**
 * Servlet implementation class CoreController
 */
public class CoreController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("进入核心控制器！");
		
		//获取用户请求的方法
		String methodName = request.getParameter("method");
		System.out.println("method:"+methodName);

		String uri = request.getRequestURI();
		System.out.println("uri:"+uri);//uri:/MVC/user.action
		
		StringBuffer requestURL = request.getRequestURL();	
		System.out.println("请求的url:"+requestURL);
		
		
		
		//需要知道用户请求的模型地址 如：通过user.action-->UserAction
		String[] arrURI = uri.split("/");
		String action = arrURI[arrURI.length-1];
		System.out.println(action);//user.action
		
		//根据请求字符串，获取模型对象
		IModel model = MapUtils.getAction(action);
		System.out.println("model:"+model);
		
		
		//调用method方法，反射实现
		Class clazz = model.getClass();//BoardAction/UserAction
		System.out.println("clazz:"+clazz);
		//该方法的参数列表
		try {
			Method m = clazz.getDeclaredMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			//对象
			Object result  = m.invoke(model, request,response);
			System.out.println("result:"+result);
			
			if(result==null)
			{
				//不经过核心控制跳转
				return;
			}
			
			String url = result.toString();
			System.out.println("url:"+url);
			
			//判断跳转的方式：如果有:则判断前面是不是redirect---response跳转，其他所有情况都是服务器端跳转
			if(url.indexOf(":")!=-1)//    redirect:main.jsp
			{
				String flag = url.split(":")[0];
				url = url.split(":")[1];
				
				if(flag.equals("redirect"))
				{
					response.sendRedirect(request.getContextPath()+"/"+url);
					return;
				}
			}
			
			request.getRequestDispatcher("/"+url).forward(request, response);
			
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
