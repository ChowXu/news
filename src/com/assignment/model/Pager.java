package com.assignment.model;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author zhouxi
 * 
 * @param <T>  T ---> Entity
 */
public class Pager<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	private int currentPage;
	private int pageSize;
	private int totalRecords;
	private int totalPages;
	private List<T> datalist;

	/**
	 * 
	 * @param currentPage  
	 * @param pageSize
	 * @param totalRecords
	 * @param totalPages  
	 * @param datalist      
	 */
	public Pager(int currentPage, int pageSize, int totalRecords,
			int totalPages, List<T> datalist) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalRecords = totalRecords;
		this.totalPages = totalPages;
		this.datalist = datalist;
	}

	public Pager() {

	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public List<T> getDatalist() {
		return datalist;
	}

	public void setDatalist(List<T> datalist) {
		this.datalist = datalist;
	}

	@Override
	public String toString() {
		return "Pager [currentPage=" + currentPage + ", pageSize=" + pageSize
				+ ", totalRecords=" + totalRecords + ", totalPages="
				+ totalPages + ", datalist=" + datalist + "]";
	}

}
