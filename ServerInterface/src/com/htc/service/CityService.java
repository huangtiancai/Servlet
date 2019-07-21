/**
 * 
 */
package com.htc.service;

import java.sql.SQLException;
import java.util.List;

import com.htc.bean.City;
import com.htc.dao.CityDao;

/**  
* @ClassName CityService
* @Description:
* @author htc  
* @date 2019年7月21日下午7:18:17 
*/
public class CityService {
	CityDao cd = new CityDao();
	public List<City> selectAllCity(){
		try {
			return cd.selectAllCity();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;		
	}
}
