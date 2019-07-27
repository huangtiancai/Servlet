package com.htc.service;


import java.sql.SQLException;

import com.htc.bean.User;
import com.htc.dao.UserDao;
import com.htc.utils.JDBCUtils;

public class UserService {
	UserDao sd=new UserDao();

	//登录
	public User login(User user){
	    	//调用dao层方法
	    	try {
				return sd.selectUserOne(user);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
	}
	

	
	//注册
	public int regist(User user){
		int row=0;
	     try{
	    	//开启事务
	    	JDBCUtils.beginTransaction();
	    	
	    	//调用dao层方法
	    	row= sd.saveUser(user);
		   
		    //提交事务
		    JDBCUtils.commitTransaction();
		}catch(Exception e){
			e.printStackTrace();
			//回滚事务
			try {
				JDBCUtils.rollbackTransaction();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		return row;
	
	}

}
