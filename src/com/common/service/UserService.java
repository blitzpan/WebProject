package com.common.service;

import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.dao.UserDao;
import com.common.entity.User;
import com.utils.StrUtil;
@Service
public class UserService {
	Logger log = Logger.getLogger(UserService.class);
	@Autowired
	private UserDao userDao;
	/**
	 * @Description:微博用户登录 
	 * @param @param user
	 * @param @return
	 * @param @throws Exception   
	 * @return User  
	 * @throws
	 * @author Panyk
	 * @date 2015年10月26日
	 */
	public User weiboLogin(User user) throws Exception{
		User u = userDao.queryByUid(user);
		if(u == null){//不存在，入库
			UUID uuid = UUID.randomUUID();
			user.setId(uuid.toString().replaceAll("-", ""));
			userDao.addUser(user);
		}else{//已存在，更新
			user.setId(u.getId());
			userDao.updateUserForThird(user);
		}
		return user;
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
		return userDao.isExist(user);
	}
	/**
	 * @Description:普通用户注册 
	 * @param @param user
	 * @param @return
	 * @param @throws Exception   
	 * @return int  
	 * @throws
	 * @author Panyk
	 * @date 2015年11月17日
	 */
	public int register(User user) throws Exception{
		user.setId(StrUtil.getUUID());
		user.setSecurityCode(StrUtil.getUUID());
		return userDao.addUser(user);
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
		return userDao.queryById(user);
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
		return userDao.queryUser(user);
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
		return userDao.activation(user);
	}
}
