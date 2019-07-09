/**
 * 
 */
package com.htc.service;

import com.htc.bean.User;

/**  
* @ClassName UserService
* @Description:
* @author htc  
* @date 2019年6月28日下午2:39:06 
*/
public interface UserService {
	//用户登录
	User login(User user);
	//用户查询
	User queryUser(String username);
}
