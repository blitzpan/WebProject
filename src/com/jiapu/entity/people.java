package com.jiapu.entity;

public class people {
	private String id;
	private String name;
	private int age;
	private String birth;
	private String sex;
	private String summary;
	private String desc;
	
	@Override
	public String toString() {
		return "people [age=" + age + ", birth=" + birth + ", desc=" + desc
				+ ", id=" + id + ", name=" + name + ", sex=" + sex
				+ ", summary=" + summary + "]";
	}
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
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
}