package com.junxun.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.common.entity.User;
import com.common.service.UserService;
import com.common.utils.SendMailUtils;
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
			User resU = userService.queryUser(user);
			if(resU == null){
				res.setFailed("您输入的用户名或密码不正确。");
			}else if(resU.getState()==1){//没通过邮箱验证
				session.setAttribute("USERIDTEMP", resU.getId());
				res.setSuccessed("请激活用户名！","/user/userCheck.action");
			}else{
				session.setAttribute("USERID", resU.getId());
				session.setAttribute("USERNAME", resU.getNickName());
				session.setAttribute("THIRD", resU.getThird());
				if(resU.getThird().equals("3")){
					res.setSuccessed("欢迎您！","/junxun/index.jsp");
				}else if(resU.getThird().equals("4")){
					res.setSuccessed("欢迎您！","/jiapu/index.jsp");
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
	@RequestMapping(value="/sendEmail")
	@ResponseBody
	public Object sendEmail(HttpSession session){
		Res res = new Res();
		try {
			User user = new User();
			user.setId((String)session.getAttribute("USERIDTEMP"));
			User resU = userService.queryUser(user);
			if(resU == null){
				res.setFailed("没有查询到用户信息！");
			}else{
				String time = (String)session.getAttribute("REGISTERTIME");
				Calendar now = Calendar.getInstance(); 
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				String nowStr = sdf.format(now.getTime());
				if(time==null || time.compareTo(nowStr)<0){
//					String url = "http://www.junxun.win/user/activation.action?id="+resU.getId()+"&securityCode="+resU.getSecurityCode();
					String url = "http://127.0.0.1:8080/user/activation.action?id="+resU.getId()+"&securityCode="+resU.getSecurityCode();
					SendMailUtils smu = new SendMailUtils(resU.getName(), url);
					smu.start();
					now.add(Calendar.MINUTE, 3);
					session.setAttribute("REGISTERTIME", sdf.format(now.getTime()));
					res.setSuccessed("已发送！" + sdf.format(now.getTime()), "已发送！" + sdf.format(now.getTime()));
				}else{
					res.setFailed("发送过于频繁，请在'"+time+"'之后进行发送！");
				}
			}
		} catch (Exception e) {
			log.error("sendEmail", e);
			res.setFailed("程序出现异常，请稍后再试！");
		}
		return res;
	}
	@RequestMapping(value="/activation")
	public ModelAndView activation(RedirectAttributes attr, String id, String securityCode,String third){
		ModelAndView mv = new ModelAndView();
		Res res = new Res();
		try{
			if(id == null || id.trim().equals("") || securityCode == null || securityCode.trim().equals("")){
				res.setFailed("激活链接出现问题，请重新发送激活邮件。");
			}else{
				User user = new User();
				user.setName(id);
				user.setSecurityCode(securityCode);
				int upC = (Integer)userService.activation(user);
				if(upC>0){
					res.setSuccessed("激活成功，请登录！", "激活成功，请登录！");
				}else{
					res.setFailed("已经成功激活或激活链接出现问题。");
				}
			}
		}catch(Exception e){
			log.error("activation", e);
			res.setFailed("帐号激活程序发生异常！");
		}
		String index;
		mv.addObject(res);
		mv.setViewName("/public/activationResult");
		return mv;
	}
}