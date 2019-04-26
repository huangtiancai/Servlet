package com.htc.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserAgent1 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("«Î«Û∑Ω∑®£∫"+request.getMethod());
		System.out.println("URL£∫"+request.getRequestURL());
		System.out.println("URI£∫"+request.getRequestURI());
		System.out.println("CharacterEncoding£∫"+request.getCharacterEncoding());
		System.out.println("ContentLength£∫"+request.getContentLength());
		System.out.println("ContentType£∫"+request.getContentType());
		System.out.println("ContextPath£∫"+request.getContextPath());
		System.out.println("DateHeader£∫"+request.getDateHeader(getServletName()));
		System.out.println("DateHeader£∫"+request.getDateHeader(getServletInfo()));
		System.out.println("Header£∫"+request.getHeader(getServletName()));
		System.out.println("Header£∫"+request.getHeader(getServletInfo()));
		System.out.println("LocalAddr£∫"+request.getLocalAddr());
		System.out.println("LocalName£∫"+request.getLocalName());
		System.out.println("LocalPort£∫"+request.getLocalPort());
		System.out.println("RemoteAddr£∫"+request.getRemoteAddr());
		System.out.println("RemoteHost£∫"+request.getRemoteHost());
		System.out.println("RemotePort£∫"+request.getRemotePort());
		System.out.println("RemoteUser£∫"+request.getRemoteUser());
		System.out.println("ServerName£∫"+request.getServerName());
		System.out.println("ServerPort£∫"+request.getServerPort());
		System.out.println("ServletPath£∫"+request.getServletPath());
		System.out.println("hashCode£∫"+request.hashCode());
		System.out.println("toString£∫"+request.toString());
		System.out.println("Cookies£∫"+request.getCookies());
		System.out.println("HeaderNames£∫"+request.getHeaderNames());
		System.out.println("Headers£∫"+request.getHeaders(getServletName()));
		System.out.println("Locale£∫"+request.getLocale());
		System.out.println("Locales£∫"+request.getLocales());
		System.out.println("ServletContext£∫"+request.getServletContext());
		System.out.println("Session£∫"+request.getSession());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
