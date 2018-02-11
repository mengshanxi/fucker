package com.self.fucker.util;

import java.util.ArrayList;
import java.util.List;

import com.github.pagehelper.PageInfo;

/**
 * 
 * @ClassName: PageList
 * @Description: TODO
 * @author mengshanxi
 * @date 2017年9月13日 下午1:45:13
 * 
 * @param <E>
 */
public class PageList<E> {
	// 默认分页数
	public final static int DEFAULT_PAGESIZE = 20;
	// 总数，展示用
	private long iTotalRecords;
	// 总数，实际数字
	private long total;
	// 过滤后的总数
	private long iTotalDisplayRecords;
	// 每页的数据
	private List<E> aaData;
	// 显示第几页
	private String sEcho;
	// 返回结果标识
	private String resultFlag;

	public PageList() {
	}

	public PageList(PageInfo<E> pageInfo, String echo) {
		this.sEcho = echo;
		if (pageInfo != null) {
			this.resultFlag = "1";
			this.iTotalRecords = pageInfo.getTotal();
			this.total = pageInfo.getTotal();
			this.iTotalDisplayRecords = pageInfo.getTotal();
			this.aaData = pageInfo.getList();
		}
	}

	public PageList(long iTotalRecords, long iTotalDisplayRecords, List<E> aaData, String sEcho) {
		this.iTotalRecords = iTotalRecords;
		this.total = iTotalRecords;
		this.iTotalDisplayRecords = iTotalDisplayRecords;
		this.aaData = aaData;
		this.sEcho = sEcho;
	}

	public List<E> getAaData() {
		if (this.aaData == null) {
			return new ArrayList<E>();
		}
		return aaData;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public void setAaData(List<E> aaData) {
		this.aaData = aaData;
	}

	public long getiTotalRecords() {
		return iTotalRecords;
	}

	public void setiTotalRecords(long iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
	}

	public long getiTotalDisplayRecords() {
		return iTotalDisplayRecords;
	}

	public void setiTotalDisplayRecords(long iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}

	public String getsEcho() {
		return sEcho;
	}

	public void setsEcho(String sEcho) {
		this.sEcho = sEcho;
	}

	public String getResultFlag() {
		return resultFlag;
	}

	public void setResultFlag(String resultFlag) {
		this.resultFlag = resultFlag;
	}

}
