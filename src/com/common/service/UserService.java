package com.common.service;

import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.dao.UserDao;
import com.common.entity.User;
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

}
