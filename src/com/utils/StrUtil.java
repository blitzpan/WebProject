package com.utils;

import java.util.UUID;

public class StrUtil {
	public static String getUUID() throws Exception{
		return UUID.randomUUID().toString().replace("-", "");
	}
}
