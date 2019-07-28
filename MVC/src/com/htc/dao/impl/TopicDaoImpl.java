package com.htc.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.htc.bean.Topic;
import com.htc.utils.JDBCUtils;

public class TopicDaoImpl {

	public List<Topic> findTopicByKeyWord(String keyword) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql="select t.*,u.username,u.head from topic t,users u where t.userid=u.userid and (title like ? or content like ?)";
		return runner.query(sql, new BeanListHandler<Topic>(Topic.class), "%"+keyword+"%","%"+keyword+"%");
	}
/*	public static void main(String[] args) throws SQLException {
		List<Topic> list = findTopicByKeyWord("����");
		System.out.println(list.size());
	}*/
}
