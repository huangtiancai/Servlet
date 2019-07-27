package com.htc.web;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

public class FileUploadServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	//上传
	public String upload(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		//java web文件上传
		
		//什么是文件上传?
		//要将客户端（浏览器）大数据存储到服务器端，不将数据直接存储到数据库中，而是要将数据存储到服务器所在的磁盘上，这要使用文件上传
		
		//为什么使用文件上传?
		//通过文件上传，可以将浏览器端的大数据直接保存到服务器端。
		//不将数据保存到数据库中，而是保存到服务器磁盘上，这样减少了数据库服务器的压力，对数据的操作更加灵活
		
		//文件上传原理分析
		//所谓的文件上传就是服务器端通过request对象获取输入流，	将浏览器端上传的数据读取出来，保存到服务器端。
		
		//上传文件注意事项
		//1.请求方式必须是post.
		//2.需要使用组件 <input type="file" name="f"> 组件必须有名称.
		//3.表单必须设置enctype="multipart/form-data"
		
		//服务器端处理
		//通过request对象，获取InputStream，可以将浏览器提交的所有数据读取到。
		
//		InputStream is  = request.getInputStream();
//		byte[] buffer =  new byte[1024];
//		int len = 0;
//		while((len =is.read(buffer)) !=-1){
//		    System.out.println(new String(buffer,0,len));
//		}
//		is.close();
		
		//fileupload 实现文件上传，接收用户上传的文件
		//fileupload 是什么?
		//fileupload是由apache的commons组件提供上传组件。它最主要的工作就是帮我们解析request.getnputStram().
		//导入commons-fileupload 相关 jar包
	    //* commons-fileupload.jar 核心包
	    //* commons-io.jar 依赖包
		
		//fileupload 核心类:DiskFileItemFactory ServletFileUpload  FileItem
		//DiskFileItemFactory:
		//1.设置缓存大小
		//factory.setSizeThreshold(1024*1024)   设置为1m默认是10k
		
		//ServletFileUpload:
		//1.parseRequest方法
		//得到所有的上传信息，将每一部分映射成FileItem对象
		//List<Fileitme> upload.pareRequest(request)
		
		//2.isMultipartContent 方法
		//boolean isMultipartContent(request)
		//这个方法返回值是boolean 它是用于判断当前表单是否是一个上传的表单，简单说就判断它的encType的值是否是mulipart/form-data。
		
		//3.setHeaderEncoding 方法
		//用于解决上传文件/表单 中文乱码问题
		
		//4.设置上传文件大小
		//设置单个文件上传大小
		//void setFileSizeMax(long fileSizeMax)
		//设置总文件上传大小
		//void setSizeMax()
		
		
		//FileItem
		//1.boolean isFormField() 判断当前表单字段是否为普通文本字段，如果返回false,说明是文件字段；
		//2.String getFieldName() 获取字段名称：<input type="text" name="username"> 是指username.
		//3.String getString("utf-8") 获取字段的内容，如果是文件字段，那么获取的文件内容，当然上传的文件必须是文本文件；
		//4.String getName():获取文件字段名称（xxx.png）
		//.....
		
		
		//使用步骤:
		//1.创建工厂类DiskFileItemFactory 对象：
		//DiskFileItemFactory factory = new DiskFileItemFactory();
		//2.使用工厂创建解析器对象
		//ServletFileUpload fileUpload = new ServletFileUpload(factory);
		//3.使用解析器来解析request对象
		//List<FileItem> list = fileUpload.parseRequest(request);
		
		
		//判断表单是否支持文件。即enctype="multipart/form-data"
		boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);
		
		if(!isMultipartContent){
			 throw new RuntimeException("your form is not multipart/form-data");
		}
		
		//创建工厂类DiskFileItemFactory 对象
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		//创建一个ServletFileUpload核心对象(创建解析器)
		ServletFileUpload fileUpload = new ServletFileUpload(factory);
		
		try {
			List<FileItem> fileItems = fileUpload.parseRequest(request);
			for(FileItem item:fileItems){
				if(item.isFormField()){////true 是普通字段 false 文件字段
					processFormField(item);
				}else{
					processUploadField(item);
				}
			}
			
			
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @describe 描述
	 * @author ks0pc23-PC 
	 * @date 2019年7月27日 下午6:28:36
	 * @param fileitem
	 * @return void
	 * @throws Exception
	 */
	private void processUploadField(FileItem fileitem) {
		//获得文件输入流
		try {
			InputStream is  = fileitem.getInputStream();
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @describe 描述
	 * @author ks0pc23-PC 
	 * @date 2019年7月27日 下午6:23:51
	 * @param item
	 * @return void
	 * @throws Exception
	 */
	private void processFormField(FileItem item) {
		// TODO Auto-generated method stub
		
	}




	
}
