package org.zetta1985.framework.domain;

import java.util.List;

public class TestListLoader<E> implements ListLoader<E> {
	
	private List<E> source;
	
	/**
	 * @param source
	 */
	public TestListLoader(List<E> source) {
		super();
		this.source = source;
	}

	@Override
	public int allCount() {
		return source.size();
	}
	
	/**
	 * @inheritDoc
	 */
	@Override
	public List<E> load(int from, int to) {
		return source.subList(from - 1, to);
	}
}