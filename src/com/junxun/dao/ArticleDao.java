package com.junxun.dao;

import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.junxun.entity.Article;
import com.junxun.util.Page;
import com.junxun.util.PageUtil;
import com.junxun.util.QueryParm;
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
	/**
	 * @Description:获取所有文章信息 
	 * @param @param page
	 * @param @return
	 * @param @throws Exception   
	 * @return List  
	 * @throws
	 * @author Panyk
	 * @date 2015年10月21日
	 */
	public List getAllArticle(Page page, QueryParm qp) throws Exception{
		String sql = "SELECT * from jx_article where 1=1";
		Vector values = new Vector();
		if(qp.getMenu()!=null && qp.getMenu().equals("index")){
			
		}else if(qp.getMenu() != null){
			sql += " and type like ?";
			values.add("%"+qp.getMenu()+"%");
		}
		if(qp.getTag() != null){
			sql += " and tag like ?";
			values.add("%"+qp.getTag()+"%");
		}
		page.setTotalCount(jdbcTemplate.queryForObject(PageUtil.appendCount(sql), Integer.class, values.toArray()));
		return jdbcTemplate.query(PageUtil.appendPage(page, sql), new BeanPropertyRowMapper(Article.class), values.toArray());
	}
}
