package com.htc.web;

import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

public class FileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//下载
		public void unload(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException{
			
			//获取下载的文件名
			String downFileName=request.getParameter("filename");
			
			//获取当前服务器的下载目录
			String unloadFilePath=request.getSession().getServletContext().getRealPath("/upload");
			
			
			//拼接下载地址
			String filename=unloadFilePath+"\\"+downFileName;
			
			//获取文件的类型
			String contentType=request.getSession().getServletContext().getMimeType(filename);
			
			//将文件名进行转码
			String framename=new String(downFileName.getBytes("GBK"),"ISO-8859-1");
			
			
			//指定下载类型 即下载的文件名
			String contentDisposition="attachment;filename="+framename;
			
			//设置2头
			response.setHeader("Content-Type",contentType);
			response.setHeader("Content-Disposition",contentDisposition);
			
			//设置流
			FileInputStream input=new FileInputStream(filename);
			
			//获取响应端的流
			ServletOutputStream output=response.getOutputStream();
			
			//把输入流中的数据写到输出流中   实现下载
			IOUtils.copy(input, output);
			
			//关闭流
			input.close();
			
		}
}
