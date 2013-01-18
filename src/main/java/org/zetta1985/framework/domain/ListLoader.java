package org.zetta1985.framework.domain;

import java.util.List;

/**
 * @author t_hara
 */
public interface ListLoader<E> {

	int allCount();
	
	List<E> load(int from, int to);
}
