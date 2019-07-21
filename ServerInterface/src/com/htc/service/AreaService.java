/**
 * 
 */
package com.htc.service;

import java.sql.SQLException;
import java.util.List;

import com.htc.bean.Area;
import com.htc.dao.AreaDao;

/**  
* @ClassName AreaService
* @Description:
* @author htc  
* @date 2019年7月21日下午7:21:11 
*/
public class AreaService {
	AreaDao ad = new AreaDao();
	public List<Area> selectAllArea(){
		try {
			return ad.selectAllArea();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;		
	}
}
