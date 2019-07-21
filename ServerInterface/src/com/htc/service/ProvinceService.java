/**
 * 
 */
package com.htc.service;

import java.sql.SQLException;
import java.util.List;

import com.htc.bean.Province;
import com.htc.dao.ProvinceDao;

/**  
* @ClassName ProvinceService
* @Description:
* @author htc  
* @date 2019年7月21日下午5:19:16 
*/
public class ProvinceService {
	ProvinceDao pd = new ProvinceDao();
	
	public List<Province> selectAllProvince(){
		try {
			return pd.selectAllProvince();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;		
	}
}
