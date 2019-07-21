package com.htc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.htc.bean.Area;
import com.htc.bean.City;
import com.htc.bean.Province;
import com.htc.service.AreaService;
import com.htc.service.CityService;
import com.htc.service.ProvinceService;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class ServerInterface
 */
public class ServerInterface extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("进入ServerInterface!");
		//获取参数
//		String username = request.getParameter("username");
//		System.out.println("用户名："+username);
//		String city = request.getParameter("city");
//		System.out.println("城市："+city);
		
		//实例类型模型
		ProvinceService ps = new ProvinceService();
		CityService cs = new CityService();
		AreaService as = new AreaService();
		
		//获取全部类型
	    List<Province> lists = ps.selectAllProvince();
	    List<City> citys = cs.selectAllCity();
	    List<Area> areas = as.selectAllArea();
	    		
	    System.out.println(lists);//list集合
	    
		//JSONLIB:list集合-->json
	    JSONArray jsonStr = JSONArray.fromObject(lists);
	    JSONArray jsonStr1 = JSONArray.fromObject(citys);
	    JSONArray jsonStr2 = JSONArray.fromObject(areas);
	    
	    String jsonString = jsonStr.toString();
	    String jsonString1 = jsonStr1.toString();
	    String jsonString2 = jsonStr2.toString();
	    
	    System.out.println(jsonString);
	    System.out.println(jsonString1);
	    System.out.println(jsonString2);
		
		//1.js-ajax:前端使用 setRequestHeader() 来添加的 HTTP 头
		//xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		
		//2.若是jquery-ajax:前端不需要设置使用 setRequestHeader() 来添加 HTTP 头
		
		//后台获得请求体
		//String requestType = request.getContentType();
		//System.out.println("获得请求体:"+requestType);//application/x-www-form-urlencoded
		
		
		//通过response设置响应头(设置允许跨域-允许所有域名都可以访问，不够安全)
		response.setHeader("Access-Control-Allow-Origin", "*");
		//通过response设置响应体
		//设置响应的编码方式
		response.setContentType("text/html;charset=UTF-8");
		
		response.getWriter().write(jsonString);;
//		response.getWriter().write(jsonString1);
//		response.getWriter().write(jsonString2);
		
//		response.getWriter().write(result);
	}

}
