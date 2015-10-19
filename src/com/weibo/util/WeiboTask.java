package com.weibo.util;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.weibo.service.WeiboService;

/**
 * 定时发送微博
 * @author Administrator
 */
@Component
@Scope("prototype")//每一个请求都有一个类来处理，避免线程安全问题。
public class WeiboTask {
	@Autowired
	private WeiboService weiboService;
	public void sendWeibo() {
		System.out.println("发送微博开始：" + new Date());  
		weiboService.doWeibo();
        System.out.println("发送微博结束：" + new Date());  
	}
}