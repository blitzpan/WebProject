package com.common.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.common.entity.User;
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
		String sql = "INSERT into user(id,third,thirduid,name,nickname,description,imgurl,gender,password,accesstoken)VALUES(?,?,?,?,?,?,?,?,?,?)";
		return jdbcTemplate.update(sql, new Object[]{user.getId(), user.getThird(), user.getThirdUid(),user.getName(),user.getNickName(),user.getDescription(),user.getImgUrl(),user.getGender(),user.getPassword(),user.getAccessToken() });
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
}