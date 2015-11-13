package com.jiapu.dao;

import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jiapu.entity.People;

@Repository
public class PeopleDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	/**
	 * @Description:查询所有people信息
	 * @param @param people
	 * @param @return
	 * @param @throws Exception   
	 * @return List<People>  
	 * @throws
	 * @author Panyk
	 * @date 2015年11月13日
	 */
	public List<People> queryAllPeople(People people) throws Exception{
		String sql = "select * from jp_people where 1=1";
		Vector values = new Vector();
		sql += " order by level asc, fid";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper(People.class), values.toArray());
	}
}
