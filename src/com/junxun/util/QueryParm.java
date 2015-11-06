package com.junxun.util;

public class QueryParm {
	public String menu;//菜单
	public String tag;//标签
	public String sort="ab";//排序
	@Override
	public String toString() {
		return "QueryParm [menu=" + menu + ", tag=" + tag + ", sort=" + sort + "]";
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
}
