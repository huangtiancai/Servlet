/**
 * 
 */
package com.htc.bean;

/**  
* @ClassName User
* @Description:
* @author htc  
* @date 2019年7月27日下午12:26:49 
*/
public class User {
	private Integer id;
	private String name;
	private String password;
	private String img;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public User(Integer id, String name, String password, String img) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.img = img;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password
				+ ", img=" + img + "]";
	}
	
}
