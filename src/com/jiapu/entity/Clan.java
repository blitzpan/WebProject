package com.jiapu.entity;

import org.springframework.stereotype.Repository;
/**
 * ClassName: Clan 
 * @Description:家族类 
 * @author Panyk
 * @date 2015年11月20日
 */
@Repository
public class Clan {
	private String id;
	private String uid;
	private String name;
	private String summary;
	private int state;
	private String cjsj;
	private String modsj;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getCjsj() {
		return cjsj;
	}
	public void setCjsj(String cjsj) {
		this.cjsj = cjsj;
	}
	public String getModsj() {
		return modsj;
	}
	public void setModsj(String modsj) {
		this.modsj = modsj;
	}
	@Override
	public String toString() {
		return "Clan [id=" + id + ", uid=" + uid + ", name=" + name + ", summary=" + summary + ", state=" + state
				+ ", cjsj=" + cjsj + ", modsj=" + modsj + "]";
	}
	
}
