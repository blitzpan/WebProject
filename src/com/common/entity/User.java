package com.common.entity;

public class User {
	private String id;
	private String third;//来自哪个平台，1微博；2qq
	private String thirdUid;//第三方用户id
	private String name;//用户登录名
	private String nickName;//用户昵称
	private String description;//简介
	private String imgUrl;//头像url
	private String gender;//性别：m女；f男；n为止
	private String at;//access token
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getThird() {
		return third;
	}
	public void setThird(String third) {
		this.third = third;
	}
	public String getThirdUid() {
		return thirdUid;
	}
	public void setThirdUid(String thirdUid) {
		this.thirdUid = thirdUid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getAt() {
		return at;
	}
	public void setAt(String at) {
		this.at = at;
	}

}
