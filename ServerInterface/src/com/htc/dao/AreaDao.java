/**
 * 
 */
package com.htc.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.htc.bean.Area;
import com.htc.utils.C3P0Utils;

/**  
* @ClassName AreaDao
* @Description:
* @author htc  
* @date 2019年7月21日下午7:16:58 
*/
public class AreaDao {
	public List<Area> selectAllArea() throws SQLException{
		List<Area> areas = new ArrayList<Area>();
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from area";
		areas = queryRunner.query(sql, new BeanListHandler<Area>(Area.class));
		return areas;
	}
}
