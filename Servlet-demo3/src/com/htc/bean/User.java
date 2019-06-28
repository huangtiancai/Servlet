/**
 * 
 */
package com.htc.bean;

/**  
* @ClassName User
* @Description:
* @author htc  
* @date 2019年6月6日下午4:41:41 
*/
public class User {
	private String username;
	private String password;

	public User() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param username
	 * @param password
	 */
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	

}
