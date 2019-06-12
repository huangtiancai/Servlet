/**
 * 
 */
package com.htc.bean;

/**  
* @ClassName:Category
* @Description:
* @author:htc  
* @date:2019年6月12日 下午10:18:00
*/
public class Category {
	private String cid;
	private String cname;

	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Category(String cid, String cname) {
		super();
		this.cid = cid;
		this.cname = cname;
	}
	public Category() {
		super();
	}
	@Override
	public String toString() {
		return "Category [cid=" + cid + ", cname=" + cname + "]";
	}
}
