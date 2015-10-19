package com.weibo.entity;

public class Source {
	private int id;
	private String title;
	private String content;
	private String url;
	private int type;
	private int ifcheck;
	private String time;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getIfcheck() {
		return ifcheck;
	}
	public void setIfcheck(int ifcheck) {
		this.ifcheck = ifcheck;
	}
}
