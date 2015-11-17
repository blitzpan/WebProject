package com.junxun.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.common.entity.User;
import com.common.service.UserService;
import com.junxun.entity.Res;
@RequestMapping(value="/user")
@Controller
public class UserController{
	Logger log = Logger.getLogger(UserController.class);
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/isLogin")
	@ResponseBody  
	public Object isLogin(HttpSession session){
		Res res = new Res();
		try{
			String uid = (String) session.getAttribute("USERID");
			if(uid!=null&&!uid.trim().equals("")){
				res.setSuccessed(uid);
			}else{
				res.setFailed("请登录后再投稿！");
			}
		}catch(Exception e){
			log.error("isLogin", e);
			res.setFailed("系统出现异常，请稍后再次尝试！");
		}
        return res;  
	}
	@RequestMapping(value="/login")
	@ResponseBody
	public Object login(HttpSession session, User user){
		Res res = new Res();
		try{
			System.out.println("name=" + user.getName());
			System.out.println("pw1=" + user.getPassword());
			User resU = userService.queryUser(user);
			if(resU == null){
				res.setFailed("您输入的用户名或密码不正确。");
			}else if(resU.getState()==1){//没通过邮箱验证
				session.setAttribute("USERIDTEMP", resU.getId());
				res.setSuccessed("请激活用户名！","/user/userCheck.action");
			}else{
				session.setAttribute("USERID", resU.getId());
				if(resU.getThird().equals("3")){
					res.setSuccessed("欢迎您！","/junxun/index");
				}else if(resU.getThird().equals("4")){
					res.setSuccessed("欢迎您！","/jiapu/index");
				}
			}
		}catch(Exception e){
			log.error("login", e);
			res.setFailed("系统出现异常，请稍后再次尝试！");
		}
        return res;
	}
	/**
	 * @Description:判断用户名是否已经存在 
	 * @param @param user
	 * @param @return   
	 * @return Object  
	 * @throws
	 * @author Panyk
	 * @date 2015年11月17日
	 */
	@RequestMapping(value="/isExist")
	@ResponseBody
	public Object isExist(User user){
		Res res = new Res();
		try{
			int count = userService.isExist(user);
			if(count>0){
				res.setFailed("用户名已存在，请直接登录！");
			}else{
				res.setSuccessed(null);
			}
		}catch(Exception e){
			log.error("isExist", e);
			res.setFailed("系统出现异常，请稍后再次尝试！");
		}
		return res;
	}
	/**
	 * @Description:注册 
	 * @param @param user
	 * @param @return   
	 * @return Object  
	 * @throws
	 * @author Panyk
	 * @date 2015年11月17日
	 */
	@RequestMapping("/register")
	@ResponseBody
	public Object register(User user, HttpSession session){
		Res res = new Res();
		try{
			int result = userService.register(user);
			if(result > 0){//新增成功
				res.setSuccessed("注册成功！", "/user/userCheck.action");
				session.setAttribute("USERIDTEMP", user.getId());
			}else{//新增失败
				res.setFailed("注册失败！");
			}
		}catch(Exception e){
			log.error("register", e);
			res.setFailed("用户注册发生异常！");
		}
		return res;
	}
	/**
	 * @Description: 用户账户验证
	 * @param @return   
	 * @return MovelAndView  
	 * @throws
	 * @author Panyk
	 * @date 2015年11月17日
	 */
	@RequestMapping(value="/userCheck")
	public ModelAndView userCheck(HttpSession session){
		ModelAndView mv = new ModelAndView();
		Res res = new Res();
		try{
			String userIdTemp = session.getAttribute("USERIDTEMP").toString();
			User parm = new User();
			parm.setId(userIdTemp);
			User user = userService.queryById(parm);
			if(user!=null){
				res.setSuccessed("查询成功！", user);
				if(user.getThird().equals("3")){
					mv.setViewName("/junxun/user/userCheck");
				}else if(user.getThird().equals("4")){
					mv.setViewName("/jiapu/user/userCheck");
				}
			}else{
				res.setFailed("没有查询到当前id的用户信息！");
			}
		}catch(Exception e){
			log.error("userCheck=", e);
			res.setFailed("账户验证出现异常！");
		}
		mv.addObject(res);
		return mv;
	}
}