package org.zetta1985.framework.domain;

/**
 * @author t_hara
 */
public class PagingCriteria {

	/** get the requested page. By default grid sets this to 1.  */
	private int page = 1;
	
	/** get how many rows client wants to have into the grid */
	private int rows = 10;
	
	private String sortedIndex;
	
	private boolean ascendingOrder = true;

	public PagingCriteria() {
	}
	
	/**
	 * @param page
	 * @param rows
	 * @param sortedIndex
	 * @param ascendingOrder
	 */
	public PagingCriteria(int page, int rows, String sortedIndex,
			boolean ascendingOrder) {
		super();
		this.page = page;
		this.rows = rows;
		this.sortedIndex = sortedIndex;
		this.ascendingOrder = ascendingOrder;
	}



	/**
	 * @return the page
	 */
	public int getPage() {
		return page;
	}

	/**
	 * @param page the page to set
	 */
	public void setPage(int page) {
		this.page = page;
	}

	/**
	 * @return the rows
	 */
	public int getRows() {
		return rows;
	}

	/**
	 * @param rows the rows to set
	 */
	public void setRows(int rows) {
		this.rows = rows;
	}

	/**
	 * @return the sortedIndex
	 */
	public String getSortedIndex() {
		return sortedIndex;
	}

	/**
	 * @param sortedIndex the sortedIndex to set
	 */
	public void setSortedIndex(String sortedIndex) {
		this.sortedIndex = sortedIndex;
	}

	/**
	 * @return the ascendingOrder
	 */
	public boolean isAscendingOrder() {
		return ascendingOrder;
	}

	/**
	 * @param ascendingOrder the ascendingOrder to set
	 */
	public void setAscendingOrder(boolean ascendingOrder) {
		this.ascendingOrder = ascendingOrder;
	}
}
