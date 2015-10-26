package com.junxun.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import weibo4j.Oauth;
import weibo4j.Users;
import weibo4j.http.AccessToken;
import weibo4j.model.User;
import weibo4j.model.WeiboException;
@RequestMapping(value="/weibo")
@Controller
public class WeiboController{
	Logger log = Logger.getLogger(WeiboController.class);
	
	@RequestMapping(value="/weiboLogin")
	public ModelAndView weiboLogin(String code){
		log.info("微博登陆**************************");
		log.info("code=" + code);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/junxun/index");
		
		
		Oauth oauth = new Oauth();
		try {
			AccessToken at = oauth.getAccessTokenByCode(code);
			log.info("根据code查询到的accessToken" + at);
			
			String accessToken = at.getAccessToken();
			Users um = new Users(accessToken);
			User u = um.showUserById(at.uid);
			log.info("用户信息=" + u);
			String uid = u.getId();
			String name = u.getScreenName();
			String description = u.getDescription();
			String imgUrl = u.getProfileImageUrl();//头像
			String gender = u.getGender();//性别,m--男，f--女,n--未知
		} catch (WeiboException e) {
			e.printStackTrace();
		}
		
		
		
		/*
		Res res = new Res();
		try{
			res.setSuccessed("新增成功！", 1);
		}catch(Exception e){
			res.setFailed("新增失败！");
			log.error("addArticle", e);
		}
		mv.addObject("res", res);
		mv.addObject("nextPage","/article/beforeAddArticle.action");
		mv.addObject("nextPageBtn","再来一篇");
		 */
		return mv;
	}
}