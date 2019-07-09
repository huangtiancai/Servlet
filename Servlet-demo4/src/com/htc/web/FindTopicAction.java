package com.htc.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.htc.bean.Board;
import com.htc.service.BoardService;
import com.htc.service.impl.BoardServiceImpl;

public class FindTopicAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("进入FindTopicAction");
//		List<String> list = new ArrayList<String>();
//		list.add("小明");
//		list.add("小红");
//		list.add("小黄");
//		list.add("小黑");
//		Gson gson = new Gson();
//		String json = gson.toJson(list);
//		response.setContentType("text/html;charset=UTF-8");
//		response.getWriter().write(json);
		
		String boardId = request.getParameter("boardId");
		System.out.println(boardId);
		//根据boardId查询boardIdName
		BoardService bs = new BoardServiceImpl();
		
		Board board = bs.findboardNamebyboardId(boardId);
		String boardIdName = board.getBoardName();
		
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(boardIdName);
		
	}

}
