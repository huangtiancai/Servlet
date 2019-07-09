/**
 * 
 */
package com.htc.dao;

import com.htc.bean.Board;

/**  
* @ClassName:BoardService
* @Description:
* @author:htc  
* @date:2019年7月10日 上午12:52:13
*/
public interface BoardDao {
	Board findboardNamebyboardId(String boardId);
}
