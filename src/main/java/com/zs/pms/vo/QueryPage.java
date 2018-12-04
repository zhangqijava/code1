package com.zs.pms.vo;

import com.zs.pms.util.Constants;

public class QueryPage {
	//起始条数
	protected int start;
	//终止条数
	protected int end;
	//当前页数
	protected int page;
	public int getStart() {
		//（page-1）*每页条数+1
		return (page-1)*Constants.PAGECOUNT+1;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return page*Constants.PAGECOUNT;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
}
