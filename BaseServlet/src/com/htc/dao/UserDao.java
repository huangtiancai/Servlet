package com.htc.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.htc.bean.User;
import com.htc.utils.JDBCUtils;


public class UserDao {
	//注册  增加
	public int saveUser(User user) throws SQLException{
		//工具类
		QueryRunner qr=new QueryRunner();
		//获得链接
		Connection conn=JDBCUtils.getConnection();
		
		
		String sql="insert into user values(null,?,?,?)";
		Object [] params={user.getName(),user.getPassword(),user.getImg()};
		
		
		//调用工具类中的方法进行更新
		int row=qr.update(conn,sql, params);
		//关闭连接
		JDBCUtils.closeConnection(conn);
		
		return row;
	}
	
	//登录  查询
	public User selectUserOne(User user) throws SQLException{
		//工具类
		QueryRunner qr=new QueryRunner();
		//获得链接
		Connection conn=JDBCUtils.getConnection();
		
		
		String sql="select * from User where name=? and password=?";
		Object [] params={user.getName(),user.getPassword()};
		
		
		//调用工具类中的方法进行更新
		User st=qr.query(conn,sql, new BeanHandler<User>(User.class), params);
		//关闭连接
		JDBCUtils.closeConnection(conn);
		
		return st;
	}
	
	
	
}
