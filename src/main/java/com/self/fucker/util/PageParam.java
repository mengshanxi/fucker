package com.self.fucker.util;

import java.util.HashMap;

/**
 * 
 * @ClassName: PageParam
 * @Description: TODO
 * @author mengshanxi
 * @date 2017年9月13日 下午12:01:08
 *
 */
public class PageParam {
	private String sEcho;
	private int offset;// 本页开始下标
	private int pageSize;// 每页显示记录数
	private String orderBy;// 排序列+排序方式

	public PageParam() {
		super();
	}

	public PageParam(String jsonStr) {
		HashMap<String, Object> param = DatatableParamUtil.decodeParam(jsonStr);
		// 查询开始角标
		if (null == param.get("iDisplayStart") || ("").equals(param.get("iDisplayStart"))) {
			this.offset = 0;
		} else {
			this.offset = Integer.parseInt(param.get("iDisplayStart").toString());
		}
		// 查询分页大小
		if (null == param.get("iDisplayLength") || ("").equals(param.get("iDisplayLength"))) {
			// 默认分页大小
			this.pageSize = Constants.PAGE_SIZE;
		} else {
			this.pageSize = Integer.parseInt(param.get("iDisplayLength").toString());
		}
		String sortCol = "";
		// 排序列
		if (null == param.get("iSortCol_0") || ("").equals(param.get("iSortCol_0"))) {
			// 非PC端请求
			if (null == param.get("sortCol") || ("").equals(param.get("sortCol"))) {
				param.remove("sortCol");
			} else {
				sortCol = param.get("sortCol").toString();
			}
		} else {
			String sortColParam = param.get("mDataProp_" + param.get("iSortCol_0").toString()).toString();
			sortCol = Converter.propToColumn(sortColParam);
		}
		if (StringUtils.isNotEmpty(sortCol) && !"index".equals(sortCol)) {
			// 排序方式
			if (null == param.get("sort") || ("").equals(param.get("sort"))) {
				this.orderBy = sortCol + " " + param.get("sSortDir_0").toString();
			}
		}

		if (null == param.get("sEcho") || ("").equals(param.get("sEcho"))) {
			this.sEcho = "0";
		} else {
			this.sEcho = param.get("sEcho").toString();
		}
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getsEcho() {
		return sEcho;
	}

	public void setsEcho(String sEcho) {
		this.sEcho = sEcho;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

}
