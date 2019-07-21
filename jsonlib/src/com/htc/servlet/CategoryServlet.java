package com.htc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.htc.bean.Category;
import com.htc.service.CategoryService;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class CategoryServlet
 */
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//实例类型模型
		CategoryService cs = new CategoryService();
		//获取全部类型
		List<Category> lists = cs.selectAllCategory();
		System.out.println(lists);//list集合
		//JSONLIB:list集合-->json
		JSONArray jsonStr = JSONArray.fromObject(lists);
		System.out.println(jsonStr);
		//System.out.println(jsonStr.toString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
