package com.yundongjia.oa.utils;

import java.util.List;

public class UtilPage {
	/*private int pageNum;//当前页码数
	private int pageSize;//每页显示多少条数据
	private int total;//总条数
	private int rowStart;//每页起始第一条数据的索引数
	private int pageCount;//总页码数
	private boolean hasPre;//是否有上一页
	private int prePage;//上一页页码
	private int firstPage;//首页数
	private boolean hasNext;//是否有下一页
	private int nextPage;//下一页页码
	private int lastPage;//最后一个页数
	private int everyPageCount = 10;//每页显示多少页;
	private int everyPageStart;//每页页码起始数
	private int everyPageEnd;//每页页码结束数
	private List dataList;//存储分页后的数据
	
	public UtilPage(String pageNumStr,String pageSizeStr,int total) {
		//由页面获取的当前页码数为字符串对其进行判断并转型。
		this.pageNum = Integer.parseInt(pageNumStr == null ? "1":pageNumStr);
		//由页面获取的每页显示数据的条数对其判断以及转型。
		this.pageSize = Integer.parseInt((String) (pageSizeStr == null ? "10":pageSizeStr));
		this.total = total;
		//每页起始第一条数据的索引数 = (当前页数 - 1)*每页显示的条数
		this.rowStart = (this.pageNum - 1) * this.pageSize;
		//总页码数 = （总数据转为浮点型/每页数据条数）向上取整强转为int
		this.pageCount = (int) Math.ceil(total*1.0/pageSize);
		//页码起始数 = 当前页-每页显示的页码数/2 小于1 就赋值为1.大于1则为this.pageNum-this.everyPageCount/2
		this.everyPageStart = (this.pageNum-this.everyPageCount/2)<1 ? 1 : this.pageNum-this.everyPageCount/2;
		//页码结束数 = 页码起始数 + 页码总个数 -1  大于等于  当前页  则为其赋值为当前页值，小于当前页则为 this.everyPageStart+this.everyPageCount - 1
		this.everyPageEnd = (this.everyPageStart+this.everyPageCount - 1) >= this.pageCount ? this.pageCount : this.everyPageStart+this.everyPageCount - 1;
		if(this.pageNum != 1){
			this.hasPre = true; 
			this.prePage = this.pageNum - 1;
			this.firstPage = 1;
		}
		if(this.pageNum < this.pageCount){
			this.hasNext = true;
			this.nextPage = this.pageNum + 1;
			this.lastPage = this.pageCount;
		}
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getRowStart() {
		return rowStart;
	}

	public void setRowStart(int rowStart) {
		this.rowStart = rowStart;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public boolean isHasPre() {
		return hasPre;
	}

	public void setHasPre(boolean hasPre) {
		this.hasPre = hasPre;
	}

	public int getPrePage() {
		return prePage;
	}

	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}

	public int getFirstPage() {
		return firstPage;
	}

	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}

	public boolean isHasNext() {
		return hasNext;
	}

	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public int getEveryPageCount() {
		return everyPageCount;
	}

	public void setEveryPageCount(int everyPageCount) {
		this.everyPageCount = everyPageCount;
	}

	public int getEveryPageStart() {
		return everyPageStart;
	}

	public void setEveryPageStart(int everyPageStart) {
		this.everyPageStart = everyPageStart;
	}

	public int getEveryPageEnd() {
		return everyPageEnd;
	}

	public void setEveryPageEnd(int everyPageEnd) {
		this.everyPageEnd = everyPageEnd;
	}

	public List getDataList() {
		return dataList;
	}

	public void setDataList(List dataList) {
		this.dataList = dataList;
	}*/
	
	/**
	 * gohengProject的实体类
	 */
	
	// 每页显示的条数
		 private int pageSize;
		 // 总共的条数
		 private int recordCount;
		 // 当前页面
		 private int currentPage;
		 public UtilPage(int pageSize, int recordCount, int currentPage) {
		  this.pageSize = pageSize;
		  this.recordCount = recordCount;
		  setCurrentPage(currentPage);
		 }
		 // 构造方法
		 public UtilPage(int pageSize, int recordCount) {
		  this(pageSize, recordCount, 1);
		 }
		 // 总页数
		 public int getPageCount() {
		  // 总条数/每页显示的条数=总页数
		  int size = recordCount / pageSize;
		  // 最后一页的条数
		  int mod = recordCount % pageSize;
		  if (mod != 0)
		   size++;
		  return recordCount == 0 ? 1 : size;
		 }
		 // 包含，起始索引为0
		 public int getFromIndex() {
		  // System.out.println("from index:"+(currentPage-1) * pageSize);
		  return (currentPage - 1) * pageSize;
		 }
		 // 不包含
		 public int getToIndex() {
		  // System.out.println("to index:"+Math.min(recordCount, currentPage *
		  // pageSize));
		  return Math.min(recordCount, currentPage * pageSize);
		 }
		 // 得到当前页
		 public int getCurrentPage() {
		  return currentPage;
		 }
		 // 设置当前页
		 public void setCurrentPage(int currentPage) {
		  int validPage = currentPage <= 0 ? 1 : currentPage;
		  validPage = validPage > getPageCount() ? getPageCount() : validPage;
		  this.currentPage = validPage;
		 }
		 // 得到每页显示的条数
		 public int getPageSize() {
		  return pageSize;
		 }
		 // 设置每页显示的条数
		 public void setPageSize(int pageSize) {
		  this.pageSize = pageSize;
		 }
		 // 得到总共的条数
		 public int getRecordCount() {
		  return recordCount;
		 }
		 // 设置总共的条数
		 public void setRecordCount(int recordCount) {
		  this.recordCount = recordCount;
		 }
	
}
