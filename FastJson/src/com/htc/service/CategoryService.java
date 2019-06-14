/**
 * 
 */
package com.htc.service;

import java.sql.SQLException;
import java.util.List;

import com.htc.bean.Category;
import com.htc.dao.CategoryDao;

/**  
* @ClassName:CategoryService
* @Description:
* @author:htc  
* @date:2019年6月12日 下午10:21:21
*/
public class CategoryService {
	CategoryDao cd = new CategoryDao();
	
	public List<Category> selectAllCategory(){
		try {
			return cd.selectAllCategory();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
