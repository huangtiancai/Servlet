
package com.htc.bean;
import java.util.Date;


public class Topic {
	private int topicId;
	private String title;
	private String content;
	private int userId;
	private String username;
	private int boardId;
	private Date publishTime;
	private Date modifyTime;
	private int num;//��������
	private String head;
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getTopicId() {
		return topicId;
	}
	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public Date getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}
	public Date getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	public Topic(int topicId, String title, String content, int userId, int boardId, Date publishTime,
			Date modifyTime) {
		super();
		this.topicId = topicId;
		this.title = title;
		this.content = content;
		this.userId = userId;
		this.boardId = boardId;
		this.publishTime = publishTime;
		this.modifyTime = modifyTime;
	}
	public Topic() {
		super();
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
