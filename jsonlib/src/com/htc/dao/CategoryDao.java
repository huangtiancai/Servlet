/**
 * 
 */
package com.htc.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.htc.bean.Category;
import com.htc.utils.C3P0Utils;

/**  
* @ClassName:CategoryDao
* @Description:数据层
* @author:htc  
* @date:2019年6月12日 下午10:20:35
*/
public class CategoryDao {
	public List<Category> selectAllCategory() throws SQLException{
		List<Category> cates = new ArrayList<Category>();		
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from category";
		cates = queryRunner.query(sql, new BeanListHandler<Category>(Category.class));
		return cates;
	}
}
