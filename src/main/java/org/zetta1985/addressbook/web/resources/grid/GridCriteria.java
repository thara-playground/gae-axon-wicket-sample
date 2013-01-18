package org.zetta1985.addressbook.web.resources.grid;

import javax.ws.rs.QueryParam;

import org.zetta1985.framework.domain.PagingCriteria;

/**
 * @author t_hara
 */
public class GridCriteria extends PagingCriteria{

	/** sorting order : "asc" or "desc" */
	private String sord = "asc";
	
	@Override
	public boolean isAscendingOrder() {
		return sord == null ? true : sord.equals("asc"); 
	}
	
	/**
	 * @return the sord
	 */
	public String getSord() {
		return sord;
	}

	/**
	 * @param sord the sord to set
	 */
	@QueryParam("sord")
	public void setSord(String sord) {
		this.sord = sord;
	}
	
	@Override
	public int getPage() {
		return super.getPage();
	}
	
	@Override
	@QueryParam("page")
	public void setPage(int page) {
		super.setPage(page);
	}
	
	@Override
	public int getRows() {
		return super.getRows();
	}
	
	@Override
	@QueryParam("rows")
	public void setRows(int rows) {
		super.setRows(rows);
	}
	
	@Override
	public String getSortedIndex() {
		return super.getSortedIndex();
	}
	
	@Override
	@QueryParam("sidx")
	public void setSortedIndex(String sortedIndex) {
		super.setSortedIndex(sortedIndex);
	}
}
