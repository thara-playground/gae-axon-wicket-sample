package org.zetta1985.addressbook.web.resources.grid;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author t_hara
 */
public class GridRecord<E> implements Serializable{

	private static final long serialVersionUID = 8697863377427519695L;

	private final String id;
	
	private final List<E> cell = new ArrayList<E>();
	
	/**
	 * @param id
	 */
	public GridRecord(String id) {
		super();
		this.id = id;
	}
	
	public GridRecord(long id) {
		super();
		this.id = String.valueOf(id);
	}
	
	public GridRecord<E> append(E e) {
		cell.add(e);
		return this;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the cell
	 */
	public List<E> getCell() {
		return cell;
	}
}
