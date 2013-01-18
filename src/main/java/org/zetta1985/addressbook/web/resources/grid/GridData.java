package org.zetta1985.addressbook.web.resources.grid;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.Assert;
import org.zetta1985.framework.domain.PaginatedList;

/**
 * @author t_hara
 */
public class GridData implements Serializable{

	private static final long serialVersionUID = -6087131478126761014L;

	/** total number of records for the query */
	private int records;
	
	/** total pages for the query */
	private int total;
	
	/** current page of the query */
	private int page;

	/** a list that contains the actual data */
	private final List<Object> rows = new ArrayList<Object>();

	public <E> GridData(PaginatedList<E> list) {
		Assert.notNull(list);
		
		this.records = list.getAllCount();
		this.total = list.getPageCount();
		this.page = list.getCurrentPage();
		rows.addAll(list);
	}
	
	public <E> GridData(PaginatedList<E> list, GridRecordBuilder<E> builder) {
		Assert.notNull(list);
		Assert.notNull(builder);
		Assert.isTrue(list.isLoaded());
		
		this.records = list.getAllCount();
		this.total = list.getPageCount();
		this.page = list.getCurrentPage();
		
		for (E e : list) {
			rows.add(builder.create(e));
		}
	}
	
	/**
	 * @return the records
	 */
	public int getRecords() {
		return records;
	}

	/**
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * @return the page
	 */
	public int getPage() {
		return page;
	}

	/**
	 * @return the rows
	 */
	public List<Object> getRows() {
		return rows;
	}
	
	
}
