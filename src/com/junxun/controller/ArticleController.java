package com.junxun.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.junxun.entity.Article;
import com.junxun.entity.Res;
import com.junxun.service.ArticleService;
@RequestMapping(value="/article")
@Controller
public class ArticleController{
	Logger log = Logger.getLogger(ArticleController.class);
	@Autowired
	private ArticleService articleService;
	@RequestMapping(value="/beforeAddArticle")
	public ModelAndView beforeAddArticle(){
		ModelAndView mv = new ModelAndView();
		Res res = new Res();
		mv.setViewName("/junxun/article/addArticle");
		try{
			
		}catch(Exception e){
			res.setFailed("程序发生异常！");
			log.error("beforeAddArticle", e);
		}
		return mv;
	}
	@RequestMapping(value="/addArticle")
	public ModelAndView addArticle(Article article){
		ModelAndView mv = new ModelAndView();
		Res res = new Res();
		mv.setViewName("/junxun/public/prompt");
		try{
			articleService.addArticle(article);
			res.setSuccessed("新增成功！", 1);
		}catch(Exception e){
			res.setFailed("新增失败！");
			log.error("addArticle", e);
		}
		mv.addObject("res", res);
		mv.addObject("nextPage","/article/beforeAddArticle.action");
		mv.addObject("nextPageBtn","再来一篇");
		return mv;
	}
	
	public ArticleService getArticleService() {
		return articleService;
	}



	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}


}
