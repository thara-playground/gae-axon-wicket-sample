package org.zetta1985.framework.domain;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.springframework.util.Assert;

/**
 * @author t_hara
 */
public class PaginatedList<E> implements List<E>{

	private List<E> source;
	
	private ListLoader<E> listLoader;
	
	private int allCount;
	
	private int pageCount;
	
	private int currentPage;
	
	private int fromIndex;
	
	private int toIndex;

	/**
	 * @param listLoader
	 */
	public PaginatedList(ListLoader<E> listLoader) {
		super();
		this.listLoader = listLoader;
	}
	
	public void load(PagingCriteria criteria) {
		this.load(criteria.getPage(), criteria.getRows());
	}
	
	public void load(int page, int rows) {
		Assert.isTrue(page > 0);
		Assert.isTrue(rows > 0);
		
		this.currentPage = page;
		allCount = this.listLoader.allCount();
		pageCount = allCount % rows == 0 ? allCount / rows : allCount / rows + 1;
		fromIndex = (rows * page) - rows + 1;
		int end = rows * page;
		toIndex = end > allCount ? allCount : end;
		source = listLoader.load(fromIndex, toIndex);
	}
	
	public E first() {
		return getSource().get(0);
	}
	
	public E last() {
		return getSource().get(getSource().size() - 1);
	}
	
	public boolean isLoaded() {
		return source != null;
	}
	
	/**
	 * @return the currentPage
	 */
	public int getCurrentPage() {
		return currentPage;
	}
	
	/**
	 * @return the source
	 */
	List<E> getSource() {
		if (source == null) throw new IllegalStateException("this paginated list hasn't be loaded yet.");
		return source;
	}

	/**
	 * @return the allCount
	 */
	public int getAllCount() {
		return allCount;
	}

	/**
	 * @return the pageCount
	 */
	public int getPageCount() {
		return pageCount;
	}

	/**
	 * @return the fromIndex
	 */
	public int getFromIndex() {
		return fromIndex;
	}

	/**
	 * @return the toIndex
	 */
	public int getToIndex() {
		return toIndex;
	}

	/**
	 * @param e
	 * @return
	 * @see java.util.List#add(java.lang.Object)
	 */
	public boolean add(E e) {
		return getSource().add(e);
	}

	/**
	 * @param index
	 * @param element
	 * @see java.util.List#add(int, java.lang.Object)
	 */
	public void add(int index, E element) {
		getSource().add(index, element);
	}

	/**
	 * @param c
	 * @return
	 * @see java.util.List#addAll(java.util.Collection)
	 */
	public boolean addAll(Collection<? extends E> c) {
		return getSource().addAll(c);
	}

	/**
	 * @param index
	 * @param c
	 * @return
	 * @see java.util.List#addAll(int, java.util.Collection)
	 */
	public boolean addAll(int index, Collection<? extends E> c) {
		return getSource().addAll(index, c);
	}

	/**
	 * 
	 * @see java.util.List#clear()
	 */
	public void clear() {
		getSource().clear();
	}

	/**
	 * @param o
	 * @return
	 * @see java.util.List#contains(java.lang.Object)
	 */
	public boolean contains(Object o) {
		return getSource().contains(o);
	}

	/**
	 * @param c
	 * @return
	 * @see java.util.List#containsAll(java.util.Collection)
	 */
	public boolean containsAll(Collection<?> c) {
		return getSource().containsAll(c);
	}

	/**
	 * @param o
	 * @return
	 * @see java.util.List#equals(java.lang.Object)
	 */
	public boolean equals(Object o) {
		return getSource().equals(o);
	}

	/**
	 * @param index
	 * @return
	 * @see java.util.List#get(int)
	 */
	public E get(int index) {
		return getSource().get(index);
	}

	/**
	 * @return
	 * @see java.util.List#hashCode()
	 */
	public int hashCode() {
		return getSource().hashCode();
	}

	/**
	 * @param o
	 * @return
	 * @see java.util.List#indexOf(java.lang.Object)
	 */
	public int indexOf(Object o) {
		return getSource().indexOf(o);
	}

	/**
	 * @return
	 * @see java.util.List#isEmpty()
	 */
	public boolean isEmpty() {
		return getSource().isEmpty();
	}

	/**
	 * @return
	 * @see java.util.List#iterator()
	 */
	public Iterator<E> iterator() {
		return getSource().iterator();
	}

	/**
	 * @param o
	 * @return
	 * @see java.util.List#lastIndexOf(java.lang.Object)
	 */
	public int lastIndexOf(Object o) {
		return getSource().lastIndexOf(o);
	}

	/**
	 * @return
	 * @see java.util.List#listIterator()
	 */
	public ListIterator<E> listIterator() {
		return getSource().listIterator();
	}

	/**
	 * @param index
	 * @return
	 * @see java.util.List#listIterator(int)
	 */
	public ListIterator<E> listIterator(int index) {
		return getSource().listIterator(index);
	}

	/**
	 * @param index
	 * @return
	 * @see java.util.List#remove(int)
	 */
	public E remove(int index) {
		return getSource().remove(index);
	}

	/**
	 * @param o
	 * @return
	 * @see java.util.List#remove(java.lang.Object)
	 */
	public boolean remove(Object o) {
		return getSource().remove(o);
	}

	/**
	 * @param c
	 * @return
	 * @see java.util.List#removeAll(java.util.Collection)
	 */
	public boolean removeAll(Collection<?> c) {
		return getSource().removeAll(c);
	}

	/**
	 * @param c
	 * @return
	 * @see java.util.List#retainAll(java.util.Collection)
	 */
	public boolean retainAll(Collection<?> c) {
		return getSource().retainAll(c);
	}

	/**
	 * @param index
	 * @param element
	 * @return
	 * @see java.util.List#set(int, java.lang.Object)
	 */
	public E set(int index, E element) {
		return getSource().set(index, element);
	}

	/**
	 * @return
	 * @see java.util.List#size()
	 */
	public int size() {
		return getSource().size();
	}

	/**
	 * @param fromIndex
	 * @param toIndex
	 * @return
	 * @see java.util.List#subList(int, int)
	 */
	public List<E> subList(int fromIndex, int toIndex) {
		return getSource().subList(fromIndex, toIndex);
	}

	/**
	 * @return
	 * @see java.util.List#toArray()
	 */
	public Object[] toArray() {
		return getSource().toArray();
	}

	/**
	 * @param <T>
	 * @param a
	 * @return
	 * @see java.util.List#toArray(T[])
	 */
	public <T> T[] toArray(T[] a) {
		return getSource().toArray(a);
	}
}
