package com.junxun.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.junxun.entity.Article;
import com.junxun.entity.Res;
import com.junxun.service.ArticleService;
import com.junxun.util.Page;
import com.junxun.util.QueryParm;
@RequestMapping(value="/article")
@Controller
public class ArticleController{
	Logger log = Logger.getLogger(ArticleController.class);
	@Autowired
	private ArticleService articleService;
	
	/**
	 * @Description:新增文章之前
	 * @param @return   
	 * @return ModelAndView  
	 * @throws
	 * @author Panyk
	 * @date 2015年10月21日
	 */
	@RequestMapping(value="/beforeAddArticle")
	public ModelAndView beforeAddArticle(HttpSession session){
		ModelAndView mv = new ModelAndView();
		Res res = new Res();
		try{
			String uid = (String) session.getAttribute("USERID");
			if(uid!=null&&!uid.trim().equals("")){
				mv.setViewName("/junxun/article/addArticle");
			}else{
				res.setFailed("请登录后再投稿！");
				mv.setViewName("/junxun/public/prompt");
			}
		}catch(Exception e){
			res.setFailed("程序发生异常！");
			log.error("beforeAddArticle", e);
		}
		mv.addObject("res", res);
		return mv;
	}
	/**
	 * @Description:新增文章 
	 * @param @param article
	 * @param @return   
	 * @return ModelAndView  
	 * @throws
	 * @author Panyk
	 * @date 2015年10月21日
	 */
	@RequestMapping(value="/addArticle")
	public ModelAndView addArticle(Article article, HttpSession session){
		ModelAndView mv = new ModelAndView();
		Res res = new Res();
		mv.setViewName("/junxun/public/prompt");
		try{
			String uid = (String) session.getAttribute("USERID");
			if(uid!=null&&!uid.trim().equals("")){
				article.setUid(uid);
				articleService.addArticle(article);
				res.setSuccessed("新增成功！", 1);
			}else{
				res.setFailed("请登录后再投稿！");
			}
		}catch(Exception e){
			res.setFailed("新增失败！");
			log.error("addArticle", e);
		}
		mv.addObject("res", res);
		mv.addObject("nextPage","/article/beforeAddArticle.action");
		mv.addObject("nextPageBtn","再来一篇");
		return mv;
	}
	/**
	 * @Description:获取所有文章 
	 * @param @return   
	 * @return ModelAndView  
	 * @throws
	 * @author Panyk
	 * @date 2015年10月21日
	 */
	/*
	//这是用url传参
	@RequestMapping(value="/getAllArticle/{menu}")
	public ModelAndView getAllArticle(Page page,@PathVariable String menu){
		System.out.println("**************"+ menu);
	*/
	@RequestMapping(value="/getAllArticle")
	public ModelAndView getAllArticle(Page page,QueryParm qp){
		ModelAndView mv = new ModelAndView();
		Res res = new Res();
		try{
			res.setSuccessed("翻页查询成功！", articleService.getAllArticle(page, qp));
		}catch(Exception e){
			res.setFailed("翻页查询异常！");
			log.error("getAllArticle", e);
		}
		mv.setViewName("/junxun/public/articleList");
		mv.addObject("res",res);
		mv.addObject("page", page);
		return mv;
	}
	@RequestMapping(value="/showArticle")
	public ModelAndView showArticle(Article article){
		ModelAndView mv = new ModelAndView();
		Res res = new Res();
		try{
			res.setSuccessed(articleService.getArticle(article));
		}catch(Exception e){
			res.setFailed("发生异常！");
			log.error("showArticle", e);
		}
		mv.setViewName("/junxun/article/article");
		mv.addObject("res", res);
		return mv;
	}
	/**
	 * @Description:获取最近文章 
	 * @param @return   
	 * @return ModelAndView  
	 * @throws
	 * @author Panyk
	 * @date 2015年11月6日
	 */
	@RequestMapping(value="/getRecentArtical")
	public ModelAndView getRecentArtical(Page page,QueryParm qp){
		ModelAndView mv = new ModelAndView();
		Res res = new Res();
		try{
			res.setSuccessed("最近文章查询成功！", articleService.getAllArticle(page, qp));
		}catch(Exception e){
			res.setFailed("最近文章查询查询异常！");
			log.error("getRecentArtical", e);
		}
		mv.setViewName("/junxun/public/recentPage");
		mv.addObject("res",res);
		return mv;
	}
	public ArticleService getArticleService() {
		return articleService;
	}
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
}