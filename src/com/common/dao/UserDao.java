package com.common.dao;

import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.common.entity.User;
import com.utils.StrUtil;
@Repository
public class UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	/**
	 * @Description:根据uid查询一个用户信息 
	 * @param @param user
	 * @param @return
	 * @param @throws Exception   
	 * @return User  
	 * @throws
	 * @author Panyk
	 * @date 2015年10月26日
	 */
	public User queryByUid(User user) throws Exception{
		try{
			String sql = "SELECT * from user WHERE thirduid=? and third =?";
			return jdbcTemplate.queryForObject(sql, new Object[]{user.getThirdUid(),user.getThird() }, new BeanPropertyRowMapper(User.class));
		}catch(Exception e){
			return null;
		}
	}
	/**
	 * @Description: 
	 * @param @param user
	 * @param @return
	 * @param @throws Exception   
	 * @return int  
	 * @throws
	 * @author Panyk
	 * @date 2015年10月26日
	 */
	public int addUser(User user) throws Exception{
		String sql = "INSERT into user(id,third,thirduid,name,nickname,description,imgurl,gender,password,accesstoken,state,securityCode)VALUES(?,?,?,?,?,?,?,?,md5(?),?,?,?)";
		return jdbcTemplate.update(sql, new Object[]{user.getId(), user.getThird(), user.getThirdUid(),user.getName(),user.getNickName(),user.getDescription(),user.getImgUrl(),user.getGender(),user.getPassword(),user.getAccessToken(),user.getState(),user.getSecurityCode() });
	}
	/**
	 * @Description:第三方更新用户信息 
	 * @param @param user
	 * @param @return
	 * @param @throws Exception   
	 * @return int  
	 * @throws
	 * @author Panyk
	 * @date 2015年10月27日
	 */
	public int updateUserForThird(User user) throws Exception{
		String sql = "UPDATE user set name=?,nickname=?,description=?,imgurl=?,gender=?,accesstoken=? WHERE thirdUid=? and third=?";
		return jdbcTemplate.update(sql,new Object[]{user.getName(),user.getNickName(),user.getDescription(),user.getImgUrl(),user.getGender(),user.getAccessToken() ,user.getThirdUid(),user.getThird()});
	}
	/**
	 * @Description:判断用户是否存在 
	 * @param @param user
	 * @param @return   
	 * @return Object  
	 * @throws
	 * @author Panyk
	 * @date 2015年11月17日
	 */
	public int isExist(User user) throws Exception{
		String sql = "select count(*) from user where third =0 and name=?";
		return jdbcTemplate.queryForInt(sql, user.getName());
	}
	/**
	 * @Description:根据用户id查询一个用户的所有信息 
	 * @param @param user
	 * @param @return
	 * @param @throws Exception   
	 * @return User  
	 * @throws
	 * @author Panyk
	 * @date 2015年11月17日
	 */
	public User queryById(User user) throws Exception{
		String sql = "SELECT id,third,name,nickname,state,securitycode from user where id=?";
		User res = null;
		try{
			res = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper(User.class), user.getId());
		}catch(Exception e){
			e.printStackTrace();
		}
		return res;
	}
	/**
	 * @Description:根据条件来查询一个user 
	 * @param @param user
	 * @param @return
	 * @param @throws Exception   
	 * @return User  
	 * @throws
	 * @author Panyk
	 * @date 2015年11月17日
	 */
	public User queryUser(User user) throws Exception{
		StringBuffer sql = new StringBuffer("SELECT id,third,name,nickname,state,securitycode from user where 1=1");
		Vector values = new Vector();
		User res = null;
		try{
			if(!StrUtil.isBlank(user.getId())){
				sql.append(" and id=?");
				values.add(user.getId());
			}
			if(!StrUtil.isBlank(user.getName())){
				sql.append(" and name=?");
				values.add(user.getName());
			}
			if(!StrUtil.isBlank(user.getPassword())){
				sql.append(" and password=md5(?)");
				values.add(user.getPassword());
			}
			if(!StrUtil.isBlank(user.getThird())){
				sql.append(" and third=?");
				values.add(user.getThird());
			}
			sql.append(" limit 0,1");
			System.out.println(sql.toString());
			
			res = jdbcTemplate.queryForObject(sql.toString(), values.toArray(), new BeanPropertyRowMapper(User.class));
		}catch(Exception e){
			e.printStackTrace();
		}
		return res;
	}
	/**
	 * @Description: 帐号激活
	 * @param @param id
	 * @param @param securityCode
	 * @param @return   
	 * @return Object  
	 * @throws
	 * @author Panyk
	 * @date 2015年11月18日
	 */
	public Object activation(User user) throws Exception{
		String sql = "update user set state=0,securityCode='' where id=? and securityCode=?";
		return jdbcTemplate.update(sql, user.getName(), user.getSecurityCode());
	}
}