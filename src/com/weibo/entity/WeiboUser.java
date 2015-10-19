package com.weibo.entity;

public class WeiboUser {
	private String uid;
	private String accessToken;
	private String rete;//发送频率
	private long nextTime;//下次时间
	private long interval;//时间间隔
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getRete() {
		return rete;
	}
	public void setRete(String rete) {
		this.rete = rete;
	}
	public long getNextTime() {
		return nextTime;
	}
	public void setNextTime(long nextTime) {
		this.nextTime = nextTime;
	}
	public long getInterval() {
		return interval;
	}
	public void setInterval(long interval) {
		this.interval = interval;
	}
}
