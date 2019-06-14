/**
 * 
 */
package com.htc.test;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.htc.utils.C3P0Utils;

/**  
* @ClassName:jdbcTest
* @Description:测试JDBC连接
* @author:htc  
* @date:2019年6月12日 下午10:11:01
*/
public class jdbcTest {
	@Test
	public void testJdbc(){
		try {
			Connection conn = C3P0Utils.getConnection();
			System.out.println(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
