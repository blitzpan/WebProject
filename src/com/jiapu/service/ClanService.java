package com.jiapu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jiapu.dao.ClanDao;
import com.jiapu.dao.PeopleDao;
import com.jiapu.entity.Clan;
import com.jiapu.entity.People;
import com.utils.StrUtil;
@Transactional
@Service
public class ClanService {
	@Autowired
	private ClanDao clanDao;
	@Autowired
	private PeopleDao peopleDao;
	/**
	 * @Description:新增一个家族信息 
	 * @param @param clan
	 * @param @return
	 * @param @throws Exception   
	 * @return int  
	 * @throws
	 * @author Panyk
	 * @date 2015年11月20日
	 */
	public int addClan(Clan clan) throws Exception{
		//创建家族信息
		String id = StrUtil.getUUID();
		clan.setId(id);
		clanDao.addClan(clan);
		//创建树的根节点
		People people = new People();
		people.setId(StrUtil.getUUID());
		people.setFid("-1");
		people.setName("家谱");
		people.setCid(id);
		people.setBirth("");
		return peopleDao.addPeople(people);
	}
	/**
	 * @Description:更新一个家谱信息 
	 * @param @param clan
	 * @param @return
	 * @param @throws Exception   
	 * @return int  
	 * @throws
	 * @author Panyk
	 * @date 2015年11月20日
	 */
	public int upClan(Clan clan) throws Exception{
		return clanDao.upClan(clan);
	}
	/**
	 * @Description:查询一个家谱信息 
	 * @param @param c
	 * @param @return
	 * @param @throws Exception   
	 * @return Clan  
	 * @throws
	 * @author Panyk
	 * @date 2015年11月24日
	 */
	public Clan queryOneClan(Clan c) throws Exception{
		return clanDao.queryOneClan(c);
	}
	public ClanDao getClanDao() {
		return clanDao;
	}
	public void setClanDao(ClanDao clanDao) {
		this.clanDao = clanDao;
	}
	public PeopleDao getPeopleDao() {
		return peopleDao;
	}
	public void setPeopleDao(PeopleDao peopleDao) {
		this.peopleDao = peopleDao;
	}
}
