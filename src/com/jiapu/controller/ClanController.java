package com.jiapu.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jiapu.entity.Clan;
import com.jiapu.service.ClanService;
import com.junxun.entity.Res;

@Controller
@RequestMapping(value="/clan")
public class ClanController {
	@Autowired
	private ClanService clanService;
	private Logger log = Logger.getLogger(ClanController.class);
	
	/**
	 * @Description:新增或者更新一个家族信息 
	 * @param @param clan
	 * @param @return
	 * @param @throws Exception   
	 * @return int  
	 * @throws
	 * @author Panyk
	 * @date 2015年11月20日
	 */
	@RequestMapping(value="/addClan")
	@ResponseBody
	public Object addClan(HttpSession session, Clan clan) {
		Res res = new Res();
		try{
			String uid = (String)session.getAttribute("UID");
			uid = "123";
			clan.setUid(uid);
			if(uid==null||uid.equals("")){
				res.setFailed("请登陆后再操作！");
			}else{
				if(clan.getId()==null||clan.getId().trim().equals("")){//新增
					clanService.addClan(clan);
					res.setSuccessed("新增成功！","新增成功！");
				}else{//更新
					clanService.upClan(clan);
					res.setSuccessed("更新成功！","更新成功！");
				}
			}
		}catch(Exception e){
			log.error("addClan=", e);
			res.setFailed("程序发生异常！");
		}
		return res;
	}
}
