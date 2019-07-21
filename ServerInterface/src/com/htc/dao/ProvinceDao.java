/**
 * 
 */
package com.htc.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.htc.bean.Province;
import com.htc.utils.C3P0Utils;

/**  
* @ClassName ProvinceDao
* @Description:数据层
* @author htc  
* @date 2019年7月21日下午5:20:57 
*/
public class ProvinceDao {
	public List<Province> selectAllProvince() throws SQLException{
		List<Province> pros = new ArrayList<Province>();
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from province";
		pros = queryRunner.query(sql, new BeanListHandler<Province>(Province.class));
		return pros;
	}
}
