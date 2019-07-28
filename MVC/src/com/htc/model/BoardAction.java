package com.htc.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardAction implements IModel{
	public String findBoard(HttpServletRequest request,HttpServletResponse response)
	{
		return "/pages/login.jsp";
	}
}
