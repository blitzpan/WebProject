package com.qiniu;

import java.util.UUID;

import org.json.JSONException;

import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;

public class Uptoken {
	public final static String makeUptoken() throws AuthException, JSONException {
		Auth auth = Config.auth;
		String token = auth.uploadToken(Config.bucket, null, 3600, new StringMap()
		         .put("returnUrl", "http://127.0.0.1:8081/junxun/ueditor1_2_6_1/jsp/QiNiuCallback.jsp").putNotEmpty("callbackHost", "")
		         .put("returnBody", "{\"name\": $(fname),\"size\": \"$(fsize)\",\"w\": \"$(imageInfo.width)\",\"h\": \"$(imageInfo.height)\",\"key\":$(etag)}"));
		System.out.println("token=" + token);
		return token;
	}

	/**
	 * 生成32位UUID 并去掉"-"
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	public static void main(String[] args) {
	}
}
