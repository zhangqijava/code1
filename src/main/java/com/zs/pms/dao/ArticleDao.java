package com.zs.pms.dao;

import java.util.List;

import com.zs.pms.po.Tarticle;

import com.zs.pms.vo.QueryArticle;


public interface ArticleDao {
		//根据条件查询
		public List<Tarticle> queryByCon(QueryArticle article);
		//根据分页查询
		public List<Tarticle> queryByPage(QueryArticle article);
		//根据主键查询
		public Tarticle queryById(int id);
		//批量删除
		public void deleteByIds(int[] ids);
		//修改
		public void update(Tarticle article);
		//添加文章
		public int insert(Tarticle article);
		//删除一条
		public void delete(int id);
		//查询总数
		public int queryCount(QueryArticle article);
}
