package com.zs.pms.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TuserPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3019125219818306191L;
	private int id;
	private String loginname;
	private String password;
	private int isenabled;
	public int getIsenabled() {
		return isenabled;
	}
	public void setIsenabled(int isenabled) {
		this.isenabled = isenabled;
	}
	private String sex;
	private Date birthday;
	private String email;
	private String isenableTxt;
	public String getIsenableTxt() {
		if (isenabled==1) {
			return "可用";
		}
		return "不可用";
	}
	
	//一对多关联
	private List<Tpermission> permissions;
	
	public List<Tpermission> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<Tpermission> permissions) {
		this.permissions = permissions;
	}
	//部门关联
	private TdeptPO dep;
	//左侧菜单，由permission整理出来
	private List<Tpermission> menu=new ArrayList<>();
	public List<Tpermission> getMenu() {
		//清空
		menu.clear();
		for (Tpermission per1 : permissions) {
			//判断pid，如果pid=0，说明为一级菜单
			if (per1.getPid()==0) {
				//遍历二级菜单
				//如果二级菜单的pid等于一级菜单的id，说明该菜单为一级菜单
				for(Tpermission per2:permissions){
					if (per2.getPid()==per1.getId()) {
						//将权限菜单放到一级权限的子菜单中
						per1.getChildren().add(per2);
					}
				}
				//将装集好的一级菜单放到集合中
				menu.add(per1);
			}
		}
		
		return menu;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public TdeptPO getDep() {
		return dep;
	}
	public void setDep(TdeptPO dep) {
		this.dep = dep;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public int getCreator() {
		return creator;
	}
	public void setCreator(int creator) {
		this.creator = creator;
	}
	public Date getCreatime() {
		return creatime;
	}
	public void setCreatime(Date creatime) {
		this.creatime = creatime;
	}
	public int getUpdator() {
		return updator;
	}
	public void setUpdator(int updator) {
		this.updator = updator;
	}
	public Date getUpdatime() {
		return updatime;
	}
	public void setUpdatime(Date updatime) {
		this.updatime = updatime;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	private String realname;
	private int creator;
	private Date creatime;
	private int updator;
	private Date updatime;
	private String pic;
}
