package com.zs.pms.dao;

import java.util.List;

import com.zs.pms.po.TuserPO;
import com.zs.pms.vo.queryUser;

public interface UserDao {
	//根据条件查询
	public List<TuserPO> queryByCon(queryUser user);
	//根据分页查询
	public List<TuserPO> queryByPage(queryUser user);
	//根据主键查询
	public TuserPO queryById(int id);
	//批量删除
	public void deleteByIds(int[] ids);
	//修改
	public void update(TuserPO user);
	//添加用户
	public int insert(TuserPO user);
	//删除一条
	public void delete(int id);
	//查询总数
	public int queryCount(queryUser user);
	
}
