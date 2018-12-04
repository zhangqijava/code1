package com.zs.pms.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Tpermission implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -35412919658786676L;
	private int id;
	private String pname;
	private int pid;
	private int lev;
	private int isleaf;
	private String url;
	private String con;
	private List<Tpermission> children=new ArrayList<>();
	public List<Tpermission> getChildren() {
		return children;
	}
	public void setChildren(List<Tpermission> children) {
		this.children = children;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getLev() {
		return lev;
	}
	public void setLev(int lev) {
		this.lev = lev;
	}
	public int getIsleaf() {
		return isleaf;
	}
	public void setIsleaf(int isleaf) {
		this.isleaf = isleaf;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getCon() {
		return con;
	}
	public void setCon(String con) {
		this.con = con;
	}
}
