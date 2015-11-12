package com.jiapu.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.junxun.entity.Res;

@RequestMapping(value="/people")
@Controller
public class PeopleController{
	Logger log = Logger.getLogger(PeopleController.class);
	@RequestMapping(value="/queryAllPeople")
	@ResponseBody
	public Object queryAllPeople(){
		Res res = new Res();
		try{
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