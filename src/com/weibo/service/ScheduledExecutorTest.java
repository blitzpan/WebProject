package com.weibo.service;

import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import weibo4j.Timeline;
import weibo4j.model.Status;
import weibo4j.model.StatusWapper;

import com.auto.source.bo.SourceBo;
import com.auto.source.entity.Source;
import com.auto.utils.MyApplicationContextUtil;
import com.weibosay.WeiboSay;

/*具体定时任务的实现类*/
@Transactional
@Service
public class WeiboService {
	private WeiboSay ws = null;
	private SourceBo sourceBo;
	private Source source;

	public void run() {
		try{
			String at = "2.00Hp8ZeC1rOq2C7a23d0528aB4paQC";
			Timeline tm = new Timeline();
			tm.setToken(at);
			//获取最新的公共微博，并转发其中转发量最高的一条
			StatusWapper sw = tm.getPublicTimeline(40, 0);
//			StatusWapper sw = tm.getFriendsTimeline();
//			StatusWapper sw = tm.getHomeTimeline();
			List<Status> swl = sw.getStatuses();
//			转发
//			tm.Repost(this.getMaxReposts(swl));
			tm.Repost(this.getMaxFollowers(swl));
			
			
			//获取微博的转发和评论个数
			System.out.println(tm.getRepostsAndComments(this.getMaxFollowers(swl)));
			
			//获取当前登录用户及其所关注用户的最新微博
			/*
			StatusWapper status;
			status = tm.getFriendsTimeline();
			for(Status s : status.getStatuses()){
				User u = s.getUser();
			}
			*/
		}catch(Exception e){
			
		}
		
		if(true){
			return;
		}
		
		
		
		//发布一条新的微博
		Calendar date = Calendar.getInstance();
//		int type = ScheduleUtils.getDoWhat()[date.get(Calendar.HOUR_OF_DAY)];// 根据时间获取当前应该干什么
		int type = (int) (Math.random()*30);
		type = 10;
		/* 获取要发表的内容 */
		try {
			System.out.println("查询微博开始：");
			sourceBo = (SourceBo) MyApplicationContextUtil.getContext().getBean("sourceBo");
			if(type < 15){//笑话
				source = new Source();
				
				source = sourceBo.getASourceForAutoSay(0);
				// 启动发送微博线程
				System.out.println("开始发送文字：");
				if (source != null) {// 只有当不是空的时候才发
					source.setContent(source.getContent().replaceAll("\t\n", "").trim());
					if(source.getContent().length()>140){
						source.setContent(source.getContent().substring(0,130));
					}
					ws = new WeiboSay();
					ws.setSource(source);
					ws.setType(0);
					ws.start();
					System.out.println("发送文字结束。");
				}
			}else if(type < 25){
				System.out.println("开始发送图片：");
				ws = new WeiboSay();
				ws.setType(1);
				ws.start();
				System.out.println("发送图片结束。");
			}else{
				source = sourceBo.getASourceForAutoSay(2);
				// 启动发送微博线程
				System.out.println("开始发送视频");
				if (source != null) {// 只有当不是空的时候才发
					source.setContent(source.getContent().replaceAll("\t\n", "").trim());
					if(source.getContent().length()>90){
						source.setContent(source.getContent().substring(0,90));
					}
					ws = new WeiboSay();
					ws.setSource(source);
					ws.setType(2);
					ws.start();
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	* 基本功能：获取微博列表中转发量最高的一条
	* 编    者：潘宜奎
	* 完成日期：2015-4-27
	* 修改内容：
	* @param 
	* @return 
	* @throws
	 */
	private String getMaxReposts(List<Status> sl){
		String tempId = "";
		int max = 0;
		for(Status s:sl){
			if(s.getRepostsCount()>max){
				tempId = s.getId();
				max = s.getRepostsCount();
			}
		}
		return tempId;
	}
	/**
	* 基本功能：获取微博列表中粉丝数最多的人的微博
	* 编    者：潘宜奎
	* 完成日期：2015-4-27
	* 修改内容：
	* @param 
	* @return 
	* @throws
	 */
	private String getMaxFollowers(List<Status> sl){
		String tempId = "";
		int max = 0;
		for(Status s:sl){
			if(s.getUser().getFollowersCount()>max){
				tempId = s.getId();
				max = s.getUser().getFollowersCount();
			}
		}
		return tempId;
	}

	public SourceBo getSourceBo() {
		return sourceBo;
	}

	public void setSourceBo(SourceBo sourceBo) {
		this.sourceBo = sourceBo;
	}
}