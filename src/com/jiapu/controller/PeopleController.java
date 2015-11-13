package com.jiapu.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jiapu.entity.People;
import com.jiapu.service.PeopleService;
import com.junxun.entity.Res;

@RequestMapping(value="/people")
@Controller
public class PeopleController{
	Logger log = Logger.getLogger(PeopleController.class);
	@Autowired 
	private PeopleService peopleService;
	
	@RequestMapping(value="/queryPeoplesForTree")
	@ResponseBody
	public Object queryPeoplesForTree(People people){
		Res res = new Res();
		try{
			res.setSuccessed(peopleService.queryPeoplesForTree(people));
		}catch(Exception e){
			log.error("login", e);
			res.setFailed("系统出现异常，请稍后再次尝试！");
		}
        return res;
	}
}