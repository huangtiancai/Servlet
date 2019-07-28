package com.htc.web;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.htc.bean.User;
import com.htc.service.UserService;

public class UserServlet extends BaseServlet {
	//注册
	public String regist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
		//声明User对象 收集用户注册的数据
		User user=new User();
		
		//在解析文件之前 先判断请求类型是否为文件上传类型
		boolean isMultipart=ServletFileUpload.isMultipartContent(request);
		
		String uploadFilePath="";
		
		if(isMultipart){
			//指定上传文件的路径
			uploadFilePath=request.getSession().getServletContext().getRealPath("/upload");
			//如果目录不存在 创建一个新的目录
			File saveDir=new File(uploadFilePath);
			//判断是否存在
			if(!saveDir.exists()){
				saveDir.mkdir();
			}
		}
		
		//创建一个文件工厂
		FileItemFactory factory=new DiskFileItemFactory();
		//创建解析器
		ServletFileUpload upload=new ServletFileUpload(factory);
		
		//指定上传文件的大小  字节    1024字节=1KB  
		//upload.setFileSizeMax(1024);//限制单个文件大小为1KB
	
		//指定提交表单的大小  字节
		//upload.setSizeMax(1024);
		
		
		try {
			//通过解析器  解析上传的表单   把每一个表单项放在FileItem对象中
			List<FileItem> items=upload.parseRequest(request);
			//迭代器
			Iterator<FileItem> iter=items.iterator();
			//循环取每一个表单项
			while(iter.hasNext()){
				FileItem item=iter.next();
				//如果是普通表单
				if(item.isFormField()){
					//获得name属性值
					String fieldName=item.getFieldName();
					if(fieldName.equals("username")){
						String name=item.getString("utf-8");
						user.setName(name);
					}else if(fieldName.equals("pwd")){
						String pwd=item.getString("utf-8");
						user.setPassword(pwd);
					}
				}else{
					//上传的表单项
					//获取文件的名字
					String fileName=item.getName();
					
					//根据获取的上传文件名判断用户是真的上传了
					if(fileName!=null&&!fileName.equals("")){
						
                        //c:\ccc\ccc\佩奇.png
						int index=fileName.lastIndexOf("\\");
						if(index!=-1){
							fileName=fileName.substring(index+1);
						}
						
						System.out.println("fileName:"+fileName);
						//为对象赋值
						user.setImg(fileName);
						
						//指定文件的保存路径
						File saveFile=new File(uploadFilePath,fileName);
						System.out.println("文件的保存路径:"+saveFile);
						
						try {
							//上传
							item.write(saveFile);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				}
			}
			
			
			
		} catch (Exception e) {
			if(e instanceof FileUploadBase.FileSizeLimitExceededException){
				request.setAttribute("uploadMessage", "你上传的文件过大!开通会员了解一下");
				return "z:/index.jsp";
			}else if(e instanceof FileUploadBase.SizeLimitExceededException){
				request.setAttribute("uploadMessage", "你提交的表单过大!开通超级会员了解一下");
				return "z:/index.jsp";
			}
			
		}
		
		//调用service模型方法进行注册
		UserService us=new UserService();
		if(us.regist(user)>0){
			return "c:/login.jsp";
		}

		return null;
	}
	
	
	
	//登录
	public String login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		//获取登录的参数
		String username=request.getParameter("username");
		String pwd=request.getParameter("pwd");
		
		//调用模型方法进行登录
		UserService us=new UserService();
		
		//返回登录的用户对象
		User user=us.login(new User(null, username, pwd, null));
		
		if(user!=null){
			//登录成功
			HttpSession session=request.getSession();
			session.setAttribute("user", user);
			return "c:/welcome.jsp";
		}else{
			//登录失败
			request.setAttribute("loginMessage", "用户名或密码错误");
			return "z:/login.jsp";
		}
	}
	
	
	
}
