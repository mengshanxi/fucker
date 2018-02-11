package com.self.fucker.util;


import java.util.List;

import com.github.pagehelper.Page;

/**
 * 基础分页展示类，包含index属性
 * 
 * @author 
 *
 */
public class BasePageBean {
	private Integer index;// 序号

	public BasePageBean() {
		super();
	}

	public BasePageBean(int index) {
		this.index = index;
	}

	/**
	 * 给某个列表增加序号的方法
	 * 
	 */
	public static void addIndexForList(List<? extends BasePageBean> list) {
		Page<?> pageList = null;
		int pageZeroIndex = 0;
		try {
			pageList = (Page<?>) list;
			int pageNum = pageList.getPageNum();
			int pageSize = pageList.getPageSize();
			pageZeroIndex = pageSize * (pageNum - 1);
		} catch (Exception e) {
		}
		if (list != null && list.size() > 0) {
			int size = list.size();
			for (int index = 0; index < size; index++) {
				BasePageBean bean = list.get(index);
				bean.setIndex(++pageZeroIndex);
			}
		}
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

}
