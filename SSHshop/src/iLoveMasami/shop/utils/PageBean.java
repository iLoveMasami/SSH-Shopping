package iLoveMasami.shop.utils;

import java.util.List;

/**
 * 分页类
 * @author iLoveMasami
 * @date   2018年1月30日 下午1:58:21
 */
public class PageBean<T> {
	//当前页数
	private int page;
	//总记录数
	private int totalCount;
	//总页数
	private int totalPage;
	//每页显示的记录数
	private int limit;
	//每页显示的集合
	private List<T> list;
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
}
