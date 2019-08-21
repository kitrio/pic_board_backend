package com.j.board.domain;

import java.sql.Timestamp;
import java.util.List;

public class BoardVO {
    private int boardNum;
    private String memberId;
    private String nickname;
    private String title;
    private String content;
    private Timestamp writeTime;
    private int readCount;
    private int goodCount;
    private String ip;
    private List<FilesVO> files;

    public int getBoardNum() {
        return this.boardNum;
    }
    public void setBoardNum(int boardNum) {
        this.boardNum = boardNum;
    }

    public String getMemberId() {
    	return this.memberId;
    }
    public void setMemberId(String memberId) {
    	this.memberId = memberId;
    }

    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getTitle() {
    	return this.title;
    }
    public void setTitle(String title) {
    	this.title = title;
    }

    public String getContent() {
    	return this.content;
    }
    public void setContent(String content) {
    	this.content = content;
    }

    public Timestamp getWriteTime() {
    	return this.writeTime;
    }
    public void setWriteTime(Timestamp contentTime) {
    	this.writeTime = contentTime;
    }

    public int getReadCount() {
    	return this.readCount;
    }
    public void setReadCount(int readCount) {
    	this.readCount = readCount;
    }

    public int getGoodCount() {
    	return this.goodCount;
    }
    public void setGoodCount(int goodCount) {
    	this.goodCount = goodCount;
    }
    
    public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
    }
    
    public List<FilesVO> getFiles() {
        return files;
    }
    public void setFiles(List<FilesVO> files) {
        this.files = files;
    }
}