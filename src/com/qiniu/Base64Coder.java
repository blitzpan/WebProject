package com.qiniu;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;

public class Base64Coder {

	public static String decode(String s) {
		return StringUtils.newStringUtf8(Base64.decodeBase64(s.getBytes()));
	}

	public static String encode(String s) {
		return Base64.encodeBase64(StringUtils.getBytesUtf8(s)).toString();
	}
}
