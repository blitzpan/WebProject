package com.junxun.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.junxun.entity.Article;
@Repository
public class ArticleDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
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
	public int addArticle(Article article) throws Exception {
		String sql = "INSERT into jx_article(id,uid,type,title,content,cjsj,state) values(REPLACE(uuid(),'-',''),?,?,?,?,SYSDATE(),?)";
		return jdbcTemplate.update(sql, new Object[]{article.getUid(), article.getType(),article.getTitle(),article.getContent(),article.getState() });
	}
}
