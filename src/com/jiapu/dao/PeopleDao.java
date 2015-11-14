package com.jiapu.dao;

import java.util.List;
import java.util.UUID;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jiapu.entity.People;
import com.utils.StrUtil;

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
		String sql = "select * from jp_people where state=1";
		Vector values = new Vector();
		sql += " order by level asc, fid,birth asc";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper(People.class), values.toArray());
	}
	/**
	 * @Description:新增一个人员 
	 * @param @param p
	 * @param @return
	 * @param @throws Exception   
	 * @return int  
	 * @throws
	 * @author Panyk
	 * @date 2015年11月13日
	 */
	public int addPeople(People p) throws Exception{
		String sql = "insert into jp_people(id,fid,name,birth,sex,summary,moddate) values(?,?,?,?,?,?,now())";
		Vector values = new Vector();
		values.add(p.getId());
		values.add(p.getFid());
		values.add(p.getName());
		if(p.getBirth().trim().equals("")){
			values.add(null);
		}else{
			values.add(p.getBirth());
		}		
		values.add(p.getSex());
		values.add(p.getSummary());
		return jdbcTemplate.update(sql, values.toArray());
	}
	/**
	 * @Description:删除 
	 * @param @param p
	 * @param @return
	 * @param @throws Exception   
	 * @return int  
	 * @throws
	 * @author Panyk
	 * @date 2015年11月13日
	 */
	public int delPeople(People p) throws Exception{
		String sql = "update jp_people set state=0,moddate=now() WHERE id=?"
				+ " and not EXISTS ("
				+ " select * from (SELECT * from jp_people WHERE fid=? and state=1) t"
				+ " )";
		return jdbcTemplate.update(sql, p.getId(),p.getId());
	}
	/**
	 * @Description:更新 
	 * @param @param p
	 * @param @return
	 * @param @throws Exception   
	 * @return int  
	 * @throws
	 * @author Panyk
	 * @date 2015年11月13日
	 */
	public int upPeople(People p) throws Exception{
		String sql = "update jp_people set moddate=now(),fid=? where id=?";
		return jdbcTemplate.update(sql, p.getFid(), p.getId());
	}
	/**
	* 基本功能：用户基本信息和详细信息修改
	* 编    者：潘宜奎
	* 完成日期：2015年11月14日
	* 修改内容：
	* @param 
	* @return 
	* @throws
	 */
	public int upPeople(People p, String upType) throws Exception{
		if(upType!=null && upType.trim().equals("basic")){//修改基本信息
			if(p.getBirth()!=null && !p.getBirth().trim().equals("")){
				String sql = "update jp_people set moddate=now(),name=?,birth=?,sex=?,summary=? where id=?";
				System.out.println(sql);
				return jdbcTemplate.update(sql, p.getName(),p.getBirth(), p.getSex(),p.getSummary(), p.getId());
			}else{
				String sql = "update jp_people set moddate=now(),name=?,sex=?,summary=? where id=?";
				System.out.println(sql);
				return jdbcTemplate.update(sql, p.getName(), p.getSex(),p.getSummary(), p.getId());
			}
		}else if(upType!=null && upType.trim().equals("desc")){//修改详细信息
			String sql = "update jp_people set moddate=now(),des=? where id=?";
			System.out.println(sql);
			return jdbcTemplate.update(sql, p.getDes(), p.getId());
		}
		return 0;
	}
	/**
	 * @Description:查询一个people 
	 * @param @param p
	 * @param @return
	 * @param @throws Exception   
	 * @return People  
	 * @throws
	 * @author Panyk
	 * @date 2015年11月13日
	 */
	public People queryOnePeople(People p) throws Exception{
		String sql = "select id,fid,name,age,sex,summary,des,date_format(birth,'%Y-%m-%d') birth from jp_people where id=?";
		People res = new People();
		try{
			res = jdbcTemplate.queryForObject(sql, new Object[]{p.getId()}, new BeanPropertyRowMapper(People.class) );
		}catch(Exception e){
			e.printStackTrace();
			res = new People();
			res.setName("您所查询的信息不存在！");
		}
		return res;
	}
}