package com.weibo.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.weibo.entity.Source;

@Repository
public class SourceDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	/**
	 * @Description:查询一条消息 
	 * @param @param parm
	 * @param @return
	 * @param @throws Exception   
	 * @return Source  
	 * @throws
	 * @date 2015年10月19日
	 */
	public Source getASourceForAutoSay(Map parm) throws Exception{
		String sql = "select id,title,trim(content) as content,url,type,ifcheck,time from source"
				+ " where id>(select num from myindex where type=?)"
				+ " and ifcheck=1"
				+ " limit 0,1";
		try{
			return jdbcTemplate.queryForObject(sql, new Object[]{parm.get("type") }, new BeanPropertyRowMapper<Source>(Source.class));
		}catch(Exception e){
			return null;
		}
	}
	/**
	 * @Description:更改index 
	 * @param @param parm
	 * @param @return
	 * @param @throws Exception   
	 * @return int  
	 * @throws
	 * @author Panyk
	 * @date 2015年10月19日
	 */
	public int setMyindex(Source source) throws Exception{
		String sql = "update myindex set num=? where type=?";
		return jdbcTemplate.update(sql, new Object[]{source.getId(), source.getType()} );
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
