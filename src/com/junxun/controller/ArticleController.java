package com.junxun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.junxun.entity.Article;
import com.junxun.entity.Res;
import com.junxun.service.ArticleService;

@Controller
public class ArticleController{
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping(value="/addArticle", method=RequestMethod.GET)
	public ModelAndView addArticle(@ModelAttribute("article") Article article){
System.out.println("addArticle********************************");
System.out.println("article.id" + article.getId());
System.out.println("article.title" + article.getTitle());
		ModelAndView mv = new ModelAndView();
		Res res = new Res();
		mv.setViewName("index");
		try{
			articleService.addArticle(article);
			res.setSuccessed("新增成功！", 1);
		}catch(Exception e){
			res.setFailed("新增失败！");
		}
		mv.addObject("res", res);
		return mv;
	}
	
	
	
	@RequestMapping("/listContent")
	public ModelAndView listContent(){
		try{
			
		}catch(Exception e){
			e.printStackTrace();
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", "hello world!");
		mv.setViewName("index");
		return mv;
	}



	public ArticleService getArticleService() {
		return articleService;
	}



	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}


}
