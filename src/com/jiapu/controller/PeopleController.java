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
	/**
	 * @Description:新增一个用户 
	 * @param @param p
	 * @param @return
	 * @param @throws Exception   
	 * @return int  
	 * @throws
	 * @author Panyk
	 * @date 2015年11月13日
	 */
	@RequestMapping(value="/addPeople")
	@ResponseBody
	public Object addPeople(People p) throws Exception{
		Res res = new Res();
		try{
			res.setSuccessed(peopleService.addPeople(p));
		}catch(Exception e){
			log.error("addPeople", e);
			res.setFailed("新增出现异常。");
		}
		return res;
	}
	/**
	 * @Description:根据id删除 
	 * @param @param p
	 * @param @return
	 * @param @throws Exception   
	 * @return Object  
	 * @throws
	 * @author Panyk
	 * @date 2015年11月13日
	 */
	@RequestMapping(value="/delPeople")
	@ResponseBody
	public Object delPeople(People p) throws Exception{
		Res res = new Res();
		try{
			int count = peopleService.delPeople(p);
			if(count > 0){
				res.setSuccessed(1);
			}else{
				res.setFailed("后代不为空不允许删除！");
			}
		}catch(Exception e){
			log.error("delPeople", e);
			res.setFailed("删除出现异常。");
		}
		return res;
	}
	/**
	 * @Description:查询树状图 
	 * @param @param people
	 * @param @return   
	 * @return Object  
	 * @throws
	 * @author Panyk
	 * @date 2015年11月13日
	 */
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