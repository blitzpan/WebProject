package com.weibo.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weibo.dao.SourceDao;
import com.weibo.dao.WeiboDao;
import com.weibo.entity.Source;
import com.weibo.entity.WeiboUser;

import weibo4j.Timeline;
import weibo4j.http.ImageItem;
import weibo4j.model.Status;
import weibo4j.model.WeiboException;
import weibo4j.util.URLEncodeUtils;
@Service
public class WeiboSay extends Thread {
	/*
	@Autowired
	private SourceDao sourceDao;
	@Autowired
	private WeiboDao weiboDao;
	private int type;
	private Source source;
	private List<WeiboUser> wbul = null;
	private Timeline tm = null;
	private File imgF = null;
	ImageItem ii = null; 
	String path = "E:\\www2\\vhhk4ge-f36e7bd54751211e014768adb18f0627\\webapps\\ROOT\\upimage";
	String title = "";
	byte[] fileByte = null;

	public void run() {
		Status status = null;
		boolean error = false;
		try {
//			wbul = weiboBo.findAllWeiboUser(new Date().getTime());//微博user list
			
			//临时的wbul
			WeiboUser wu = new WeiboUser();
			wu.setAccessToken("2.00Hp8ZeC1rOq2C7a23d0528aB4paQC");
			wbul = new ArrayList<WeiboUser>();
			wbul.add(wu);
			
			
			if(type == 1){//获取图片
				imgF = new File(path);
				if(imgF != null && imgF.isDirectory()){
					String[] fileNameA = imgF.list();
					if(fileNameA != null && fileNameA.length > 0){
						System.out.println("图片标题：" + fileNameA[0]);
						title = fileNameA[0];
						fileByte = Upload.readFileImage(path + File.separator + title);
					}
				}
			}
			//遍历access_token发送消息	
			String tip = "#独乐乐不如众乐乐#";
			for(int i = 0; i < wbul.size(); i++){
				WeiboUser wbu = wbul.get(i);
				tm = new Timeline();
				tm.client.setToken(wbul.get(i).getAccessToken());
				try{
					if (type == 0) {// 发送文字笑话
						// 自己所发的微博内容，不超过140个字！
						status = tm.UpdateStatus(tip + source.getContent());
					} else if (type == 1) {// 发送图片笑话
						if(fileByte != null){
							ii = new ImageItem("pic", fileByte);
							status = tm.UploadStatus(URLEncodeUtils.encodeURL("独乐乐不如众乐乐"), ii);
						}
					} else if (type == 2) {// 发送视频
						status = tm.UpdateStatus(tip + source.getContent() + source.getUrl());
					} else {
						System.out.println("执行发微博：" + type);
					}
					System.out.println(status);
					tip = "";
					weiboDao.refreshTime(wbu);
				}catch(WeiboException e){
					error = true;
					System.out.println("发送微博错误。status = " + status);
					if(e.getErrorCode()==21332){//invalid_access_token
						weiboDao.delWeiboInfo(wbu);
					}else if(e.getErrorCode()==10013){//不合法的微博用户
						weiboDao.delWeiboInfo(wbu);
					}else if(e.getErrorCode()==20003){//用户不存在
						weiboDao.delWeiboInfo(wbu);
					}else{
						
					}
					Log.logDebug("发送微博错误。status = " + status);
					e.printStackTrace();
				}catch(Exception e){
					System.out.println("发送消息出错。status = " + status);
					Log.logDebug("发送消息出错。status = " + status);
					e.printStackTrace();
				}
				
			}
			if(type == 0){//文字笑话
					sourceDao.setMyindex(source);
			}else if(type == 1){//图片笑话
				//发送完毕之后删除文件
				if(fileByte!= null){
					File deleteFile = new File(path + File.separator + title);
					System.out.println("删除文件：" + deleteFile.getAbsolutePath());
					boolean flag = deleteFile.delete();
					System.out.println("删除" + (flag==true?"成功":"失败"));
				}
			}
		} catch (Exception e1) {
			Log.logInfo("获取用户access_token信息错误");
			System.out.println("获取用户access_token信息错误");
			e1.printStackTrace();
		}
	}

	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}

	public Source getSource() {
		return source;
	}

	public void setSource(Source source) {
		this.source = source;
	}
	*/
}
