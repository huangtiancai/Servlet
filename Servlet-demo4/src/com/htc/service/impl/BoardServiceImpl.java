/**
 * 
 */
package com.htc.service.impl;

import com.htc.bean.Board;
import com.htc.dao.BoardDao;
import com.htc.dao.impl.BoardDaoImpl;
import com.htc.service.BoardService;

/**  
* @ClassName:BoardServiceImpl
* @Description:
* @author:htc  
* @date:2019年7月10日 上午12:51:24
*/
public class BoardServiceImpl implements BoardService {
	private BoardDao  boardDao = new BoardDaoImpl();
	@Override
	public Board findboardNamebyboardId(String boardId) {
		return boardDao.findboardNamebyboardId(boardId);
	}

}
