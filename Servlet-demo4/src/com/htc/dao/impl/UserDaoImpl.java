/**
 * 
 */
package com.htc.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

import com.htc.bean.User;
import com.htc.dao.UserDao;

/**  
* @ClassName UserDaoImpl实现类
* @Description:数据层
* @author htc  
* @date 2019年6月28日下午2:25:37 
*/
public class UserDaoImpl extends BaseDaoImpl implements UserDao{

	@Override
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
