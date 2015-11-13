package com.jiapu.entity;

import java.util.ArrayList;
import java.util.List;

public class People {
	private String id;
	private String fid;
	private String name;
	private int age;
	private String birth;
	private String sex;
	private String summary;
	private String des;
	private int level;
	private List<People> children = new ArrayList<People>();
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public List<People> getChildren() {
		return children;
	}
	public void setChildren(List<People> children) {
		this.children = children;
	}
	@Override
	public String toString() {
		return "People [id=" + id + ", fid=" + fid + ", name=" + name + ", age=" + age + ", birth=" + birth + ", sex="
				+ sex + ", summary=" + summary + ", des=" + des + ", level=" + level + ", children=" + children + "]";
	}
}