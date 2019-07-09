/**
 * 
 */
package com.htc.service;

import com.htc.bean.Board;

/**  
* @ClassName:BoardService
* @Description:
* @author:htc  
* @date:2019年7月10日 上午12:46:53
*/
public interface BoardService {
	Board findboardNamebyboardId(String boardId);
}
