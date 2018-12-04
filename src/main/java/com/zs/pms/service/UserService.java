package com.zs.pms.service;



import java.util.List;

import com.zs.pms.exception.AppException;
import com.zs.pms.po.TuserPO;
import com.zs.pms.vo.queryUser;

public interface UserService {
	//登陆验证
	public TuserPO chkLogin(queryUser user) throws AppException;
	//批量删除
	public void deleteByIds(int[] ids);
	//用户修改
	public void update(TuserPO user) throws AppException;
	//根据条件查询
	public List<TuserPO> queryByCon (queryUser user) throws AppException;
	//用户新增
	public int insert(TuserPO user) throws AppException;
	//删除一条用户
	public void deleteById(int id) throws AppException;
	//分页查询
	public List<TuserPO> queryByPage(queryUser query,int page);
	//获得总页数
	public int queryByCount(queryUser query);
	
	
}
