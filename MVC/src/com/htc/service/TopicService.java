package com.htc.service;

import java.sql.SQLException;
import java.util.List;

import com.htc.bean.Topic;
import com.htc.dao.impl.TopicDaoImpl;

public class TopicService {
	private TopicDaoImpl tdao = new TopicDaoImpl();
	public List<Topic> findTopicByKeyWord(String keyword) throws SQLException {
		
		return tdao.findTopicByKeyWord(keyword);
		
	}
	
}
