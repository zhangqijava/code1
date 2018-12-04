package com.zs.pms.article.service;

import java.util.List;

import com.zs.pms.exception.AppException;
import com.zs.pms.po.Tarticle;

import com.zs.pms.vo.QueryArticle;


public interface ArticleService {
	//批量删除
		public void deleteByIds(int[] ids);
		//文章修改
		public void update(Tarticle tarticle) throws AppException;
		//根据条件查询
		public List<Tarticle> queryByCon (QueryArticle query) throws AppException;
		//用户新增
		public int insert(Tarticle tarticle) throws AppException;
		//删除一条用户
		public void deleteById(int id) throws AppException;
		//分页查询
		public List<Tarticle> queryByPage(QueryArticle query,int page)throws AppException;
		//获得总页数
		public int queryByCount(QueryArticle query) throws AppException;
}
