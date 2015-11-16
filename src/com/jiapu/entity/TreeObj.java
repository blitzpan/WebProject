package com.jiapu.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeObj {
	public String value;
	public String name;
	public String symbol = "";
	public Object symbolSize = null;
	public List<TreeObj> children = new ArrayList<TreeObj>();
	public Map itemStyle = new HashMap();
	public static Map doubleL = new HashMap();//两人健全
	public static Map manL = new HashMap();//男健全
	public static Map womanL = new HashMap();//女健全
	public static Map doubleD = new HashMap();//两人都不健全
	static {
		doubleL.put("color", "#00868B");
		manL.put("color", "#1C86EE");
		womanL.put("color", "#FF3E96");
		doubleD.put("color", "#A9A9A9");
	}
	public TreeObj(People p){
		if(p.getSex().equals("0")){//男
			symbolSize = new int[]{100,70};//男的是个方
			if(p.getLive()==0 && p.getLive2() == 0){//两人都健全
				itemStyle.put("normal", doubleL);
			}else if(p.getLive()==0){//男健全
				itemStyle.put("normal", manL);
			}else if(p.getLive2()==0){//女健全
				itemStyle.put("normal", womanL);
			}else{//都不健全
				itemStyle.put("normal", doubleD);
			}
		}else{
			symbol = "circle"; 
            symbolSize = 60; 
			if(p.getLive()==0){//女健全
				itemStyle.put("normal", doubleL);
			}else{
				itemStyle.put("normal", doubleD);
			}
		}
    }
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public Object getSymbolSize() {
		return symbolSize;
	}
	public void setSymbolSize(Object symbolSize) {
		this.symbolSize = symbolSize;
	}
	public List<TreeObj> getChildren() {
		return children;
	}
	public void setChildren(List<TreeObj> children) {
		this.children = children;
	}
	public Map getItemStyle() {
		return itemStyle;
	}
	public void setItemStyle(Map itemStyle) {
		this.itemStyle = itemStyle;
	}
	public static Map getDoubleL() {
		return doubleL;
	}
	public static void setDoubleL(Map doubleL) {
		TreeObj.doubleL = doubleL;
	}
	public static Map getManL() {
		return manL;
	}
	public static void setManL(Map manL) {
		TreeObj.manL = manL;
	}
	public static Map getWomanL() {
		return womanL;
	}
	public static void setWomanL(Map womanL) {
		TreeObj.womanL = womanL;
	}
	public static Map getDoubleD() {
		return doubleD;
	}
	public static void setDoubleD(Map doubleD) {
		TreeObj.doubleD = doubleD;
	}


	
	
}