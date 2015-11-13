package com.jiapu.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreeObj {
	public String value;
	public String name;
	public int[] symbolSize = new int[]{90,70};
	public List<TreeObj> children = new ArrayList<TreeObj>();
	@Override
	public String toString() {
		return "TreeObj [value=" + value + ", name=" + name + ", symbolSize=" + Arrays.toString(symbolSize)
				+ ", children=" + children + "]";
	}
}