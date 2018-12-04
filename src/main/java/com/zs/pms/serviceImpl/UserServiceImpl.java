package com.zs.pms.serviceImpl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zs.pms.dao.UserDao;
import com.zs.pms.exception.AppException;
import com.zs.pms.po.TuserPO;
import com.zs.pms.service.UserService;
import com.zs.pms.util.Constants;
import com.zs.pms.util.MD5;
import com.zs.pms.vo.queryUser;
@Service
@Transactional
public class UserServiceImpl implements UserService{
@Autowired
private UserDao dao;
	public TuserPO chkLogin(queryUser user) throws AppException {
		//将明码变成密码
		MD5 md5=new MD5();
		String p1 = md5.getMD5ofStr(user.getPassword());
		// TODO Auto-generated method stub
		List<TuserPO> users=dao.queryByCon(user);
		//进行判断，如果集合为空，说明数据库没有相应的登录名和密码信息，则提示用户名密码不正确
		if (users==null||users.size()!=1) {
			throw new AppException(1000, "用户名或密码不正确，请重新输入");
		}
		TuserPO user1 = users.get(0);
		//用户名，密码正确，则返回集合的第一条数据
		return dao.queryById(user1.getId());
	}
	/*
	 * 根据条件查询
	 * */
	public List<TuserPO> queryByCon(queryUser user) throws AppException{
		return dao.queryByCon(user);
	}
	/**
	 * @param ids
	 * 批量删除
	 */
	@Override
	@Transactional(rollbackFor=Exception.class)//有异常就回滚
	public void deleteByIds(int[] ids) {
		// TODO Auto-generated method stub
		dao.deleteByIds(ids);
	}
	/**
	 * 用户修改
	 * @param user
	 * @throws AppException
	 */
	/*
	 * 
	 * 用户修改
	 * */
	@Override
	@Transactional(rollbackFor=Exception.class)//有异常就回滚
	public void update(TuserPO user) throws AppException {
		if (user.getPassword()!=null&&(!"".equals(user.getPassword()))) {
			//密码加密
			MD5 md5=new MD5();
			user.setPassword(md5.getMD5ofStr(user.getPassword()));
		}
		dao.update(user);
	}
	/* (non-Javadoc)
	 * @see com.zs.pms.service.UserService#insert(com.zs.pms.po.TuserPO)
	 * 用户新增
	 */
	@Override
	@Transactional(rollbackFor=Exception.class)//有异常就回滚
	public int insert(TuserPO user) throws AppException {
		// TODO Auto-generated method stub
		return dao.insert(user);
	}
	/*
	 * 删除一条
	 * */
	@Override
	public void deleteById(int id) throws AppException {
		// TODO Auto-generated method stub
		dao.delete(id);
		
		
	}
	@Override
	public List<TuserPO> queryByPage(queryUser query, int page) {
		// TODO Auto-generated method stub
		query.setPage(page);
		return dao.queryByPage(query);
	}
	@Override
	public int queryByCount(queryUser query) {
		// TODO Auto-generated method stub
		int count=dao.queryCount(query);
		//判断是否能整除
		if (count%Constants.PAGECOUNT==0) {
			return count/Constants.PAGECOUNT;
		} else {
			return count/Constants.PAGECOUNT+1;
		}
		
	}
	
	
	
}
