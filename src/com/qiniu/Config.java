package com.qiniu;

import com.qiniu.util.Auth;

public class Config {
	
	public static String USER_AGENT;
	
	public static String ACCESS_KEY = "yCNJIbXCgdikemUspoPA8LYpgozkdyOPMyEceriy";

	public static String SECRET_KEY = "PZhapcldcAYNUGGH2xDOWDI8om4I7VCOWT502RFM";

	public static String RS_HOST = "http://rs.qbox.me";

	public static String UP_HOST = "http://up.qbox.me";
	
	public static String RSF_HOST = "http://rsf.qbox.me";
	
	
	/*************************上面是老版本sdk用的，下面是新版本sdk用的*****************************/
	public static final Auth auth = Auth.create("yCNJIbXCgdikemUspoPA8LYpgozkdyOPMyEceriy",
			"PZhapcldcAYNUGGH2xDOWDI8om4I7VCOWT502RFM");
	public static final String bucket = "webproject";
	public static final String key = "java-duke.svg";
	public static final String domain = "http://7xnzc3.com1.z0.glb.clouddn.com/";
}
