/**
 * 
 */
package com.htc.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

import com.htc.bean.User;
import com.htc.utils.C3P0Utils;

/**  
* @ClassName UserDao
* @Description:数据层
* @author htc  
* @date 2019年6月6日下午4:48:27 
*/
public class UserDao {
	/*
	 * 测试使用C3P0UtilsL连接数据库是否连接成功
	 */
	@Test
	public void TestConnection() throws SQLException{
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		Connection conn  = C3P0Utils.getConnection();
		System.out.println(queryRunner);
		System.out.println(conn);
	}
	

	private QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());

	public User login(User user){
		String sql = "select * from user where username = ? and password = ?";
		try {
			return queryRunner.query(sql, new BeanHandler<User>(User.class),user.getUsername(),user.getPassword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("用户登陆失败!");
		}
		
	}
	
	
	
	
}
