package com.junxun.entity;

public class Res {
	private String state = "1";//1是成功，0是失败
	private String info = "";//原因
	private Object res = null;//具体的结果
	
	public void setFailed(String info){
		this.state = "0";
		this.info = info;
	}
	public void setSuccessed(String info, Object res){
		this.state = "1";
		this.info = info;
		this.res = res;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Object getRes() {
		return res;
	}
	public void setRes(Object res) {
		this.res = res;
	}
}
