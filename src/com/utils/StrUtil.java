package com.utils;

import java.util.UUID;

public class StrUtil {
	public static String getUUID() throws Exception{
		return UUID.randomUUID().toString().replace("-", "");
	}
	/**
	 * @Description:为空或者空字符串返回true 
	 * @param @param parm
	 * @param @return
	 * @param @throws Exception   
	 * @return boolean  
	 * @throws
	 * @author Panyk
	 * @date 2015年11月17日
	 */
	public static boolean isBlank(String parm) throws Exception{
		if(parm == null || parm.trim().equals("")){
			return true;
		}else{
			return false;
		}
	} 
}
