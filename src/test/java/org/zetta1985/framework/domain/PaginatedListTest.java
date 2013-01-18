package org.zetta1985.framework.domain;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


/**
 * @author t_hara
 */
public class PaginatedListTest {

	private PaginatedList<String> target;

	/**
	 * 
	 */
	public PaginatedListTest() {
		List<String> source = new ArrayList<String>();
		for (int i = 1; i <= 100; i++) {
			source.add("TEST_" + i);
		}
		
		ListLoader<String> listLoader = new TestListLoader<String>(source);
		target = new PaginatedList<String>(listLoader);
	}

	@Test
	public void paginated_1() {
		target.load(1, 10);
		assertEquals(10, target.getPageCount());
		assertEquals(1, target.getFromIndex());
		assertEquals(10, target.getToIndex());
		assertEquals("TEST_1", target.first());
		assertEquals("TEST_10", target.last());
		
		target.load(2, 10);
		assertEquals(10, target.getPageCount());
		assertEquals(11, target.getFromIndex());
		assertEquals(20, target.getToIndex());
		assertEquals("TEST_11", target.first());
		assertEquals("TEST_20", target.last());
		
		target.load(10, 10);
		assertEquals(10, target.getPageCount());
		assertEquals(91, target.getFromIndex());
		assertEquals(100, target.getToIndex());
		assertEquals("TEST_91", target.first());
		assertEquals("TEST_100", target.last());
	}
	
	@Test
	public void paginated_2() {
		target.load(1, 3);
		assertEquals(34, target.getPageCount());
		assertEquals(1, target.getFromIndex());
		assertEquals(3, target.getToIndex());
		assertEquals("TEST_1", target.first());
		assertEquals("TEST_3", target.last());
		
		target.load(2, 3);
		assertEquals(34, target.getPageCount());
		assertEquals(4, target.getFromIndex());
		assertEquals(6, target.getToIndex());
		assertEquals("TEST_4", target.first());
		assertEquals("TEST_6", target.last());

		target.load(33, 3);
		assertEquals(34, target.getPageCount());
		assertEquals(97, target.getFromIndex());
		assertEquals(99, target.getToIndex());
		assertEquals("TEST_97", target.first());
		assertEquals("TEST_99", target.last());
		
		target.load(34, 3);
		assertEquals(34, target.getPageCount());
		assertEquals(100, target.getFromIndex());
		assertEquals(100, target.getToIndex());
		assertEquals("TEST_100", target.first());
		assertEquals("TEST_100", target.last());
	}
}
