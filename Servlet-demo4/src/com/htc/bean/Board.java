package com.htc.bean;

public class Board {
	private int boardId;
	private String boardName;
	private int parentId;
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public String getBoardName() {
		return boardName;
	}
	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public Board(int boardId, String boardName, int parentId) {
		super();
		this.boardId = boardId;
		this.boardName = boardName;
		this.parentId = parentId;
	}
	public Board() {
		super();
	}
	
	
}
