/**
 * 
 */
package com.htc.service;

import com.htc.bean.User;
import com.htc.dao.UserDao;

/**  
* @ClassName UserService
* @Description:
* @author htc  
* @date 2019年6月6日下午4:47:44 
*/
public class UserService {
	private UserDao userDao = new UserDao();
	
	public User login(User user){
		return userDao.login(user);	
	}
}
