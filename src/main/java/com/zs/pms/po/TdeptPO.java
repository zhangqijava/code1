package com.zs.pms.po;

import java.io.Serializable;

public class TdeptPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2180189160750302380L;
	
	//部门编号
	private int id;
	//部门名称
	private String dname;
	//上级部门
	private int pid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	
}
