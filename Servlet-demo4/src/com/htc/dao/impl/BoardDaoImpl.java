/**
 * 
 */
package com.htc.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.handlers.BeanHandler;

import com.htc.bean.Board;
import com.htc.dao.BoardDao;

/**  
* @ClassName:BoardDaoImpl
* @Description:
* @author:htc  
* @date:2019年7月10日 上午12:53:22
*/
public class BoardDaoImpl extends BaseDaoImpl implements BoardDao {

	@Override
	public Board findboardNamebyboardId(String boardId) {
		String sql = "select * from board where BOARDID = ?";
		try {
			return queryRunner1.query(sql, new BeanHandler<Board>(Board.class), boardId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
