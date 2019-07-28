/**
 * 
 */
package com.htc.test;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.htc.utils.JDBCUtils;

/**  
* @ClassName JDBCTest
* @Description:
* @author htc  
* @date 2019年7月27日下午12:51:54 
*/
public class JDBCTest {
	@Test
	public void testJdbc(){
		Connection conn = JDBCUtils.getConnection();
		System.out.println(conn);
	}
}
