package com.htc.web;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
//				InputStream is  = request.getInputStream();
//				byte[] buffer =  new byte[1024];
//				int len = 0;
//				while((len =is.read(buffer)) !=-1){
//				    System.out.println(new String(buffer,0,len));
//				}
//				is.close();
		
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
		
		//解决表单乱码
		fileUpload.setHeaderEncoding("UTF-8");
		
		
		//指定上传文件的大小  字节    1024字节=1KB 
		//fileUpload.setFileSizeMax(1024*1024*10);//单个文件不能超过3M
		//fileUpload.setSizeMax(1024*1024*100);////总上传文件不能超过100M
		
		
		
		fileUpload.setProgressListener(new ProgressListener() {
			
			@Override
			public void update(long pBytesRead, long pContentLength, int pItems) {
				if(pContentLength == -1){
					System.out.println("文件错误");
				}else{
					float percent = (float) (pBytesRead*1.0/pContentLength*100);
					int percents = (int) percent;
					System.out.println("已完成："+percents+"%");			 
				}				
			}
		});
		
		//int percents = (int) percent;
		//response.getWriter().write(percents);

		
		//解析request对象，并把表单中的每一个输入项包装成一个fileItem 对象，并返回一个保存了所有FileItem的list集合。
		try {
			List<FileItem> fileitems = fileUpload.parseRequest(request);
			for(FileItem item:fileitems){
				if(item.isFormField()){//true 是普通字段 false 文件字段
					processFormField(item);
				}else{
					processUploadField(item);
				}
			}	
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @describe 上传文件
	 * @author ks0pc23-PC 
	 * @date 2019年7月28日 下午2:16:37
	 * @param item
	 * @return void
	 * @throws Exception
	 */
	private void processUploadField(FileItem fileitem) {
		//得到文件输入流
		try {
			//InputStream is  = fileitem.getInputStream();
			
			//直接指定任意的保存文件的路径
			String path = "E:\\JavaWeb";
			//String path = "E:/upload";
			
			String uploadFilePath = path+File.separator+"upload";
			
			//如果目录不存在 创建一个新的目录
			File saveDir = new File(uploadFilePath);
			System.out.println("saveDir:"+saveDir);
			
			//判断是否存在
			if(!saveDir.exists()){
				System.out.println("----saveDir.exists-------");
				saveDir.mkdir();
			}
			
			
			//文件名称
			//获取文件的名字
			String fileName=fileitem.getName();
			
			//根据获取的上传文件名判断用户是真的上传了
			if(fileName!=null && !fileName.trim().equals("")){
				//lastIndexOf:返回指定字符在此字符串中最后一次出现处的索引
				// \ 在字符串中是转义符，会把 \ 之后的字符转换成另一个意思，如 \n 表示回车。那么要在字符串中出现一个 \ 字符就要写成 \\ ，意思是用前面的 \ 把后面的 \ 转换成正常的 \ 字符。 
				//如：c:\ccc\ccc\佩奇.png
				System.out.println("----------");
				int index = fileName.lastIndexOf("\\");
				if(index!=-1){
					fileName = fileName.substring(index+1);//包括起始索引，截取图片的文件名不包括\,所有应该是index+1
					System.out.println("fileName"+fileName);
				}
			}
			
			//解决重名问题
			fileName = UUID.randomUUID() + "_" + fileName;
			
			//指定文件的保存路径
			File saveFile = new File(uploadFilePath,fileName);
			System.out.println("文件的保存路径:"+saveFile);

			
			//上传
			try {
				fileitem.write(saveFile);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}






	/**
	 * @describe 非文件上传
	 * @author ks0pc23-PC 
	 * @date 2019年7月28日 下午2:15:50
	 * @param item
	 * @return void
	 * @throws Exception
	 */
	private void processFormField(FileItem item) {
		//处理普通表单项
	}






	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
