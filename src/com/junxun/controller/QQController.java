package com.junxun.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.common.service.UserService;
import com.junxun.entity.Res;
import com.qq.connect.api.OpenID;
import com.qq.connect.api.qzone.UserInfo;
import com.qq.connect.javabeans.AccessToken;
import com.qq.connect.javabeans.qzone.UserInfoBean;
import com.qq.connect.oauth.Oauth;
@RequestMapping(value="/qq")
@Controller
public class QQController{
	Logger log = Logger.getLogger(QQController.class);
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/qqLogin{abc}")
	//http://www.junxun.win/qq/qqLogin.action?#access_token=8E1FFFF1E379EC591252E086DCFE7494&expires_in=7776000
	public ModelAndView qqLogin(HttpSession session, HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
//		mv.setViewName("/junxun/index");
		Res res = new Res();
		log.info("*************************" + new Date());
		try {
			AccessToken accessTokenObj = (new Oauth()).getAccessTokenByRequest(request);
			log.info("accesstoken=" + accessTokenObj);
			
			log.info("----------------"+accessTokenObj.getAccessToken()+"*************************");
			// 利用获取到的accessToken 去获取当前用的openid -------- start
            OpenID openIDObj =  new OpenID(accessTokenObj.getAccessToken());
            String openID = openIDObj.getUserOpenID();
            log.info("openid = " + openID);
            UserInfo qzoneUserInfo = new UserInfo(accessTokenObj.getAccessToken(), openID);
            UserInfoBean userInfoBean = qzoneUserInfo.getUserInfo();
            log.info("userInfo=" + userInfoBean);
			/*
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
			*/
		} catch (Exception e) {
//			log.error("qqLogin=",e);
			res.setFailed("登录失败！");
		}
		mv.addObject("res", res);
		return mv;
	}
}