package com.junxun.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.junxun.entity.Res;
@RequestMapping(value="/user")
@Controller
public class UserController{
	Logger log = Logger.getLogger(UserController.class);
	
	@RequestMapping(value="/isLogin")
	@ResponseBody  
	public Object isLogin(HttpSession session){
		Res res = new Res();
		try{
			String uid = (String) session.getAttribute("USERID");
			if(uid!=null&&!uid.trim().equals("")){
				res.setSuccessed(uid);
			}else{
				res.setFailed("请登录后再投稿！");
			}
		}catch(Exception e){
			log.error("isLogin", e);
			res.setFailed("系统出现异常，请稍后再次尝试！");
		}
        return res;  
	}
	@RequestMapping(value="/login")
	@ResponseBody
	public Object login(HttpSession session, String name, String pw){
		Res res = new Res();
		try{
			System.out.println("name=" + name);
			System.out.println("pw1=" + pw);
			/*
			String uid = (String) session.getAttribute("USERID");
			if(uid!=null&&!uid.trim().equals("")){
				res.setSuccessed(uid);
			}else{
				res.setFailed("请登录后再投稿！");
			}
			*/
		}catch(Exception e){
			log.error("login", e);
			res.setFailed("系统出现异常，请稍后再次尝试！");
		}
        return res;
	}
}