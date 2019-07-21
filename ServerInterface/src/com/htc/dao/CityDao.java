/**
 * 
 */
package com.htc.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.htc.bean.City;
import com.htc.utils.C3P0Utils;

/**  
* @ClassName CityDao
* @Description:
* @author htc  
* @date 2019年7月21日下午7:14:50 
*/
public class CityDao {
	public List<City> selectAllCity() throws SQLException{
		List<City> citys = new ArrayList<City>();
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from city";
		citys = queryRunner.query(sql, new BeanListHandler<City>(City.class));
		return citys;
	}
}
