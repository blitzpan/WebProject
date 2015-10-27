package com.junxun.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.common.service.UserService;
import com.junxun.entity.Res;

import weibo4j.Oauth;
import weibo4j.Users;
import weibo4j.http.AccessToken;
import weibo4j.model.User;
@RequestMapping(value="/weibo")
@Controller
public class WeiboController{
	Logger log = Logger.getLogger(WeiboController.class);
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/weiboLogin")
	public ModelAndView weiboLogin(String code,HttpSession session){
		log.info("code=" + code);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/junxun/index");
		Res res = new Res();
		try {
			Oauth oauth = new Oauth();
			AccessToken at = oauth.getAccessTokenByCode(code);
			log.info("根据code查询到的accessToken" + at);
			String accessToken = at.getAccessToken();
			Users um = new Users(accessToken);
			User weiboUser = um.showUserById(at.uid);
			log.info("用户信息=" + weiboUser);
			com.common.entity.User user = new com.common.entity.User();
			user.setAccessToken(accessToken);
			user.setDescription(weiboUser.getDescription());
			user.setGender(weiboUser.getGender());
			user.setImgUrl(weiboUser.getProfileImageUrl());
			user.setName("");
			user.setNickName(weiboUser.getScreenName());
			user.setThird("1");
			user.setThirdUid(weiboUser.getId());
			userService.weiboLogin(user);
			res.setSuccessed("登录成功！", user);
			session.setAttribute("USERNAME", user.getNickName());
			session.setAttribute("USERID", user.getId());
			session.setAttribute("USERUID", user.getThirdUid());
			session.setAttribute("THIRD", user.getThird());
		} catch (Exception e) {
			log.error("weiboLogin",e);
			res.setFailed("登录失败！");
		}
		mv.addObject("res", res);
		return mv;
	}
}