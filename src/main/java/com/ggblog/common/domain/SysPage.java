package com.ggblog.common.domain;

import java.util.List;

/**
 * 分页类
 * @author 44359
 *
 * @param <T>
 */
public class SysPage<T> {
	private int pageNum; //当前页数
	private int totalCount;  //总记录数
	private int totalPage;  //总页数
	private int pageSize;   //每页显示的记录数
	private List<T> list; //每页显示数据记录的集合
	
	private boolean isNext; //是否由上一页
	private boolean isPrev; //是否由下一页
	
	public SysPage() {
		
	}
	

	public SysPage(int pageNum, int totalCount, int totalPage, int pageSize, List<T> list, boolean isNext,
			boolean isPrev) {
		super();
		this.pageNum = pageNum;
		this.totalCount = totalCount;
		this.totalPage = totalPage;
		this.pageSize = pageSize;
		this.list = list;
		this.isNext = isNext;
		this.isPrev = isPrev;
	}

	public SysPage(int pageNum,int pageSize) {
		this.pageNum = pageNum;
		this.pageSize = pageSize;
	}



	/**
	 * @return the pageNum
	 */
	public int getPageNum() {
		return pageNum;
	}


	/**
	 * @param pageNum the pageNum to set
	 */
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}










	/**
	 * @return the totalCount
	 */
	public int getTotalCount() {
		return totalCount;
	}

	/**
	 * @param totalCount the totalCount to set
	 */
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	/**
	 * @return the totalPage
	 */
	public int getTotalPage() {
		return totalPage;
	}

	/**
	 * @param totalPage the totalPage to set
	 */
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return the list
	 */
	public List<T> getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(List<T> list) {
		this.list = list;
	}

	/**
	 * @return the isNext
	 */
	public boolean isNext() {
		return isNext;
	}

	/**
	 * @param isNext the isNext to set
	 */
	public void setNext(boolean isNext) {
		this.isNext = isNext;
	}

	/**
	 * @return the isPrev
	 */
	public boolean isPrev() {
		return isPrev;
	}

	/**
	 * @param isPrev the isPrev to set
	 */
	public void setPrev(boolean isPrev) {
		this.isPrev = isPrev;
	}

  
	
	
	
}
