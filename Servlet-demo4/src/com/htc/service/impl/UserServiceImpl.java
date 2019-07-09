/**
 * 
 */
package com.htc.service.impl;

import com.htc.bean.User;
import com.htc.dao.UserDao;
import com.htc.dao.impl.UserDaoImpl;
import com.htc.service.UserService;


/**  
* @ClassName UserService
* @Description:
* @author htc  
* @date 2019年6月6日下午4:47:44 
*/
public class UserServiceImpl implements UserService{
	private UserDao userDao = new UserDaoImpl();

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return userDao.login(user);
	}


	@Override
	public User queryUser(String username) {
		// TODO Auto-generated method stub
		return userDao.checkUser(username);
	}
	
	
}
