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
 * 
* @ClassName UserDao接口
* @Description:
* @author htc  
* @date 2019年6月28日下午2:33:27
 */
public interface UserDao {
	User login(User user);
	User checkUser(String username);
}
