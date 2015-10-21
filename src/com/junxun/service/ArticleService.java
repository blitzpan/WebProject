package com.junxun.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.junxun.dao.ArticleDao;
import com.junxun.entity.Article;

@Service
@Transactional
public class ArticleService {
	@Autowired
	private ArticleDao articleDao;
	/**
	 * @Description:插入一篇新的文章 
	 * @param @param article
	 * @param @return
	 * @param @throws Exception   
	 * @return int  
	 * @throws
	 * @author Panyk
	 * @date 2015年10月20日
	 */
	public int addArticle(Article article) throws Exception{
		if(article.getUid().equals("0")){//如果匿名，那么文章审核之后可以查看
			article.setState("0");
		}
		return articleDao.addArticle(article);
	}
}
