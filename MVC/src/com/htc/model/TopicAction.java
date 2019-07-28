package com.htc.model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.htc.bean.Topic;
import com.htc.service.TopicService;

public class TopicAction implements IModel{
	//ajax
	public void getJson1(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException  {
		//业务逻辑
		//获取参数
		String keyword = request.getParameter("keyword");
		//System.out.println(new String();
		keyword = new String(keyword.getBytes("ISO-8859-1"),"UTF-8");
		
		System.out.println(keyword);
		TopicService service = new TopicService();
		try {
			List<Topic> list = service.findTopicByKeyWord(keyword);
			System.out.println(list.size());
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
			
			String json = gson.toJson(list);
			System.out.println(json);
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().write(json);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//ajax
	public String  getJson2(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException  {
		//业务逻辑
		//获取参数
		String keyword = request.getParameter("keyword");
		//System.out.println(new String();
		keyword = new String(keyword.getBytes("ISO-8859-1"),"UTF-8");
		
		System.out.println(keyword);
		TopicService service = new TopicService();
		try {
			List<Topic> list = service.findTopicByKeyWord(keyword);
			//System.out.println(list.size());
			
			request.setAttribute("topicList", list);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "ajax/showTopics.jsp";
		
	}
}
