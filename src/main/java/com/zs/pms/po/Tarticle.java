package com.zs.pms.po;

import java.io.Serializable;
import java.util.Date;

public class Tarticle implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5819329460147285907L;
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String title;
    private String content;
    private String author;
    private Date creatime;
    private int channel;
    private int isrecommend;
    private int ishot;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getCreatime() {
		return creatime;
	}
	public void setCreatime(Date creatime) {
		this.creatime = creatime;
	}
	public int getChannel() {
		return channel;
	}
	public void setChannel(int channel) {
		this.channel = channel;
	}
	public int getIsrecommend() {
		return isrecommend;
	}
	public void setIsrecommend(int isrecommend) {
		this.isrecommend = isrecommend;
	}
	public int getIshot() {
		return ishot;
	}
	public void setIshot(int ishot) {
		this.ishot = ishot;
	}
    
}
