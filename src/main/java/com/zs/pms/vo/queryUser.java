package com.zs.pms.vo;
/*
 * 			根据条件查询，当有多个条件时，需要进行封装
 * 
 * */
public class queryUser extends QueryPage{
	//登陆名
	private String loginname;
	//密码
	private String password;
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
