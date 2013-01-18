package org.zetta1985.addressbook.web.resources.grid;

/**
 * @author t_hara
 */
public interface GridRecordBuilder<T> {

	GridRecord<? extends Object> create(T src);
}
