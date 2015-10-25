package com.junxun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.junxun.dao.ArticleDao;
import com.junxun.entity.Article;
import com.junxun.util.Page;
import com.junxun.util.QueryParm;

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
	/**
	 * @Description:获取翻页文章 
	 * @param @param page
	 * @param @return
	 * @param @throws Exception   
	 * @return List  
	 * @throws
	 * @author Panyk
	 * @date 2015年10月21日
	 */
	public List getAllArticle(Page page, QueryParm qp) throws Exception{
		return articleDao.getAllArticle(page, qp);
	}
}
