package com.weibo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.weibo.entity.WeiboUser;
@Repository
public class WeiboDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int addWeiboInfo(WeiboUser weiboUser) throws Exception {
		return 0;
	}
	/**
	 * @Description:access token过期 
	 * @param @param weiboUser
	 * @param @return
	 * @param @throws Exception   
	 * @return int  
	 * @throws
	 * @author Panyk
	 * @date 2015年10月19日
	 */
	public int delWeiboInfo(WeiboUser weiboUser) throws Exception{
		String sql = "update weibouser set accessToken='' where uid = ?";
		return jdbcTemplate.update(sql, weiboUser.getUid());
	}
	/**
	 * 功能介绍：获取所有用户的id和access_token
	 * @return
	 * @throws Exception
	 */
	public List<WeiboUser> findAllWeiboUser(long ctime) throws Exception{
		return null;
	}
	/**
	 * @Description:更新时间 
	 * @param @param weiboUser
	 * @param @throws Exception   
	 * @return void  
	 * @throws
	 * @author Panyk
	 * @date 2015年10月19日
	 */
	public int refreshTime(WeiboUser weiboUser) throws Exception{
		String sql = "update weibouser set nextTime=(SELECT val from (select nextTime+intervals as val from weibouser where uid=? as b) where uid =?";
		return jdbcTemplate.update(sql, new Object[]{weiboUser.getUid(), weiboUser.getUid()} );
	}
}
