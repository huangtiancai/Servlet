/**
 * 
 */
package com.htc.jdbctest;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.htc.utils.C3P0Utils2;

/**  
* @ClassName:JDBCTest
* @Description:
* @author:htc  
* @date:2019年7月10日 上午12:04:18
*/
public class JDBCTest {
	@Test
	public void jdbcTest(){
		try {
			Connection coon = C3P0Utils2.getConnection();
			System.out.println(coon);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
		}
	}
}
