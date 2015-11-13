package com.jiapu.entity;

import java.util.HashMap;
import java.util.Map;

public class DataConstant {
	public static String name="name";
	public static String value="value";
	public static String symbolSize="symbolSize";
	public static String itemStyle="itemStyle";
	public static String normal="normal";
	public static String label="label";
	public static String show="show";
	public static String children = "children";
	public static Map itemStyleMap = new HashMap();
	public DataConstant() {
		Map map1 = new HashMap();
		map1.put("show", true);
		Map map2 = new HashMap();
		map2.put("label", map1);
		Map map3 = new HashMap();
		map3.put("normal", map2);
	}
}
