package com.zs.pms.article.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zs.pms.article.service.ArticleService;
import com.zs.pms.dao.ArticleDao;
import com.zs.pms.exception.AppException;
import com.zs.pms.po.Tarticle;
import com.zs.pms.util.Constants;
import com.zs.pms.vo.QueryArticle;
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService{
@Autowired
ArticleDao dao;
	@Override
	@Transactional(rollbackFor=Exception.class)//有异常就回滚
	public void deleteByIds(int[] ids) {
		// TODO Auto-generated method stub
		dao.deleteByIds(ids);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)//有异常就回滚
	public void update(Tarticle tarticle) throws AppException {
		// TODO Auto-generated method stub
		dao.update(tarticle);
	}

	@Override
	public List<Tarticle> queryByCon(QueryArticle query) throws AppException {
		// TODO Auto-generated method stub
		return dao.queryByCon(query);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)//有异常就回滚
	public int insert(Tarticle tarticle) throws AppException {
		// TODO Auto-generated method stub
		return dao.insert(tarticle);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)//有异常就回滚
	public void deleteById(int id) throws AppException {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	public List<Tarticle> queryByPage(QueryArticle query, int page) throws AppException {
		// TODO Auto-generated method stub
		query.setPage(page);
		
		return dao.queryByPage(query);
	}

	@Override
	public int queryByCount(QueryArticle query) throws AppException {
		// TODO Auto-generated method stub
		int count=dao.queryCount(query);
		if (count%Constants.PAGECOUNT==0) {
			return count/Constants.PAGECOUNT;
		} else {
			return count/Constants.PAGECOUNT+1;
		}
		
	}

}
